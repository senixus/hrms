package com.hrms.hrms.core.utilities.mernis;

import com.hrms.hrms.entities.concretes.Candidate;
import org.springframework.stereotype.Service;

@Service("fakeMernis")
public class UserCheckManager implements  UserCheckService{
    @Override
    public boolean checkIfRealPerson(Candidate candidate) {
        return true;
    }
}
