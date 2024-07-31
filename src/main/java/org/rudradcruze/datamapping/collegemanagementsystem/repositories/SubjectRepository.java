package org.rudradcruze.datamapping.collegemanagementsystem.repositories;

import org.rudradcruze.datamapping.collegemanagementsystem.entities.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {
}
