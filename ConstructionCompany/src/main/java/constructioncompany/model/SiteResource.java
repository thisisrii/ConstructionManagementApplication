package constructioncompany.model;

import constructioncompany.domain.Staff;
import org.springframework.hateoas.ResourceSupport;

import java.util.List;

/**
 * Created by Yusiry Davids on 7/22/2015.
 */
public class SiteResource extends ResourceSupport {

    private Long resid;
    private String name;

    private String sitecode;
    private String address;

    private List<Staff> staff;

    private SiteResource(){}

    public long getResid(){
        return resid;
    }

    public String getName(){
        return name;
    }

    public String getSitecode(){
        return sitecode;
    }

    public String getAddress(){
        return address;
    }

    public List<Staff> getStaff(){
        return staff;
    }

    public SiteResource(Builder builder){
        this.resid = builder.resid;
        this.name = builder.name;
        this.address = builder.address;
        this.staff = builder.staff;
        this.sitecode = builder.sitecode;
    }

    public static class Builder{
        private Long resid;
        private String name;

        private String sitecode;
        private String address;

        private List<Staff> staff;

        public Builder(String name){
            this.name = name;
        }

        public Builder address(String val){
            this.address = val;
            return this;
        }

        public Builder resid(Long val){
            this.resid = val;
            return this;
        }

        public Builder sitecode(String val){
            this.sitecode = val;
            return this;
        }

        public Builder staff(List<Staff> value){
            this.staff = value;
            return this;
        }

        public Builder copy(SiteResource value){
            this.address = value.address;
            this.sitecode = value.sitecode;
            this.name = value.name;
            this.resid = value.resid;
            this.staff = value.staff;
            return this;
        }

        public SiteResource build(){
            return new SiteResource(this);
        }
    }
}
