package cput.ac.za.recruitmentapp.client;

import android.test.AndroidTestCase;

import junit.framework.Assert;

import java.util.Set;

import cput.ac.za.recruitmentapp.domain.client.ClientBooking;
import cput.ac.za.recruitmentapp.domain.client.ClientSchedule;
import cput.ac.za.recruitmentapp.repository.Client.ClientScheduleRepository;
import cput.ac.za.recruitmentapp.repository.Client.impl.ClientScheduleRepositoryImpl;

/**
 * Created by Tank on 5/7/2016.
 */
public class ClientScheduleRepositoryTest extends AndroidTestCase
{
    private static final String TAG="HUMANRESOURCE TEST";
    private Long id;

    public void
    testCreateReadUpdateDelete() throws Exception
    {
        ClientScheduleRepository repo = new ClientScheduleRepositoryImpl(this.getContext())
        {
            @Override
            public ClientSchedule save(ClientSchedule entity) {
                return null;
            }
        };
        // CREATE
        ClientSchedule createEntity = new ClientSchedule.Builder()
                .date("FDCD")
                .available(true)
                .personBooked("dg")
                .build();
        ClientSchedule insertedEntity = repo.save(createEntity);
        id=insertedEntity.getId();
        Assert.assertNotNull(TAG + " CREATE", insertedEntity);

        //READ ALL
        Set<ClientSchedule> humanResources = repo.findAll();
        Assert.assertTrue(TAG+" READ ALL",humanResources.size()>0);

        //READ ENTITY
        ClientSchedule entity = (ClientSchedule) repo.findById(id);
        Assert.assertNotNull(TAG+" READ ENTITY",entity);



        //UPDATE ENTITY
        ClientSchedule updateEntity = new ClientSchedule.Builder()
                .copy(entity)
                .date("TEST47")
                .build();
        repo.update(updateEntity);
        ClientSchedule newEntity = (ClientSchedule) repo.findById(id);
        Assert.assertEquals(TAG + " UPDATE ENTITY", "TEST47", newEntity.getDate());

        // DELETE ENTITY
        repo.delete(updateEntity);
        ClientSchedule deletedEntity = repo.findById(id);
        Assert.assertNull(TAG+" DELETE",deletedEntity);

    }
}
