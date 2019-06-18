package nntu.irit.asu.controller;

import nntu.irit.asu.model.Tickets;
import nntu.irit.asu.service.TicketsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TicketsController {
    private TicketsService ticketsService;

    @Autowired(required = true)
    @Qualifier(value = "ticketsService")
    public void setTicketsService(TicketsService ticketsService) {
        this.ticketsService = ticketsService;
    }

    @RequestMapping(value = "tickets", method = RequestMethod.GET)
    public  String listTickets(Model model){
        model.addAttribute("tickets", new Tickets());
        model.addAttribute("listTickets", this.ticketsService.listTickets());

        return "tickets";
    }

    @RequestMapping(value = "/tickets/addtickets", method = RequestMethod.POST)
    public String addTickets(@ModelAttribute("tickets") Tickets tickets){
        if(tickets.getIdTickets()==0){
            this.ticketsService.addTickets(tickets);
        }
        else {
            this.ticketsService.updateTickets(tickets);
        }

        return "redirect:/tickets";
    }

    @RequestMapping("/removetickets/{idTickets}")
    public String removeTickets(@PathVariable("idTickets") int idTickets){
        this.ticketsService.removeTickets(idTickets);

        return "redirect:/tickets";
    }

    @RequestMapping("edittickets/{idTickets}")
    public String editTickets(@PathVariable("idTickets") int idTickets, Model model){
        model.addAttribute("tickets", this.ticketsService.getTicketsById(idTickets));
        model.addAttribute("listTickets", this.ticketsService.listTickets());

        return "tickets"; //??????????????????   return "redirect:/tickets"
    }

    @RequestMapping("ticketsdata/{idTickets}")
    public String ticketsData(@PathVariable("idTickets") int idTickets, Model model){
        model.addAttribute("tickets", this.ticketsService.getTicketsById(idTickets));

        return "ticketsdata";
    }
}


