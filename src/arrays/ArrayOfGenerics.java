package arrays;

import java.util.ArrayList;
import java.util.List;

//It is possible to create arrays of generics
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

        //Because ArrayList<Integer> is subtype of Object
        objects[1] = new ArrayList<Integer>();



    }
}
