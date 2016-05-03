package cput.ac.za.recruitmentapp.domain.client;

/**
 * Created by student on 2016/04/03.
 */
public class ClientBooking
{
    Long id;
    String bookedPerson;
    String bookingCompany;
    public Boolean available;

    public ClientBooking(Builder builder)
    {   this.id = builder.id;
        available = builder.availability;
        bookedPerson = builder.bookingPerson;
        bookingCompany = builder. bookingCompany;

    }

    public Long getId() {
        return id;
    }

    public String getBookedPerson() {
        return bookedPerson;
    }

    public String getBookingCompany() {
        return bookingCompany;
    }

    public Boolean getAvailability() {
        return available;
    }


    public static class Builder
    {
        Long id;
        private Boolean availability;
        String bookingPerson;
        String bookingCompany;

        public Builder id(boolean value)
        {
            this.availability = value;
            return this;
        }

        public Builder availability(boolean value)
        {
            this.availability = value;
            return this;
        }

        public Builder bookingPerson(String bookingPerson)
        {
            this.bookingPerson =  bookingPerson;
            return this;
        }

        public Builder bookingCompany(String bookingCompany)
        {
            this.bookingCompany = bookingCompany;
            return this;
        }

        public Builder copy(ClientBooking clientBooking)
        {
            this.availability = clientBooking.getAvailability();
            this.bookingCompany = String.valueOf(clientBooking.getBookingCompany());
            this.bookingPerson = clientBooking.getBookedPerson();


            return this;
        }

        public ClientBooking build()
        {
            return new ClientBooking(this);
        }


    }
}
