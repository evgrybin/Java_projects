package nntu.irit.asu.controller;

import nntu.irit.asu.entity.Customer;
import nntu.irit.asu.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.transaction.Transactional;
import java.util.List;



@Controller
@RequestMapping(value = "/customer")
public class CustomerController {

    @Autowired
    private CustomerRepository repository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @Transactional
    public String getlist(Model model) {
        List<Customer> customers = repository.findAll();
        model.addAttribute("customers", customers);
        return "customer/customerspage";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    @Transactional
    public String getAdd(Model model) {
        model.addAttribute("customerAttribute", new Customer());
        return "customer/addpage";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @Transactional
    public String add(@ModelAttribute("customerAttribute") Customer customer) {
        repository.save(customer);
        return "customer/addedpage";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    @Transactional
    public String delete(@RequestParam(value = "id", required = true) Long id,
                         Model model) {
        repository.delete(repository.findOne(id));
        model.addAttribute("id", id);
        return "customer/deletedpage";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    @Transactional
    public String getEdit(@RequestParam(value = "id", required = true) Long id,
                          Model model) {
        model.addAttribute("customerAttribute", repository.findOne(id));
        return "customer/editpage";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    @Transactional
    public String saveEdit(@ModelAttribute("customerAttribute") Customer customer,
                           @RequestParam(value = "id", required = true) Long id,
                           Model model) {
        customer.setId(id);
        repository.save(customer);
        model.addAttribute("id", id);
        return "customer/editedpage";
    }
}

