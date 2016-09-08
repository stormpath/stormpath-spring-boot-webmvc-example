package com.stormpath.example.controller;

import com.stormpath.example.model.MathRequest;
import com.stormpath.example.service.MathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class MathController {

    @Autowired
    MathService mathService;

    @RequestMapping(path = "/compute", method = GET)
    public String computeForm() {
        return "compute-form";
    }

    @RequestMapping(path = "/compute", method = POST)
    public String computeResult(MathRequest req, Model model) {
        model.addAttribute("mathResponse", mathService.compute(req));

        return "compute-result";
    }
}
