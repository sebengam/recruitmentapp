package cput.ac.za.recruitmentapp.repository.humanResource;

import java.util.Set;

import cput.ac.za.recruitmentapp.domain.humanResource.HumanResourceExperience;
import cput.ac.za.recruitmentapp.repository.Repository;

/**
 * Created by Tank on 4/24/2016.
 */
public interface HumanResourceExperienceRepository extends Repository<HumanResourceExperience,Long>
{

    HumanResourceExperience save(HumanResourceExperience entity);
}
