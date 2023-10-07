package common;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 处理用户输入的工具类
 */
public class In {
    static Logger logger = Logger.getLogger("scanner");
    private static Scanner scanner;
    static {
        scanner = new Scanner(System.in);
    }
    public static int getInt() {
        String inputString = scanner.nextLine();
        try {
            return Integer.parseInt(inputString);
        }catch (Exception e){
            logger.log(Level.WARNING,"出错了，错误原因"+e.getMessage());
            return -1;
        }
    }

    public static String getString() {
        return scanner.nextLine();
    }
}
