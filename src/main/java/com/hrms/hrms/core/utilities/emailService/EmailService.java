package com.hrms.hrms.core.utilities.emailService;

import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.entities.concretes.Candidate;

public interface EmailService {
    Result sendEmail(String email);
}
