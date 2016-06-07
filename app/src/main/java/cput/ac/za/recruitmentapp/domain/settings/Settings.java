package cput.ac.za.recruitmentapp.domain.settings;/*package cput.ac.za.recruitmentmanager.domain.settings;

import java.io.Serializable;

import cput.ac.za.recruitmentmanager.domain.humanResource.HumanResource;

/**
 * Created by Tank on 4/21/2016.
 */

import java.io.Serializable;

public class Settings implements Serializable
{

    private Long id;
    private String code;
    private String username;
    private String password;


    public Long getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Settings(Builder builder) {
        this.id=builder.id;
        this.code =builder.code;
        this.password= builder.password;
        this.username = builder.username;
    }

    public static class  Builder{
        private Long id;
        private String code;
        private String username;
        private String password;

        public Builder id(Long value){
            this.id=value;
            return this;
        }

        public Builder code(String value){
            this.code=value;
            return this;
        }

        public Builder username(String value){
            this.username=value;
            return this;
        }

        public Builder password(String value){
            this.password=value;
            return this;
        }

        public Builder copy(Settings value){
            this.password=value.password;
            this.username=value.username;
            this.code = value.code;
            this.id = value.id;
            return this;
        }

        public Settings build(){
            return new Settings(this);
        }
    }

}
