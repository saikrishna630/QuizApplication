package com.saikrishna.quiz.service;

import com.saikrishna.quiz.model.AttemptedQuestions;
import com.saikrishna.quiz.model.Question;
import com.saikrishna.quiz.model.QuestionWrapper;
import com.saikrishna.quiz.model.Quiz;
import com.saikrishna.quiz.repository.QuestionRepository;
import com.saikrishna.quiz.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    @Autowired
    QuizRepository quizRepository;
    @Autowired
    QuestionRepository questionRepository;

    public void createQuiz(int noOfQuestions, String quizTitle) {
        List<Question> questions=questionRepository.findRandomQuestions(noOfQuestions);
        Quiz quiz=new Quiz();
        quiz.setQuizTitle(quizTitle);
        quiz.setQuestions(questions);
        quizRepository.save(quiz);
    }

    public List<QuestionWrapper> getQuiz(long id) {
        Optional<Quiz> quiz=quizRepository.findById(id);
        List<Question> questionList=quiz.get().getQuestions();
        List<QuestionWrapper> questions=new ArrayList<>();
        for(Question q:questionList){
            QuestionWrapper qw=new QuestionWrapper(q.getId(),q.getQuestionTitle(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
            questions.add(qw);
        }
        return questions;
    }

    public Integer calculateResult(long id, List<AttemptedQuestions> attemptedQuestions) {
        Quiz quiz=quizRepository.findById(id).get();
        List<Question> questions=quiz.getQuestions();
        int score=0;
        int i=0;
        for(AttemptedQuestions attemptedQuestion:attemptedQuestions){
            if(attemptedQuestion.getAnswer().equalsIgnoreCase(questions.get(i).getCorrectAnswer())){
                score++;
            }
            i++;
        }
        return score;
    }
}
