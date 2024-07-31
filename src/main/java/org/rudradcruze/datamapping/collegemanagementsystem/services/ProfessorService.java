package org.rudradcruze.datamapping.collegemanagementsystem.services;

import org.rudradcruze.datamapping.collegemanagementsystem.entities.Professor;
import org.rudradcruze.datamapping.collegemanagementsystem.entities.Student;
import org.rudradcruze.datamapping.collegemanagementsystem.repositories.ProfessorRepository;
import org.rudradcruze.datamapping.collegemanagementsystem.repositories.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfessorService {

    private final ProfessorRepository professorRepository;
    private final StudentRepository studentRepository;

    public ProfessorService(ProfessorRepository professorRepository, StudentRepository studentRepository) {
        this.professorRepository = professorRepository;
        this.studentRepository = studentRepository;
    }

    public List<Professor> getAllProfessors() {
        return professorRepository.findAll();
    }

    public Professor getProfessorById(Long id) {
        return professorRepository.findById(id).orElse(null);
    }

    public Professor saveProfessor(Professor professor) {
        return professorRepository.save(professor);
    }

    public Professor assignStudentIntoProfessor(Long professorId, Long studentId) {
        Optional<Professor> professor = professorRepository.findById(professorId);
        Optional<Student> student = studentRepository.findById(studentId);

        return professor.flatMap(prof ->
            student.map(stu -> {
                stu.getProfessors().add(prof);
                studentRepository.save(stu);
                prof.getStudents().add(stu);
                return prof;
            })).orElse(null);
    }
}
