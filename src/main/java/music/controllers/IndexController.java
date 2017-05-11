package music.controllers;

import music.entities.SongSearchParam;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {

	@RequestMapping(value = "/music", method = RequestMethod.GET)
	public String index(Model model){
		model.addAttribute("songSearchParam", new SongSearchParam());
		return "music/index";
	}
}
