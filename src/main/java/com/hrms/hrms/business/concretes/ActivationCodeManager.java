package com.hrms.hrms.business.concretes;

import com.hrms.hrms.business.abstracts.ActivationCodeService;
import com.hrms.hrms.core.dataAccess.UserDao;
import com.hrms.hrms.core.entities.User;
import com.hrms.hrms.core.utilities.results.ErrorResult;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.core.utilities.results.SuccessResult;
import com.hrms.hrms.dataAccess.abstracts.ActivationCodeDao;
import com.hrms.hrms.entities.concretes.ActivationCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.UUID;

@Service
public class ActivationCodeManager implements ActivationCodeService {

    private UserDao userDao;
    private ActivationCodeDao activationCodeDao;



    @Autowired
    public ActivationCodeManager(UserDao userDao,ActivationCodeDao activationCodeDao){
        this.userDao = userDao;
        this.activationCodeDao = activationCodeDao;
    }

    @Override
    public String createActivationCode(User user) {
        String code = UUID.randomUUID().toString();
        ActivationCode activationCode = new ActivationCode();
        activationCode.setUserId(user);
        activationCode.setCreatedAt(LocalDate.now());
        activationCode.setActivationCode(UUID.randomUUID().toString());
        this.activationCodeDao.save(activationCode);

        return code;
    }

    @Override
    public void sendEmail(String mail) {
            System.out.println("Mail gönderildi");
    }

    @Override
    public Result confirmUser(String code) {
        if(!this.activationCodeDao.existsByActivationCode(code)){
            return new ErrorResult("check your activation code");
        }
        ActivationCode activationCode = this.activationCodeDao.getByActivationCode(code);
        if(this.activationCodeDao.getOne(activationCode.getId()).isConfirmed()){
            return new ErrorResult("your account have already confirmed");
        }
        activationCode.setConfirmed(true);
        activationCode.setConfirmedAt(LocalDate.now());
        this.activationCodeDao.save(activationCode);

        User confirmUser = new User();

        confirmUser = this.userDao.getOne(activationCode.getUserId().getId());
        confirmUser.setConfirmed(true);;
        this.userDao.save(confirmUser);


        return new SuccessResult("Your account has been confirmed");
    }
}
