package thinkinginjava.typeinfo;

import java.lang.String;

public class GenericToyTest {
    public static void main(String[] args) throws Exception {
        //Exact Class type for generic
        Class<FancyToy> ftClass = FancyToy.class;
        //Produces exact type
        FancyToy fancyToy = ftClass.newInstance();

        //? super Class for generic
        Class<? super FancyToy> up = ftClass.getSuperclass();
        //This won't compile because return is not exactly type
//        Class<Toy> up2 = ftClass.getSuperclass() ;
        //Ony produce Object, cannot return exact type because Class is not exact
        Object obj= up.newInstance();
        //Pass reference directly create by .class
        Class<? super FancyToy> up3 = Toy.class;


        //? extends Class for generic
        Class<? extends Toy> down = FancyToy.class;
        down = Toy.class;

    }
}
