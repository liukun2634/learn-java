package javaguide.basic;

import java.lang.String;

import java.util.Scanner;

public class InputTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(s);
        String s2 = scanner.next();
        System.out.println(s2);
    }
}
