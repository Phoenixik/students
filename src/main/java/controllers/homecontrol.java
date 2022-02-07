package controllers;

import models.studentlist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import services.myservice;

import java.util.List;
import java.util.Optional;

@Controller
public class homecontrol {

    @Autowired
    myservice services;

    @GetMapping("/add")
    public String homepage(@ModelAttribute studentlist stud, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            System.out.println("error .." + bindingResult);
        }
        model.addAttribute("stud", stud);
        return "student_list";
    }

    @PostMapping("/save")
    public String save(@RequestParam String name, @RequestParam String country, @RequestParam String mobile) {
        services.saveall(name, country, mobile);

        return "redirect:/";
    }

    @PostMapping(value = "/update", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String saveas(@RequestParam String id, @RequestParam String name, @RequestParam String country, @RequestParam String mobile ) {
        System.out.println(id);
        services.update(name, country, mobile, id);

        return "redirect:/";
    }

    @GetMapping("/")
    public String retrieveall(Model model) {

        List<studentlist> liststud  = services.retrieveall();
        model.addAttribute("liststud", liststud);
        return "retrieve";
    }

    @GetMapping("/update/{studid}")
    public String updateall(@PathVariable("studid") String id, @ModelAttribute("stud") Optional<studentlist> stud, BindingResult bindingResult, Model model) {

        System.out.println(id);
        stud = services.retrieve(id);

//        model.addAttribute("id", s);
        model.addAttribute("stud", stud);
        return "saved_page";
    }

    @RequestMapping("/delete/{studid}")
    public String delete(@PathVariable("studid") String id) {
        services.delete(id);
        return "redirect:/";
    }

}
