package test;

import val.ProjectConst;

import java.util.Objects;

public class Test {
    public static void main(String[] args) {
        String path = Objects.requireNonNull(ProjectConst.class.getClassLoader().getResource("")).getPath();
        System.out.println(path);
    }
}
