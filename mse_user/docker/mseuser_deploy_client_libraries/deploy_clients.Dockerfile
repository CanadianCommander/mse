FROM openjdk:17.0.1-jdk-buster

ARG USER_GROUP_ID
ARG USER_ID

# setup user
RUN /usr/sbin/groupadd --gid ${USER_GROUP_ID} container_u
RUN /usr/sbin/useradd -m -d /home/container_u -g container_u --uid ${USER_ID} container_u

# create work dir
RUN mkdir -p /opt/source/
RUN chown container_u:container_u /opt/source
WORKDIR /opt/source/

# install rbenv
RUN apt update
RUN apt install -y build-essential libssl-dev zlib1g-dev
RUN git clone https://github.com/rbenv/rbenv.git /home/container_u/.rbenv
RUN mkdir -p /home/container_u/.rbenv/plugins
RUN git clone https://github.com/rbenv/ruby-build.git /home/container_u/.rbenv/plugins/ruby-build
RUN chown -R container_u:container_u /home/container_u/

# install npm
RUN apt install -y nodejs npm

# setup rbenv env
USER container_u
RUN /home/container_u/.rbenv/bin/rbenv install 3.0.1
RUN /home/container_u/.rbenv/bin/rbenv global 3.0.1

# TODO sbmicro fix this
ENTRYPOINT ["./docker/mseuser_deploy_client_libraries/deploy.sh"]
