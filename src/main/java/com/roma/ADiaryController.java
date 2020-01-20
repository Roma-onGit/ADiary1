package com.roma;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/design")
public class ADiaryController {

    @Autowired
    RecordRepository repository;

    Iterable list;

    @GetMapping
    public String showDesignForm(Model model)  {

        model.addAttribute("rec", new Record());
        return "design";
    }

    @PostMapping
    public String processDesign(Record record, Model model)  {

        repository.save(record);

        list = repository.findAll();   list.forEach(x -> System.out.println(x));

        model.addAttribute("records", list);

        return "design1";
    }
}
