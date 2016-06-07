package cput.ac.za.recruitmentapp.factory.client;


import cput.ac.za.recruitmentapp.domain.client.Client;

/**
 * Created by student on 2016/04/03.
 */
public class ClientFactory
{ public static Client getClient(String companyName, String regNumber, String email)
    {
        Client myClient = new Client.Builder()
                .companyName(companyName)
                .regNumber(regNumber)
                .email(email)
                .build();
        return myClient;

    }


}
