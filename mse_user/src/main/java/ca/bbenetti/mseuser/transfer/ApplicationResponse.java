package ca.bbenetti.mseuser.transfer;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApplicationResponse<T>
{

	protected ApplicationResponseStatusCode statusCode;
	protected String statusMessage;
	protected T data;
}
