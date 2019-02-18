/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tabeladata.training.demospringboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author dimasm93
 */
@Controller
public class HaloController {

    @GetMapping("/halo")
    public String halo(Model model) {
        model.addAttribute("message", "Halo ini dari springboot");
        return "/contoh";
    }

}
