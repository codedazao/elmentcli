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
        } finally {
        }
        return null;
    }
}
