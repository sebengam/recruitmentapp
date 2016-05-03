package cput.ac.za.recruitmentapp.testSuit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import cput.ac.za.recruitmentapp.Domain.humanResource.humanResource.Administrator.AdminPaymentTest;
import cput.ac.za.recruitmentapp.Domain.humanResource.humanResource.Administrator.AdminWagesTest;
import cput.ac.za.recruitmentapp.Domain.humanResource.humanResource.Administrator.AdministratorTest;
import cput.ac.za.recruitmentapp.Domain.humanResource.humanResource.Client.ClienTest;
import cput.ac.za.recruitmentapp.Domain.humanResource.humanResource.Client.ClientBookingTest;
import cput.ac.za.recruitmentapp.Domain.humanResource.humanResource.Client.ClientScheduleTest;
import cput.ac.za.recruitmentapp.Domain.humanResource.humanResource.HumanResourceExperienceTest;
import cput.ac.za.recruitmentapp.Domain.humanResource.humanResource.HumanResourceLocationTest;
import cput.ac.za.recruitmentapp.Domain.humanResource.humanResource.HumanResourceQualificationTest;
import cput.ac.za.recruitmentapp.Domain.humanResource.humanResource.HumanResourceTest;


@RunWith(Suite.class)
@Suite.SuiteClasses({
        AdministratorTest.class,
        AdminPaymentTest.class,
        AdminWagesTest.class,
        ClienTest.class,
        ClientBookingTest.class,
        ClientScheduleTest.class,
        HumanResourceExperienceTest.class,
        HumanResourceLocationTest.class,
        HumanResourceTest.class,
        HumanResourceQualificationTest.class,

})
/**
 * Created by Tank on 4/16/2016.
 */
public class FactoryTestSuit
{

}
