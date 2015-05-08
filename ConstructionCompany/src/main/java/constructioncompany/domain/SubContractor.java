package constructioncompany.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Yusiry Davids on 4/23/2015.
 */
@Entity
public class SubContractor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(unique = true)
    private String contractorCode;
    private String name;
    private String addressCode;
    private String speciality;

    public SubContractor(Builder builder){
       // id = builder.id;
        contractorCode = builder.contractorCode;
        name = builder.name;
        addressCode = builder.addressCode;
        speciality = builder.speciality;
    }

    public SubContractor(){

    }

    public int getId() {
        return id;
    }

    public String getContractorCode() {
        return contractorCode;
    }

    public String getName() {
        return name;
    }

    public String getAddressCode() {
        return addressCode;
    }

    public String getSpeciality() {
        return speciality;
    }

    public static class Builder{
    //    private int id;
        private String contractorCode;
        private String name;
        private String addressCode;
        private String speciality;

        public Builder(String code){
            this.contractorCode = code;
        }

        public Builder name(String value){
            this.name = value;
            return this;
        }

        public Builder addressCode(String value){
            this.addressCode = value;
            return this;
        }

        public Builder speciality(String value){
            this.speciality = value;
            return this;
        }

        public Builder copy(SubContractor subContractor){
            this.contractorCode = subContractor.contractorCode;
            this.name = subContractor.name;
            this.addressCode = subContractor.addressCode;
            this.speciality = subContractor.speciality;
            return this;
        }

        public SubContractor build(){
            return new SubContractor(this);
        }
    }
}
