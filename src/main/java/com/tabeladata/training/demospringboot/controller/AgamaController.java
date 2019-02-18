/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tabeladata.training.demospringboot.controller;

import com.tabeladata.training.demospringboot.AgamaMapper;
import com.tabeladata.training.demospringboot.dto.AgamaDto;
import com.tabeladata.training.demospringboot.entity.Agama;
import com.tabeladata.training.demospringboot.repository.AgamaRepository;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author dimasm93
 */
@Controller
@RequestMapping("/master/agama")
public class AgamaController {

    @Autowired
    private AgamaRepository dao;

    private final Logger console = LoggerFactory.getLogger(AgamaController.class);

    @GetMapping({"/", "/list"})
    public String list(Model model) {
        List<Agama> list = dao.findAll();
        model.addAttribute("list", list);
        return "/pages/agama/list-agama";
    }

    @GetMapping("/{id}")
    public String findById(@PathVariable("id") Integer id, Model model) {
        Agama agama = dao.findById(id);
        model.addAttribute("obj", AgamaMapper.INSTANCE.convertToDto(agama));
        return "/pages/agama/update-agama";
    }

    @GetMapping("/new")
    public String formNew(Model model, @ModelAttribute AgamaDto.AgamaNewRequest agama) {
        model.addAttribute("obj", agama);
        return "/pages/agama/new-agama";
    }

    @PostMapping("/new")
    public String formNewSubmit(
            @ModelAttribute("obj") @Validated AgamaDto.AgamaNewRequest agama,
            BindingResult binding) {
        if (binding.hasErrors()) {
            console.error("{}", binding.getAllErrors());
            return "/pages/agama/new-agama";
        }

        Agama value = AgamaMapper.INSTANCE.convertToEntity(agama);
        console.info("{} : {}", agama, value);

        value.setCreatedBy("admin");
        value.setCreatedDate(Timestamp.valueOf(LocalDateTime.now()));
        dao.save(value);
        return "redirect:/master/agama/list";
    }

    @PostMapping("/update")
    public String formUpdateSubmit(
            @ModelAttribute("obj") @Validated AgamaDto.AgamaUpdateRequest agama,
            BindingResult binding) {
        if (binding.hasErrors()) {
            console.error("{}", binding.getAllErrors());
            return "/pages/agama/update-agama";
        }

        Agama value = AgamaMapper.INSTANCE.convertToEntityUpdated(agama);
        console.info("{} : {}", agama, value);
        value.setLastUpdateBy("admin");
        dao.update(value);
        return "redirect:/master/agama/list";
    }
    
    @GetMapping("/delete/{id}")
    public String formUpdateSubmit(
            @PathVariable("id")Integer id) {
        boolean removed = dao.removeById(id);
        return  "redirect:/master/agama/list";
    }

}
