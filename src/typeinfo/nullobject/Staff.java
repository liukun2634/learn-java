package typeinfo.nullobject;

import java.util.ArrayList;

public class Staff extends ArrayList<Position> {
    public void add(String title, Person person) {
        add(new Position(title, person));
    }

    public void add(String... titles) {
        for (String title : titles) {
            add(new Position(title));
        }
    }

    //Constructor accept number of Strings
    public Staff(String... titles) {
        add(titles);
    }

    public boolean positionAvailable(String title) {
        for (Position position : this) {
            if (position.getTitle().equals(title) && position.getPerson() == Person.NULL)
                return true;
        }
        return false;
    }

    public void fillPosition(String title, Person hire) {
        for (Position position : this) {
            if (position.getTitle().equals(title) && position.getPerson() == Person.NULL) {
                position.setPerson(hire);
                return;
            }
        }
        //If position not available, throw exception -> Better than return true of false
        throw new RuntimeException("Postion:" + title + "is not available or wrong");
    }

    public static void main(String[] args) {
        Staff staff = new Staff("President", "CTO", "Marketing Manager","Product Manager", "Project lead",
                "Software Engineer", "Software Engineer", "Software Engineer", "Software Engineer",
                "Test Engineer", "Test Engineer");
        staff.fillPosition("President", new Person("Tommy","Li", "Address 1"));
        staff.fillPosition("Project lead", new Person("Ana","Song", "Address 2"));
        staff.fillPosition("Software Engineer", new Person("Wen","Tang", "Address 3"));
        if(staff.positionAvailable("Software Engineer")){
            staff.fillPosition("Software Engineer", new Person("Na","He", "Address 4"));
        }
        //Null Person can avoid using toString() method for null
        //Other case also need check if it is null
        System.out.println(staff);
    }
}
