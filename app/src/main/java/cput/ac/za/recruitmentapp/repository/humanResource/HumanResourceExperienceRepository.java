package cput.ac.za.recruitmentapp.repository.humanResource;

import java.util.Set;

import cput.ac.za.recruitmentapp.domain.humanResource.HumanResourceExperience;
import cput.ac.za.recruitmentmanagerapp.domain.humanResource.HumanResourceExperience;
import cput.ac.za.recruitmentmanager.repository.Repository;
import cput.ac.za.recruitmentmanagerapp.domain.humanResource.HumanResource;

/**
 * Created by Tank on 4/24/2016.
 */
public interface HumanResourceExperienceRepository extends Repository<HumanResourceExperienceRepository,Long>
{


    HumanResourceExperience save(HumanResourceExperience entity);

    HumanResourceExperience update(HumanResourceExperience entity);

    Set<HumanResourceExperience> findAll();

    HumanResourceExperience delete(HumanResourceExperience entity);

    HumanResourceExperience deleteAll(HumanResourceExperience entity);

    HumanResource deleteAll(HumanResource entity);

    HumanResourceExperience findById(Long id);

    int deleteAll();
}
