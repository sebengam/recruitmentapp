package cput.ac.za.recruitmentapp.Domain.humanResource.humanResource;

import org.junit.Assert;
import org.junit.Test;

import cput.ac.za.recruitmentapp.domain.humanResource.HumanResource;
import cput.ac.za.recruitmentapp.factory.humanResource.HumanResourceFactory;


/**
 * Created by student on 2016/04/03.
 */
public class HumanResourceTest
{

    @Test
    public void testCreate() throws Exception {
        HumanResource humanResource = HumanResourceFactory.getHumanResource("Tankiso", "Sebenga", "jpg","IT","Developer","test@test.co.za");
        Assert.assertEquals(humanResource.getName(),"Tankiso");
        Assert.assertEquals(humanResource.getSurname(),"Sebenga");
        Assert.assertEquals(humanResource.getCandidateImage(),"jpg");
        Assert.assertEquals(humanResource.getIndustry(),"IT");
        Assert.assertEquals(humanResource.getOccupation(),"Developer");
        Assert.assertEquals(humanResource.getEmail(),"test@test.co.za");
    }

    @Test
    public void testNewUpdate() throws Exception {
    HumanResource humanResource = HumanResourceFactory.getHumanResource("Tankiso", "Sebenga", "jpg","IT","Developer","test@test.co.za");
        HumanResource humanResourceUpdate = new HumanResource
                .Builder()
                .copy(humanResource)
                .name("Tankiso")
                .surname("Sebenga")
                .candidateImage("jpg")
                .industry("IT")
                .occupation("Developer")
                .email("test@test.co.za")
                .build();
        Assert.assertEquals(humanResourceUpdate.getName(),"Tankiso");
        Assert.assertEquals(humanResourceUpdate.getSurname(),"Sebenga");
        Assert.assertEquals(humanResource.getCandidateImage(),"jpg");
        Assert.assertEquals(humanResourceUpdate.getIndustry(),"IT");
        Assert.assertEquals(humanResource.getOccupation(),"Developer");
        Assert.assertEquals(humanResource.getEmail(),"test@test.co.za");

    }
}
