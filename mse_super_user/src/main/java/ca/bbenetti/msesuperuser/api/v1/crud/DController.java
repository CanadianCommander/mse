package ca.bbenetti.msesuperuser.api.v1.crud;

import ca.bbenetti.msesuperuser.model.AbstractBaseModel;
import ca.bbenetti.msesuperuser.service.ApplicationResponseFactory;
import ca.bbenetti.msesuperuser.transfer.AbstractModelInboundTransfer;
import ca.bbenetti.msesuperuser.transfer.ApplicationResponse;
import ca.bbenetti.msesuperuser.transfer.AbstractModelTransfer;
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
