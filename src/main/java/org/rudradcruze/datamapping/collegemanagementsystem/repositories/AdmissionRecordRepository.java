package org.rudradcruze.datamapping.collegemanagementsystem.repositories;

import org.rudradcruze.datamapping.collegemanagementsystem.entities.AdmissionRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdmissionRecordRepository extends JpaRepository<AdmissionRecord, Long> {
}
