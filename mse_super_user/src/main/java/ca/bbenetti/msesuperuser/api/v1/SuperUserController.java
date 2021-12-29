package ca.bbenetti.msesuperuser.api.v1;
import ca.bbenetti.msesuperuser.api.v1.AbstractBaseController;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class SuperUserController extends AbstractBaseController
{
	@GetMapping("/")
	public String helloWorld()
	{
		return "Super User Endpoint";
	}
}
