package com.doubles.qna.web;

import com.doubles.qna.domain.Activity;
import com.doubles.qna.domain.ActivityRepository;
import com.doubles.qna.domain.ContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private ActivityRepository activityRepository;

    @GetMapping("/")
    public String home(Model model) {
    	
    	Sort sort = new Sort(Direction.DESC, "id");
        List<Activity> activities = activityRepository.findAll(sort);

        for(Activity act : activities) {
            act.setIsLocation(act.getContentType().equals(ContentType.CONTENT_LCOATION));
            System.out.println("--------------");
            System.out.println(act.getLocation() + " -/- " + act.getBehaviour());
            System.out.println("-------------");
        }

        model.addAttribute("activities", activities);
        return "index";
    }

}
