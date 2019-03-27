package com.sadhwani.kubernetes.TransactionService.Payment;

import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;


@Entity
@Table(name="Payment")
public class Payment {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Double amount;
    private TranType tranType;

    public enum TranType{PAY, COLLECT};

    public TranType getTranType() {
        return tranType;
    }

    public void setTranType(TranType tranType) {
        this.tranType = tranType;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }



    public Payment(){

    }



}
