package pojo;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

public class Customer implements Serializable {
    @Serial
    private static final long serialVersionUID = -2137604392515080948L;
    private String userId;
    private String username;
    private String password;
    private String realName;
    private float customerBalance;
    private List<Shop> shopCar;
    public Customer(String userId, String username, String password, String realName, float customerBalance) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.realName = realName;
        this.customerBalance = customerBalance;
    }

    public Customer setShopCar(List<Shop> shops){
        this.shopCar = shops;
        return this;
    }
    public List<Shop> getShopCar(){
        return this.shopCar;
    }
    public Customer(String userId, String username, String password, String realName) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.realName = realName;
    }

    public String getRealName() {
        return realName;
    }

    public Customer setRealName(String realName) {
        this.realName = realName;
        return this;
    }

    public float getCustomerBalance() {
        return customerBalance;
    }

    public void setCustomerBalance(float customerBalance) {
        this.customerBalance = customerBalance;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "userId='" + userId + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", realName='" + realName + '\'' +
                ", customerBalance=" + customerBalance +
                '}';
    }

    public Customer(){}
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public Customer setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public Customer setPassword(String password) {
        this.password = password;
        return this;
    }

    public Customer(String userId, String username, String password) {
        this.userId = userId;
        this.username = username;
        this.password = password;
    }
}
