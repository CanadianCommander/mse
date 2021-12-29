package ca.bbenetti.msesuperuser.api.v1.crud;

import ca.bbenetti.msesuperuser.model.AbstractBaseModel;
import ca.bbenetti.msesuperuser.transfer.AbstractModelInboundTransfer;
import ca.bbenetti.msesuperuser.transfer.ApplicationResponse;
import ca.bbenetti.msesuperuser.transfer.AbstractModelTransfer;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.UUID;

public interface CRController<Model extends AbstractBaseModel, Transfer extends AbstractModelTransfer, InboundTransfer extends AbstractModelInboundTransfer>
		extends RController<Model, Transfer, InboundTransfer>, CController<Model, Transfer, InboundTransfer>
{

}
