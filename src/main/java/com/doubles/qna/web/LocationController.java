package com.doubles.qna.web;

import com.doubles.qna.domain.Activity;
import com.doubles.qna.domain.ActivityRepository;
import com.doubles.qna.domain.ContentType;
import com.doubles.qna.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/locations")
public class LocationController {
    @Autowired
    private ActivityRepository activityRepo;

    // 질문 작성 화면
    @GetMapping("/form")
    public String question(HttpSession session) {
        // 로그인되어 있지 않으면 로그인 페이지로
        if ( !HttpSessionUtils.isLoginUser(session)) {
            return "redirect:/users/loginForm";
        }
        return "/location/form";
    }

    @PostMapping
    public String createLocation(String location, String behavior, HttpSession session) {
        // 로그인되어 있지 않으면 로그인 페이지로
        if ( !HttpSessionUtils.isLoginUser(session) ) {
            return null;
        }

        User loginUser = HttpSessionUtils.getUserFromSession(session);

        Activity activity = new Activity(loginUser, "# New Location", "", "");
        activity.setLocation(location);
        activity.setBehaviour(behavior);
        activity.setContentType(ContentType.CONTENT_LCOATION);

        activityRepo.save(activity);

        return "redirect:/";
    }
}
