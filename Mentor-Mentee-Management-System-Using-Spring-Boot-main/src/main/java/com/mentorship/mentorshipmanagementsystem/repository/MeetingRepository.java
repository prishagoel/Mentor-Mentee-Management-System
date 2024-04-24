package com.mentorship.mentorshipmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mentorship.mentorshipmanagementsystem.domain.Meeting;

@Repository
public interface MeetingRepository extends JpaRepository<Meeting, Long> {
    // Define custom query methods if needed
}

