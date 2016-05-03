package cput.ac.za.recruitmentapp.Domain.humanResource.humanResource;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import cput.ac.za.recruitmentmanager.domain.humanResource.HumanResource;
import cput.ac.za.recruitmentmanager.factory.humanResource.HumanResourceFactory;


/**
 * Created by student on 2016/04/03.
 */
public class HumanResourceTest
{

    @Test
    public void testCreate() throws Exception {
        HumanResource humanResource = HumanResourceFactory.getHumanResource("Tankiso", "Sebenga", "jpg","IT","Developer");
        Assert.assertEquals(humanResource.getName(),"Tankiso");
        Assert.assertEquals(humanResource.getSurname(),"Sebenga");
        Assert.assertEquals(humanResource.getCandidateImage(),"jpg");
        Assert.assertEquals(humanResource.getIndustry(),"IT");
        Assert.assertEquals(humanResource.getOccupation(),"Developer");
    }

    @Test
    public void testNewUpdate() throws Exception {
    HumanResource humanResource = HumanResourceFactory.getHumanResource("Tankiso", "Sebenga", "jpg","IT","Developer");
        HumanResource humanResourceUpdate = new HumanResource
                .Builder()
                .copy(humanResource)
                .name("Tankiso")
                .surname("Sebenga")
                .candidateImage("jpg")
                .industry("IT")
                .occupation("Developer")
                .build();
        Assert.assertEquals(humanResourceUpdate.getName(),"Tankiso");
        Assert.assertEquals(humanResourceUpdate.getSurname(),"Sebenga");
        Assert.assertEquals(humanResource.getCandidateImage(),"jpg");
        Assert.assertEquals(humanResourceUpdate.getIndustry(),"IT");
        Assert.assertEquals(humanResource.getOccupation(),"Developer");

    }
}
