package typeinfo;

interface Interface {
    void doSomething();
    void doSomethingElse(String args);
}

class RealObject implements Interface {

    @Override
    public void doSomething() {
        System.out.println("do something");
    }

    @Override
    public void doSomethingElse(String args) {
        System.out.println("do something else " + args);
    }
}


//Proxy pattern:
// 1. implement Interface
// 2. contains a private Interface object
// 3. a constructor with Interface param
class SimpleProxy implements Interface {

    private Interface proxied;

    public SimpleProxy(Interface proxied) {
        this.proxied = proxied;
    }

    @Override
    public void doSomething() {
        System.out.println("Simple proxy do something");
        proxied.doSomething();
    }

    @Override
    public void doSomethingElse(String args) {
        System.out.println("Simple proxy do something else " + args);
        proxied.doSomethingElse(args);
    }
}

public class SimpleProxyDemo {
    public static void consumer(Interface iface) {
        iface.doSomething();
        iface.doSomethingElse("bonobo");
    }

    public static void main(String[] args) {
        System.out.println("***** Consume RealObject *****");
        consumer(new RealObject());
        System.out.println("***** Consume SimpleProxy *****");
        consumer(new SimpleProxy(new RealObject()));
    }
}
