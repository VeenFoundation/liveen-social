package com.doubles.qna.web;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.doubles.qna.domain.Activity;
import com.doubles.qna.domain.ActivityRepository;
import com.doubles.qna.domain.User;

@RestController
@RequestMapping("/activity/favorite")
public class FavoriteController {
    @Autowired
    private ActivityRepository activityRepository;
    
    // Like / Dislike Count 하기 
    @PostMapping("/{id}/{favor}")
    public  Activity favoriteLike(@PathVariable Long id, @PathVariable String favor, HttpSession session)  {
        
        // 로그인되어 있지 않으면 로그인 페이지로
        if ( !HttpSessionUtils.isLoginUser(session) ) {
            return null;
        }  
        
        // 로그인된 회원의 정보 가져오기
        User loginUser = HttpSessionUtils.getUserFromSession(session);
        System.out.println("userId = " + loginUser.getId());
        
        Activity activity = activityRepository.findOne(id);

        if (!activity.isSameWriter(loginUser)) {
            if (favor.equals("like"))
            	    activity.like_hit();
            else 
            	    activity.dislike_hit();

            activityRepository.save(activity);
        } else {
        	    return null;
        }
        
//        List<Activity> aList = activityRepository.findByTitle("Hot");
//        for(Activity act : aList){
//        	System.out.println("alist = " + act.toString());
//        }
//        List<Activity> aList = activityRepository.findAllMyData();
// 
//        Gson gson = new Gson();
//        System.out.println("alist Json = " + gson.toJson(aList));
        
        RestTemplate restTemplate = new RestTemplate();
//        Quote quote = restTemplate.getForObject("http://gturnquist-quoters.cfapps.io/api/random", Quote.class);  // Call restapi and return with Quote class (To create)

        
        
	
        return activity;
    }    
}
