package cput.ac.za.recruitmentapp.Domain.humanResource.humanResource.Client;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import cput.ac.za.recruitmentmanager.domain.client.ClientBooking;
import cput.ac.za.recruitmentmanager.factory.client.ClientBookingFactory;

/**
 * Created by student on 2016/04/05.
 */
public class ClientBookingTest
{

    private ClientBooking clientBooking;

    @Before
    public void setUp() throws Exception
    {

        clientBooking = ClientBookingFactory.getBooking(true, "CPUT", "Tankiso");
    }

    @Test
    public void testAdvocate() throws Exception
    {
        Assert.assertEquals(clientBooking.getAvailability(),true);
        Assert.assertEquals(clientBooking.getBookingCompany(),"CPUT");
        Assert.assertEquals(clientBooking.getBookedPerson(),"Tankiso");
    }

    @Test
    public void testNewUpdate() throws Exception {
        ClientBooking bookingUpdate = new ClientBooking.Builder()
                .copy(clientBooking)
                .availability(true)
                .bookingCompany("CPUT")
                .bookingPerson("Tankiso")
                .build();
        Assert.assertEquals(bookingUpdate.getAvailability(),true);
        Assert.assertEquals(bookingUpdate.getBookingCompany(),"CPUT");
        Assert.assertEquals(bookingUpdate.getBookedPerson(),"Tankiso");


    }
}