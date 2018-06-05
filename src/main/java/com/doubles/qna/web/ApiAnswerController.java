package com.doubles.qna.web;

import com.doubles.qna.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/api/questions/{activityId}/answers")
public class ApiAnswerController {

    @Autowired
    private AnswerRepository answerRepository;

    @Autowired
    private ActivityRepository activityRepository;

    // 답변 하기
    @PostMapping
    public  Answer create(@PathVariable Long activityId, String contents, HttpSession session) {
        // 로그인되어 있지 않으면 로그인 페이지로
        if ( !HttpSessionUtils.isLoginUser(session) ) {
            return null;
        }
        // 로그인된 회원의 정보 가져오기
        User loginUser = HttpSessionUtils.getUserFromSession(session);
        Activity activity = activityRepository.findOne(activityId);
        Answer answer = new Answer(loginUser, activity, contents);
        // 답변의 갯수 증가
        activity.addAnswer();
        return answerRepository.save(answer); 
        
    }

    // 답변 삭제하기
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long activityId, @PathVariable Long id, HttpSession session) {
        if ( !HttpSessionUtils.isLoginUser(session) ) {
            return Result.fail("로그인해야 합니다.");
        }

        Answer answer = answerRepository.findOne(id);
        User loginUser = HttpSessionUtils.getUserFromSession(session);
        if ( !answer.isSameWriter(loginUser) ) {
            return Result.fail("자신의 글만 삭제할 수 있습니다.");
        }

        answerRepository.delete(id);
        Activity activity = activityRepository.findOne(activityId);
        // 답변의 갯수 감소
        activity.deleteAnswer();
        activityRepository.save(activity);
        return Result.ok();
    }
}
