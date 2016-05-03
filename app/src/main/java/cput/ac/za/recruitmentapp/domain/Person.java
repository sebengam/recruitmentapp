package cput.ac.za.recruitmentapp.domain;

import java.io.Serializable;

/**
 * Created by student on 2016/04/03.
 */
public abstract class Person implements Serializable
{
    private Long id;
    private String name;
    private String surname;
    private String IDNumber;
    private String authorisation;

    public Person(Builder builder)
    {
        this.id = builder.id;
        this.name = builder.name;
        this.surname = builder.surname;
        this.IDNumber = builder.IDNumber;
        this.authorisation = builder.authorisation;

    }

    public Long getId() {
        return id;
    }

    public Person() {

    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getIDNumber() {
        return IDNumber;
    }

    public String getAuthorisation() {
        return authorisation;
    }

    abstract int totalHours();

    abstract float getRatePerHour();


    public static class Builder {

        //Equivalent to setters
        public Long id;
        private String name;
        private String surname;
        private String IDNumber;
        public String authorisation;


        public Builder id(Long value)
        {
            this.id = value;
            return this;
        }

        public Builder IDNumber(String value)
        {
            this.IDNumber = value;
            return this;
        }

        public Builder surname(String value) {
            this.surname = value;
            return this;
        }

        public Builder name(String value)   {
            this.name = value;
            return this;
        }
        public Builder authorisation(String value)   {
            this.name = value;
            return this;
        }




        public Builder copy(Person value)
        {
            this.id = value.id;
            this.IDNumber = value.IDNumber;
            this.surname = value.surname;
            this.name = value.name;
            this.authorisation = value.authorisation;
            return this;
        }

        public Person build() {
            return new Person(this) {
                public float totalWages() {
                    return totalHours()*getRatePerHour();
                }

                @Override
                public int totalHours() {
                    return 0;
                }

                @Override
                public float getRatePerHour() {
                    return 0;
                }
            };
        }
    }

}
