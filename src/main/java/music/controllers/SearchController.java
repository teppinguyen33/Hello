package music.controllers;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import music.entities.Song;
import music.entities.SongSearchParam;
import music.enums.MusicMP3Enum;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import common.SystemException;

@Controller
public class SearchController {

	@RequestMapping(value = "/music/search", method = RequestMethod.GET)
	public String searchSong(Model model,
			@ModelAttribute("songSearchParam") SongSearchParam songSearchParam)
			throws SystemException {

		// Request search
		Document doc = requestSearch(songSearchParam.getQ());

		// Retrieve song info
		List<Song> listSong = retrieveSongInfo(doc);
		
		// Select total song
		String total = doc.select("div.item-search > h3.title-sub").get(0).text();
		
		// Set data to display
		model.addAttribute("listSong", listSong);
		model.addAttribute("keyword", songSearchParam.getQ());
		model.addAttribute("total", total);
		
		return "music/result";
	}

	// **********
	/**
	 * Private method
	 * 
	 * @throws IOException
	 * @throws SystemException
	 */
	// **********

	private String getSongIdFromUrl(String url) {
		if (url == null || "".equals(url)) {
			return null;
		}
		int start = url.lastIndexOf("/");
		int end = url.lastIndexOf(".");

		return (start == -1 || end == -1) ? null : url
				.substring(start + 1, end);
	}

	private List<Song> retrieveSongInfo(Document doc) {
		List<Song> listSong = null;

		// Select all a tag within div tag and href start with /bai-hat/
		Elements songUrls = doc.select("div.obj-inside.not-img > a[href^=/bai-hat/]");
		// Select all h2 tag within div tag and have class title-song
		Elements titles = doc.select("div.obj-inside.not-img > h2.title-song.ellipsis-2");
		// Select all h3 tag within div tag and have class title-sub
		Elements artists = doc.select("div.obj-inside.not-img > h3.title-sub");
		// Select all span tag within div tag and have class nu
		Elements listens = doc.select("div.obj-inside.not-img > span.nu");
		
		int songNum = 0;
		if (songUrls == null || songUrls.size() == 0) {
			return null;
		} else {
			listSong = new ArrayList<Song>();
			songNum = songUrls.size();
		}
		
		String songId = null;
		String title = null;
		String artist = null;
		String listen = null;
		
		Element songUrl = null;
		Element titleEle = null;
		Element artistEle = null;
		Element listenEle = null;
		
		for (int i = 0; i < songNum; i++) {
			songUrl = songUrls.get(i);
			titleEle = titles.get(i);
			artistEle = artists.get(i);
			listenEle = listens.get(i);
			
			songId = getSongIdFromUrl(songUrl.attr("href"));
			title = titleEle.text();
			artist = artistEle.text();
			listen = listenEle.text();
			
			Song song = new Song();
			song.setId(songId);
			song.setTitle(title);
			song.setArtist(artist);
			song.setListen(listen);
			
			listSong.add(song);
		}

		return listSong;
	}

	private Document requestSearch(String keyword) throws SystemException {
		Document document = null;
		String url = null;
		try {
			String param = "?q=" + URLEncoder.encode(keyword, "UTF-8");
			url = MusicMP3Enum.HOST.getText() + MusicMP3Enum.SEARCH.getText()
					+ param;
			document = Jsoup.connect(url).get();
		} catch (IOException e) {
			throw new SystemException("Can't request to url: " + url, e);
		}
		return document;
	}
}
