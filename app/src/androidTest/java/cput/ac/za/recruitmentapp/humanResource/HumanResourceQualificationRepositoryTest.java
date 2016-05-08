package cput.ac.za.recruitmentapp.humanResource;

import android.test.AndroidTestCase;

import junit.framework.Assert;

import java.util.Set;

import cput.ac.za.recruitmentapp.domain.humanResource.HumanResourceQualification;
import cput.ac.za.recruitmentapp.repository.humanResource.HumanResourceQualificationRepository;
import cput.ac.za.recruitmentapp.repository.humanResource.impl.HumanResourceQualificationRepositoryImpl;

/**
 * Created by Tank on 5/6/2016.
 */
public class HumanResourceQualificationRepositoryTest extends AndroidTestCase
{
    private static final String TAG="HUMANRESOURCEQUALIFICATION TEST";
    private Long id;

    public void
    testCreateReadUpdateDelete() throws Exception
    {
        HumanResourceQualificationRepository repo = new HumanResourceQualificationRepositoryImpl(this.getContext())
        {
            @Override
            public HumanResourceQualification save(HumanResourceQualification entity) {
                return null;
            }
        };
        // CREATE
        HumanResourceQualification createEntity = new HumanResourceQualification.Builder()
                .institution("FDCD")
                .highestQualification("test12")
                .year("fc89b@test.com")
                .build();
        HumanResourceQualification insertedEntity = repo.save(createEntity);
        id=insertedEntity.getId();
        Assert.assertNotNull(TAG + " CREATE", insertedEntity);

        //READ ALL
        Set<HumanResourceQualification> humanResources = repo.findAll();
        Assert.assertTrue(TAG+" READ ALL",humanResources.size()>0);

        //READ ENTITY
        HumanResourceQualification entity = (HumanResourceQualification) repo.findById(id);
        Assert.assertNotNull(TAG+" READ ENTITY",entity);



        //UPDATE ENTITY
        HumanResourceQualification updateEntity = new HumanResourceQualification.Builder()
                .copy(entity)
                .institution("TEST47")
                .build();
        repo.update(updateEntity);
        HumanResourceQualification newEntity = (HumanResourceQualification) repo.findById(id);
        Assert.assertEquals(TAG + " UPDATE ENTITY", "TEST47", newEntity.getInstitution());

        // DELETE ENTITY
        repo.delete(updateEntity);
        HumanResourceQualification deletedEntity = repo.findById(id);
        Assert.assertNull(TAG+" DELETE",deletedEntity);

    }
}
