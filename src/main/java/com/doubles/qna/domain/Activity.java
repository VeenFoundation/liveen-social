package com.doubles.qna.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Entity
public class Activity extends AbstractEntity {

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_question_writer"))
    @JsonProperty
    private User writer;

    @JsonProperty
    private String title;
    
    @JsonProperty
    private String location;
    
    @JsonProperty
    private String behaviour;
    
    @JsonProperty
    private String hashtag;
    
    @JsonProperty
    private Integer like_hit = 0;
    
    @JsonProperty
    private Integer dislike_hit = 0;

    @Lob
    @JsonProperty
    private String contents;
    
    @JsonProperty
    private String contentType;

    @OneToMany(mappedBy = "activity")
    @OrderBy("id DESC")
    private List<Answer> answers;

    @JsonProperty
    private Integer countOfAnswer = 0;

    @JsonProperty
    private boolean isLocation = false;

    public Activity() {
    }

    public Activity(User writer, String title, String contents, String hashtag) {
        this.writer = writer;
        this.title = title;
        this.contents = contents;
        this.hashtag = hashtag;
    }

    // 로그인유저와 글작성자 비교
    public boolean isSameWriter(User loginUser) {
        return this.writer.equals(loginUser);
    }

    // update 메서드
    public void update(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }

    // 답변 수 증가 메서드
    public void addAnswer() {
        this.countOfAnswer += 1;
    }

    // 답변 수 감소 메서드
    public void deleteAnswer() {
        this.countOfAnswer -= 1;
    }
    
    // like 버튼 hit
    public void like_hit(){
    	this.like_hit += 1;
    }
    
    // dislike 버튼 hit
    public void dislike_hit(){
    	this.dislike_hit += 1;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getBehaviour() {
        return behaviour;
    }

    public void setBehaviour(String behaviour) {
        this.behaviour = behaviour;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public boolean isLocation() {
        return isLocation;
    }

    public void setIsLocation(boolean location) {
        isLocation = location;
    }

    //    @Override
//    public String toString() {
//        return "Activity{" + super.toString() +
//                "writer=" + writer +
//                ", title='" + title + '\'' +
//                ", contents='" + contents + '\'' +
//                ", hashtag='" + hashtag + '\'' +
//                ", answers=" + answers + '\'' +
//                ", countOfAnswer=" + countOfAnswer +
//                ", like_hit=" + like_hit +
//                ", dislike_hit=" + dislike_hit +
//                '}';
//    }

    @Override
    public String toString() {
        return "Activity{" + super.toString() +
                "writer=" + writer +
                ", title='" + title + '\'' +
                ", contents='" + contents + '\'' +
                ", answers=" + answers +
                ", countOfAnswer=" + countOfAnswer +
                ", location=" + location +
                ", behaviour=" + behaviour +
                ", hashtag=" + hashtag +
                ", like_hit=" + like_hit +
                ", dislike_hit=" + dislike_hit +
                ", contentType=" + contentType +
                '}';
    }
}

