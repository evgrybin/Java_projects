package nntu.irit.asu.controller;

import nntu.irit.asu.model.Airports;
import nntu.irit.asu.service.AirplanesService;
import nntu.irit.asu.service.AirportsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AirportsController {
    private AirportsService airportsService;

    @Autowired(required = true)
    @Qualifier(value = "airportsService")
    public void setAirportsService(AirportsService airportsService) {
        this.airportsService = airportsService;
    }

    @RequestMapping(value = "airports", method = RequestMethod.GET)
    public  String listAirports(Model model){
        model.addAttribute("airports", new Airports());
        model.addAttribute("listAirports", this.airportsService.listAirports());

        return "airports";
    }

    @RequestMapping(value = "/airports/addairports", method = RequestMethod.POST)
    public String addAirports(@ModelAttribute("airports") Airports airports){
        if(airports.getIdAirports()==0){
            this.airportsService.addAirports(airports);
        }
        else {
            this.airportsService.updateAirports(airports);
        }

        return "redirect:/airports";
    }

    @RequestMapping("/removeairports/{idAirports}")
    public String removeAirports(@PathVariable("idAirports") int idAirports){
        this.airportsService.removeAirports(idAirports);

        return "redirect:/airports";
    }

    @RequestMapping("editairports/{idAirports}")
    public String editAirports(@PathVariable("idAirports") int idAirports, Model model){
        model.addAttribute("airports", this.airportsService.getAirportsById(idAirports));
        model.addAttribute("listAirports", this.airportsService.listAirports());

        return "airports"; //??????????????????   return "redirect:/tickets"
    }

    @RequestMapping("airportsdata/{idAirports}")
    public String airportsData(@PathVariable("idAirports") int idAirports, Model model){
        model.addAttribute("airports", this.airportsService.getAirportsById(idAirports));

        return "airportsdata";
    }
}
