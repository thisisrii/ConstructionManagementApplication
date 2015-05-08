package constructioncompany.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Yusiry Davids on 4/23/2015.
 */
@Entity
public class Address implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int number;
    private String street;
    private String subCity;
    private String city;
    private String province;
    private String country;
    private int areaCode;
    @Column(unique = true)
    private String addressCode;

    public Address(){

    }

    public Address(Builder builder){
      //  id = builder.id;
        number = builder.number;
        street = builder.street;
        subCity = builder.subCity;
        city = builder.city;
        province = builder.province;
        country = builder.country;
        areaCode = builder.areaCode;
        addressCode = builder.addressCode;
    }

    public int getId() {
        return id;
    }

    public int getNumber() {
        return number;
    }

    public String getStreet() {
        return street;
    }

    public String getSubCity() {
        return subCity;
    }

    public String getCity() {
        return city;
    }

    public String getProvince() {
        return province;
    }

    public String getCountry() {
        return country;
    }

    public int getAreaCode() {
        return areaCode;
    }

    public String getAddressCode() {
        return addressCode;
    }

    public static class Builder{
     //   private int id;
        private int number;
        private String street;
        private String subCity;
        private String city;
        private String province;
        private String country;
        private int areaCode;
        private String addressCode;

        public Builder(String code){
            this.addressCode = code;
        }

        public Builder number(int value){
            this.number = value;
            return this;
        }

        public Builder street(String value){
            this.street = value;
            return this;
        }

        public Builder subCity(String value){
            this.subCity = value;
            return this;
        }

        public Builder city(String value){
            this.city = value;
            return this;
        }

        public Builder province(String value){
            this.province = value;
            return this;
        }

        public Builder country(String value){
            this.country = value;
            return this;
        }

        public Builder areaCode(int value){
            this.areaCode = value;
            return this;
        }


        public Builder copy(Address value){
           // this.id = value.id;
            this.number = value.number;
            this.street = value.street;
            this.subCity = value.subCity;
            this.city = value.city;
            this.province = value.province;
            this.country = value.country;
            this.areaCode = value.areaCode;
            this.addressCode = value.addressCode;

            return this;
        }

        public Address build(){
            return new Address(this);
        }
    }
}
