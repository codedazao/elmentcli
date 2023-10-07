package view;

/**
 * view层的顶级接口，所有的接口都是其子类
 */
public interface View {
    /**
     * 显示用户注册或者登录的选项
     */
    void userUI();
    /**
     * 用户登录界面
     */
    void loginUI();

    /**
     * 用户注册界面
     */
    void registerUI();

    /**
     * 用户登出界面
     */
    void logoutUI();

    /**
     * 用户更新界面
     */
    void updateUI();

    /**
     * 用户主界面
     */
    void mainUI();
}
