package movieflix.restapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import movieflix.restapi.entity.Users;
import movieflix.restapi.exception.BadRequest;
import movieflix.restapi.repository.UserRepository;

/**
 * @author Muthiah
 * This is an implementation class for UserService
 *
 */
@Service
public class UserServiceImpl implements UserService
{

	@Autowired
	private UserRepository userRepository;

	
	@Override
	@Transactional
	public Users createUser(Users user)
	{
		if (userRepository.getUserByUserName(user.getUserName()) == null
				&& userRepository.getUserByEmailId(user.getEmailId()) == null)
		{
			return userRepository.createUser(user);
		}
		else
		{
			throw new BadRequest(
					"Username/EMail ID already exists in the database. Please verify the information and try again later");
		}
	}

	@Override
	@Transactional
	public Users updateUser(String userId, Users user)
	{

		Users existingUser = userRepository.getUser(userId);
		if (existingUser != null)
		{
			existingUser.copyUserFrom(user);
			return userRepository.updateUser(existingUser);
		}
		else
		{
			throw new BadRequest("The user you wish to update does not exist in our database");
		}
	}

	@Override
	@Transactional
	public void deleteUser(String userId)
	{
		Users existingUser = userRepository.getUser(userId);
		if (existingUser != null)
		{
			userRepository.deleteUser(existingUser);
		}
		else
		{
			throw new BadRequest("The user you wish to delete does not exist in our database");
		}

	}

	@Override
	@Transactional(readOnly = true)
	public Users findUser(String userName, String password)
	{
		return userRepository.validateUser(userName, password);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Users> getAllUsers()
	{
		return userRepository.getAllUsers();
	}

	@Override
	@Transactional(readOnly = true)
	public Users getUser(String userId)
	{
		return userRepository.getUser(userId);
	}

	@Override
	@Transactional(readOnly = true)
	public Users validateUser(String userName, String password)
	{
		return userRepository.validateUser(userName, password);
	}
}
