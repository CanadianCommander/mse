package ca.bbenetti.mseuser.api.v1.crud;

import ca.bbenetti.mseuser.model.AbstractBaseModel;
import ca.bbenetti.mseuser.transfer.AbstractModelInboundTransfer;
import ca.bbenetti.mseuser.transfer.ApplicationResponse;
import ca.bbenetti.mseuser.transfer.AbstractModelTransfer;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.UUID;

public interface CRController<Model extends AbstractBaseModel, Transfer extends AbstractModelTransfer, InboundTransfer extends AbstractModelInboundTransfer>
		extends RController<Model, Transfer, InboundTransfer>, CController<Model, Transfer, InboundTransfer>
{

}
