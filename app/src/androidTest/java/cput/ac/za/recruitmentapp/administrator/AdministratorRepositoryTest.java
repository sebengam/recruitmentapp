package cput.ac.za.recruitmentapp.administrator;

import android.test.AndroidTestCase;

import junit.framework.Assert;

import java.util.Set;

import cput.ac.za.recruitmentapp.domain.Administrator.Administrator;
import cput.ac.za.recruitmentapp.repository.administrator.AdministratorRepository;
import cput.ac.za.recruitmentapp.repository.administrator.impl.AdministratorRepositoryImpl;

/**
 * Created by Tank on 5/7/2016.
 */
public class AdministratorRepositoryTest extends AndroidTestCase
{
    private static final String TAG="HUMANRESOURCE TEST";
    private Long id;

    public void
    testCreateReadUpdateDelete() throws Exception
    {
        AdministratorRepository repo = new AdministratorRepositoryImpl(this.getContext())
        {
            @Override
            public Administrator save(Administrator Entity) {
                return null;
            }

            @Override
            public Administrator delete(Administrator entity) {
                return null;
            }

            @Override
            public Set<Administrator> findAll() {
                return null;
            }
        };
        // CREATE
        Administrator createEntity = new Administrator.Builder()
                .staffNumber("FDCD")
                .booking(true)
                .totalWage(200f)
                .build();
        Administrator insertedEntity = repo.save(createEntity);
        id=insertedEntity.getId();
        Assert.assertNotNull(TAG + " CREATE", insertedEntity);

        //READ ALL
        Set<Administrator> humanResources = repo.findAll();
        Assert.assertTrue(TAG+" READ ALL",humanResources.size()>0);

        //READ ENTITY
        Administrator entity = (Administrator) repo.findById(id);
        Assert.assertNotNull(TAG+" READ ENTITY",entity);



        //UPDATE ENTITY
        Administrator updateEntity = new Administrator.Builder()
                .copy(entity)
                .staffNumber("TEST47")
                .build();
        repo.update(updateEntity);
        Administrator newEntity = (Administrator) repo.findById(id);
        Assert.assertEquals(TAG + " UPDATE ENTITY", "TEST47", newEntity.getStaffNumber());

        // DELETE ENTITY
        repo.delete(updateEntity);
        Administrator deletedEntity = repo.findById(id);
        Assert.assertNull(TAG+" DELETE",deletedEntity);

    }

}
