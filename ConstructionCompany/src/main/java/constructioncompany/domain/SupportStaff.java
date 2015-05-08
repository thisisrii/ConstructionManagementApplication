package constructioncompany.domain;

import java.io.Serializable;

/**
 * Created by Yusiry Davids on 4/23/2015.
 */
public class SupportStaff extends Staff implements Serializable {

    private String position;
    private String qualification;
    private String university;

    public SupportStaff(){

    }


    public String getPosition() {
        return position;
    }


    public String getQualification() {
        return qualification;
    }

    public String getUniversity() {
        return university;
    }


    public SupportStaff(Builder builder){
        position = builder.position;
        qualification = builder.qualification;
        university = builder.university;
        setName(builder.name);
        setSurname(builder.surname);
        setAddressCode(builder.addressCode);
        setPhone(builder.phone);
        setIDnumber(builder.IDnumber);
        setPayCode(builder.payCode);
        setStaffCode(builder.staffCode);
    }

    public static class Builder{
        private String position;
        private String qualification;
        private String university;
        private String addressCode;
        private String name;
        private String surname;
        private String phone;
        private String IDnumber;
        private String payCode;
        private String staffCode;

        public Builder(String position){
            this.position = position;
        }

        public Builder qualification(String value){
            this.qualification = value;
            return this;
        }

        public Builder university(String value){
            this.university = value;
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

        public SupportStaff build(){
            return new SupportStaff(this);
        }
    }
}
