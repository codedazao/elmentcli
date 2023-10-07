package service.impl;

import common.Pr;
import pojo.Customer;
import service.EnterpriseService;
import val.ProjectConst;

import java.io.*;

public class EnterpriseServiceImpl implements EnterpriseService {
    @Override
    public void registerEnterpriseAccount(Customer sessionCustomer) {
        File enterPriseInfo = new File(ProjectConst.path+"\\"+sessionCustomer.getUsername());
        try (ObjectOutputStream objcetOutputStream = new ObjectOutputStream(new FileOutputStream(enterPriseInfo));){
            objcetOutputStream.writeObject(sessionCustomer);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public Customer loginEnterPrise(String username, String password) {
        File enterPriseInfo = new File(ProjectConst.path+"\\"+username);
        if (!enterPriseInfo.exists()){
            Pr.printLine("您的账户尚未注册企业");
            return null;
        }else {
            try {
                ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(enterPriseInfo));
                return (Customer) objectInputStream.readObject();
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
