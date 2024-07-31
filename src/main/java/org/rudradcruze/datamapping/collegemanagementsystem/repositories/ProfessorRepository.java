package org.rudradcruze.datamapping.collegemanagementsystem.repositories;

import org.rudradcruze.datamapping.collegemanagementsystem.entities.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> {
}
