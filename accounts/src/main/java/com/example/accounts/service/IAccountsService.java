package com.example.accounts.service;

import com.example.accounts.dto.CustomerDto;

public interface IAccountsService {

    /**
     * This method is used to create a new account.
     *
     * @param customerDto the customer data transfer object containing account details
     */
    void createAccount(CustomerDto customerDto);
    CustomerDto fetchAccount(String mobileNumber);
    boolean updateAccount(CustomerDto customerDto);
    boolean deleteAccount(String mobileNumber);
}
