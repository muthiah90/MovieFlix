package movieflix.restapi.repository;

import java.util.List;

import movieflix.restapi.entity.Users;

/**
 * @author Muthiah
 *
 */
public interface UserRepository
{
	/**
	 * Method to get all the Users
	 * 
	 * @return - List of users
	 */
	public List<Users> getAllUsers();

	/**
	 * Method to get the user based on the userId
	 * 
	 * @param userId
	 *            - ID for which the User object is to be retrieved
	 * @return - User Object
	 */
	public Users getUser(String userId);

	/**
	 * This method validates the user by checking the user name and password
	 * 
	 * @param userName
	 * @param password
	 * @return - The User object if the validation passes through and null if
	 *         not
	 */
	public Users validateUser(String userName, String password);

	/**
	 * This method is to create a new user in the database
	 * 
	 * @param user
	 *            - User object to be persisted
	 * @return - The persisted user
	 */
	public Users createUser(Users user);

	/**
	 * This method is to update the existing user
	 * 
	 * @param user
	 *            - The user object to be updated
	 * @return - The updated object
	 */
	public Users updateUser(Users user);

	/**
	 * This method is to delete an existing user object
	 * 
	 * @param user
	 *            - Object to be deleted
	 */
	public void deleteUser(Users user);

	/**
	 * Method to get the user based on the username
	 * 
	 * @param userName
	 * @return - The user object if found and null if not
	 */
	public Users getUserByUserName(String userName);

	/**
	 * Method to get the user based on the mailId
	 * 
	 * @param emailId
	 * @return - he user object if found and null if not
	 */
	public Users getUserByEmailId(String emailId);
}
