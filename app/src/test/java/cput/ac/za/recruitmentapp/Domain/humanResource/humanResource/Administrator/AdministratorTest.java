


package cput.ac.za.recruitmentapp.Domain.humanResource.humanResource.Administrator;



import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import cput.ac.za.recruitmentmanager.domain.Administrator.Administrator;
import cput.ac.za.recruitmentmanager.factory.administrator.AdministratorFactory;

/**
 * Created by student on 2016/04/03.
 */
public class AdministratorTest
{


    private Administrator administrator;

    @Before
    public void setUp() throws Exception
    {

        administrator = AdministratorFactory.getAdministrator("2366608", true, 6500.32f);
    }

    @Test
    public void testAdministrator() throws Exception
    {
        Assert.assertEquals(administrator.getStaffNumber(),"2366608");
        Assert.assertEquals(administrator.getBooking(), true);
        Assert.assertEquals(administrator.totalWage(),1,6500.32f);


    }

    @Test
    public void testNewUpdate() throws Exception {
        Administrator administratorUpdate = new Administrator.Builder()
                .staffNumber("2366608")
                .copy(administrator)
                .booking(true)
                .totalWage(6500.32f)
                .build();
        Assert.assertEquals(administratorUpdate.getStaffNumber(),"2366608");
        Assert.assertEquals(administratorUpdate.getBooking(),true);
        Assert.assertEquals(administratorUpdate.totalWage(),1,6500.32f);

    }
}
