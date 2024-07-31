package org.rudradcruze.datamapping.collegemanagementsystem.controllers;

import org.rudradcruze.datamapping.collegemanagementsystem.entities.AdmissionRecord;
import org.rudradcruze.datamapping.collegemanagementsystem.services.AdmissionRecordService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admission")
public class AdmissionRecordController {

    private final AdmissionRecordService admissionRecordService;

    public AdmissionRecordController(AdmissionRecordService admissionRecordService) {
        this.admissionRecordService = admissionRecordService;
    }

    @GetMapping
    public List<AdmissionRecord> getAllAdmissionRecords() {
        return admissionRecordService.getAllAdmissionRecords();
    }

    @PostMapping()
    public AdmissionRecord saveAdmissionRecord(@RequestBody AdmissionRecord admissionRecord) {
        return admissionRecordService.saveAdmissionRecord(admissionRecord);
    }

    @GetMapping("/{id}")
    public AdmissionRecord getAdmissionRecordById(@PathVariable Long id) {
        return admissionRecordService.getAdmissionRecordById(id);
    }

    @PutMapping("{admissionId}/students/{studentId}")
    public AdmissionRecord assignStudentIntoAdmission(@PathVariable Long admissionId, @PathVariable Long studentId) {
        return admissionRecordService.assignStudentIntoAdmission(admissionId, studentId);
    }
}
