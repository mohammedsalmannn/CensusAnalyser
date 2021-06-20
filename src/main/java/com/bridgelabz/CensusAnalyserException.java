package com.bridgelabz;


public class CensusAnalyserException extends Exception {

    enum ExceptionType {
        FILE_PROBLEM, CSV_FILE_INVALID, NOT_A_CSV_TYPE, NOT_A_CSV_TYPE_OR_HEADERS_INVALID, NO_SUCH_FILE;
    }

    ExceptionType type;

    public CensusAnalyserException(String message, ExceptionType type) {
        super(message);
        this.type = type;
    }

}