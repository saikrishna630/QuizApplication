package com.saikrishna.quiz.repository;

import com.saikrishna.quiz.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question,Long> {
    List<Question> findByCategory(String category);
    @Query(value = "SELECT * FROM question order by RAND() LIMIT :noOfQuestions",nativeQuery = true)
    List<Question> findRandomQuestions(int noOfQuestions);
}
