package movieflix.restapi.service;

import java.util.List;

import movieflix.restapi.entity.CommentAndRating;

/**
 * @author Muthiah
 *
 */
public interface CommentsService
{
	/**
	 * Method to get all comments
	 * 
	 * @return - List of comments
	 */
	public List<CommentAndRating> getAllComments();

	/**
	 * Method to get the comment based on the ID
	 * 
	 * @param commentId
	 *            - ID for which the comment object is to be found
	 * @return - The comment object
	 */
	public CommentAndRating getComment(String commentId);

	/**
	 * Method to get comments for a title
	 * 
	 * @param titleId
	 * @return - The list of comment objects
	 */
	public List<CommentAndRating> getCommentsForTitle(String titleId);

	/**
	 * Method to get the comments logged by the user
	 * 
	 * @param userId
	 *            - The user of the User
	 * @return - List of comment objects
	 */
	public List<CommentAndRating> getCommentsForUser(String userId);

	/**
	 * Method to get the Average ratings for a given title based on all the
	 * ratings logged for that title
	 * 
	 * @param titleId
	 *            - Title Id for which the rating is to be found
	 * @return - The average rating
	 */
	public float getAverageRating(String titleId);

	/**
	 * This method is to create a new comment object and persist the same in the
	 * database
	 * 
	 * @param titleId
	 *            - The title ID for which the comment is logged
	 * @param userId
	 *            - The user ID by whom the comment is logged
	 * @param commentAndRating
	 *            - The rating and comment in the comment object
	 * @return - The persisted comment object
	 */
	public CommentAndRating createComment(String titleId, String userId, CommentAndRating commentAndRating);

	/**
	 * This method is used to update the comment object
	 * 
	 * @param commentId
	 *            - The comment ID that has to be updated
	 * @param commentAndRating
	 *            - The new comment object that has to persisted
	 * @return - The updated comment object
	 */
	public CommentAndRating updateComment(String commentId, CommentAndRating commentAndRating);

	/**
	 * This method is to delete the comment object
	 * 
	 * @param commentId
	 *            - The id to be deleted
	 */
	public void deleteComment(String commentId);

}
