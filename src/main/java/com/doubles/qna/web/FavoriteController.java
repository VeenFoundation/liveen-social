package com.doubles.qna.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.doubles.qna.domain.Activity;
import com.doubles.qna.domain.ActivityRepository;
import com.doubles.qna.domain.Result;
import com.doubles.qna.domain.User;

@RestController
@RequestMapping("/activity/favorite")
public class FavoriteController {

    @Autowired
    private ActivityRepository activityRepository;
	
    
    // Like / Dislike Count 하기 
//    @GetMapping("/favorite/{id}")
//    @PostMapping
    @PostMapping("/{id}/{favor}")
    public  Activity favoriteLike(@PathVariable Long id, @PathVariable String favor, HttpSession session)  {
    	
        System.out.println("activity id : " + id);
        
        // 로그인되어 있지 않으면 로그인 페이지로
        if ( !HttpSessionUtils.isLoginUser(session) ) {
            return null;
        }  
        
        // 로그인된 회원의 정보 가져오기
        User loginUser = HttpSessionUtils.getUserFromSession(session);
        System.out.println("userId = " + loginUser.getId());
        
        Activity activity = activityRepository.findOne(id);

        if(!activity.isSameWriter(loginUser)){
            if(favor.equals("like"))
            	activity.like_hit();  
            else 
            	activity.dislike_hit();
            activityRepository.save(activity);
        }else {
        	return null;
        }

        return activity;
    }    
}
