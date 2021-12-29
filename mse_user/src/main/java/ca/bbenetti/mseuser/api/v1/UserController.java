package ca.bbenetti.mseuser.api.v1;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class UserController extends AbstractBaseController
{
	@GetMapping("/")
	public String helloWorld()
	{
		return "User Endpoint";
	}
}
