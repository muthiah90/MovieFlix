package movieflix.restapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import movieflix.restapi.entity.CommentAndRating;
import movieflix.restapi.entity.Titles;
import movieflix.restapi.entity.Users;
import movieflix.restapi.exception.BadRequest;
import movieflix.restapi.exception.RequestNotFoundException;
import movieflix.restapi.repository.CommentAndRatingRepository;

/**
 * @author Muthiah
 * This is an implementation class for CommentsService
 *
 */
@Service
public class CommentsServiceImpl implements CommentsService
{
	@Autowired
	private CommentAndRatingRepository commentRepository;
	
	@Autowired
	private TitleService titleService;
	
	@Autowired
	private UserService userService;

	@Override
	@Transactional(readOnly = true)
	public List<CommentAndRating> getAllComments()
	{
		return commentRepository.getAllComments();
	}
	
	@Override
	@Transactional(readOnly = true)
	public CommentAndRating getComment(String commentId)
	{
		return commentRepository.getComment(commentId);
	}

	@Override
	@Transactional
	public CommentAndRating createComment(String titleId, String userId, CommentAndRating commentAndRating)
	{
		Titles title = titleService.getTitle(titleId);
		Users user = userService.getUser(userId);
		if(title != null && user != null)
		{
			commentAndRating.setTitle(title);
			commentAndRating.setUser(user);
			return commentRepository.createComment(commentAndRating);
		}
		else
		{
			throw new BadRequest("Title/User not found in the database");
		}
	}

	@Override
	@Transactional
	public CommentAndRating updateComment(String commentId, CommentAndRating commentAndRating)
	{
		CommentAndRating existingComment = commentRepository.getComment(commentId);
		if (existingComment != null)
		{
			existingComment.copyFrom(commentAndRating);
			return commentRepository.updateComment(existingComment);
		}
		else
		{
			throw new RequestNotFoundException("The comment to be updated does not exist in the database");
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<CommentAndRating> getCommentsForTitle(String titleId)
	{
		Titles title = titleService.getTitle(titleId);
		
		if(title != null)
		{
			return commentRepository.getCommentsForTitle(title);
		}
		else
		{
			throw new BadRequest("Title not found in the database");
		}		
	}

	@Override
	@Transactional(readOnly = true)
	public List<CommentAndRating> getCommentsForUser(String userId)
	{
		Users user = userService.getUser(userId);
		
		if(user != null)
		{
			return commentRepository.getCommentsForUser(user);
		}
		else
		{
			throw new BadRequest("User not found in the database");
		}			
	}

	@Override
	@Transactional(readOnly = true)
	public float getAverageRating(String titleId)
	{
		Titles title = titleService.getTitle(titleId);
		
		if(title != null)
		{
			return commentRepository.getAverageRating(title);
		}
		else
		{
			throw new BadRequest("Title not found in the database");
		}		
	}

	@Override
	@Transactional
	public void deleteComment(String commentId)
	{
		CommentAndRating existingComment = commentRepository.getComment(commentId);
		if (existingComment != null)
		{
			commentRepository.deleteComment(existingComment);
		}
		else
		{
			throw new RequestNotFoundException("The comment to be deleted does not exist in the database");
		}
	}
}
