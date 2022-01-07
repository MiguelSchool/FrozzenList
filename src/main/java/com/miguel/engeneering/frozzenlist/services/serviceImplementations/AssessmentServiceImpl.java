package com.miguel.engeneering.frozzenlist.services.serviceImplementations;

import com.miguel.engeneering.frozzenlist.models.Assessment;
import com.miguel.engeneering.frozzenlist.repositories.AssessmentRepository;
import com.miguel.engeneering.frozzenlist.services.AssessmentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

@Service
@AllArgsConstructor
public class AssessmentServiceImpl implements AssessmentService {


    private AssessmentRepository assessmentRepository;

    @Override
    public Assessment saveAssessment(Assessment assessment) {
        return this.assessmentRepository.save(assessment);
    }

    @Override
    public List<Assessment> saveAllAssessments(List<Assessment> assessments) {
        assessments.forEach(this::saveAssessment);
        return assessments;
    }

    @Override
    public boolean deleteAssessmentById(Long id) {
        this.assessmentRepository.deleteById(id);
        return this.assessmentRepository.existsById(id);
    }

    @Override
    public void deleteAllAssessmentsById(List<Long> ids) {
        ids.forEach(this::deleteAssessmentById);
    }

    @Override
    public List<Assessment> findAssessmentByDescriptionValue(String value) {
        List<Assessment>assessments = new ArrayList<>();
        Iterator<Assessment> assessmentIterator = this.assessmentRepository.findAll().iterator();
        while (assessmentIterator.hasNext()){
            if(assessmentIterator.next().getDescription().contains(value)) {
                assessments.add(assessmentIterator.next());
            }
        }
        return assessments;
    }

    @Override
    public List<Assessment> sortAssessmentByEvaluation(List<Assessment> assessments) {
        return assessments.stream()
                          .sorted(Comparator.comparing(Assessment::getEvaluation))
                          .toList();
    }
}
