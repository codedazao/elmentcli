package pojo;

public class Shop {
    private String shopId;
    private String shopName;

    @Override
    public String toString() {
        return "Shop{" +
                "shopId='" + shopId + '\'' +
                ", shopName='" + shopName + '\'' +
                '}';
    }

    public String getShopId() {
        return shopId;
    }

    public Shop setShopId(String shopId) {
        this.shopId = shopId;
        return this;
    }

    public String getShopName() {
        return shopName;
    }

    public Shop setShopName(String shopName) {
        this.shopName = shopName;
        return this;
    }
}
