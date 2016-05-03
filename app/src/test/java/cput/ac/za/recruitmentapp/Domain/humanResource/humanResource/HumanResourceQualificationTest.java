package cput.ac.za.recruitmentapp.Domain.humanResource.humanResource;

import junit.framework.Assert;

import org.junit.Test;

import cput.ac.za.recruitmentmanagerapp.domain.humanResource.HumanResourceQualification;
import cput.ac.za.recruitmentmanagerapp.factory.humanResource.HumanResourceQualificationFactory;


/**
 * Created by Tank on 4/22/2016.
 */
public class HumanResourceQualificationTest
{
    @Test
    public void testCreate() throws Exception {
        HumanResourceQualification humanResourceQualification = HumanResourceQualificationFactory.getHumanResourceQualification("Tankiso", "Sebenga", "jpg");
        Assert.assertEquals(humanResourceQualification.getInstitution(),"Tankiso");
        Assert.assertEquals(humanResourceQualification.getHighestQualification(),"Sebenga");
        Assert.assertEquals(humanResourceQualification.getYear(),"jpg");

    }

    @Test
    public void testNewUpdate() throws Exception {
        HumanResourceQualification humanResource = HumanResourceQualificationFactory.getHumanResourceQualification("Tankiso", "Sebenga", "jpg");
        HumanResourceQualification humanResourceUpdate = new HumanResourceQualification
                .Builder()
                .copy(humanResource)
                .institution("Tankiso")
                .highestQualification("Sebenga")
                .year("jpg")
                .build();
        Assert.assertEquals(humanResourceUpdate.getInstitution(),"Tankiso");
        Assert.assertEquals(humanResourceUpdate.getHighestQualification(),"Sebenga");
        Assert.assertEquals(humanResource.getYear(),"jpg");

    }
}
