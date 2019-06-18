package nntu.irit.asu.controller;

import nntu.irit.asu.model.Seats;
import nntu.irit.asu.service.SeatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class SeatsController {
    private SeatsService seatsService;

    @Autowired(required = true)
    @Qualifier(value = "seatsService")
    public void setSeatsService(SeatsService seatsService) {
        this.seatsService = seatsService;
    }

    @RequestMapping(value = "seats", method = RequestMethod.GET)
    public  String listSeats(Model model){
        model.addAttribute("seats", new Seats());
        model.addAttribute("listSeats", this.seatsService.listSeats());

        return "seats";
    }

    @RequestMapping(value = "/seats/addseats", method = RequestMethod.POST)
    public String addSeats(@ModelAttribute("seats") Seats seats){
        if(seats.getIdSeats()==0){
            this.seatsService.addSeats(seats);
        }
        else {
            this.seatsService.updateSeats(seats);
        }

        return "redirect:/seats";
    }

    @RequestMapping("/removeseats/{idSeats}")
    public String removeSeats(@PathVariable("idSeats") int idSeats){
        this.seatsService.removeSeats(idSeats);

        return "redirect:/seats";
    }

    @RequestMapping("editseats/{idSeats}")
    public String editSeats(@PathVariable("idSeats") int idSeats, Model model){
        model.addAttribute("seats", this.seatsService.getSeatsById(idSeats));
        model.addAttribute("listSeats", this.seatsService.listSeats());

        return "seats"; //??????????????????   return "redirect:/tickets"
    }

    @RequestMapping("seatsdata/{idSeats}")
    public String seatsData(@PathVariable("idSeats") int idSeats, Model model){
        model.addAttribute("seats", this.seatsService.getSeatsById(idSeats));

        return "seatsdata";
    }


}
