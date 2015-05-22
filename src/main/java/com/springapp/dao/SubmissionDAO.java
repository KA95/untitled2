package com.springapp.dao;

import com.springapp.domain.Submission;
import org.springframework.stereotype.Repository;

@Repository
public class SubmissionDAO extends DAO<Submission> {
    public SubmissionDAO() {
        super(Submission.class);
    }
}