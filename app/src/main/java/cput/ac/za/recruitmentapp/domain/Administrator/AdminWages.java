package cput.ac.za.recruitmentapp.domain.Administrator;

/**
 * Created by Tank on 4/23/2016.
 */
public class AdminWages
{   Long id;
    int hours;
    float ratePerHour;
    float totalWages;

    public AdminWages(Builder builder) {

        this.id = builder.id;
        this.hours = builder.hours;
        this.ratePerHour = builder.ratePerHour;
        this.totalWages = builder.totalWages;
    }

    public int getHours() {
        return hours;
    }

    public float getRatePerHour() {
        return ratePerHour;
    }

    public float getTotalWages() {
        return totalWages;
    }

    public static class Builder
    {   Long id;
        int hours;
        float ratePerHour;
        float totalWages;

        public Builder id(Long value) {
            this.id = value;
            return this;
        }

        public Builder hours(int value) {
            this.hours = value;
            return this;
        }

        public Builder ratePerHour(float ratePerHour) {
            this.ratePerHour = ratePerHour;
            return this;
        }

        public Builder totalWages(float value) {
            this.totalWages = value;
            return this;
        }

        public Builder copy(AdminWages value)
        {
            this.id = value.id;
            this.hours = value.hours;
            this.ratePerHour = value.ratePerHour;
            this.totalWages = value.totalWages;

            return this;
        }


        public AdminWages build()
        {
            return new AdminWages(this) {};
        }


    }

}
