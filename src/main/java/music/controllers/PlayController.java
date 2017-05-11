package music.controllers;

import java.io.IOException;

import music.common.CallAPIGetMethod;
import music.entities.Song;
import music.entities.SongData;
import music.entities.SongSearchParam;
import music.enums.MusicMP3Enum;

import org.apache.commons.httpclient.HttpException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class PlayController {
	@RequestMapping(value = "/music/song/{songId}", method = RequestMethod.GET)
	public String songByCode(@PathVariable("songId") String songId, Model model) {

		Song song = new Song();
		String url = MusicMP3Enum.HOST.getText() + MusicMP3Enum.SONG.getText()
				+ songId;

		try {
			CallAPIGetMethod callAPI = new CallAPIGetMethod(url);
			byte[] responseBody = callAPI.getResponseBody();

			ObjectMapper objectMapper = new ObjectMapper();
			SongData songData = objectMapper.readValue(responseBody,
					SongData.class);
			if ("1".equals(songData.getError())) {
				model.addAttribute("song", song);
				model.addAttribute("songSearchParam", new SongSearchParam());
				return "music/index";
			}
			song.setTitle(songData.getData().getTitle());
			songData.getData().getQualities().sync();
			song.setQualities(songData.getData().getQualities());

		} catch (HttpException he) {
			he.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		model.addAttribute("song", song);
		model.addAttribute("songSearchParam", new SongSearchParam());
		return "music/index";
	}
}
