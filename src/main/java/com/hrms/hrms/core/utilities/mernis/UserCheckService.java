package com.hrms.hrms.core.utilities.mernis;

import com.hrms.hrms.core.entities.User;
import com.hrms.hrms.entities.concretes.Candidate;

public interface UserCheckService {

    boolean checkIfRealPerson(Candidate candidate);

}
