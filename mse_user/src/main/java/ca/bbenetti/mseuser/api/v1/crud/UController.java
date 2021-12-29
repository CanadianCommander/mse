package ca.bbenetti.mseuser.api.v1.crud;

import ca.bbenetti.mseuser.model.AbstractBaseModel;
import ca.bbenetti.mseuser.service.ApplicationResponseFactory;
import ca.bbenetti.mseuser.transfer.AbstractModelInboundTransfer;
import ca.bbenetti.mseuser.transfer.ApplicationResponse;
import ca.bbenetti.mseuser.transfer.AbstractModelTransfer;
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
