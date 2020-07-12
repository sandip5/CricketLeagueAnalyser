package com.bridgelabz.cricketleagueanalyser.exception;

public class CricketLeagueException extends Throwable {
    public enum ExceptionType {
        CENSUS_FILE_PROBLEM,
        DELIMITER_AND_HEADER_PROBLEM
    }

    public ExceptionType type;

    public CricketLeagueException(String message, ExceptionType type) {
        super(message);
        this.type = type;
    }
}
