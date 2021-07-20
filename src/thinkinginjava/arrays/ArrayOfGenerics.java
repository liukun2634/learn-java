package thinkinginjava.arrays;

import java.util.ArrayList;
import java.util.List;

//It is possible to create thinkinginjava.arrays of generics
public class ArrayOfGenerics {
    @SuppressWarnings("unckecked")
    public static void main(String[] args) {

        //1. Create a array of generics (List<String> is element type), but do not initialize
        List<String>[] ls;

        //2. Create a array of List, but no generic
        List[] la = new List[10];

        //3. Cast la to generic type, and pass reference to ls
        ls = (List<String>[]) la; // Compiler warning

        //4. Initialize ls
        ls[0] = new ArrayList<String>();

        //Compile error: because ls is Array of List<String>, type incompatible
//        ls[0] = new ArrayList<Integer>();


        /*** Arrays are covariance ***/
        //List<String> is a subtype of Object
        //List<String>[] is a subtype of Object[]
        Object[] objects = ls;


        /*** Array vs Generic List ***/

        //Because ArrayList<Integer> is subtype of Object
        objects[1] = new ArrayList<Integer>();
        //Can put different type in List, object[1] is List<Integer>
        //If fool compiler then can fool run-time
        ((ArrayList<Integer>)objects[1]).add(1);
        ((ArrayList<ArrayOfGenerics>)objects[1]).add(new ArrayOfGenerics());//heap polution
        System.out.println(objects[1]);


        //Array can fool compiler but cannot fool run-time type system
        Integer[] myInts = {1,2,3,4};
        Number[] myNumber = myInts;
        //ArrayStoreException
        myNumber[0] = 3.14; //attempt of heap pollution

        //If Generic List can fool compiler, then it can fool run-time type system
        Object myInts2 = new ArrayList<Integer>();
        //Compiler can
        (((ArrayList<Integer>)myInts2)).add(1);
        (((ArrayList<Double>)myInts2)).add(3.14); //heap polution
        System.out.println(myInts2);

        List<Integer> myInts3 = new ArrayList<Integer>();
        //Compiler will prevent this cast
        //((ArrayList<Double>)myInts2))myInts3
    }
}
