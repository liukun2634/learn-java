package thinkinginjava.typeinfo.interfacea;


class B implements A {

    @Override
    public void f() {
    }

    public void g() {
    }
}

public class InterfaceViolation {
    public static void main(String[] args) {
        A a = new B();
        a.f();
        // a.g(); // Compiler error
        System.out.println(a.getClass().getName());
        //downcast to B, interface A cannot protect the legal exposed method now
        B b = (B) a;
        b.g();
    }

}
