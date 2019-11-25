package typeinfo;

//Examination of the wat the class loader works
class Candy {
    //Static block only run once when loading this class
    static {
        System.out.println("Loading Candy");
    }
}

class Gum {
    static {
        System.out.println("Loading Gum");
    }
}

class Cookie {
    static {
        System.out.println("Loading Cookie");
    }
}

public class SweetShop {
    public static void main(String[] args) {
        System.out.println("inside main");
        new Candy();
        System.out.println("after create Candy");
        try {
            //Must add prepend package name
            Class.forName("typeinfo.Gum");
        } catch (ClassNotFoundException e) {
            System.out.println("Could not find Gum");
        }
        System.out.println("after class.forName(Gum)");
        new Cookie();
        System.out.println("after create Cookie");

    }
}
