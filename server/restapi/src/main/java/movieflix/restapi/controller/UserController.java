package movieflix.restapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import movieflix.restapi.entity.Users;
import movieflix.restapi.service.UserService;

/**
 * @author Muthiah 
 * This is a controller class for handling the request on Users
 *         registered in the system
 *
 */
@RestController
@RequestMapping(value = "users")
public class UserController
{

	@Autowired
	private UserService userService;

	@RequestMapping(method = RequestMethod.GET)
	public List<Users> getAllUsers()
	{
		return userService.getAllUsers();
	}

	@RequestMapping(method = RequestMethod.GET, value = "{userId}")
	public Users getUserByUserId(@PathVariable("userId") String userId)
	{
		return userService.getUser(userId);
	}

	@RequestMapping(method = RequestMethod.GET, value = "{userName}/{password}")
	public Users validateUser(@PathVariable("userName") String userName, @PathVariable("password") String password)
	{
		return userService.validateUser(userName, password);
	}

	@RequestMapping(method = RequestMethod.POST)
	public Users createUser(@RequestBody Users user)
	{
		return userService.createUser(user);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "{userId}")
	public Users updateUser(@PathVariable("userId") String userId, @RequestBody Users user)
	{
		return userService.updateUser(userId, user);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "{userId}")
	public void deleteUser(@PathVariable("userId") String userId)
	{
		userService.deleteUser(userId);
	}
}
