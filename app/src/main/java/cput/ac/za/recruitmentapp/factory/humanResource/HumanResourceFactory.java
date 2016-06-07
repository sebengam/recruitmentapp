package cput.ac.za.recruitmentapp.factory.humanResource;


import cput.ac.za.recruitmentapp.domain.humanResource.HumanResource;

/**
 * Created by student on 2016/04/03.
 */
public class HumanResourceFactory
{
    public static HumanResource getHumanResource(String name, String surname, String candidateImage, String industry, String occupation,String email)
    {
        HumanResource myCompany = new HumanResource.Builder()
                .name(name)
                .surname(surname)
                .candidateImage(candidateImage)
                .industry(industry)
                .occupation(occupation)
                .email(email)
                .build();
        return myCompany;

    }

}
