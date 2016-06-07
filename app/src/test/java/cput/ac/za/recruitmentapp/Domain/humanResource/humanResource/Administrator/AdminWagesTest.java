package cput.ac.za.recruitmentapp.Domain.humanResource.humanResource.Administrator;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import cput.ac.za.recruitmentapp.domain.Administrator.AdminWages;
import cput.ac.za.recruitmentapp.factory.administrator.AdminWagesFactory;


/**
 * Created by Tank on 4/23/2016.
 */
public class AdminWagesTest
{


    private AdminWages adminWages;

    @Before
    public void setUp() throws Exception {

        adminWages = AdminWagesFactory.getAdminWages(200, 350f, 6500.32f);
    }

    @Test
    public void testAdministrator() throws Exception {
        Assert.assertEquals(adminWages.getHours(), 200);
        Assert.assertEquals(adminWages.getRatePerHour(), 350f);
        Assert.assertEquals(adminWages.getTotalWages(), 1, 6500.32f);


    }

    @Test
    public void testNewUpdate() throws Exception {
        AdminWages administratorUpdate = new AdminWages.Builder()
                .copy(adminWages)
                .hours(200)
                .ratePerHour(300f)
                .totalWages(6500.32f)
                .build();
        Assert.assertEquals(administratorUpdate.getHours(), 200);
        Assert.assertEquals(administratorUpdate.getRatePerHour(), 300f);
        Assert.assertEquals(administratorUpdate.getTotalWages(), 1, 6500.32f);

    }
}