package thinkinginjava.arrays;


import java.lang.String;

import java.util.Arrays;

class BerylliumSphere {
    private static long counter;
    private final long id = counter++;

    public String toString() {
        return "Sphere" + id;
    }
}

//Initialization and re-assignment of thinkinginjava.arrays
public class ArrayOptions {
    public static void main(String[] args) {
        /*** Array of objects ***/

        //Type1: local uninitialized variable
        BerylliumSphere[] a;
        //Compiler would throw error when using uninitialized variable
        //System.out.println(a);

        //Type2: automatically initialized to null
        BerylliumSphere[] b = new BerylliumSphere[5];
        System.out.println("b: " + Arrays.toString(b)); //Arrays.toString() to output the whole array
        System.out.println(b);        //b is a reference, inherit from Object


        //Type3: Aggregate thinkinginjava.initialization
        BerylliumSphere[] d = {new BerylliumSphere(), new BerylliumSphere(), new BerylliumSphere()};
        System.out.println("d: " + Arrays.toString(d));

        //Type4: Dynamic aggregate initilization
        a = new BerylliumSphere[]{new BerylliumSphere(), new BerylliumSphere()};
        System.out.println("a: " + Arrays.toString(a));


        /*** Array of primitives ***/

        //Type1: local uninitialized variable
        int[] e;
//        System.out.println(e); //Also cannot be used

        //Type2: automatically initialized to ,
        int[] f = new int[5];
        //0 for numeric
        System.out.println("f: " + Arrays.toString(f));
        //rectangular for char
        char[] fchar = new char[5];
        System.out.println("fchar: " + Arrays.toString(fchar));
        //false for boolean
        boolean[] fboolean = new boolean[5];
        System.out.println("fboolean: " + Arrays.toString(fboolean));

        //Type3: Aggregate thinkinginjava.initialization
        int[] h = {1, 2, 3};
        System.out.println("h: " + Arrays.toString(h));

        //Type4: Dynamic aggregate thinkinginjava.initialization
        e = new int[]{4, 5};
        System.out.println("e: " + Arrays.toString(e));


    }
}
