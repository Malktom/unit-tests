package org.example;

public class Account {

    private boolean active;
    private Address defaultDeliveryAdress;

    public Address getDefaultDeliveryAdress() {
        return defaultDeliveryAdress;
    }

    public void setDefaultDeliveryAdress(Address defaultDeliveryAdress) {
        this.defaultDeliveryAdress = defaultDeliveryAdress;
    }

    public Account(){
        this.active = false;

    }

    public void activate() {
        this.active = true;

    }
    public boolean isActive() {
        return this.active;
    }
}
