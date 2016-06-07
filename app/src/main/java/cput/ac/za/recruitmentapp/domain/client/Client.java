package cput.ac.za.recruitmentapp.domain.client;

import java.io.Serializable;

/**
 * Created by student on 2016/04/03.
 */
public class Client implements Serializable
{
    private long id;
    private String companyName;
    private String regNumber;
    private String email;

    public Client(Builder builder) {
        this.id = builder.id;
        this.companyName = builder.companyName;
        this.regNumber = builder.regNumber;
        this.email = builder.email;

    }

    public long getId() {
        return id;
    }

    public Client() {

    }

    public String getCompanyName() {
        return companyName;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public String getEmail() {
        return email;
    }

    public static class Builder
    {

        private String companyName;
        private String regNumber;
        public long id;
        private String email;


        public Builder id(Long value){
            this.id = value;
            return this;
        }

        public Builder regNumber(String regNumber){
            this.regNumber = regNumber;
            return this;
        }

        public Builder email(String value)
        {
            this.email = value;
            return this;
        }


        public Builder companyName(String companyName) {
            this.companyName = companyName;
            return this;
        }

        public Builder copy(Client client){
            this.id = client.id;
            this.companyName = client.getCompanyName();
            this.regNumber = client.getRegNumber();
            this.email = client.getEmail();

            return this;
        }

        public Client build() {
            return new Client(this){};
        }

    }

}
