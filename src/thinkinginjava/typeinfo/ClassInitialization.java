package thinkinginjava.typeinfo;

import java.util.Random;

class Initable {
    static final int staticFinal = 47;
    static final int staticFinal2 = ClassInitialization.rand.nextInt(1000);
    static {
        System.out.println("Initalizing Initable");
    }
}

class Initable2 {
    static int staticNonFinal = 47;
    static {
        System.out.println("Initalizing Initable2");
    }
}

class Initable3 {
    static final int staticNonFinal = 47;
    static {
        System.out.println("Initalizing Initable 3");
    }
}


public class ClassInitialization {
    public static Random rand = new Random(47);

    public static void main(String[] args) {
        //Use .class to get Class reference
        //Different from Class.forName(), .class has no side-effect that initiate the class
        Class initable = Initable.class;
        System.out.println("After creating Initable ref");

        //Does not trigger thinkinginjava.initialization
        System.out.println(Initable.staticFinal);

        //Does trigger thinkinginjava.initialization, because staticFinal2 is not a constant in compile time
        System.out.println(Initable.staticFinal2);

        //Does trigger thinkinginjava.initialization, because staticNonFinal is not a constant
        System.out.println(Initable2.staticNonFinal);

        //Class.forName need try-catch block and have side effect
        try {
            Class initable3 = Class.forName("thinkinginjava.typeinfo.Initable3");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("After creating Initable3 ref");


    }


}
