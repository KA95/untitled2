package com.springapp.service;

import com.springapp.dao.SubmissionDAO;
import com.springapp.domain.Submission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SubmissionService{

    @Autowired
    private SubmissionDAO SubmissionDAO;

    public void addSubmission(Submission Submission) {
        SubmissionDAO.add(Submission);
    }

    public void updateSubmission(Submission Submission) {
        SubmissionDAO.update(Submission);
    }

    public List<Submission> listSubmission() {
        return SubmissionDAO.list();
    }

    public void removeSubmission(Integer id) {
        SubmissionDAO.remove(id);
    }
}