package cput.ac.za.recruitmentapp.factory.humanResource;


import cput.ac.za.recruitmentapp.domain.humanResource.HumanResourceLocation;

/**
 * Created by Tank on 4/23/2016.
 */
public class HumanResourceLocationFactory
{
    public static HumanResourceLocation getHumanResourceLocation(double number, String street, String surburb, String city, String province)
    {
        HumanResourceLocation myHumanResourceQualification = new HumanResourceLocation.Builder()
                .number(number)
                .street(street)
                .surburb(surburb)
                .city(city)
                .province(province)
                .build();
        return myHumanResourceQualification;

    }
}
