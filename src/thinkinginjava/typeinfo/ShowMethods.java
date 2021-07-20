package thinkinginjava.typeinfo;
//Using reflection to show all methods of a class
//even if the method are defined in the base class

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.regex.Pattern;

public class ShowMethods {
    //test 18: Comment out below code will not print default constructor
    //private ShowMethods(){};

    private static String usage =
            "usage:\n" +
                    "ShowMethods packageName.className(args1)\n" +
                    "To show all methods in class or :\n" +
                    "ShowMethods packageName.className(args1) word(args2)\n" +
                    "To search for methods involving 'word'";
    //Remove package name for method name
    private static Pattern p = Pattern.compile("\\w+\\.");

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println(usage);
            System.exit(0);
        }
        int lines = 0;
        try {
            String classPath = args[0];
            Class<?> c = Class.forName(classPath);
            Method[] methods = c.getMethods();
            Constructor[] constructors = c.getConstructors();
            if (args.length == 1) {
                System.out.println("***** All methods in Class " + classPath);
                for (Method method : methods) {
//                    System.out.println(method.toString()); //Show original signature, like public static void thinkinginjava.typeinfo.ShowMethods.main(java.lang.String[])
                    System.out.println(p.matcher(method.toString()).replaceAll(""));
                }
                System.out.println("***** Constructor in Class" + classPath);
                for (Constructor constructor : constructors) {
//                    System.out.println(constructor.toString()); //public thinkinginjava.typeinfo.ShowMethods()
                    System.out.println(p.matcher(constructor.toString()).replaceAll(""));
                }
                lines = methods.length + constructors.length;
            } else {
                for (Method method : methods) {
                    if (method.toString().contains(args[1])) {
                        System.out.println(p.matcher(method.toString()).replaceAll(""));
                        lines++;
                    }
                }
                for (Constructor constructor : constructors) {
                    if (constructor.toString().contains(args[1])) {
                        System.out.println(p.matcher(constructor.toString()).replaceAll(""));
                        lines++;
                    }

                }
                lines = methods.length + constructors.length;
            }
        } catch (ClassNotFoundException e)

        {
            e.printStackTrace();
        }

        System.out.println("lines results" + lines);
    }
}
