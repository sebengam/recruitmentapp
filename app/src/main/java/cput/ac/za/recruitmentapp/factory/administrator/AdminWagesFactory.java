package cput.ac.za.recruitmentapp.factory.administrator;

import cput.ac.za.recruitmentmanagerapp.domain.Administrator.AdminWages;

/**
 * Created by Tank on 4/23/2016.
 */
public class AdminWagesFactory
{
    public static AdminWages getAdminWages(int hours, float ratePerHour, float totalAmount)
    {
        AdminWages myClientBooking = new AdminWages.Builder()
                .hours(hours)
                .ratePerHour(ratePerHour)
                .totalWages(totalAmount)
                .build();
        return myClientBooking;

    }
}
