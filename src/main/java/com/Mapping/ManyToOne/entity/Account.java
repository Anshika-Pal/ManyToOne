package com.Mapping.ManyToOne.entity;

import jakarta.persistence.*;

@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int acc_no;
    private String name;
    private int balance;
    @ManyToOne(cascade = CascadeType.MERGE)
    private Branch branch;

    @Override
    public String toString() {
        return "Account{" +
                "acc_no=" + acc_no +
                ", name='" + name + '\'' +
                ", balance=" + balance +
                ", branch=" + branch +
                '}';
    }

    public Account(int acc_no, String name, int balance, Branch branch) {
        this.acc_no = acc_no;
        this.name = name;
        this.balance = balance;
        this.branch = branch;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }


    public int getAcc_no() {
        return acc_no;
    }

    public void setAcc_no(int acc_no) {
        this.acc_no = acc_no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public Account() {
    }

}
