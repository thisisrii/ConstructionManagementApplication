package constructioncompany.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Yusiry Davids on 4/22/2015.
 */
@Entity
public class Site implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String siteName;
    @Column(unique = true)
    private String siteCode;
    private String addressCode;
    private int siteSize;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="staffCode")
    private List<Staff> staff;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="subcontractorCode")
    private List<SubContractor> subContractors;

    private Site(){

    }

    public Site(Builder builder){
        siteName = builder.siteName;
        siteCode = builder.siteCode;
        addressCode = builder.addressCode;
        siteSize = builder.siteSize;
        staff = builder.staff;
        subContractors = builder.subContractors;
    }


    public String getSiteName(){
        return  siteName;
    }

    public String getSiteCode(){
        return siteCode;
    }

    public String getAddressCodeTwo(){
        return addressCode;
    }

    public int getSiteSize(){
        return  siteSize;
    }

    public List<Staff> getStaff(){
        return staff;
    }


    public List<SubContractor> getSubContractors() {
        return subContractors;
    }

    public static class Builder{

        private Long id;
        private String siteName;
        private String siteCode;
        private String addressCode;
        private int siteSize;
        private List<Staff> staff;
        private List<SubContractor> subContractors;


        public Builder(String siteCode){
            this.siteCode = siteCode;
        }

        public Builder siteSize(int value){
            this.siteSize = value;
            return this;
        }

        public Builder staff(List<Staff> value){
            this.staff = value;
            return this;
        }

        public Builder subContractors(List<SubContractor> value){
            this.subContractors = value;
            return this;
        }

        public Builder id(Long value){
            this.id = value;
            return this;
        }

        public Builder addressCode(String value){
            this.addressCode = value;
            return this;
        }

        public Builder siteName(String value){
            this.siteName = value;
            return this;
        }

        public Builder copy(Site value){
            this.siteName = value.getSiteName();
            this.siteCode = value.getSiteCode();
            this.siteSize = value.getSiteSize();
            this.addressCode = value.getAddressCodeTwo();

            this.staff = value.getStaff();
            this.subContractors = value.getSubContractors();
            return this;
        }

        public Site build(){
            return new Site(this);
        }
    }


    @Override
    public String toString(){
        return "Site{" +
                " id = " + id +
                ", name = " + siteName +
                ", code = " + siteCode +
                ", size = " + siteSize +
                ", addressCode = " + addressCode +
                "};";
    }
}
