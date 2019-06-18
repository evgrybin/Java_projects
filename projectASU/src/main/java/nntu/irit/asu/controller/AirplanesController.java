package nntu.irit.asu.controller;

import nntu.irit.asu.model.Airplanes;
import nntu.irit.asu.service.AirplanesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AirplanesController {
    private AirplanesService airplanesService;

    @Autowired(required = true)
    @Qualifier(value = "airplanesService")
    public void setAirplanesService(AirplanesService airplanesService) {
        this.airplanesService = airplanesService;
    }

    @RequestMapping(value = "airplanes", method = RequestMethod.GET)
    public  String listAirplanes(Model model){
        model.addAttribute("airplanes", new Airplanes());
        model.addAttribute("listAirplanes", this.airplanesService.listAirplanes());

        return "airplanes";
    }

    @RequestMapping(value = "/airplanes/addairplanes", method = RequestMethod.POST)
    public String addAirplanes(@ModelAttribute("airplanes") Airplanes airplanes){
        if(airplanes.getIdAirplanes()==0){
            this.airplanesService.addAirplanes(airplanes);
        }
        else {
            this.airplanesService.updateAirplanes(airplanes);
        }

        return "redirect:/airplanes";
    }

    @RequestMapping("/removeairplanes/{idAirplanes}")
    public String removeAirplanes(@PathVariable("idAirplanes") int idAirplanes){
        this.airplanesService.removeAirplanes(idAirplanes);

        return "redirect:/airplanes";
    }

    @RequestMapping("editairplanes/{idAirplanes}")
    public String editAirplanes(@PathVariable("idAirplanes") int idAirplanes, Model model){
        model.addAttribute("airplanes", this.airplanesService.getAirplanesById(idAirplanes));
        model.addAttribute("listAirplanes", this.airplanesService.listAirplanes());

        return "airplanes"; //??????????????????   return "redirect:/tickets"
    }

    @RequestMapping("airplanesdata/{idAirplanes}")
    public String ticketsData(@PathVariable("idAirplanes") int idAirplanes, Model model){
        model.addAttribute("airplanes", this.airplanesService.getAirplanesById(idAirplanes));

        return "airplanesdata";
    }
}
