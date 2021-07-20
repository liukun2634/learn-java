package thinkinginjava.typeinfo;


interface HasBatteries {
}

interface Waterproof {
}

interface Shoots {
}

class Toy{
    //Comment out the following default constructor
    // to see NoSuchMethodError from (*1*)
    Toy() {}
    Toy(int i) {}
}

class FancyToy extends Toy implements HasBatteries, Waterproof, Shoots{
    FancyToy() {super(1);}
}


public class ToyTest {
    private static void printInfo(Class cc) {
        System.out.println("Class name: " + cc.getName() + " is interface? [" + cc.isInterface() +"]" );
        System.out.println("Simple name: " + cc.getSimpleName()); //Name without package
        System.out.println("Canonical name: " + cc.getCanonicalName()); //Name contains package
    }

    public static void main(String[] args) {


        //FancyToy.class
        Class c = null;
        try {
            c = Class.forName("thinkinginjava.typeinfo.FancyToy");
        } catch (ClassNotFoundException e) {
            System.out.println("Can't find FancyToy");
            System.exit(1);
        }
        printInfo(c);

        //Interfaces.class
        for(Class face : c.getInterfaces()){
            printInfo(face);
        }

        //Toy.class
        Class up = c.getSuperclass();
        printInfo(up);


        Object obj = null;
        try {
            //Requires default constructor
            obj = up.newInstance();
        } catch (InstantiationException e) {
            System.out.println("Can't instantiate");
            System.exit(1);
        } catch (IllegalAccessException e) {
            System.out.println("Can't access");
            System.exit(1);
        }
        printInfo(obj.getClass()); //Object has getClass() method to get the reference to class

    }

}
