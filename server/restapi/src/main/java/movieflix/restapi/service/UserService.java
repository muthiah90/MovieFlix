package movieflix.restapi.service;

import java.util.List;

import movieflix.restapi.entity.Users;

/**
 * @author Muthiah
 *
 */
public interface UserService
{
	/**
	 * This is to create a new user in the system
	 * @param user - The user object to be persisted
	 * @return - The persisted object
	 */
	public Users createUser(Users user);

	/**
	 * This is to update the existing user
	 * @param userId - The user id to be updated
	 * @param user - The user object that has to be persisted
	 * @return - The updated user object
	 */
	public Users updateUser(String userId, Users user);

	/**
	 * This is to delete the existing user
	 * @param userId - The user ID to be deleted
	 */
	public void deleteUser(String userId);

	/**
	 * This is to find the user based on the emailID and the password
	 * @param emailId - The email ID of the user
	 * @param password - The password of the user
	 * @return - The user object if the email ID and password matches and null otherwise
	 */
	public Users findUser(String emailId, String password);

	/**
	 * This method is to get all users registered in the system
	 * @return - List of User objects
	 */
	public List<Users> getAllUsers();

	/**
	 * Get a user object based on the user ID
	 * @param userId
	 * @return - The user object
	 */
	public Users getUser(String userId);

	/**
	 * This method is to validate the user based on the user name and password
	 * @param userName
	 * @param password
	 * @return - The user object if the validation goes through and null otherwise
	 */
	public Users validateUser(String userName, String password);
}
