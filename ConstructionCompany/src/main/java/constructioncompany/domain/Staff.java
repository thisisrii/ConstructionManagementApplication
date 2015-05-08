package constructioncompany.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.net.IDN;


/**
 * Created by Yusiry Davids on 4/23/2015.
 */
@Entity
public abstract class Staff implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String surname;
    private String phone;
    private String IDnumber;
    @Embedded
    private String addressCode;
   // @OneToOne(cascade = CascadeType.ALL)
   // @JoinColumn(name="payCode")
    private String payCode;

    public String getStaffCode() {
        return staffCode;
    }

    @Column(unique = true)
    private String staffCode;

    public Staff() {
    }

    public String getAddressCode() {
        return addressCode;
    }

    public int getId() {
        return id;

    }

    public void setAddressCode(String addressCode) {
        this.addressCode = addressCode;
    }

    public void setPayCode(String payCode) {
        this.payCode = payCode;
    }

    public void setStaffCode(String staffCode) {
        this.staffCode = staffCode;
    }

    public String getPayCode() {
        return payCode;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIDnumber() {
        return IDnumber;
    }

    public void setIDnumber(String IDnumber) {
        this.IDnumber = IDnumber;
    }

    public String getAddressID() {
        return addressCode;
    }

    public void setAddressID(String addressID) {
        this.addressCode = addressID;
    }


}
