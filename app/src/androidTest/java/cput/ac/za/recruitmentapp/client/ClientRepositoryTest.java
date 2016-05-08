package cput.ac.za.recruitmentapp.client;

import android.content.Context;
import android.test.AndroidTestCase;

import junit.framework.Assert;

import java.util.Set;

import cput.ac.za.recruitmentapp.domain.client.Client;
import cput.ac.za.recruitmentapp.repository.Client.ClientRepository;
import cput.ac.za.recruitmentapp.repository.Client.impl.ClientRepositoryImpl;

/**
 * Created by Tank on 5/6/2016.
 */
public class ClientRepositoryTest extends AndroidTestCase
{
    private static final String TAG="HUMANRESOURCE TEST";
    private Long id;

    public void
    testCreateReadUpdateDelete() throws Exception
    {
        ClientRepository repo = new ClientRepositoryImpl(this.getContext())
        {
            @Override
            public Client save(Client entity) {
                return null;
            }
        };
        // CREATE
        Client createEntity = new Client.Builder()
                .companyName("FDCD")
                .regNumber("test12")
                .build();
        Client insertedEntity = repo.save(createEntity);
        id=insertedEntity.getId();
        Assert.assertNotNull(TAG + " CREATE", insertedEntity);

        //READ ALL
        Set<Client> humanResources = repo.findAll();
        Assert.assertTrue(TAG+" READ ALL",humanResources.size()>0);

        //READ ENTITY
        Client entity = (Client) repo.findById(id);
        Assert.assertNotNull(TAG+" READ ENTITY",entity);



        //UPDATE ENTITY
        Client updateEntity = new Client.Builder()
                .copy(entity)
                .companyName("TEST47")
                .build();
        repo.update(updateEntity);
        Client newEntity = (Client) repo.findById(id);
        Assert.assertEquals(TAG + " UPDATE ENTITY", "TEST47", newEntity.getCompanyName());

        // DELETE ENTITY
        repo.delete(updateEntity);
        Client deletedEntity = repo.findById(id);
        Assert.assertNull(TAG+" DELETE",deletedEntity);

    }



}
