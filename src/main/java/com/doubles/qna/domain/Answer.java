package com.doubles.qna.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
public class Answer extends AbstractEntity{

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_answer_writer"))
    @JsonProperty
    private User writer;

    @Lob // 255자가 넘는 String 타입일 경우 애노테이션 추가
    @JsonProperty
    private String contents;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_answer_question"))
    @JsonProperty
    private Activity activity;

    // 기본 생성자
    public Answer() {
    }

    // 생성자
    public Answer(User writer, Activity activity, String contents) {
        this.writer = writer;
        this.contents = contents;
        this.activity = activity;
    }

    public boolean isSameWriter(User loginUser) {
        return loginUser.equals(this.writer);
    }

    @Override
    public String toString() {
        return "Answer{" + super.toString() +
                "writer=" + writer +
                ", contents='" + contents + '\'' +
                ", activity=" + activity +
                '}';
    }
}
