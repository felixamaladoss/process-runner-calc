package uk.ac.assessment.process;

public class InvalidInputException extends Exception {

    private static final long serialVersionUID = 434334443L;

    public InvalidInputException(String message){
        super(message);
    }
}
