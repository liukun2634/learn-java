package thinkinginjava.typeinfo;

import thinkinginjava.typeinfo.interfacea.A;
import thinkinginjava.typeinfo.packageaccess.HiddenC;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class HiddenImplementation {
    public static void main(String[] args) throws Exception{
        A a = HiddenC.makeA();
        a.f();
        System.out.println(a.getClass().getName());
        //Cannot find class C because class C is package access
        //(C) a.f();

        //Opps! Reflection still allows us to call the method in Class C
        callHiddenMethod(a, "g");
        callHiddenMethod(a, "u");
        callHiddenMethod(a, "v");
        callHiddenMethod(a, "w");
    }

    private static void callHiddenMethod(Object a, String methodName) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method m = a.getClass().getDeclaredMethod(methodName);
        //Hark the access, key for get access
        m.setAccessible(true);
        m.invoke(a);
    }
}
