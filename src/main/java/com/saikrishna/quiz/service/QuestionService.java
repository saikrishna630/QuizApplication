package com.saikrishna.quiz.service;

import com.saikrishna.quiz.exception.QuestionNotFound;
import com.saikrishna.quiz.model.Question;
import com.saikrishna.quiz.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class QuestionService {
    @Autowired
    QuestionRepository questionRepository;

    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    public void addQuestion(Question question) {
        questionRepository.save(question);
    }

    public Question updateQuestion(Question question, long questionId) {
        Question ques=questionRepository.findById(questionId).orElseThrow(
                ()->new QuestionNotFound(String.format("Question with id %d is not present",questionId)));
        ques.setQuestionTitle(question.getQuestionTitle());
        ques.setCategory(question.getCategory());
        ques.setDifficultLevel(question.getDifficultLevel());
        ques.setOption1(question.getOption1());
        ques.setOption2(question.getOption2());
        ques.setOption3(question.getOption3());
        ques.setOption4(question.getOption4());
        ques.setCorrectAnswer(question.getCorrectAnswer());
        return questionRepository.save(ques);
    }

    public void deleteQuestion(long questionId) {
        Question question=questionRepository.findById(questionId).orElseThrow(
                ()-> new QuestionNotFound(String.format("Question with id %d is not present",questionId))
        );
        questionRepository.deleteById(questionId);
    }

    public List<Question> getQuestionsByCategory(String category) {
        return questionRepository.findByCategory(category);
    }
}
