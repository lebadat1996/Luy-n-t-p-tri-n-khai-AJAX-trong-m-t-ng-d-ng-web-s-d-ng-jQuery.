package com.codegym.controller;

import com.codegym.model.Phones;
import com.codegym.service.IPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/smartPhone")
public class PhoneController {
    @Autowired
    IPhoneService phoneService;

    @GetMapping("list")
    public ModelAndView showListPhone() {
        ModelAndView modelAndView = new ModelAndView("list");
        Iterable<Phones> phones = phoneService.findAll();
        modelAndView.addObject("phone", phones);
        return modelAndView;
    }

    @GetMapping("create")
    public ModelAndView createPhone() {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("phone", new Phones());
        return modelAndView;
    }


    @PostMapping(value = "create", produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Phones create(@RequestBody Phones phones) {
        return phoneService.save(phones);
    }

    @GetMapping("edit/{id}")
    public ModelAndView showEdit(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("edit");
        Phones phones = phoneService.getPhoneById(id);
        if (phones != null) {
            modelAndView.addObject("phone", phones);
        }
        return modelAndView;
    }

    @PostMapping(value = "edit/{id}", produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Phones update(@RequestBody Phones phones, @PathVariable Long id) {
        phones.setId(id);
        return phoneService.save(phones);
    }

    @RequestMapping(method = RequestMethod.POST, value = "delete/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Phones deletePhone(@PathVariable Long id) {
        return phoneService.delete(id);
    }

}
