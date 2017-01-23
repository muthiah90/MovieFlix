package movieflix.restapi.service;

import java.util.List;

import movieflix.restapi.entity.Titles;

/**
 * @author Muthiah
 *
 */
public interface TitleService
{
	/**
	 * This method is used to get all the titles from the DB
	 * @return - List of titles
	 */
	public List<Titles> getAllTitles();

	/**
	 * This method is to get a title based on the ID
	 * @param titleId
	 * @return - The title object
	 */
	public Titles getTitle(String titleId);

	/**
	 * This is to get titles based on types like movies, series
	 * @param customType - Type(movie/series)
	 * @return - List of Titles
	 */
	public List<Titles> getCustomTitles(String customType);

	/**
	 * This is to create a new title
	 * @param title - Title object to be persisted
	 * @return - The persisted object
	 */
	public Titles createTitle(Titles title);

	/**
	 * This method updates the existing title
	 * @param titleId - The title id to be updated
	 * @param title - The new title object that has to be persisted
	 * @return - The updated title object
	 */
	public Titles updateTitle(String titleId, Titles title);

	/**
	 * This is to delete the existing title
	 * @param titleId - The title ID to be deleted
	 */
	public void deleteTitle(String titleId);

	/**
	 * This gets the top rated movies or series. The list is ordered in descending order based on the rating
	 * @param value - Movie / Series
	 * @return - List of titles
	 */
	public List<Titles> topRatedMoviesandSeries(String value);

	/**
	 * This is to filter movies and series based on language and genre
	 * @param filterTag - Language/ Genre
	 * @param filterValue - Specific language or genre to be filtered
	 * @return
	 */
	public List<Titles> customFilteredTitles(String filterTag, String filterValue);
}
