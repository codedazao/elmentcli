package service;

import pojo.Customer;

public interface CustomService {
    Customer login(Customer customer);

    Customer registerUser(Customer customer);

    void updateCustom(Customer customer);
}
