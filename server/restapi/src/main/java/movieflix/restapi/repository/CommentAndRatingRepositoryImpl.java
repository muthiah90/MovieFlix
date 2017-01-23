package movieflix.restapi.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import movieflix.restapi.entity.CommentAndRating;
import movieflix.restapi.entity.Titles;
import movieflix.restapi.entity.Users;

/**
 * @author Muthiah
 * This is an implementation class for the CommentAndRatings Repository
 */
@Repository
public class CommentAndRatingRepositoryImpl implements CommentAndRatingRepository
{
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<CommentAndRating> getAllComments()
	{
		TypedQuery<CommentAndRating> commentQuery = em.createNamedQuery("CommentsAndRating.getAllComments",
				CommentAndRating.class);
		return commentQuery.getResultList();
	}

	@Override
	public CommentAndRating getComment(String commentId)
	{
		try
		{
			TypedQuery<CommentAndRating> commentQuery = em.createNamedQuery("CommentsAndRating.getComment",
					CommentAndRating.class);
			commentQuery.setParameter("pCommentId", commentId);
			return commentQuery.getSingleResult();
		}
		catch (NoResultException e)
		{
			return null;
		}
	}

	@Override
	public List<CommentAndRating> getCommentsForTitle(Titles title)
	{
		TypedQuery<CommentAndRating> commentQuery = em.createNamedQuery("CommentsAndRating.getCommentsForTitle",
				CommentAndRating.class);
		commentQuery.setParameter("pTitle", title);
		return commentQuery.getResultList();
	}

	@Override
	public List<CommentAndRating> getCommentsForUser(Users user)
	{
		TypedQuery<CommentAndRating> commentQuery = em.createQuery("CommentsAndRating.getCommentsForUsers",
				CommentAndRating.class);
		commentQuery.setParameter("pUser", user);
		return commentQuery.getResultList();
	}

	@Override
	public float getAverageRating(Titles title)
	{
		try
		{
			Query valueQuery = em.createNamedQuery("CommentsAndRating.getAverageRatingforTitle");
			valueQuery.setParameter("pTitle", title);
			float result = Float.valueOf(valueQuery.getSingleResult().toString());
			return result;
		}
		catch (NoResultException e)
		{
			return 0;
		}
	}

	@Override
	public CommentAndRating createComment(CommentAndRating commentAndRating)
	{
		em.persist(commentAndRating);
		return commentAndRating;
	}

	@Override
	public CommentAndRating updateComment(CommentAndRating commentAndRating)
	{
		em.merge(commentAndRating);
		return commentAndRating;
	}

	@Override
	public void deleteComment(CommentAndRating commentAndRating)
	{
		em.remove(commentAndRating);
	}
}
