package cput.ac.za.recruitmentapp.Domain.humanResource.humanResource.Client;

import org.junit.Assert;
import org.junit.Test;

import cput.ac.za.recruitmentapp.domain.client.Client;
import cput.ac.za.recruitmentapp.factory.client.ClientFactory;


/**
 * Created by student on 2016/04/03.
 */
public class ClienTest
{
    Client client = ClientFactory.getClient("CPUT","88856","1");


    @Test
    public void testPerson() throws Exception
    {

        Assert.assertEquals(client.getRegNumber(),"88856");
        Assert.assertEquals(client.getCompanyName(),"CPUT");
        Assert.assertEquals(client.getEmail(),"1");



    }

    @Test
    public void testNewUpdate() throws Exception {
        Client companyUpdate = new Client.Builder()
                .copy(client)
                .regNumber("88856")
                .companyName("CPUT")
                .email("1")
                .build();
        Assert.assertEquals(companyUpdate.getRegNumber(),"88856");
        Assert.assertEquals(companyUpdate.getCompanyName(), "CPUT");
        Assert.assertEquals(companyUpdate.getEmail(),"1");

    }
}
