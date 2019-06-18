package nntu.irit.asu.controller;

import nntu.irit.asu.model.Timetables;
import nntu.irit.asu.service.TimetablesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TimetablesController {
    private TimetablesService timetablesService;

    @Autowired(required = true)
    @Qualifier(value = "timetablesService")
    public void setTimetablesService(TimetablesService timetablesService) {
        this.timetablesService = timetablesService;
    }

    @RequestMapping(value = "timetables", method = RequestMethod.GET)
    public  String listTimetables(Model model){
        model.addAttribute("timetables", new Timetables());
        model.addAttribute("listTimetables", this.timetablesService.listTimetables());

        return "timetables";
    }

    @RequestMapping(value = "/timetables/addtimetables", method = RequestMethod.POST)
    public String addTimetables(@ModelAttribute("timetables") Timetables timetables){
        if(timetables.getIdTimetables()==0){
            this.timetablesService.addTimetables(timetables);
        }
        else {
            this.timetablesService.updateTimetables(timetables);
        }

        return "redirect:/timetables";
    }

    @RequestMapping("/removetimetables/{idTimetables}")
    public String removeTimetables(@PathVariable("idTimetables") int idTimetables){
        this.timetablesService.removeTimetables(idTimetables);

        return "redirect:/timetables";
    }

    @RequestMapping("edittimetables/{idTimetables}")
    public String editTimetables(@PathVariable("idTimetables") int idTimetables, Model model){
        model.addAttribute("timetables", this.timetablesService.getTimetablesById(idTimetables));
        model.addAttribute("listTimetables", this.timetablesService.listTimetables());

        return "timetables"; //??????????????????   return "redirect:/tickets"
    }

    @RequestMapping("timetablesdata/{idTimetables}")
    public String timetablesData(@PathVariable("idTimetables") int idTimetables, Model model){
        model.addAttribute("timetables", this.timetablesService.getTimetablesById(idTimetables));

        return "timetablesdata";
    }
}
