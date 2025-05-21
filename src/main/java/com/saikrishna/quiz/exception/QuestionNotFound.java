package com.saikrishna.quiz.exception;

import org.springframework.stereotype.Component;

public class QuestionNotFound extends RuntimeException{
    public QuestionNotFound(String message){
        super(message);
    }
}
