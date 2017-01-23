package movieflix.restapi.entity;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @author Muthiah
 * This is an entity class for Movies and Series
 *
 */
@Entity
@NamedQueries({ 
	@NamedQuery(name = "Titles.getAllTitles", query = "select t from Titles t"),
	@NamedQuery(name = "Titles.getTitle", query = "select t from Titles t where t.titleId = :pTitleId"),
	@NamedQuery(name = "Titles.getByTitle", query = "select t from Titles t where LOWER(t.title) = :pTitle"),
	@NamedQuery(name = "Titles.getMoviesorSeries", query = "select t from Titles t where LOWER(t.type) = :pType"),
	@NamedQuery(name = "Titles.getTitlesonGenre", query = "select t from Titles t where LOWER(t.genre) like :pGenre"),
	@NamedQuery(name = "Titles.getTitlesonLanguage", query = "select t from Titles t where LOWER(t.language) like :pLanguage"),
	@NamedQuery(name = "Titles.getTopRatedTitles", query = "select t from Titles t where LOWER(t.type) = :pType order by t.imdbRating desc") 
})
public class Titles
{

	@Id
	private String titleId;

	@Column(unique = true)
	private String title;

	private int year;
	private String rated;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date released;

	private String runtime;
	private String genre;
	private String director;
	private String writer;
	private String actors;
	private String plot;
	private String language;
	private String country;
	private String awards;
	private String poster;
	private int metaScore;
	private float imdbRating;
	private long imdbVotes;
	private String imdbId;
	private String type;
	private Date createdDate;
	private Date updatedDate;

	public Titles()
	{
		this.titleId = UUID.randomUUID().toString();
	}

	public String getTitleId()
	{
		return titleId;
	}

	public void setTitleId(String titleId)
	{
		this.titleId = titleId;
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public int getYear()
	{
		return year;
	}

	public void setYear(int year)
	{
		this.year = year;
	}

	public String getRated()
	{
		return rated;
	}

	public void setRated(String rated)
	{
		this.rated = rated;
	}

	public Date getReleased()
	{
		return released;
	}

	public void setReleased(Date released)
	{
		this.released = released;
	}

	public String getRuntime()
	{
		return runtime;
	}

	public void setRuntime(String runtime)
	{
		this.runtime = runtime;
	}

	public String getGenre()
	{
		return genre;
	}

	public void setGenre(String genre)
	{
		this.genre = genre;
	}

	public String getDirector()
	{
		return director;
	}

	public void setDirector(String director)
	{
		this.director = director;
	}

	public String getWriter()
	{
		return writer;
	}

	public void setWriter(String writer)
	{
		this.writer = writer;
	}

	public String getActors()
	{
		return actors;
	}

	public void setActors(String actors)
	{
		this.actors = actors;
	}

	public String getPlot()
	{
		return plot;
	}

	public void setPlot(String plot)
	{
		this.plot = plot;
	}

	public String getLanguage()
	{
		return language;
	}

	public void setLanguage(String language)
	{
		this.language = language;
	}

	public String getCountry()
	{
		return country;
	}

	public void setCountry(String country)
	{
		this.country = country;
	}

	public String getAwards()
	{
		return awards;
	}

	public void setAwards(String awards)
	{
		this.awards = awards;
	}

	public String getPoster()
	{
		return poster;
	}

	public void setPoster(String poster)
	{
		this.poster = poster;
	}

	public int getMetaScore()
	{
		return metaScore;
	}

	public void setMetaScore(int metaScore)
	{
		this.metaScore = metaScore;
	}

	public float getImdbRating()
	{
		return imdbRating;
	}

	public void setImdbRating(float imdbRating)
	{
		this.imdbRating = imdbRating;
	}

	public long getImdbVotes()
	{
		return imdbVotes;
	}

	public void setImdbVotes(int imdbVotes)
	{
		this.imdbVotes = imdbVotes;
	}

	public String getImdbId()
	{
		return imdbId;
	}

	public void setImdbId(String imdbId)
	{
		this.imdbId = imdbId;
	}

	public String getType()
	{
		return type;
	}

	public void setType(String type)
	{
		this.type = type;
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

	@PrePersist
	void populateDateFields()
	{
		this.createdDate = this.updatedDate = new Date();
	}

	@PreUpdate
	void updateDate()
	{
		this.updatedDate = new Date();
	}

	public void copyFrom(Titles title)
	{
		this.title = title.getTitle();
		this.year = title.getYear();
		this.rated = title.getRated();
		this.released = title.getReleased();
		this.runtime = title.getRuntime();
		this.genre = title.getGenre();
		this.director = title.getDirector();
		this.writer = title.getWriter();
		this.actors = title.getActors();
		this.plot = title.getPlot();
		this.language = title.getLanguage();
		this.country = title.getCountry();
		this.awards = title.getAwards();
		this.poster = title.getPoster();
		this.metaScore = title.getMetaScore();
		this.imdbRating = title.getImdbRating();
		this.imdbVotes = title.getImdbVotes();
		this.imdbId = title.getImdbId();
		this.type = title.getType();
	}
}
