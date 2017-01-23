package movieflix.restapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import movieflix.restapi.entity.Titles;
import movieflix.restapi.service.TitleService;

/**
 * @author Muthiah 
 * This is a controller class for handling all the request on
 *         Movies and Series stored in the database
 *
 */
@RestController
@RequestMapping(value = "titles")
public class TitlesController
{

	@Autowired
	private TitleService titleService;

	@RequestMapping(method = RequestMethod.GET)
	public List<Titles> getAllTitles()
	{
		return titleService.getAllTitles();
	}

	@RequestMapping(method = RequestMethod.GET, value = "{customType}")
	public List<Titles> getCustomTitles(@PathVariable("customType") String customType)
	{
		return titleService.getCustomTitles(customType);
	}

	@RequestMapping(method = RequestMethod.POST)
	public Titles createTitle(@RequestBody Titles title)
	{
		return titleService.createTitle(title);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "{titleId}")
	public Titles updateTitle(@PathVariable("titleId") String titleId, @RequestBody Titles title)
	{
		return titleService.updateTitle(titleId, title);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "{titleId}")
	public void deleteTitle(@PathVariable("titleId") String titleId)
	{
		titleService.deleteTitle(titleId);
	}

	@RequestMapping(method = RequestMethod.GET, value = "title/{titleId}")
	public Titles getByTitle(@PathVariable("titleId") String titleId)
	{
		return titleService.getTitle(titleId);
	}

	@RequestMapping(method = RequestMethod.GET, path = "toprated/{type}")
	public List<Titles> topRatedMoviesAndSeries(@PathVariable("type") String type)
	{
		return titleService.topRatedMoviesandSeries(type);
	}

	@RequestMapping(method = RequestMethod.GET, path = "{searchType}/{searchValue}")
	public List<Titles> searchMovies(@PathVariable("searchType") String searchType,
			@PathVariable("searchValue") String searchValue)
	{
		return titleService.customFilteredTitles(searchType, searchValue);
	}
}
