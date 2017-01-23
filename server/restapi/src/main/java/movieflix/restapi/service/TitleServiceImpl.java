package movieflix.restapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import movieflix.restapi.entity.Titles;
import movieflix.restapi.exception.BadRequest;
import movieflix.restapi.exception.RequestNotFoundException;
import movieflix.restapi.repository.TitleRepository;

/**
 * @author Muthiah
 * This is an implementation class for TitleService
 *
 */
@Service
public class TitleServiceImpl implements TitleService
{

	@Autowired
	private TitleRepository titleRepository;

	@Override
	@Transactional(readOnly = true)
	public List<Titles> getAllTitles()
	{
		return titleRepository.getAllTitles();
	}

	public Titles getTitle(String titleId)
	{
		return titleRepository.getTitle(titleId);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Titles> getCustomTitles(String customType)
	{
		return titleRepository.getCustomTitles(customType);
	}

	@Override
	@Transactional
	public Titles createTitle(Titles title)
	{
		Titles existingTitle = titleRepository.getTitleByTitle(title.getTitle());

		if (existingTitle == null)
		{
			return titleRepository.createTitle(title);
		}

		throw new BadRequest("Title already exists in the database, try updating the title to avoid the error");
	}

	@Override
	@Transactional
	public Titles updateTitle(String titleId, Titles title)
	{
		Titles existingTitle = titleRepository.getTitle(titleId);

		if (existingTitle != null)
		{
			existingTitle.copyFrom(title);
			return titleRepository.updateTitle(existingTitle);
		}
		else
		{
			throw new RequestNotFoundException("Title not found in the database to have the same updated");
		}
	}

	@Override
	@Transactional
	public void deleteTitle(String titleId)
	{
		Titles existingTitle = titleRepository.getTitle(titleId);

		if (existingTitle != null)
		{
			titleRepository.deleteTitle(existingTitle);
		}
		else
		{
			throw new RequestNotFoundException("Title not found in the database to delete the same");
		}

	}

	@Override
	@Transactional(readOnly = true)
	public List<Titles> topRatedMoviesandSeries(String value)
	{
		return titleRepository.topRatedMoviesandSeries(value);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Titles> customFilteredTitles(String filterTag, String filterValue)
	{
		return titleRepository.customFilteredTitles(filterTag, filterValue);
	}
}
