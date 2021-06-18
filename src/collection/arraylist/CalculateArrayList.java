package collection.arraylist;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class CalculateArrayList {
    private static int MAX_PUSH_TIMES = 20;

    public static void main(String[] args) throws Exception {
        List<Integer> list = new ArrayList<>();
        printArray(0, list);
        for (int i = 0; i < MAX_PUSH_TIMES; i++) {
            list.add(1);
            printArray(i + 1, list);
        }
    }

    //Use Reflection to get Capacity
    private static int getCapacity(List<Integer> array) throws Exception {
        Field field = ArrayList.class.getDeclaredField("elementData");
        field.setAccessible(true);
        return ((Object[]) field.get(array)).length;
    }

    private static void printArray(int pushTimes, List<Integer> list) throws Exception {
        System.out.println("push times: " + pushTimes + " size: " + list.size() + " capacity: " + getCapacity(list));
    }
}
