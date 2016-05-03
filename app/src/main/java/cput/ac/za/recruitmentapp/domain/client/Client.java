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

    public Client(Builder builder) {
        this.id = builder.id;
        this.companyName = builder.companyName;
        this.regNumber = builder.regNumber;

    }

    public Client() {

    }

    public String getCompanyName() {
        return companyName;
    }

    public String getRegNumber() {
        return regNumber;
    }


    public static class Builder
    {

        private String companyName;
        private String regNumber;
        public long id;


        public Builder id(Long value){
            this.id = value;
            return this;
        }

        public Builder regNumber(String regNumber){
            this.regNumber = regNumber;
            return this;
        }

        public Builder() {

        }


        public Builder companyName(String companyName) {
            this.companyName = companyName;
            return this;
        }

        public Builder copy(Client client){
            this.companyName = client.getCompanyName();
            this.regNumber = client.getRegNumber();

            return this;
        }

        public Client build() {
            return new Client(this){};
        }

    }

}
