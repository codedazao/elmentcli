package service;

import pojo.Shop;

import java.util.List;

public interface ShopService {
    List<Shop> getShops();

    void groundingShops(List<Shop> shops);
}
