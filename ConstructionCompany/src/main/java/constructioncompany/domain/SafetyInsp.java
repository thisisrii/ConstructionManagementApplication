package constructioncompany.domain;

import javax.persistence.Entity;
import java.io.Serializable;

/**
 * Created by Yusiry Davids on 4/23/2015.
 */
@Entity
public class SafetyInsp extends Staff implements Serializable {

    private String institute;
    private String qualification;

    public SafetyInsp(){

    }


    public String getInstitute() {
        return institute;
    }


    public String getQualification() {
        return qualification;
    }

    public SafetyInsp(Builder builder){
        institute = builder.institute;
        qualification = builder.qualification;
        setName(builder.name);
        setSurname(builder.surname);
        setAddressCode(builder.addressCode);
        setPhone(builder.phone);
        setIDnumber(builder.IDnumber);
        setPayCode(builder.payCode);
        setStaffCode(builder.staffCode);
    }

    public static class Builder{
        private String institute;
        private String qualification;
        private String addressCode;
        private String name;
        private String surname;
        private String phone;
        private String IDnumber;
        private String payCode;
        private String staffCode;

        public Builder(String institute){
            this.institute = institute;
        }

        public Builder qualification(String value){
            this.qualification = value;
            return this;
        }

        public Builder addressCode(String value){
            this.addressCode = value;
            return this;
        }

        public Builder name(String value){
            this.name = value;
            return this;
        }

        public Builder surname(String value){
            this.surname = value;
            return this;
        }

        public Builder phone(String value){
            this.phone = value;
            return this;
        }

        public Builder IDnumber(String value){
            this.IDnumber = value;
            return this;
        }

        public Builder payCode(String value){
            this.payCode = value;
            return this;
        }

        public Builder staffCode(String value){
            this.staffCode = value;
            return this;

        }

        public SafetyInsp build(){
            return new SafetyInsp(this);
        }
    }
}
