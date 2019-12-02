package typeinfo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;


//Same to proxy pattern
//1. Save real object as Object type
//2. implement invoke is a general method to call real object method
class DynamicProxyHandler implements InvocationHandler {

    //Save real object
    private Object proxied;

    //Constructor injectiong
    public DynamicProxyHandler(Object proxied) {
        this.proxied = proxied;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("**** Invoke *****");
        System.out.println("proxy class: " + proxy.getClass());
        System.out.println("method: " + method);
        System.out.println("args: " + Arrays.toString(args));
        System.out.println("real object class: " + proxied.getClass());
        return method.invoke(this.proxied, args);
    }
}

public class SimpleDynamicProxy {
    public static void consumer(Interface iface) {
        iface.doSomething();
        iface.doSomethingElse("bonobo");
    }

    public static void main(String[] args) {
        System.out.println("***** Consume RealObject *****");
        consumer(new RealObject());
        System.out.println("***** Consume DynamicProxy *****");
        Interface proxy = (Interface)Proxy.newProxyInstance(
                Interface.class.getClassLoader(),
                new Class[]{Interface.class},
                new DynamicProxyHandler(new RealObject()));
        consumer(proxy);
    }
}
