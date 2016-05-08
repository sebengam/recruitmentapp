package cput.ac.za.recruitmentapp.humanResource;

import android.test.AndroidTestCase;

import junit.framework.Assert;

import java.util.Set;

import cput.ac.za.recruitmentapp.domain.humanResource.HumanResourceLocation;
import cput.ac.za.recruitmentapp.repository.humanResource.HumanResourceLocationRepository;
import cput.ac.za.recruitmentapp.repository.humanResource.impl.HumanResourceLocationRepositoryImpl;

/**
 * Created by Tank on 5/6/2016.
 */
public class HumanResourceLocationRepositoryTest extends AndroidTestCase
{
    private static final String TAG="HUMANRESOURCE TEST";
    private Long id;

    public void
    testCreateReadUpdateDelete() throws Exception
    {
        HumanResourceLocationRepository repo = new HumanResourceLocationRepositoryImpl(this.getContext())
        {
            @Override
            public HumanResourceLocation save(HumanResourceLocation entity) {
                return null;
            }
        };
        // CREATE
        HumanResourceLocation createEntity = new HumanResourceLocation.Builder()
                .number(12)
                .street("test12")
                .surburb("fc89b@test.com")
                .city("test12")
                .province("fc89b@test.com")
                .build();
        HumanResourceLocation insertedEntity = repo.save(createEntity);
        id=insertedEntity.getId();
        Assert.assertNotNull(TAG + " CREATE", insertedEntity);

        //READ ALL
        Set<HumanResourceLocation> humanResources = repo.findAll();
        Assert.assertTrue(TAG+" READ ALL",humanResources.size()>0);

        //READ ENTITY
        HumanResourceLocation entity = (HumanResourceLocation) repo.findById(id);
        Assert.assertNotNull(TAG+" READ ENTITY",entity);



        //UPDATE ENTITY
        HumanResourceLocation updateEntity = new HumanResourceLocation.Builder()
                .copy(entity)
                .number(12)
                .build();
        repo.update(updateEntity);
        HumanResourceLocation newEntity = (HumanResourceLocation) repo.findById(id);
        Assert.assertEquals(TAG + " UPDATE ENTITY", "TEST47", newEntity.getNumber());

        // DELETE ENTITY
        repo.delete(updateEntity);
        HumanResourceLocation deletedEntity = repo.findById(id);
        Assert.assertNull(TAG+" DELETE",deletedEntity);

    }
}
