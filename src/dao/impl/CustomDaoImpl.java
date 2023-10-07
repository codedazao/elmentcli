package dao.impl;

import dao.CustomDao;
import pojo.Customer;
import val.ProjectConst;

import java.io.*;
import java.util.logging.Logger;

public class CustomDaoImpl implements CustomDao {

    void setCustom(){}

    /**
     * @param customer 传入dao层的cutomer对象
     */
    @Override
    public Customer getCustomer(Customer customer) {
        Logger logger = Logger.getLogger("getCustomer");
        File file = new File(ProjectConst.path +"\\"+customer.getUsername());
        if (!file.exists()){
            logger.warning("用户尚未注册");
            return null;
        }else{
            try {
                ObjectInputStream oos =  new ObjectInputStream(new FileInputStream(file));
                Customer customerRead= (Customer) oos.readObject();
                oos.close();
                return customerRead;
            } catch (IOException e) {
                logger.warning("出错了,读取用户信息出错");
                return null;
            } catch (ClassNotFoundException e) {
                logger.warning("无法加载类" + e.getMessage());
                return null;
            }
        }
    }

    /**
     * @param customer
     */
    @Override
    public Boolean setCustomer(Customer customer) {
        Logger logger = Logger.getLogger("setCustomer");
        try {
            File file = new File(ProjectConst.path +"\\"+customer.getUsername());
            if (!file.exists()){
                file.createNewFile();
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
                objectOutputStream.writeObject(customer);
                fileOutputStream.flush();
                objectOutputStream.flush();
                fileOutputStream.close();
                objectOutputStream.close();
            }else {
                return Boolean.FALSE;
            }
        } catch (Exception e) {
            logger.warning("用户写入出错,错误原因:"+e.getMessage());
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    /**
     * @param customer
     */
    @Override
    public void updateCustom(Customer customer) {
        try {
            File file = new File(ProjectConst.path+"\\"+customer);
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(customer);
            System.out.println("更新用户成功");
        } catch (IOException e) {
            System.out.println("更新用户失败");
        }
    }


}
