package ca.bbenetti.mseuser.api.v1.crud;

import java.util.UUID;
import ca.bbenetti.mseuser.model.AbstractBaseModel;
import ca.bbenetti.mseuser.repository.BaseRepository;
import ca.bbenetti.mseuser.service.ApplicationResponseFactory;
import ca.bbenetti.mseuser.transfer.AbstractModelInboundTransfer;
import ca.bbenetti.mseuser.transfer.ApplicationResponse;
import ca.bbenetti.mseuser.converter.AbstractInboundTransferToAbstractModelConverter;
import ca.bbenetti.mseuser.converter.AbstractModelToTransferConverter;
import ca.bbenetti.mseuser.transfer.AbstractModelTransfer;

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
