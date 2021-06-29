package com.hrms.hrms.business.validations;

import com.hrms.hrms.business.abstracts.ValidationService;
import com.hrms.hrms.core.dataAccess.UserDao;
import com.hrms.hrms.core.utilities.emailService.EmailService;
import com.hrms.hrms.core.utilities.mernis.UserCheckService;
import com.hrms.hrms.core.utilities.results.*;
import com.hrms.hrms.dataAccess.abstracts.CandidateDao;
import com.hrms.hrms.entities.concretes.Candidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidateValidationManager implements ValidationService<Candidate> {

    private CandidateDao candidateDao;
    private UserDao userDao;
    private UserCheckService userCheckService;
    private EmailService emailService;


    @Autowired
    public CandidateValidationManager(CandidateDao candidateDao,UserDao userDao,@Qualifier("fakeMernis") UserCheckService userCheckService,EmailService emailService){
        this.candidateDao = candidateDao;
        this.userDao = userDao;
        this.userCheckService = userCheckService;
        this.emailService = emailService;
    }

    @Override
    public DataResult<List<Candidate>> getAll() {
        return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll(),"Candidates have been listed");
    }

    @Override
    public Result add(Candidate candidate) {
        if(this.userDao.existsByEmail(candidate.getEmail())){
            return new ErrorResult("Email already exist");
        }
        if(this.candidateDao.existsByNationalIdentity(candidate.getNationalIdentity())){
            return new ErrorResult("National identity already exist");
        }

        if(!candidate.getPassword().equals(candidate.getConfirmPassword())){
            return new ErrorResult("Passwords  do not match");
        }
        if(!this.userCheckService.checkIfRealPerson(candidate)){
            return new ErrorResult("National Identity is not valid");
        }

        this.candidateDao.save(candidate);
     //   this.emailService.sendEmail(candidate.getEmail());
        return new SuccessResult("Candidate has been added");
    }

    @Override
    public Result update(Candidate candidate) {
        if(this.userDao.existsByEmail(candidate.getEmail())){
            return new ErrorResult("Email already exist");
        }

        if(!this.userDao.existsById(candidate.getId())){
            return new ErrorResult("User have not found");
        }

        this.candidateDao.save(candidate);
        return new SuccessResult("Candidate has been updated");
    }
}
