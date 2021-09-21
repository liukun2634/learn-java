package thinkinginjava.initialization;

import java.lang.String;

class Book {
    private boolean checkedOut = false;

    Book(boolean checkOut) {
        checkedOut = checkOut;
    }

    void checkIn() {
        checkedOut = false;
    }


    //Use finalize() to detect an object that hasn't been properly cleaned up
    @Override
    protected void finalize() {
        if(checkedOut)
            System.out.println("Error: book has not been checkout");
        //Normally, you'll also do the super finalize
        //super.finalize();
    }
}

public class TerminationCondition {
    public static void main(String[] args) {
        Book novel = new Book(true);
        //Proper clean up
        novel.checkIn();

        //Drop the reference, forget to clean up
        new Book(true);
        //Force garbage collection & finalization -> this is only a signal, the gc may also not run at this time
        //So the output may be empty or "Error: book has not been checkout"
        System.gc();
    }


}
