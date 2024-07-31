package org.rudradcruze.datamapping.collegemanagementsystem.services;

import org.rudradcruze.datamapping.collegemanagementsystem.entities.AdmissionRecord;
import org.rudradcruze.datamapping.collegemanagementsystem.entities.Student;
import org.rudradcruze.datamapping.collegemanagementsystem.repositories.AdmissionRecordRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdmissionRecordService {

    private final AdmissionRecordRepository admissionRecordRepository;
    private final StudentService studentService;

    public AdmissionRecordService(AdmissionRecordRepository admissionRecordRepository, StudentService studentService) {
        this.admissionRecordRepository = admissionRecordRepository;
        this.studentService = studentService;
    }

    public List<AdmissionRecord> getAllAdmissionRecords() {
        return admissionRecordRepository.findAll();
    }

    public AdmissionRecord getAdmissionRecordById(Long id) {
        return admissionRecordRepository.findById(id).orElse(null);
    }

    public AdmissionRecord saveAdmissionRecord(AdmissionRecord admissionRecord) {
        return admissionRecordRepository.save(admissionRecord);
    }

    public AdmissionRecord assignStudentIntoAdmission(Long admissionId, Long studentId) {
        Optional<AdmissionRecord> admissionRecord = admissionRecordRepository.findById(admissionId);
        Student student = studentService.getStudentById(studentId);
        return admissionRecord.map(admission -> {
            admission.setStudent(student);
            return admissionRecordRepository.save(admission);
        }).orElse(null);
    }
}
