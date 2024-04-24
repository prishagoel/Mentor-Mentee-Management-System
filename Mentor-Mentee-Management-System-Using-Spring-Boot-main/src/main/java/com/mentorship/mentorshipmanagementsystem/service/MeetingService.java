package com.mentorship.mentorshipmanagementsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mentorship.mentorshipmanagementsystem.domain.Meeting;
import com.mentorship.mentorshipmanagementsystem.repository.MeetingRepository;

import java.util.List;

@Service
public class MeetingService {

    @Autowired
    private MeetingRepository meetingRepository;

    @Transactional
    public void saveMeeting(Meeting meeting) {
        meetingRepository.save(meeting);
    }

    public List<Meeting> getAllMeetings() {
        return meetingRepository.findAll();
    }

    // Add other methods for meeting operations as needed
}
