package cput.ac.za.recruitmentapp.domain.Administrator;

import java.io.Serializable;

/**
 * Created by student on 2016/04/03.
 */
public class Administrator implements Serializable
{
    private Long id;
    private String staffNumber;
    public String booking;
    private float totalWage;

    public Administrator (Builder builder)
    {   this.id = builder.id;
        this.booking = builder.booking;
        this.staffNumber = builder.staffNumber;
        this.totalWage = builder.totalWage;
    }




    public String getBooking() {

        return booking;
    }

    public String getStaffNumber() {
        return staffNumber;
    }

    public float totalWage()
    {

        return totalWage;
    }

    public Long getId() {
        return id;
    }

    public static class Builder
    {
        Long id;
        String booking;
        String staffNumber;
        float totalWage;

        public Builder id(Long value)
        {
            this.id = value;
            return this;
        }


        public Builder staffNumber(String value)
        {
            this.staffNumber = value;
            return this;
        }

        public Builder booking(String booking)
        {
            this.booking = booking;
            return this;
        }

        public Builder totalWage(float totalWage)
        {
            this.totalWage = totalWage;
            return this;
        }
        public Builder copy(Administrator administrator)
        {
            this.id = administrator.id;
            this.staffNumber = administrator.getStaffNumber();
            this.booking = administrator.booking;
            this.totalWage = administrator.totalWage();

            return this;
        }


        public Administrator build()
        {
            return new Administrator(this) {};
        }


    }


    @Override
    public String toString()
    {
        return String.format("Id : %d\nstaffNumber :%s\nbooking :%.2f\ntotalWage :%s",id,staffNumber,booking,totalWage);
    }
}
