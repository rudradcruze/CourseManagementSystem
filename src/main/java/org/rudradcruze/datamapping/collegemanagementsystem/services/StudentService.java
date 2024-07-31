package org.rudradcruze.datamapping.collegemanagementsystem.services;

import org.rudradcruze.datamapping.collegemanagementsystem.entities.Student;
import org.rudradcruze.datamapping.collegemanagementsystem.entities.Subject;
import org.rudradcruze.datamapping.collegemanagementsystem.repositories.StudentRepository;
import org.rudradcruze.datamapping.collegemanagementsystem.repositories.SubjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final SubjectRepository subjectRepository;

    public StudentService(StudentRepository studentRepository, SubjectRepository subjectRepository) {
        this.studentRepository = studentRepository;
        this.subjectRepository = subjectRepository;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    public Subject assignSubjectIntoStudent(Long studentId, Long subjectId) {
        Optional<Subject> subject = subjectRepository.findById(subjectId);
        Optional<Student> student = studentRepository.findById(studentId);

        return subject.flatMap(sub ->
                student.map(stu -> {
                    stu.getSubjects().add(sub);
                    studentRepository.save(stu);
                    sub.getStudents().add(stu);
                    return sub;
                })).orElse(null);
    }
}
