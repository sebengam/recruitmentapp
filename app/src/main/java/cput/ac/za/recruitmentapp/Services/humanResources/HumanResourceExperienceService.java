package cput.ac.za.recruitmentapp.Services.humanResources;

import android.content.Context;

import cput.ac.za.recruitmentapp.domain.humanResource.HumanResource;

/**
 * Created by Tank on 5/7/2016.
 */
public interface HumanResourceExperienceService
{

    void addPersonContact(Context context, HumanResource humanResource);

    void updatePersonContact(Context context, HumanResource humanResource);

}
