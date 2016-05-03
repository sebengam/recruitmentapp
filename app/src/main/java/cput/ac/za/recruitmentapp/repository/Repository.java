package cput.ac.za.recruitmentapp.repository;

import java.util.Set;

import cput.ac.za.recruitmentapp.domain.humanResource.HumanResource;
import cput.ac.za.recruitmentmanagerapp.domain.humanResource.HumanResource;
import cput.ac.za.recruitmentmanagerapp.domain.humanResource.HumanResourceExperience;

/**
 * Created by Tank on 4/20/2016.
 */
public interface Repository<E, ID>
{
    HumanResource findById(ID id);

    HumanResource save(HumanResource entity);

    E update(E entity);

    E delete(E entity);

    Set<HumanResource> findAll();

    int deleteAll();
}
