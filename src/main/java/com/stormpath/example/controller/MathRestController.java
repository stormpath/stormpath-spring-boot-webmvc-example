package com.stormpath.example.controller;

import com.stormpath.example.model.MathRequest;
import com.stormpath.example.model.MathResponse;
import com.stormpath.example.service.MathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class MathRestController {

    @Autowired
    MathService mathService;

    @RequestMapping(path = "/maths", method = POST)
    public MathResponse maths(@RequestBody MathRequest req) {
        return mathService.compute(req);
    }
}
