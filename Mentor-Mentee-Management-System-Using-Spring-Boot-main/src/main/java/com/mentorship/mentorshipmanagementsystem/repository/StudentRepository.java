package com.mentorship.mentorshipmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mentorship.mentorshipmanagementsystem.domain.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
	// This will be AUTO IMPLEMENTED by Spring into a Bean
}
