package com.hrms.hrms.business.abstracts;

import com.hrms.hrms.core.entities.User;
import com.hrms.hrms.core.utilities.results.Result;

public interface ActivationCodeService {

    String createActivationCode(User user);

    void sendEmail(String mail);

    Result confirmUser(String code);

}
