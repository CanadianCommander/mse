package ca.bbenetti.msesuperuser.api.v1.crud;

import java.util.UUID;
import ca.bbenetti.msesuperuser.model.AbstractBaseModel;
import ca.bbenetti.msesuperuser.repository.BaseRepository;
import ca.bbenetti.msesuperuser.service.ApplicationResponseFactory;
import ca.bbenetti.msesuperuser.transfer.AbstractModelInboundTransfer;
import ca.bbenetti.msesuperuser.transfer.ApplicationResponse;
import ca.bbenetti.msesuperuser.converter.AbstractInboundTransferToAbstractModelConverter;
import ca.bbenetti.msesuperuser.converter.AbstractModelToTransferConverter;
import ca.bbenetti.msesuperuser.transfer.AbstractModelTransfer;

public interface CRUDControllerBase<Model extends AbstractBaseModel, Transfer extends AbstractModelTransfer, InboundTransfer extends AbstractModelInboundTransfer>
{
	// ==========================================================================
	// Public Methods
	// ==========================================================================

	/**
	 * override. This method should return the repository for the model
	 * @return - the repository
	 */
	public BaseRepository<Model, UUID> getModelRepository();

	/**
	 * override. This method should provide the converter to be used to transform Model -> Transfer
	 * @return - the converter
	 */
	public AbstractModelToTransferConverter<Model, Transfer> getModelToTransferConverter();

	/**
	 * override. This method should provide the converter to be used to transform Transfer -> Model
	 * @return - the converter
	 */
	public AbstractInboundTransferToAbstractModelConverter<InboundTransfer, Model> getTransferToModelConverter();
}
