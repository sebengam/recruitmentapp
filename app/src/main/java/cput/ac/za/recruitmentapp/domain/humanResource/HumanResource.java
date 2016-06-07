package cput.ac.za.recruitmentapp.domain.humanResource;

import java.io.Serializable;


/**
 * Created by student on 2016/04/03.
 */
public abstract class HumanResource extends HumanResourceExperience implements Serializable
{
    private Long id;
    private String name;
    private String surname;
    private String candidateImage;
    private String industry;
    private String occupation;
    private String email;

    public HumanResource(Builder builder)
    {
        this.id = builder.id;
        this.name = builder.name;
        this.surname = builder.surname;
        this.candidateImage = builder.candidateImage;
        this.industry = builder.industry;
        this.occupation = builder.occupation;
        this.email = builder.email;
    }

    public String getEmail() {
        return email;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getCandidateImage() {
        return candidateImage;
    }

    public String getIndustry() {
        return industry;
    }

    public String getOccupation() {
        return occupation;
    }

    public static class Builder
    {
        private Long id;
        public String name;
        private String surname;
        private String candidateImage;
        private String industry;
        private String occupation;
        private String email;



        public Builder id(Long value)
        {
            this.id = value;
            return this;
        }

        public Builder email(String value)
        {

            this.email = value;
            return this;
        }

        public Builder name(String value)
        {

            this.name = value;
            return this;
        }

        public Builder surname(String value)
        {
            this.surname = value;
            return this;
        }

        public Builder candidateImage(String value)
        {
            this.candidateImage = value;
            return this;
        }

        public Builder industry(String value)
        {

            this.industry = value;
            return this;
        }

        public Builder occupation(String value)
        {
            this.occupation = value;
            return this;
        }



        public Builder copy(HumanResource value)
        {
            this.id = value.id;
            this.name = value.name;
            this.surname = value.surname;
            this.candidateImage = value.candidateImage;
            this.industry = value.industry;
            this.occupation = value.occupation;
            this.email = value.email;
            return this;
        }

        public HumanResource build ()
        {
            return new HumanResource(this) {
            };
        }
    }


}
