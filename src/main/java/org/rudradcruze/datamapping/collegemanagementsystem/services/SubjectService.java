package org.rudradcruze.datamapping.collegemanagementsystem.services;

import org.rudradcruze.datamapping.collegemanagementsystem.entities.Professor;
import org.rudradcruze.datamapping.collegemanagementsystem.entities.Subject;
import org.rudradcruze.datamapping.collegemanagementsystem.repositories.ProfessorRepository;
import org.rudradcruze.datamapping.collegemanagementsystem.repositories.SubjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectService {

    private final SubjectRepository subjectRepository;
    private final ProfessorRepository professorRepository;

    public SubjectService(SubjectRepository subjectRepository, ProfessorRepository professorRepository) {
        this.subjectRepository = subjectRepository;
        this.professorRepository = professorRepository;
    }

    public Subject assignProfessorIntoStudent(Long subjectId, Long professorId) {
        Optional<Professor> professor = professorRepository.findById(professorId);
        Optional<Subject> subject = subjectRepository.findById(subjectId);

        return professor.flatMap(prof ->
                subject.map(sub -> {
                    sub.setProfessor(prof);
                    subjectRepository.save(sub);
                    return sub;
                })).orElse(null);
    }

    public List<Subject> getAllSubjects() {
        return subjectRepository.findAll();
    }

    public Subject getSubjectById(Long id) {
        return subjectRepository.findById(id).orElse(null);
    }

    public Subject saveSubject(Subject subject) {
        return subjectRepository.save(subject);
    }
}
