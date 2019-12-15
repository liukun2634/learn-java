package typeinfo.pets;

//Creates random sequences of Pets

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public abstract class PetCreator {
    private Random rand = new Random(47);

    //The list of the different types of Pet to create | attention: list of types
    public abstract List<Class<? extends Pet>> types();

    //Create a random Pet
    public Pet randomPet() {
        int n = rand.nextInt(types().size());
        try {
            return types().get(n).newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    //Create array of random Pets
    public Pet[] createArray(int size) {
        Pet[] result = new Pet[size];
        for(int i = 0; i < size; i++) {
            result[i] = randomPet();
        }
        return result;
    }

    //Transform array to arrayList
    public ArrayList<Pet> arrayList(int size) {
        ArrayList<Pet> result = new ArrayList<>();
        Collections.addAll(result, createArray(size));
        return result;
    }

}
