package cput.ac.za.recruitmentapp.domain.humanResource;

import android.os.Build;

/**
 * Created by Tank on 4/22/2016.
 */
public class HumanResourceLocation
{
    public Long id;
    double number;
    String street;
    String surburb;
    String city;
    String province;

    public HumanResourceLocation(Builder builder) {
        this.id = builder.id;
        this.number = builder.number;
        this.street = builder.street;
        this.surburb = builder.surburb;
        this.city = builder.city;
        this.province = builder.province;

    }


    public Long getId() {
        return id;
    }

    public double getNumber() {
        return number;
    }

    public String getStreet() {
        return street;
    }

    public String getSurburb() {
        return surburb;
    }

    public String getCity() {
        return city;
    }

    public String getProvince() {
        return province;
    }

    public static class Builder
    {
        Long id;
        double number;
        String street;
        String surburb;
        String city;
        String province;

        public Builder id(Long value)
        {
            this.id = value;
            return this;
        }

        public Builder number(double value)
        {
            this.number = value;
            return this;
        }

        public Builder street(String value) {
            this.street = value;
            return this;
        }

        public Builder surburb(String value) {
            this.surburb = value;
            return this;
        }

        public Builder city(String value) {
            this.city = value;
            return this;

        }

        public Builder province(String status) {
            this.province = status;
            return this;
        }

        public Builder copy(HumanResourceLocation value)
        {
            this.id = value.id;
            this.number = value.number;
            this.street = value.street;
            this.surburb = value.surburb;
            this.city = value.city;
            this.province = value.province;
            return this;
        }

        public HumanResourceLocation build(){

            return new HumanResourceLocation(this)
            {
            };
        }


    }
}
