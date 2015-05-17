package constructioncompany.domain;

import javax.persistence.Entity;
import java.io.Serializable;

/**
 * Created by Yusiry Davids on 4/23/2015.
 */
@Entity
public class Artisan extends Staff implements Serializable {

    private String skill;

    public Artisan(){

    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public Artisan(Builder builder){
        skill = builder.skill;
        setName(builder.name);
        setSurname(builder.surname);
        setAddressCode(builder.addressCode);
        setPhone(builder.phone);
        setIDnumber(builder.IDnumber);
        setPayCode(builder.payCode);
        setStaffCode(builder.staffCode);
    }

    public static class Builder{
        private String skill;
        private String addressCode;
        private String name;
        private String surname;
        private String phone;
        private String IDnumber;
        private String payCode;
        private String staffCode;

        public Builder(String skill){
            this.skill = skill;
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
        public Artisan build(){
            return new Artisan(this);
        }
    }

}
