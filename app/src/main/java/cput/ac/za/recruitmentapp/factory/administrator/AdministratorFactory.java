package cput.ac.za.recruitmentapp.factory.administrator;

import cput.ac.za.recruitmentmanagerapp.domain.Administrator.Administrator;

/**
 * Created by student on 2016/04/03.
 */
public class AdministratorFactory {

    public static Administrator getAdministrator(String staffNumber, boolean booking, float totalWage) {
        Administrator myAdministrator = new Administrator.Builder()
                .staffNumber(staffNumber)
                .booking(booking)
                .totalWage(totalWage)
                .build();
        return myAdministrator;

    }
}
