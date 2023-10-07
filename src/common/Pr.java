package common;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;

/**
 * 负载打印的工具类
 */
public class Pr {

    public static void prmenu(String menu) {
        System.out.println(menu);
    }

    public static void item(String... items) {
        for(String item: items){
            System.out.println(">>>"+item);
        }
    }

    public static void printBanner() {
        String path = Objects.requireNonNull(Pr.
                class.
                getClassLoader().
                getResource("")).
                getPath();
        try {
            FileInputStream bannerInputStream=
                    new FileInputStream(path+"/banner.txt");
            byte[] bytes = bannerInputStream.readAllBytes();
            System.out.println(new String(bytes));
            try {
                Pr.printNoLine("载入中");
                for (int i = 0; i < 4; i++) {
                    if (i==3){
                        System.out.println(".");
                        continue;
                    }
                    Thread.sleep(333);
                    System.out.printf(".");
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void printLine(String s){
        System.out.println(s);
    }
    public static void printNoLine(String s){
        System.out.printf(s);
    }
}
