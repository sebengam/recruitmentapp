package cput.ac.za.recruitmentapp.domain.client;

import java.util.Date;

/**
 * Created by Tank on 4/23/2016.
 */
public class ClientSchedule
{   Long id;
    Date date;
    Boolean available;
    ClientBooking personBooked;

    public ClientSchedule(Builder builder)
    {
        this.id = builder.id;
        this.date = builder.date;
        this.available = builder.available;
        this.personBooked =  builder.personBooked;

    }

    public Date getDate() {
        return date;
    }

    public Boolean getAvailable() {
        return available;
    }

    public ClientBooking getPersonBooked() {
        return personBooked;
    }

    public static class Builder
    {
        Long id;
        Date date;
        Boolean available;
        ClientBooking personBooked;


        public Builder id(Long value)
        {
            this.id = value;
            return this;
        }

        public Builder date(Date value)
        {
            this.date = value;
            return this;
        }

        public Builder available(Boolean value)
        {
            this.available = value;
            return this;
        }

        public Builder personBooked(ClientBooking value)
        {
            this.personBooked = value;
            return this;
        }

        public Builder copy(ClientSchedule value)
        {
            this.id = value.id;
            this.date = value.date;
            this.available = value.available;
            this.personBooked = value.personBooked;
            return this;
        }

        public ClientSchedule build()
        {
            return new ClientSchedule(this)
            {};
        }

    }
}
