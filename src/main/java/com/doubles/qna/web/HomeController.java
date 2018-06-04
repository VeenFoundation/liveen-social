package com.doubles.qna.web;

import com.doubles.qna.domain.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @Autowired
    private ActivityRepository questionRepository;

    @GetMapping("/")
    public String home(Model model) {
    	
    	Sort sort = new Sort(Direction.DESC, "id");
        model.addAttribute("questions", questionRepository.findAll(sort)); 
        return "index";
    }

}
