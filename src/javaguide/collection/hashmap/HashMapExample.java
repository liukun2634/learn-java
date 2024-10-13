package javaguide.collection.hashmap;

import java.lang.String;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

public class HashMapExample {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> map2 = new ConcurrentHashMap<>();
        Scanner scanner = new Scanner(System.in);

        int n;
        n = scanner.nextInt();
        int[] array = new int[5];
        for(int i = 0; i < n; i++){
            array[i] = scanner.nextInt();
        }

        for(int i = 0; i < n; i++){
            System.out.println(array[i]);
        }


    }


}
