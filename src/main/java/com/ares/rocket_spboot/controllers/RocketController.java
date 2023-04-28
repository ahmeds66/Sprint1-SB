package com.ares.rocket_spboot.controllers;

import com.ares.rocket_spboot.entities.Rocket;
import com.ares.rocket_spboot.service.RocketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class RocketController {
    final
    RocketService rocketService;

    public RocketController(RocketService rocketService) {
        this.rocketService = rocketService;
    }

    @RequestMapping("/showCreate")
    public String showCreate() {
        return "createRocket";
    }

    @RequestMapping("/saveRocket")
    public String saveRocket(@ModelAttribute("rocket") Rocket rocket, @RequestParam("date") String date,
                             ModelMap modelMap) throws
            ParseException {
        //date conversion
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        Date lunchDate = format1.parse(String.valueOf(date));
        rocket.setLunchDate(lunchDate);

        Rocket savedRocket = rocketService.saveRocket(rocket);
        String message = "Rocket saved with id: " + savedRocket.getIdRocket();
        modelMap.addAttribute("message", message);
        return "createRocket";
    }

    @RequestMapping("/ListRockets")
    public String listRockets(ModelMap modelMap, @RequestParam (name = "page", defaultValue = "0") int page,
                              @RequestParam (name = "size", defaultValue = "2") int size)
    {
        Page<Rocket> rocks = rocketService.getAllRocketsPerPage(page, size);
        modelMap.addAttribute("rockets", rocks);
        modelMap.addAttribute("pages", new int[rocks.getTotalPages()]);
        modelMap.addAttribute("currentPage", page);
        return "listRockets";
    }

    @RequestMapping("/deleteRocket")
    public String deleteRocket(@RequestParam("id") Long id, ModelMap modelMap,
                               @RequestParam (name = "page", defaultValue = "0") int page,
                               @RequestParam (name = "size", defaultValue = "2") int size) {
        rocketService.deleteRocketById(id);
        Page<Rocket> rocks = rocketService.getAllRocketsPerPage(page, size);
        modelMap.addAttribute("rockets", rocks);
        modelMap.addAttribute("pages", new int[rocks.getTotalPages()]);
        modelMap.addAttribute("currentPage", page);
        modelMap.addAttribute("size", size);
        return "listRockets";
    }

    @RequestMapping("/updateRocket")
    public String updateRocket(@RequestParam("id") Long id, ModelMap modelMap) {
        Rocket rocket = rocketService.getRocket(id);
        modelMap.addAttribute("rocket", rocket);
        return "updateRocket";
    }

    @RequestMapping("/updateRocketForm")
    public String updateRocket(@ModelAttribute("rocket") Rocket rocket, @RequestParam("date") String date,
                               ModelMap modelMap) throws ParseException {
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        Date lunchDate = format1.parse(String.valueOf(date));
        rocket.setLunchDate(lunchDate);

        rocketService.updateRocket(rocket);
        List<Rocket> rocks = rocketService.getAllRockets();
        modelMap.addAttribute("rockets", rocks);
        return "listRockets";
    }
}
