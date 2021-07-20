package thinkinginjava.typeinfo.nullobject;

public class Position {
    private String title;
    private Person person;
    public Position(String jobTitle, Person employee) {
        this.title = jobTitle;
        this.person = employee;
        //Set person to be null Person object when employee is null
        if(this.person == null) {
            person = Person.NULL;
        }
    }
    public Position(String jobTitle) {
        this.title = jobTitle;
        this.person = Person.NULL;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
        if(person == null) {
            person = Person.NULL;
        }
    }

    @Override
    public String toString() {
        return "Position: " + this.title + " " + this.person;
    }
}
