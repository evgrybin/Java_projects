package nntu.irit.asu.controller;

import nntu.irit.asu.model.Crews;
import nntu.irit.asu.service.CrewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CrewsController {
    private CrewsService crewsService;

    @Autowired(required = true)
    @Qualifier(value = "crewsService")
    public void setCrewsService(CrewsService crewsService) {
        this.crewsService = crewsService;
    }

    @RequestMapping(value = "crews", method = RequestMethod.GET)
    public  String listCrews(Model model){
        model.addAttribute("crews", new Crews());
        model.addAttribute("listCrews", this.crewsService.listCrews());

        return "crews";
    }

    @RequestMapping(value = "/crews/addcrews", method = RequestMethod.POST)
    public String addCrews(@ModelAttribute("crews") Crews crews){
        if(crews.getIdCrews()==0){
            this.crewsService.addCrews(crews);
        }
        else {
            this.crewsService.updateCrews(crews);
        }

        return "redirect:/crews";
    }

    @RequestMapping("/removecrews/{idCrews}")
    public String removeCrews(@PathVariable("idCrews") int idCrews){
        this.crewsService.removeCrews(idCrews);

        return "redirect:/crews";
    }

    @RequestMapping("editcrews/{idCrews}")
    public String editCrews(@PathVariable("idCrews") int idCrews, Model model){
        model.addAttribute("crews", this.crewsService.getCrewsById(idCrews));
        model.addAttribute("listCrews", this.crewsService.listCrews());

        return "crews"; //??????????????????   return "redirect:/tickets"
    }

    @RequestMapping("crewsdata/{idCrews}")
    public String crewsData(@PathVariable("idCrews") int idCrews, Model model){
        model.addAttribute("crews", this.crewsService.getCrewsById(idCrews));

        return "crewsdata";
    }
}
