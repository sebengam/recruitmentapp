package cput.ac.za.recruitmentapp.factory.client;

import java.util.Date;

import cput.ac.za.recruitmentapp.domain.client.ClientBooking;
import cput.ac.za.recruitmentapp.domain.client.ClientSchedule;


/**
 * Created by Tank on 4/23/2016.
 */
public class ClientScheduleFactory
{
    public static ClientSchedule getClientSchedule(String date, boolean available, String personBooked)
    {
        ClientSchedule myClientSchedule = new ClientSchedule.Builder()
                .date(date)
                .available(available)
                .personBooked(personBooked)
                .build();
        return myClientSchedule;

    }
}
