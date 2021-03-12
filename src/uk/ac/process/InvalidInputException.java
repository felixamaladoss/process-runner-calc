package uk.ac.process;

public class InvalidInputException extends Exception {

    private static final long serialVersionUID = 434334443L;

    private static final String MESSAGE = "Given input is invalid! Please enter list of array Integers like : [[2,3],[1,4]";

    public InvalidInputException(){
        super(MESSAGE);
    }
}
