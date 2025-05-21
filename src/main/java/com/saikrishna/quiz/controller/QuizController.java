package com.saikrishna.quiz.controller;

import com.saikrishna.quiz.model.AttemptedQuestions;
import com.saikrishna.quiz.model.QuestionWrapper;
import com.saikrishna.quiz.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("api/quiz")
public class QuizController {
    @Autowired
    QuizService quizService;

    @PostMapping("/createQuiz")
    public ResponseEntity<String> createQuiz(
            @RequestParam(value = "noOfQuestions") int noOfQuestions,
            @RequestParam(value = "quizTitle") String quizTitle){
        quizService.createQuiz(noOfQuestions,quizTitle);
        return new ResponseEntity<>("Quiz Created Successfully", HttpStatus.CREATED);
    }

    @GetMapping("/getQuiz/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuiz(@PathVariable long id){
        return new ResponseEntity<>(quizService.getQuiz(id),HttpStatus.OK);
    }

    @PostMapping("/submit/{id}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable long id, @RequestBody List<AttemptedQuestions> attemptedQuestions){
        return new ResponseEntity<>(quizService.calculateResult(id,attemptedQuestions),HttpStatus.CREATED);
    }

}
