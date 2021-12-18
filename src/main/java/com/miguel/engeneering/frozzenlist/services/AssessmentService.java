package com.miguel.engeneering.frozzenlist.services;

import com.miguel.engeneering.frozzenlist.models.Assessment;

import java.util.List;

public interface AssessmentService {

    Assessment saveAssessment(Assessment assessment);
    List<Assessment>saveAllAssessments(List<Assessment>assessments);

    boolean deleteAssessmentById(Long id);
    void deleteAllAssessmentsById(List<Long>ids);

    List<Assessment> findAssessmentByDescriptionValue(String value);
    List<Assessment> sortAssessmentByEvaluation(List<Assessment> assessments);
}
