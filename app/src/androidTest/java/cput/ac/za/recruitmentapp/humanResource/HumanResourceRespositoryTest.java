package cput.ac.za.recruitmentapp.humanResource;

import android.test.AndroidTestCase;

import junit.framework.Assert;

import java.util.Set;

import cput.ac.za.recruitmentapp.domain.humanResource.HumanResource;
import cput.ac.za.recruitmentapp.repository.humanResource.HumanResourceRepository;
import cput.ac.za.recruitmentapp.repository.humanResource.impl.HumanResourceRepositoryImpl;


/**
 * Created by Tank on 4/24/2016.
 */
public class HumanResourceRespositoryTest extends AndroidTestCase
{
    private static final String TAG="HUMANRESOURCE TEST";
    private Long id;

    public void
    testCreateReadUpdateDelete() throws Exception
    {
        HumanResourceRepository repo = new HumanResourceRepositoryImpl(this.getContext())
        {
            @Override
            public HumanResource save(HumanResource entity) {
                return null;
            }
        };
        // CREATE
        HumanResource createEntity = new HumanResource.Builder()
                .name("FDCD")
                .surname("test12")
                .candidateImage("fc89b@test.com")
                .industry("test12")
                .occupation("fc89b@test.com")
                .build();
        HumanResource insertedEntity = repo.save(createEntity);
        id=insertedEntity.getId();
        Assert.assertNotNull(TAG + " CREATE", insertedEntity);

       //READ ALL
        Set<HumanResource> humanResources = repo.findAll();
        Assert.assertTrue(TAG+" READ ALL",humanResources.size()>0);

        //READ ENTITY
        HumanResource entity = (HumanResource) repo.findById(id);
        Assert.assertNotNull(TAG+" READ ENTITY",entity);



        //UPDATE ENTITY
        HumanResource updateEntity = new HumanResource.Builder()
                .copy(entity)
                .name("TEST47")
                .build();
        repo.update(updateEntity);
        HumanResource newEntity = (HumanResource) repo.findById(id);
        Assert.assertEquals(TAG + " UPDATE ENTITY", "TEST47", newEntity.getName());

        // DELETE ENTITY
        repo.delete(updateEntity);
        HumanResource deletedEntity = repo.findById(id);
        Assert.assertNull(TAG+" DELETE",deletedEntity);

    }

}
