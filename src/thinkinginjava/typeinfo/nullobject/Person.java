package thinkinginjava.typeinfo.nullobject;


interface Null {
}

class Person {
    private final String first;
    private final String last;
    private final String address;

    public Person(String first, String last, String address) {
        this.first = first;
        this.last = last;
        this.address = address;
    }

    public String toString() {
        return "Person: " + first + " " + last + " " + address;
    }

    //Singleton Inner Class NullPerson
    public static class NullPerson extends Person implements Null {
        //Set constructor private
        private NullPerson() {
            super("None", "None", "None");
        }

        public String toString() {
            return "NullPerson";
        }
    }

    //Use Person.NULL to represent null person
    public static final Person NULL = new NullPerson(); //This may case deadlock for multithreading
}


