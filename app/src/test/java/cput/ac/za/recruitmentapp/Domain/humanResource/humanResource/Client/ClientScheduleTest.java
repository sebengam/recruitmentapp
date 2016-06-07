package cput.ac.za.recruitmentapp.Domain.humanResource.humanResource.Client;

import junit.framework.Assert;

import org.junit.Test;

import cput.ac.za.recruitmentapp.domain.client.ClientSchedule;
import cput.ac.za.recruitmentapp.factory.client.ClientScheduleFactory;


/**
 * Created by Tank on 4/23/2016.
 */
public class ClientScheduleTest
{
    @Test
    public void testCreate() throws Exception
    {
        ClientSchedule clientSchedule = ClientScheduleFactory.getClientSchedule(null,true ,null);
        Assert.assertEquals(clientSchedule.getDate(),null);
        //Assert.assertEquals(clientSchedule.getAvailable(),true);
        Assert.assertEquals(clientSchedule.getPersonBooked(),null);
    }

    @Test
        public void testNewUpdate() throws Exception {
        ClientSchedule clientSchedule = ClientScheduleFactory.getClientSchedule(null,true,null);
        ClientSchedule clientScheduleUpdate = new ClientSchedule
                .Builder()
                .copy(clientSchedule)
                .date(null)
                .available(true)
                .personBooked(null)
                .build();

        Assert.assertEquals(clientScheduleUpdate.getDate(), null);
       // Assert.assertEquals(clientScheduleUpdate.getAvailable(),true);
        Assert.assertEquals(clientScheduleUpdate.getPersonBooked(),null);

    }
}
