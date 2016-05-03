package cput.ac.za.recruitmentapp.Domain.humanResource.humanResource.Administrator;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import cput.ac.za.recruitmentmanager.domain.Administrator.AdminPayment;
import cput.ac.za.recruitmentmanager.factory.administrator.AdminPaymentFactory;

/**
 * Created by Tank on 4/23/2016.
 */
public class AdminPaymentTest
{

    private cput.ac.za.recruitmentmanager.domain.Administrator.AdminPayment adminPayment;

    @Before
    public void setUp() throws Exception
    {


        adminPayment = AdminPaymentFactory.getAdminPayment("2366608", "214317447", 6500.32f);
    }

    @Test
    public void testAdministrator() throws Exception
    {
        Assert.assertEquals(adminPayment.getBank(), "2366608");
        Assert.assertEquals(adminPayment.getAccountNumber(), "214317447");
        Assert.assertEquals(adminPayment.getAmount(),1,6500.32f);


    }

    @Test
    public void testNewUpdate() throws Exception {
        AdminPayment administratorUpdate = new AdminPayment.Builder()
                .copy(adminPayment)
                .bank("2366608")
                .accountNumber("214317447")
                .amount(6500.32f)
                .build();
        Assert.assertEquals(administratorUpdate.getBank(),"2366608");
        Assert.assertEquals(administratorUpdate.getAccountNumber(),"214317447");
        Assert.assertEquals(administratorUpdate.getAmount(),1,6500.32f);

    }
}
