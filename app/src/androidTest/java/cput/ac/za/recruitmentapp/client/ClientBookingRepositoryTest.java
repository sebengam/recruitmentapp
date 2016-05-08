package cput.ac.za.recruitmentapp.client;

import android.test.AndroidTestCase;

import junit.framework.Assert;

import java.util.Set;

import cput.ac.za.recruitmentapp.domain.client.ClientBooking;
import cput.ac.za.recruitmentapp.repository.Client.ClientBookingRepository;
import cput.ac.za.recruitmentapp.repository.Client.impl.ClientBookingRepositoryImpl;

/**
 * Created by Tank on 5/7/2016.
 */
public class ClientBookingRepositoryTest extends AndroidTestCase
{
    private static final String TAG="HUMANRESOURCE TEST";
    private Long id;

    public void
    testCreateReadUpdateDelete() throws Exception
    {
        ClientBookingRepository repo = new ClientBookingRepositoryImpl(this.getContext())
        {
            @Override
            public ClientBooking save(ClientBooking Entity) {
                return null;
            }
        };
        // CREATE
        ClientBooking createEntity = new ClientBooking.Builder()
                .bookingPerson("FDCD")
                .bookingCompany("test12")
                .availability(true)
                .build();
        ClientBooking insertedEntity = repo.save(createEntity);
        id=insertedEntity.getId();
        Assert.assertNotNull(TAG + " CREATE", insertedEntity);

        //READ ALL
        Set<ClientBooking> humanResources = repo.findAll();
        Assert.assertTrue(TAG+" READ ALL",humanResources.size()>0);

        //READ ENTITY
        ClientBooking entity = (ClientBooking) repo.findById(id);
        Assert.assertNotNull(TAG+" READ ENTITY",entity);



        //UPDATE ENTITY
        ClientBooking updateEntity = new ClientBooking.Builder()
                .copy(entity)
                .bookingPerson("TEST47")
                .build();
        repo.update(updateEntity);
        ClientBooking newEntity = (ClientBooking) repo.findById(id);
        Assert.assertEquals(TAG + " UPDATE ENTITY", "TEST47", newEntity.getBookedPerson());

        // DELETE ENTITY
        repo.delete(updateEntity);
        ClientBooking deletedEntity = repo.findById(id);
        Assert.assertNull(TAG+" DELETE",deletedEntity);

    }


}
