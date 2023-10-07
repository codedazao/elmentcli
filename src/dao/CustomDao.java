package dao;

import pojo.Customer;

public interface CustomDao {
    Customer getCustomer(Customer customer);

    Boolean setCustomer(Customer customer);

    void updateCustom(Customer customer);
}
