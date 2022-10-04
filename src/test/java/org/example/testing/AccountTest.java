package org.example.testing;

import org.example.Account;
import org.example.Address;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

public class AccountTest {

    @Test
    public void newAccountShouldNotBeActiveAfterCreation() {
        //given+when
        Account newAccount = new Account();
        //then
        assertFalse(newAccount.isActive(),"check if new account is not active");
        assertThat(newAccount.isActive(), equalTo(false));
        assertThat(newAccount.isActive(), is(false));
    }

    @Test
    void newAccountShouldBeActiveAfterActivation(){
        //given
        Account newAccount = new Account();

        //when
        newAccount.activate();
        //then
        assertTrue(newAccount.isActive());
        assertThat(newAccount.isActive(), equalTo(true));
    }

    @Test
    void newlyCreatedAccountShouldNotHaveDefaultDeliveryAddressSet(){
        //given
        Account account = new Account();
        //when
        Address address = account.getDefaultDeliveryAdress();
        //then
        assertNull(address);
        assertThat(address,nullValue());
    }

    @Test
    void defaultDeliveryAddressShouldNotBeNullAfterBeingSet(){
        //given
        Address address = new Address("Krakowska","55");
        Account account = new Account();
       account.setDefaultDeliveryAdress(address);
        //when
        Address defaultAddress = account.getDefaultDeliveryAdress();
        //then
        assertNotNull(defaultAddress);
        assertThat(defaultAddress,notNullValue());
    }
}
