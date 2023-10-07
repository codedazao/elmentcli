package service.impl;

import pojo.Shop;
import service.ShopService;
import val.ProjectConst;

import java.io.*;
import java.util.List;

public class ShopServiceImpl implements ShopService {
    private static final File file = new File(ProjectConst.path+"\\"+"Shops");
    /**
     * @return
     */
    @Override
    public List<Shop> getShops() {
        try {
            if (!file.exists()){
                file.createNewFile();
            }else {
                try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file))) {
                    List<Shop> shops = (List<Shop>)objectInputStream.readObject();
                    return shops;
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public void groundingShops(List<Shop> shops) {
        boolean exists = file.exists();
        if (!exists){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file))){
            List<Shop> readShops = (List<Shop>)objectInputStream.readObject();
            ObjectOutputStream objectOutputStream=new ObjectOutputStream(new FileOutputStream(file));
            objectOutputStream.writeObject(readShops.addAll(shops));
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
