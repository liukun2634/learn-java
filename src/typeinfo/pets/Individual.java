package typeinfo.pets;

public abstract class Individual {
    String name;
    public Individual(String name) {
        this.name = name;
    }

    public Individual() {
    }

    @Override
    public String toString() {
        return this.name;
    }
}
