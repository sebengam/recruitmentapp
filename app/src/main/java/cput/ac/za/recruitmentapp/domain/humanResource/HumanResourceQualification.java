package cput.ac.za.recruitmentapp.domain.humanResource;

import android.os.Build;

import java.io.Serializable;

/**
 * Created by Tank on 4/22/2016.
 */
public class HumanResourceQualification implements Serializable
{
    private Long id;
    private String institution;
    private String highestQualification;
    private String year;

    public HumanResourceQualification(Builder builder)
    {
        this.id = builder.id;
        this.institution = builder.institution;
        this.highestQualification = builder.highestQualification;
        this.year = builder.year;
    }

    public Long getId() {
        return id;
    }

    public String getInstitution() {
        return institution;
    }

    public String getHighestQualification() {
        return highestQualification;
    }

    public String getYear() {
        return year;
    }

    public static class Builder
    {
        private Long id;
        private String institution;
        private String highestQualification;
        private String year;

        public Builder id(Long value) {
            this.id = value;
            return this;
        }

        public Builder year(String value) {
            this.year = value;
            return this;
        }

        public Builder highestQualification(String value) {
            this.highestQualification = value;
            return this;
        }

        public Builder institution(String value) {
            this.institution = value;
            return this;
        }

        public Builder copy(HumanResourceQualification value)
        {
            this.id = value.id;
            this.institution = value.institution;
            this.highestQualification = value.highestQualification;
            this.year = value.year;
            return this;
        }

        public HumanResourceQualification build()
        {
            return new HumanResourceQualification(this)
            {};
        }

    }
}
