package cput.ac.za.recruitmentapp.domain.humanResource;

import java.io.Serializable;
import java.util.Set;

import cput.ac.za.recruitmentapp.repository.humanResource.HumanResourceExperienceRepository;


/**
 * Created by Tank on 4/22/2016.
 */
public abstract class HumanResourceExperience implements Serializable
{
    private Long id;
    private String companyName;
    private String duties = String.valueOf(new String [10]);
    private String startDate;
    private String endDate;

    public HumanResourceExperience(Builder builder)
    {
        this.companyName = builder.companyName;
        this.duties = builder.duties;
        this.startDate = builder.startDate;
        this.endDate = builder.endDate;
    }

    public HumanResourceExperience() {

    }

    public Long getId() {
        return id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getDuties() {
        return String.valueOf(new String[]{duties});
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public static class Builder
    {
        private Long id;
        private String companyName;
        private String duties;
        private String startDate;
        private String endDate;

        public Builder id(Long value)
        {
            this.id = value;
            return this;
        }

        public Builder companyName(String value)
        {
            this.companyName = value;
            return this;
        }

        public Builder duties(String value)
        {
            this.duties = value;
            return this;
        }

        public Builder startDate(String value)
        {
            this.startDate = value;
            return this;
        }

        public Builder endDate(String value)
        {
            this.endDate = value;
            return this;

        }



        public Builder copy(HumanResourceExperience value)
        {
            this.id = value.id;
            this.companyName = value.companyName;
            this.duties = value.duties;
            this.startDate = value.startDate;
            this.endDate = value.endDate;
            return this;
        }
        
        public HumanResourceExperience build()
        {
            return new HumanResourceExperience(this)
            {

            };
        }

    }
}
