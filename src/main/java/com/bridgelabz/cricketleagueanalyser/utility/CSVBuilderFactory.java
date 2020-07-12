package com.bridgelabz.cricketleagueanalyser.utility;

public class CSVBuilderFactory {
    public static ICSVBuilder createCSVBuilder() {
        return new OpenCSVBuilder();
    }
}
