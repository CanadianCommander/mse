package ca.bbenetti.msesuperuser.api.v1.crud;

import ca.bbenetti.msesuperuser.model.AbstractBaseModel;
import ca.bbenetti.msesuperuser.service.ApplicationResponseFactory;
import ca.bbenetti.msesuperuser.transfer.AbstractModelInboundTransfer;
import ca.bbenetti.msesuperuser.transfer.ApplicationResponse;
import ca.bbenetti.msesuperuser.transfer.AbstractModelTransfer;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.UUID;

public interface UController<Model extends AbstractBaseModel, Transfer extends AbstractModelTransfer, InboundTransfer extends AbstractModelInboundTransfer>
	extends CRUDControllerBase<Model, Transfer, InboundTransfer>
{

	// ==========================================================================
	// Endpoints
	// ==========================================================================

	@PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	default ApplicationResponse<Transfer> update(@PathVariable UUID id, @RequestBody InboundTransfer transfer)
	{
		transfer.setId(id);
		Model model = this.getModelRepository().save(this.getTransferToModelConverter().convert(transfer));
		return ApplicationResponseFactory.okResponse(getModelToTransferConverter().convert(model));
	}
}
