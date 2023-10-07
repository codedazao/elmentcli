package service.impl;

import dao.CustomDao;
import dao.impl.CustomDaoImpl;
import pojo.Customer;
import service.CustomService;

public class CustomServiceImpl implements CustomService {
    /**
     * @param customer  要验证账号密码的customer
     * @return 返回验证过后的customer，返回null代表登录失败
     */
    @Override
    public Customer login(Customer customer) {
        //本地文件保存用户的账号和密码
        CustomDao customDao = new CustomDaoImpl();
        Customer readCustomer=customDao.getCustomer(customer);
        if (readCustomer==null){
            return null;
        }
        String username = readCustomer.getUsername();
        String password = readCustomer.getPassword();
        if (customer.getUsername().equals(username)&&customer.getPassword().equals(password)){
            return customer;
        }
        return null;
    }

    /**
     * @param customer 要注册的用户西南西
     * @return 返回注册过后的用户信息，返回null代表注册失败
     */
    @Override
    public Customer registerUser(Customer customer) {
        CustomDao customDao = new CustomDaoImpl();
        Boolean successRegister = customDao.setCustomer(customer);
        if (successRegister){
            return customer;
        }
        return null;
    }

    /**
     * @param customer
     */
    @Override
    public void updateCustom(Customer customer) {
        CustomDao customDao = new CustomDaoImpl();
        customDao.updateCustom(customer);
    }
}
