package cput.ac.za.recruitmentapp.factory.administrator;

import cput.ac.za.recruitmentmanagerapp.domain.Administrator.AdminPayment;

/**
 * Created by Tank on 4/23/2016.
 */
public class AdminPaymentFactory
{
    public static AdminPayment getAdminPayment(String bank, String accountNumber, float amount)
    {
        AdminPayment myAdminPayment = new AdminPayment.Builder()
                .bank(bank)
                .accountNumber(accountNumber)
                .amount(amount)
                .build();
        return myAdminPayment;

    }
}
