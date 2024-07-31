package org.rudradcruze.datamapping.collegemanagementsystem.controllers;

import org.rudradcruze.datamapping.collegemanagementsystem.entities.Student;
import org.rudradcruze.datamapping.collegemanagementsystem.entities.Subject;
import org.rudradcruze.datamapping.collegemanagementsystem.services.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @PostMapping
    public Student saveStudent(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    @PutMapping("/{studentId}/subjects/{subjectId}")
    public Subject assignSubjectIntoStudent(@PathVariable Long studentId, @PathVariable Long subjectId) {
        return studentService.assignSubjectIntoStudent(studentId, subjectId);
    }
}
