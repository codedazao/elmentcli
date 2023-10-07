package view;

import common.In;
import common.Pr;
import pojo.Customer;
import pojo.Shop;
import service.CustomService;
import service.ShopService;
import service.impl.CustomServiceImpl;
import service.impl.ShopServiceImpl;

import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

public class CustomerViewImpl implements CustomerView {
    private Customer sessionCustomer;

    public CustomerViewImpl() {
        Pr.printBanner();
    }
    @Override
    public void userUI() {

        //显示内容 注册，登录，修改
        Pr.prmenu(">>>>>>>>>>用户界面<<<<<<<<<<<<<<");
        Pr.item("1:登录","2:注册","3:修改","4:退出");
        int n= -1;
        //这段纠错可以移动到getInt()中
        while (n==-1){
            n = In.getInt();
            if (n!=-1){break;}
            Pr.printLine("输入不合法，请重新输入");
        }
        switch (n) {
            case 1 -> loginUI();
            case 2 -> registerUI();
            case 3 -> updateUI();
            case 4 -> logoutUI();
            default -> Pr.printLine("所选功能正在开发");
        }
        Pr.printLine("输入y进行下一步操作，输入n退出本系统");
        String inputYesOrNo = In.getString();
        if(inputYesOrNo.equals("y")){
            userUI();
        }else if(inputYesOrNo.equals("n")){
            return;
        }

    }
    @Override
    public void loginUI() {
        Logger logger = Logger.getLogger("loginUI");
        //验证用户输入的用户账号和密码
        Pr.printLine("请输入您在本系统的账号");
        String username = In.getString();
        Pr.printLine("请输入您在本系统的密码");
        String password = In.getString();
        //封装实体类
        Customer customer = new Customer(UUID.randomUUID().toString(), username, password);
        CustomService customService = new CustomServiceImpl();
        customer = customService.login(customer);
        if (customer != null){
            this.sessionCustomer = customer;
            Pr.printLine("登录成功");
            this.mainUI();
        }else {
            Pr.printLine("登录失败，驶入y返回用户界面,输入n返回登录界面,否则退出程序");
            if (In.getString().equals("y")) {
                this.userUI();
            }if(In.getString().equals("n")){
                this.loginUI();
            }else {
                this.mainUI();
            }
        }

    }
    @Override
    public void registerUI() {
        CustomService customService = new CustomServiceImpl();
        System.out.println("请输入您要注册的用户账号");
        String username = In.getString();
        String password = In.getString();
        Customer customer = new Customer().setUsername(username).setPassword(password);
        Customer returncus = customService.registerUser(customer);
        if (returncus!=null){
            System.out.printf("注册成功，您注册的用户账号为:%s 密码为:%s\n",username,password);
        }else {
            System.out.printf("注册失败,请联系管理员");
        }
    }
    @Override
    public void logoutUI() {

    }
    @Override
    public void updateUI() {
        if(sessionCustomer!=null){
            Customer customer =sessionCustomer;
            Pr.printLine("请输入旧的密码");
            if (In.getString().equals(customer.getPassword())){
                Pr.item("请输入新的密码");
                String newPassword = In.getString();
                Pr.item("请输入姓名");
                String customerRealName = In.getString();
                Pr.item("请输入电话");
                String tel = In.getString();
                customer = new Customer(customer.getUserId(),
                        null,
                        newPassword,customerRealName);
                CustomService customService = new CustomServiceImpl();
                customService.updateCustom(customer);
                
            }
        }
    }
    @Override
    public void mainUI() {
        Pr.item("1.查看用户信息","2.查看购物车","3.查看企业信息","4.购物");
        int chance = In.getInt();
        if (chance == 1){
            System.out.println(sessionCustomer);
        }else if(chance == 2){
            List<Shop> shopCar = sessionCustomer.getShopCar();
            Pr.printLine("您的购物车中有");
            shopCar.forEach(System.out::println);
        } else if (chance==3) {
            Pr.printLine("暂未开发");
        } else if (chance==4) {
            Pr.printLine("目前上架的商品有");
            ShopService shopService = new ShopServiceImpl();
            shopService.getShops().forEach(System.out::println);
        }else {
            Pr.printLine("您的输入无效,按y返回主界面,按n退出程序");
            String userInput = In.getString();
            if (userInput.equals("y")){
                this.mainUI();
            }else if (userInput.equals("n")){
                return;
            }
        }
    }
}
