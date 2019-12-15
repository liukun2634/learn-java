package typeinfo.pets;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//Using class literals
public class LiteralPetCreator extends PetCreator{
    public static final List<Class<? extends Pet>> allTypes =
            Collections.unmodifiableList(Arrays.asList(Pet.class, Dog.class, Cat.class, Rodent.class,
                    Mutt.class, Pug.class, EgyptianMau.class, Manx.class,
                    Cymric.class, Rat.class, Mouse.class, Hamster.class));

    public static final List<Class<? extends Pet>> types = allTypes;

    @Override
    public List<Class<? extends Pet>> types() {
        return types;
    }

    public static void main(String[] args) {
        System.out.println(types);
    }
}
