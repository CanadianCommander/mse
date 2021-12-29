package ca.bbenetti.mseuser.api.v1.crud;

import ca.bbenetti.mseuser.transfer.AbstractModelInboundTransfer;
import ca.bbenetti.mseuser.transfer.AbstractModelTransfer;
import ca.bbenetti.mseuser.model.AbstractBaseModel;
import ca.bbenetti.mseuser.transfer.ApplicationResponse;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

// controller that provides CRUD. Create, Read, Update, Delete
public interface CRUDController<Model extends AbstractBaseModel, Transfer extends AbstractModelTransfer, InboundTransfer extends AbstractModelInboundTransfer>
		extends CController<Model, Transfer, InboundTransfer>, RController<Model, Transfer, InboundTransfer>, UController<Model, Transfer, InboundTransfer>, DController<Model, Transfer, InboundTransfer>
{

}
