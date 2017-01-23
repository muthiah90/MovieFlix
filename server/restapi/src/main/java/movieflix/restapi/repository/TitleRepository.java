package movieflix.restapi.repository;

import java.util.List;

import movieflix.restapi.entity.Titles;

/**
 * @author Muthiah
 *
 */
public interface TitleRepository
{
	/**
	 * Method to return all the titles in the database
	 * 
	 * @return - The list of Titles object from the database
	 */
	public List<Titles> getAllTitles();

	/**
	 * Method to get the Titles object based on the title ID
	 * 
	 * @param titleId
	 *            - The ID for which the object has to be returned
	 * @return - The Titles object
	 */
	public Titles getTitle(String titleId);

	/**
	 * Method to get the Titles object based on the title name
	 * 
	 * @param titleName
	 *            - The name for which the Object has to be retrieved
	 * @return - Titles Object
	 */
	public Titles getTitleByTitle(String titleName);

	/**
	 * This method is to get Titles based on the type (movie, series)
	 * 
	 * @param customType
	 *            - This specifies the type(movie, series)
	 * @return - The list of Titles matching the type
	 */
	public List<Titles> getCustomTitles(String customType);

	/**
	 * This method is to create a new title
	 * 
	 * @param title
	 *            - Titles object to be persisted
	 * @return - The persisted object
	 */
	public Titles createTitle(Titles title);

	/**
	 * This method is used to update the existing the object
	 * 
	 * @param title
	 *            - The Object to be updated
	 * @return - The updated Titles object
	 */
	public Titles updateTitle(Titles title);

	/**
	 * This method is to delete the existing Titles object
	 * 
	 * @param title
	 *            - The object to be deleted
	 */
	public void deleteTitle(Titles title);

	/**
	 * This method is to get the top rated titles based on the type(movie,
	 * series). It returns the titles in descending order
	 * 
	 * @param value
	 *            - The type (movie,series)
	 * @return - The listing of matching titles in descending order
	 */
	public List<Titles> topRatedMoviesandSeries(String value);

	/**
	 * This method is used to get Titles based on genre, language
	 * 
	 * @param filterTag
	 *            - Genre/Language
	 * @param filterValue
	 *            - The specific language (English, Mandrin) or genre(crime,
	 *            thriller) to search for
	 * @return - List of Titles matching the selection criteria
	 */
	public List<Titles> customFilteredTitles(String filterTag, String filterValue);
}
