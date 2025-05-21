package com.saikrishna.quiz.controller;

import com.saikrishna.quiz.model.Question;
import com.saikrishna.quiz.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("api/question")
public class QuestionController {
    @Autowired
    QuestionService questionService;

    @GetMapping("/allQuestions")
    public ResponseEntity<List<Question>> getAllQuestions(){
        return new ResponseEntity<>(questionService.getAllQuestions(), HttpStatus.OK);
    }

    @PostMapping("/addQuestion")
    public ResponseEntity<String> addQuestion(@RequestBody Question question){
        questionService.addQuestion(question);
        return new ResponseEntity<>("Question Added Successfully",HttpStatus.CREATED);
    }

    @PutMapping("/updateQuestion/{questionId}")
    public ResponseEntity<Question> updateQuestion(@RequestBody Question question, @PathVariable long questionId){
        return new ResponseEntity<>(questionService.updateQuestion(question,questionId),HttpStatus.OK);
    }

    @DeleteMapping("/deleteQuestion/{questionId}")
    public ResponseEntity<String> deleteQuestion(@PathVariable long questionId){
        questionService.deleteQuestion(questionId);
        return new ResponseEntity<>("Question Deleted Successfully",HttpStatus.OK);
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable String category){
        return new ResponseEntity<>(questionService.getQuestionsByCategory(category.toLowerCase()),HttpStatus.OK);
    }
}
