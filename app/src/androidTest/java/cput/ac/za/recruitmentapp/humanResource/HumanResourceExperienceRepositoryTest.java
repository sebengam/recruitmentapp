package cput.ac.za.recruitmentapp.humanResource;

import android.test.AndroidTestCase;

import junit.framework.Assert;

import java.util.Set;

import cput.ac.za.recruitmentapp.domain.humanResource.HumanResourceExperience;
import cput.ac.za.recruitmentapp.repository.humanResource.HumanResourceExperienceRepository;
import cput.ac.za.recruitmentapp.repository.humanResource.impl.HumanResourceExperienceRepositoryImpl;


/**
 * Created by Tank on 4/24/2016.
 */

public class HumanResourceExperienceRepositoryTest  extends AndroidTestCase
{

    private static final String TAG="HUMANRESOURCEEXPERIENCE TEST";
    private Long id;
    public void testCreateReadUpdateDelete() throws Exception
    {
        HumanResourceExperienceRepository repo = new HumanResourceExperienceRepositoryImpl(this.getContext())
        {
            @Override
            public HumanResourceExperience save(HumanResourceExperience entity) {
                return null;
            }

            @Override
            public HumanResourceExperience deleteAll(HumanResourceExperience entity) {
                return null;
            }

        };

        // CREATE
        HumanResourceExperience createEntity = new HumanResourceExperience.Builder()
                .companyName("FDCD")
                .duties("test12")
                .startDate("fc89b@test.com")
                .endDate("fc89b@test.co")
                .build();
        HumanResourceExperience insertedEntity = repo.save(createEntity);
        id = insertedEntity.getId();
        Assert.assertNotNull(TAG + "CREATE", insertedEntity);

        //READ ALL
        Set<HumanResourceExperience> humanResourceExperiences = repo.findAll();
        Assert.assertTrue(TAG+" READ ALL",humanResourceExperiences.size()>0);

        //READ ENTITY
        HumanResourceExperience entity = repo.findById(id);
        Assert.assertNotNull(TAG+" READ ENTITY",entity);

        //UPDATE ENTITY
        HumanResourceExperience updateEntity = new HumanResourceExperience.Builder()
                .copy(entity)
                .companyName("FDCD")
                .build();
        repo.update(updateEntity);
        HumanResourceExperience newEntity = repo.findById(id);
        Assert.assertEquals(TAG + " UPDATE ENTITY", "FDCD", newEntity.getCompanyName());

        // DELETE ENTITY
        repo.delete(updateEntity);
        HumanResourceExperience deletedEntity = repo.findById(id);
        Assert.assertNull(TAG + " DELETE", deletedEntity);


    }

}
