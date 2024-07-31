package org.rudradcruze.datamapping.collegemanagementsystem.controllers;

import org.rudradcruze.datamapping.collegemanagementsystem.entities.Subject;
import org.rudradcruze.datamapping.collegemanagementsystem.services.SubjectService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subjects")
public class SubjectController {

    private final SubjectService subjectService;

    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @GetMapping
    public List<Subject> getAllSubjects() {
        return subjectService.getAllSubjects();
    }

    @PostMapping
    public Subject saveSubject(@RequestBody Subject subject) {
        return subjectService.saveSubject(subject);
    }

    @GetMapping("/{id}")
    public Subject getSubjectById(@PathVariable Long id) {
        return subjectService.getSubjectById(id);
    }

    @PutMapping("/{subjectId}/professors/{professorId}")
    public Subject assignProfessorIntoSubject(@PathVariable Long subjectId, @PathVariable Long professorId) {
        return subjectService.assignProfessorIntoStudent(subjectId, professorId);
    }
}
