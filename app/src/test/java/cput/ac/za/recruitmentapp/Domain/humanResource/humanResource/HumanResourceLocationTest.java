package cput.ac.za.recruitmentapp.Domain.humanResource.humanResource;

import junit.framework.Assert;

import org.junit.Test;

import cput.ac.za.recruitmentmanager.domain.humanResource.HumanResourceLocation;
import cput.ac.za.recruitmentmanager.factory.humanResource.HumanResourceLocationFactory;

/**
 * Created by Tank on 4/23/2016.
 */
public class HumanResourceLocationTest
{
    @Test
    public void testCreate() throws Exception {
        HumanResourceLocation humanResourceLocation = HumanResourceLocationFactory.getHumanResourceLocation(12.0, "Tankiso", "jpg", "cpt", "wc");
        Assert.assertEquals(humanResourceLocation.getNumber(), 12.0);
        Assert.assertEquals(humanResourceLocation.getStreet(), "Tankiso");
        Assert.assertEquals(humanResourceLocation.getSurburb(),"jpg");
        Assert.assertEquals(humanResourceLocation.getCity(),"cpt");
        Assert.assertEquals(humanResourceLocation.getProvince(),"wc");

    }

    @Test
    public void testNewUpdate() throws Exception {
        HumanResourceLocation humanResource = HumanResourceLocationFactory.getHumanResourceLocation(12.0, "Tankiso", "jpg", "cpt", "wc");
        HumanResourceLocation humanResourceUpdate = new HumanResourceLocation
                .Builder()
                .copy(humanResource)
                .number(12.0)
                .street("Tankiso")
                .surburb("jpg")
                .city("cpt")
                .province("wc")
                .build();
        Assert.assertEquals(humanResourceUpdate.getNumber(),12.0);
        Assert.assertEquals(humanResourceUpdate.getStreet(),"Tankiso");
        Assert.assertEquals(humanResourceUpdate.getSurburb(),"jpg");
        Assert.assertEquals(humanResourceUpdate.getCity(),"cpt");
        Assert.assertEquals(humanResourceUpdate.getProvince(),"wc");

    }
}
