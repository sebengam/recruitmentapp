package cput.ac.za.recruitmentapp.administrator;

import android.test.AndroidTestCase;

import junit.framework.Assert;

import java.util.Set;

import cput.ac.za.recruitmentapp.domain.Administrator.AdminWages;
import cput.ac.za.recruitmentapp.repository.administrator.AdminWagesRepository;
import cput.ac.za.recruitmentapp.repository.administrator.impl.AdminWagesRepositoryImpl;

/**
 * Created by Tank on 5/7/2016.
 */
public class AdminWagesRepositoryTest extends AndroidTestCase
{
    private static final String TAG="HUMANRESOURCE TEST";
    private Long id;

    public void
    testCreateReadUpdateDelete() throws Exception
    {
        AdminWagesRepository repo = new AdminWagesRepositoryImpl(this.getContext())
        {
            @Override
            public AdminWagesRepository save(AdminWagesRepository Entity) {
                return null;
            }

            @Override
            public AdminWages delete(AdminWages entity) {
                return null;
            }

            @Override
            public Set<AdminWages> findAll() {
                return null;
            }
        };
        // CREATE
        AdminWages createEntity = new AdminWages.Builder()
                .hours(5)
                .ratePerHour(100)
                .totalWages(500f)
                .build();
        AdminWages insertedEntity = repo.save(createEntity);
        id=insertedEntity.getId();
        Assert.assertNotNull(TAG + " CREATE", insertedEntity);

        //READ ALL
        Set<AdminWages> humanResources = repo.findAll();
        Assert.assertTrue(TAG+" READ ALL",humanResources.size()>0);

        //READ ENTITY
        AdminWages entity = (AdminWages) repo.findById(id);
        Assert.assertNotNull(TAG+" READ ENTITY",entity);



        //UPDATE ENTITY
        AdminWages updateEntity = new AdminWages.Builder()
                .copy(entity)
                .hours(5)
                .build();
        repo.update(updateEntity);
        AdminWages newEntity = (AdminWages) repo.findById(id);
        Assert.assertEquals(TAG + " UPDATE ENTITY", 5, newEntity.getHours());

        // DELETE ENTITY
        repo.delete(updateEntity);
        AdminWages deletedEntity = repo.findById(id);
        Assert.assertNull(TAG+" DELETE",deletedEntity);

    }

}
