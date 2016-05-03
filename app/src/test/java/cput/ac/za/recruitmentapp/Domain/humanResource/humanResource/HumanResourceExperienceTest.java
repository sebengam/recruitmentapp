package cput.ac.za.recruitmentapp.Domain.humanResource.humanResource;

import junit.framework.Assert;

import org.junit.Test;

import cput.ac.za.recruitmentmanager.domain.humanResource.HumanResourceExperience;
import cput.ac.za.recruitmentmanager.factory.humanResource.HumanResourceExperienceFactory;

/**
 * Created by Tank on 4/22/2016.
 */
public class HumanResourceExperienceTest
{
    @Test
    public void testCreate() throws Exception
    {
        HumanResourceExperience humanResource = HumanResourceExperienceFactory.getHumanResourceExperience("CPUT","[Ljava.lang.String;@5eb5c224","5/12/2013", "5/11/2015");
        Assert.assertEquals(humanResource.getCompanyName(),"CPUT");
        Assert.assertEquals(humanResource.getDuties(),"[Ljava.lang.String;@5eb5c224");
        Assert.assertEquals(humanResource.getStartDate(),"5/12/2013");
        Assert.assertEquals(humanResource.getEndDate(),"5/11/2015");
    }

    @Test
    public void testNewUpdate() throws Exception {
        HumanResourceExperience humanResourceExperience = HumanResourceExperienceFactory.getHumanResourceExperience("CPUT","[Ljava.lang.String;@7506e922","5/12/2013", "5/11/2015");
        HumanResourceExperience humanResourceExperienceUpdate = new HumanResourceExperience
                .Builder()
                .copy(humanResourceExperience)
                .companyName("CPUT")
                .duties("[Ljava.lang.String;@5fcfe4b2")
                .startDate("5/12/2013")
                .endDate("5/11/2015")
                .build();
        Assert.assertEquals(humanResourceExperienceUpdate.getCompanyName(), "CPUT");
        Assert.assertEquals(humanResourceExperienceUpdate.getDuties(),"[Ljava.lang.String;@5fcfe4b2");
        Assert.assertEquals(humanResourceExperienceUpdate.getStartDate(),"5/12/2013");
        Assert.assertEquals(humanResourceExperienceUpdate.getEndDate(),"5/11/2015");

    }
}
