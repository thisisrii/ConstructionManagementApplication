package constructioncompany.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Yusiry Davids on 4/23/2015.
 */
@Entity
public class PayRoll implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private double amount;
    @Column(unique = true)
    private String payCode;
    private String receiverCode;

    public String getReceiverCode() {
        return receiverCode;
    }

    public int getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }

    public String getPayCode() {
        return payCode;
    }

    public PayRoll(Builder builder){
        this.id = builder.id;
        this.amount = builder.amount;
        this.payCode = builder.payCode;
        this.receiverCode = builder.receiverCode;
    }

    public static class Builder{
        private int id;
        private double amount;
        private String payCode;
        private String receiverCode;

        public Builder(int id){
            this.id = id;
        }

        public Builder amount(double value){
            this.amount = value;
            return this;
        }

        public Builder payCode(String value){
            this.payCode = value;
            return this;
        }

        public Builder receiverCode(String value){
            this.receiverCode  = value;
            return this;
        }

        public Builder copy(PayRoll value){
            this.id = value.id;
            this.amount = value.amount;
            this.payCode = value.payCode;

            return this;
        }

        public PayRoll build(){
            return new PayRoll(this);
        }
    }
}
