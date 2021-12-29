FROM openjdk:17

ARG USER_GROUP_ID
ARG USER_ID

# setup user
RUN /usr/sbin/groupadd --gid ${USER_GROUP_ID} container_u
RUN /usr/sbin/useradd -m -d /home/container_u -g container_u --uid ${USER_ID} container_u

# create work dir
RUN mkdir -p /opt/source/
RUN chown container_u:container_u /opt/source
WORKDIR /opt/source/

USER container_u
CMD ./mvnw clean verify -Dspring.profiles.active=test