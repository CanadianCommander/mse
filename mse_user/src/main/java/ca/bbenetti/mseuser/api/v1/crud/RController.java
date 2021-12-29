package ca.bbenetti.mseuser.api.v1.crud;

import ca.bbenetti.mseuser.model.AbstractBaseModel;
import ca.bbenetti.mseuser.service.ApplicationResponseFactory;
import ca.bbenetti.mseuser.transfer.AbstractModelInboundTransfer;
import ca.bbenetti.mseuser.transfer.ApplicationResponse;
import ca.bbenetti.mseuser.transfer.AbstractModelTransfer;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

public interface RController<Model extends AbstractBaseModel, Transfer extends AbstractModelTransfer, InboundTransfer extends AbstractModelInboundTransfer>
		extends CRUDControllerBase<Model, Transfer, InboundTransfer>
{

	// ==========================================================================
	// Endpoints
	// ==========================================================================

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	default ApplicationResponse<Transfer> get(@PathVariable UUID id)
	{
		Model model = this.getModelRepository().getById(id);
		return ApplicationResponseFactory.okResponse(this.getModelToTransferConverter().convert(model));
	}
}
