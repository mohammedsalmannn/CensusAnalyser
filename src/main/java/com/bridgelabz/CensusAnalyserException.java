package com.bridgelabz;


public class CensusAnalyserException extends Exception {

    enum ExceptionType {
        FILE_PROBLEM, CSV_FILE_INVALID, NOT_A_CSV_TYPE;
    }

    ExceptionType type;

    public CensusAnalyserException(String message, ExceptionType type) {
        super(message);
        this.type = type;
    }

}