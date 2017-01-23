package movieflix.restapi.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import movieflix.restapi.entity.Users;

/**
 * @author Muthiah
 * This is an implementation class for UserRepository
 *
 */
@Repository
public class UserRepositoryImpl implements UserRepository
{

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Users> getAllUsers()
	{
		TypedQuery<Users> userQuery = em.createNamedQuery("Users.getAllUsers", Users.class);
		return userQuery.getResultList();
	}

	@Override
	public Users getUser(String userId)
	{
		try
		{
			TypedQuery<Users> userQuery = em.createNamedQuery("Users.getUserDetailsbyId", Users.class);
			userQuery.setParameter("pUserId", userId);

			return userQuery.getSingleResult();
		}
		catch (NoResultException e)
		{
			return null;
		}

	}

	@Override
	public Users validateUser(String userName, String password)
	{
		try
		{
			TypedQuery<Users> userQuery = em.createNamedQuery("Users.validateUser", Users.class);
			userQuery.setParameter("pUserName", userName);
			userQuery.setParameter("pPassword", password);
			return userQuery.getSingleResult();
		}
		catch (NoResultException e)
		{
			return null;
		}
	}

	@Override
	public Users getUserByUserName(String userName)
	{
		try
		{
			TypedQuery<Users> userQuery = em.createNamedQuery("Users.getUserByUserName", Users.class);
			userQuery.setParameter("pUserName", userName);
			return userQuery.getSingleResult();
		}
		catch (NoResultException e)
		{
			return null;
		}
	}

	@Override
	public Users getUserByEmailId(String emailId)
	{
		try
		{
			TypedQuery<Users> userQuery = em.createNamedQuery("Users.getUserByEmail", Users.class);
			userQuery.setParameter("pEmailId", emailId);
			return userQuery.getSingleResult();
		}
		catch (NoResultException e)
		{
			return null;
		}
	}

	@Override
	public Users createUser(Users user)
	{
		em.persist(user);
		return user;
	}

	@Override
	public Users updateUser(Users user)
	{
		em.merge(user);
		return user;
	}

	@Override
	public void deleteUser(Users user)
	{
		em.remove(user);
	}

}
