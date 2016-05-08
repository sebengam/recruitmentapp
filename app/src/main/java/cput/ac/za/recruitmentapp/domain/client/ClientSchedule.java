package cput.ac.za.recruitmentapp.domain.client;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Tank on 4/23/2016.
 */
public class ClientSchedule implements Serializable
{   Long id;
    String date;
    Boolean available;
    String personBooked;

    public ClientSchedule(Builder builder)
    {
        this.id = builder.id;
        this.date = builder.date;
        this.available = builder.available;
        this.personBooked =  builder.personBooked;

    }

    public Long getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public Boolean getAvailable() {
        return available;
    }

    public String getPersonBooked() {
        return personBooked;
    }

    public static class Builder
    {
        Long id;
        String date;
        Boolean available;
        String personBooked;


        public Builder id(Long value)
        {
            this.id = value;
            return this;
        }

        public Builder date(String value)
        {
            this.date = value;
            return this;
        }

        public Builder available(Boolean value)
        {
            this.available = value;
            return this;
        }

        public Builder personBooked(String value)
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
