package algorithm;

import java.lang.String;

public class ThrowTwoEggs {

    //Two eggs,
    //To find from which floor cloud break the egg
    public static void main(String[] args) {
        int floorNumber = 100;
        int[] throwTimes = new int[floorNumber + 1] ;
        throwTimes[0] = 0;
        throwTimes[1] = 1;
        throwTimes[2] = 1;
        for(int i = 3; i <= floorNumber; i++) {
            throwTimes[i] = floorNumber;
        }

        for(int i = 3; i <= floorNumber; i++) {
            for (int k = 1; k  <= i; k++){
                throwTimes[i] = Math.min(throwTimes[i], Math.max(k-1, throwTimes[i-k]) + 1);
            }
        }

        for(int i = 0; i < floorNumber; i++) {
           System.out.println(throwTimes[i]);
        }
    }
}
