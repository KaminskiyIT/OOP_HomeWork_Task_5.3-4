package net.ukr.kaminskiy;

public class ExceedingTheSizeOfTheArrayException extends Exception {

    @Override
    public String getMessage() {
       return "No free places!";
    }
}
