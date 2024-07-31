package org.rudradcruze.datamapping.collegemanagementsystem.controllers;

import org.rudradcruze.datamapping.collegemanagementsystem.entities.Professor;
import org.rudradcruze.datamapping.collegemanagementsystem.services.ProfessorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professors")
public class ProfessorController {

    private final ProfessorService professorService;

    public ProfessorController(ProfessorService professorService) {
        this.professorService = professorService;
    }

    @GetMapping
    public List<Professor> getAllProfessors() {
        return professorService.getAllProfessors();
    }

    @GetMapping("/{id}")
    public Professor getProfessorById(@PathVariable Long id) {
        return professorService.getProfessorById(id);
    }

    @PostMapping
    public Professor saveProfessor(@RequestBody Professor professor) {
        return professorService.saveProfessor(professor);
    }

    @PutMapping("/{professorId}/students/{studentId}")
    public Professor assignStudentIntoProfessor(@PathVariable Long professorId, @PathVariable Long studentId) {
        return professorService.assignStudentIntoProfessor(professorId, studentId);
    }

}
