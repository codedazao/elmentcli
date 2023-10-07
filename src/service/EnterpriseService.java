package service;

import pojo.Customer;

public interface EnterpriseService {
    void registerEnterpriseAccount(Customer sessionCustomer);
    Customer loginEnterPrise(String username,String password);
}
