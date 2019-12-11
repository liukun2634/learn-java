package arrays;

class ClassParameter<T> {
    public T[] f(T[] arg) {
        return arg;
    }
}

class MethodParameter {
    public  static <T> T[] f(T[] arg) {
        return arg;
    }
}

public class ParameterizedArrayType {
    public static void main(String[] args) {
        // Illegal for generic array because of type erase
//        Collection<String>[] lists = new Collection<String>[10];


        Integer[] ints = {1,2,3,4};
        Double[] doubles = {1.1,2.2,3.3};

        // Use array type as parameter to create
        Integer[] ints1 = new ClassParameter<Integer>().f(ints);
        Double[] doubles1 = new ClassParameter<Double>().f(doubles);


        Integer[] ints2 = MethodParameter.f(ints);
        Double[] doubles2= MethodParameter.f(doubles);

    }
}
