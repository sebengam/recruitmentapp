package cput.ac.za.recruitmentapp.services.humanResource;

import android.content.Context;

import cput.ac.za.recruitmentapp.domain.humanResource.HumanResourceExperience;

/**
 * Created by Tank on 5/12/2016.
 */
public interface HumanResourceExperienceService
{
    void addHumanResourceExperience(Context context, HumanResourceExperience experience);

    void updateHumanResourceExperience(Context context, HumanResourceExperience experience);

}
