package movieflix.restapi.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import movieflix.restapi.entity.Titles;

/**
 * @author Muthiah
 * This is an implementation class for TitleRepository
 *
 */
@Repository
public class TitleRepositoryImpl implements TitleRepository
{

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Titles> getAllTitles()
	{
		TypedQuery<Titles> titleQuery = em.createNamedQuery("Titles.getAllTitles", Titles.class);
		return titleQuery.getResultList();
	}

	@Override
	public List<Titles> getCustomTitles(String customType)
	{

		if (customType.equalsIgnoreCase("movie") || customType.equalsIgnoreCase("series"))
		{
			TypedQuery<Titles> titleTypeQuery = em.createNamedQuery("Titles.getMoviesorSeries", Titles.class);
			titleTypeQuery.setParameter("pType", customType.toLowerCase());

			return titleTypeQuery.getResultList();
		}

		return null;
	}

	@Override
	public Titles getTitle(String titleId)
	{
		try
		{
			TypedQuery<Titles> titleQuery = em.createNamedQuery("Titles.getTitle", Titles.class);
			titleQuery.setParameter("pTitleId", titleId);
			return titleQuery.getSingleResult();
		}
		catch (NoResultException e)
		{
			return null;
		}

	}

	@Override
	public Titles getTitleByTitle(String titleName)
	{
		try
		{
			TypedQuery<Titles> titleQuery = em.createNamedQuery("Titles.getByTitle", Titles.class);
			titleQuery.setParameter("pTitle", titleName.toLowerCase());
			return titleQuery.getSingleResult();
		}
		catch (NoResultException e)
		{
			return null;
		}

	}

	@Override
	public Titles createTitle(Titles title)
	{
		em.persist(title);
		return title;
	}

	@Override
	public Titles updateTitle(Titles title)
	{
		return em.merge(title);
	}

	@Override
	public void deleteTitle(Titles title)
	{
		em.remove(title);
	}

	@Override
	public List<Titles> topRatedMoviesandSeries(String value)
	{
		TypedQuery<Titles> topRatedTitlesQuery = em.createNamedQuery("Titles.getTopRatedTitles", Titles.class);
		topRatedTitlesQuery.setParameter("pType", value.toLowerCase());
		return topRatedTitlesQuery.getResultList();
	}

	@Override
	public List<Titles> customFilteredTitles(String filterTag, String filterValue)
	{
		TypedQuery<Titles> filteredQuery = null;

		switch (filterTag.toLowerCase())
		{
			case "genre":
				filteredQuery = em.createNamedQuery("Titles.getTitlesonGenre", Titles.class);
				filteredQuery.setParameter("pGenre", "%" + filterValue.toLowerCase() + "%");
				break;
			case "language":
				filteredQuery = em.createNamedQuery("Titles.getTitlesonLanguage", Titles.class);
				filteredQuery.setParameter("pLanguage", "%" + filterValue.toLowerCase() + "%");
				break;
			default:
				return null;
		}

		return filteredQuery.getResultList();
	}

}
