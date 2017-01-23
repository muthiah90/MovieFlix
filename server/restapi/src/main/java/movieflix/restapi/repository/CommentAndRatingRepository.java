package movieflix.restapi.repository;

import java.util.List;

import movieflix.restapi.entity.CommentAndRating;
import movieflix.restapi.entity.Titles;
import movieflix.restapi.entity.Users;

public interface CommentAndRatingRepository
{
	/**
	 * This method will return all the comments logged in the system This method
	 * doesn't take any input
	 * 
	 * @return - List of CommentAndRating objects
	 */
	public List<CommentAndRating> getAllComments();

	/**
	 * Gets the CommentAndRating object for the specified commentId
	 * 
	 * @param commentId
	 * @return CommentAndRating object
	 */
	public CommentAndRating getComment(String commentId);

	/**
	 * This method gets all the comments logged by different users for the given
	 * title
	 * 
	 * @param title
	 *            - Titles object for which the log has to retrieved
	 * @return - List of CommentAndRating objects logged for the title
	 */
	public List<CommentAndRating> getCommentsForTitle(Titles title);

	/**
	 * This method gets all the comments logged by a single user for the all the
	 * titles that he commented for
	 * 
	 * @param user
	 *            - The Users object for which the comments had to retrieved
	 * @return - List of CommentAndRating objects logged by the user
	 */
	public List<CommentAndRating> getCommentsForUser(Users user);

	/**
	 * This method gets the average rating for the given title based on all the
	 * ratings logged for the given title
	 * 
	 * @param title
	 *            - Titles object for which the average rating is to be found
	 * @return - Average rating
	 */
	public float getAverageRating(Titles title);

	/**
	 * This method is to add a new comment record to the database
	 * 
	 * @param commentAndRating
	 *            - Object to be persisted
	 * @return - The persisted object
	 */
	public CommentAndRating createComment(CommentAndRating commentAndRating);

	/**
	 * This method is to update the existing comment object
	 * 
	 * @param commentAndRating
	 *            - object to be updated
	 * @return - The updated comment object
	 */
	public CommentAndRating updateComment(CommentAndRating commentAndRating);

	/**
	 * This method is to delete an existing comment from the database
	 * 
	 * @param commentAndRating
	 *            - The comment object to be deleted
	 */
	public void deleteComment(CommentAndRating commentAndRating);
}
