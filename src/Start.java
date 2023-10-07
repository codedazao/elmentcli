import common.Pr;
import view.CustomerView;
import view.CustomerViewImpl;

public class Start {
    public static void main(String[] args) {
        //调用userui
        CustomerView customerView = new CustomerViewImpl();
        customerView.userUI();
    }
}
