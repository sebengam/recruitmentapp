package cput.ac.za.recruitmentapp.factory.client;

import cput.ac.za.recruitmentmanagerapp.domain.client.ClientBooking;

/**
 * Created by student on 2016/04/05.
 */
public class ClientBookingFactory
{
    public static ClientBooking getBooking(Boolean availability, String bookingCompany, String bookingPerson)
    {
        ClientBooking myClientBooking = new ClientBooking.Builder()
                .availability(availability)
                .bookingCompany(bookingCompany)
                .bookingPerson(bookingPerson)
                .build();
        return myClientBooking;

    }

}
