package com.example.demo.models;

public class Name {

    public int amount;
    public String name;

    public Name(){

    }

    public Name(int amount, String name)
    {
        this.amount = amount;
        this.name = name;
    }

    public String GetName()
    {
        return name;
    }

    public int GetAmount()
    {
        return amount;
    }

    public void SetName(String setName)
    {
        name = setName;
    }

    public void SetAmount(int setAmount)
    {
        amount = setAmount;
    }

}