package com.cg.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.modal.Student;
@Repository
public interface Stud extends JpaRepository<Student, Long> {
	

}
