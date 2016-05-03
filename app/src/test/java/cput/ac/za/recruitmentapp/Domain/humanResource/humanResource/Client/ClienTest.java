package cput.ac.za.recruitmentapp.Domain.humanResource.humanResource.Client;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import cput.ac.za.recruitmentmanager.domain.client.Client;
import cput.ac.za.recruitmentmanager.factory.client.ClientFactory;


/**
 * Created by student on 2016/04/03.
 */
public class ClienTest
{

    private Client client;

    @Before
    public void setUp() throws Exception
    {

        client = ClientFactory.getClient("CPUT", "88856");
    }

    @Test
    public void testPerson() throws Exception
    {
        Assert.assertEquals(client.getRegNumber(),"88856");
        Assert.assertEquals(client.getCompanyName(),"CPUT");



    }

    @Test
    public void testNewUpdate() throws Exception {
        Client companyUpdate = new Client.Builder()
                .copy(client)
                .regNumber("88856")
                .companyName("CPUT")
                .build();
        Assert.assertEquals(companyUpdate.getRegNumber(),"88856");
        Assert.assertEquals(companyUpdate.getCompanyName(), "CPUT");

    }
}
