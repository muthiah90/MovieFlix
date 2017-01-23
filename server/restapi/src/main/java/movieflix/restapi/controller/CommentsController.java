package movieflix.restapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import movieflix.restapi.entity.CommentAndRating;
import movieflix.restapi.service.CommentsService;

/**
 * @author Muthiah 
 * This is a controller class to handle requests for User
 * Comments on different titles that is available in the database
 */
@RestController
@RequestMapping(value = "comments")
public class CommentsController
{
	@Autowired
	private CommentsService commentsService;

	@RequestMapping(method = RequestMethod.GET)
	public List<CommentAndRating> getAllComments()
	{
		return commentsService.getAllComments();
	}

	@RequestMapping(method = RequestMethod.GET, value = "{commentId}")
	public CommentAndRating getComment(@PathVariable("commentId") String commentId)
	{
		return commentsService.getComment(commentId);
	}

	@RequestMapping(method = RequestMethod.GET, value = "title/{titleId}")
	public List<CommentAndRating> getCommentsForTitle(@PathVariable("titleId") String titleId)
	{
		return commentsService.getCommentsForTitle(titleId);
	}

	@RequestMapping(method = RequestMethod.GET, value = "user/{userId}")
	public List<CommentAndRating> getCommentsForUser(@PathVariable("userId") String userId)
	{
		return commentsService.getCommentsForUser(userId);
	}

	@RequestMapping(method = RequestMethod.GET, value = "rating/{titleId}")
	public float getAverageRating(@PathVariable("titleId") String titleId)
	{
		return commentsService.getAverageRating(titleId);
	}

	@RequestMapping(method = RequestMethod.POST, value = "{titleId}/{userId}")
	public CommentAndRating createComment(@PathVariable("titleId") String titleId,
			@PathVariable("userId") String userId, @RequestBody CommentAndRating comment)
	{
		return commentsService.createComment(titleId, userId, comment);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "{commentId}")
	public CommentAndRating updateComment(@PathVariable("commentId") String commentId,
			@RequestBody CommentAndRating comment)
	{
		return commentsService.updateComment(commentId, comment);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "{commentId}")
	public void deleteComment(@PathVariable("commentId") String commentId)
	{
		commentsService.deleteComment(commentId);
	}
}
