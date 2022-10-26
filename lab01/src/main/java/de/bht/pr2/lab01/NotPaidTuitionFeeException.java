package de.bht.pr2.lab01;

public class NotPaidTuitionFeeException extends Exception{
    
    NotPaidTuitionFeeException(String nachricht) {
        super(nachricht);
    }
}
