package cput.ac.za.recruitmentapp.factory.humanResource;

import java.util.Date;

import cput.ac.za.recruitmentapp.domain.humanResource.HumanResourceExperience;


/**
 * Created by Tank on 4/22/2016.
 */
public class HumanResourceExperienceFactory
{
    public static HumanResourceExperience getHumanResourceExperience(String companyName, String duties, String startDate, String endDate)
    {
        HumanResourceExperience myHumanResourceExperience = new HumanResourceExperience.Builder()
                .companyName(companyName)
                .duties(duties)
                .startDate(startDate)
                .endDate(endDate)
                .build();
        return myHumanResourceExperience;

    }

}
