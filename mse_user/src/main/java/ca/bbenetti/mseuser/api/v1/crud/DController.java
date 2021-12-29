package ca.bbenetti.mseuser.api.v1.crud;

import ca.bbenetti.mseuser.model.AbstractBaseModel;
import ca.bbenetti.mseuser.service.ApplicationResponseFactory;
import ca.bbenetti.mseuser.transfer.AbstractModelInboundTransfer;
import ca.bbenetti.mseuser.transfer.ApplicationResponse;
import ca.bbenetti.mseuser.transfer.AbstractModelTransfer;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

public interface DController<Model extends AbstractBaseModel, Transfer extends AbstractModelTransfer, InboundTransfer extends AbstractModelInboundTransfer>
		extends CRUDControllerBase<Model, Transfer, InboundTransfer>
{

	// ==========================================================================
	// Endpoints
	// ==========================================================================

	@DeleteMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	default ApplicationResponse<Transfer> delete(@PathVariable UUID id)
	{
		Model modelToDelete = this.getModelRepository().getById(id);
		this.getModelRepository().delete(modelToDelete);
		return ApplicationResponseFactory.okResponse(this.getModelToTransferConverter().convert(modelToDelete));
	}
}
