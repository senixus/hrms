package com.hrms.hrms.adapters;

import com.hrms.hrms.core.utilities.mernis.UserCheckService;
import com.hrms.hrms.entities.concretes.Candidate;
import mernis.FUCKPSPublicSoap;
import org.springframework.stereotype.Service;

@Service("realMernis")
public class MernisServiceAdapter implements UserCheckService {

    @Override
    public boolean checkIfRealPerson(Candidate candidate) {
        FUCKPSPublicSoap client = new FUCKPSPublicSoap();

        boolean isSuccess = false;
        try {
            isSuccess = client.TCKimlikNoDogrula(Long.parseLong(candidate.getNationalIdentity()),candidate.getFirstName().toUpperCase(),candidate.getLastName().toUpperCase(),candidate.getBirthDate().getYear());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return isSuccess;

    }
}
