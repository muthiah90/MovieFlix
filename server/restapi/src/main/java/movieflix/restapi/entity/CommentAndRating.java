package movieflix.restapi.entity;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

/**
 * @author Muthiah
 * This is an entity class for Comments and Ratings
 *
 */
@Entity
@NamedQueries({ 
	@NamedQuery(name = "CommentsAndRating.getAllComments", query = "select c from CommentAndRating c"),
	@NamedQuery(name = "CommentsAndRating.getCommentsForTitle", query = "select c from CommentAndRating c where c.title = :pTitle"),
	@NamedQuery(name = "CommentsAndRating.getCommentsForUsers", query = "select c from CommentAndRating c where c.user = :pUser"),
	@NamedQuery(name = "CommentsAndRating.getAverageRatingforTitle", query = "select avg(c.rating) from CommentAndRating c where c.title = :pTitle"),
	@NamedQuery(name = "CommentsAndRating.getComment", query = "select c from CommentAndRating c where c.commentId = :pCommentId") 
})
public class CommentAndRating
{

	@Id
	private String commentId;

	@ManyToOne
	private Titles title;

	@ManyToOne
	private Users user;

	private String comment;
	private float rating;
	private Date createdDate;
	private Date updatedDate;

	public CommentAndRating()
	{
		commentId = UUID.randomUUID().toString();
	}

	public String getCommentId()
	{
		return commentId;
	}

	public void setCommentId(String commentId)
	{
		this.commentId = commentId;
	}

	public Users getUser()
	{
		return user;
	}

	public void setUser(Users user)
	{
		this.user = user;
	}

	public String getComment()
	{
		return comment;
	}

	public void setComment(String comment)
	{
		this.comment = comment;
	}

	public float getRating()
	{
		return rating;
	}

	public void setRating(float rating)
	{
		this.rating = rating;
	}

	public Date getCreatedDate()
	{
		return createdDate;
	}

	public void setCreatedDate(Date createdDate)
	{
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate()
	{
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate)
	{
		this.updatedDate = updatedDate;
	}

	public Titles getTitle()
	{
		return title;
	}

	public void setTitle(Titles title)
	{
		this.title = title;
	}

	public void copyFrom(CommentAndRating commentAndRating)
	{
		this.comment = commentAndRating.getComment();
		this.rating = commentAndRating.getRating();
	}

	@PrePersist
	public void setCreatedDate()
	{
		this.createdDate = this.updatedDate = new Date();
	}

	@PreUpdate
	public void setUpdatedDate()
	{
		this.updatedDate = new Date();
	}

}
