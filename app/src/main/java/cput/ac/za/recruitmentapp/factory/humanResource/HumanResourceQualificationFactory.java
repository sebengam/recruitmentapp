package cput.ac.za.recruitmentapp.factory.humanResource;


import cput.ac.za.recruitmentapp.domain.humanResource.HumanResourceQualification;

/**
 * Created by Tank on 4/22/2016.
 */
public class HumanResourceQualificationFactory
{
    public static HumanResourceQualification getHumanResourceQualification(String institution, String highestQualification, String year)
    {
        HumanResourceQualification myHumanResourceQualification = new HumanResourceQualification.Builder()
                .institution(institution)
                .highestQualification(highestQualification)
                .year(year)
                .build();
        return myHumanResourceQualification;

    }
}
