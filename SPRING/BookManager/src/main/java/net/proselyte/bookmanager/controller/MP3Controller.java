package net.proselyte.bookmanager.controller;

import net.proselyte.bookmanager.model.MP3;
import net.proselyte.bookmanager.service.MP3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by vika on 20.12.16.
 */
public class MP3Controller {
    private MP3Service mp3Service;

    @Autowired(required = true)
    @Qualifier(value = "mp3Service")
    public void setMp3Service(MP3Service mp3Service) {
        this.mp3Service = mp3Service;
    }

    @RequestMapping(value = "mp3", method = RequestMethod.GET)
    public String listMP3(Model model){
        model.addAttribute("mp3", new MP3());
        model.addAttribute("listMP3", this.mp3Service.listMP3());

        return "mp3";
    }
}
