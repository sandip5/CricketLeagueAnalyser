package com.bridgelabz.cricketleagueanalyser.models;

import com.opencsv.bean.CsvBindByName;

public class MostRunsCSV {
    @CsvBindByName(column = "PLAYER", required = true)
    public String player;

    @CsvBindByName(column = "Mat", required = true)
    public int match;

    @CsvBindByName(column = "Inns", required = true)
    public int innings;

    @CsvBindByName(column = "Runs", required = true)
    public int run;

    @CsvBindByName(column = "HS", required = true)
    public String highScore;

    @CsvBindByName(column = "Avg")
    public double avg;

    @CsvBindByName(column = "SR")
    public String strikeRate;

    @CsvBindByName(column = "100", required = true)
    public int hundred;

    @CsvBindByName(column = "50", required = true)
    public int fifty;

    @CsvBindByName(column = "4s", required = true)
    public int fours;

    @CsvBindByName(column = "6s", required = true)
    public int six;

    @Override
    public String toString() {
        return "MostRunsCSV{" +
                ", PLAYER='" + player + '\'' +
                ", Mat='" + match + '\'' +
                ", Inns='" + innings + '\'' +
                ", Runs='" + run + '\'' +
                ", HS='" + highScore + '\'' +
                ", Avg='" + avg + '\'' +
                ", SR='" + strikeRate + '\'' +
                ", 100='" + hundred + '\'' +
                ", 50='" + fifty + '\'' +
                ", 4s='" + fours + '\'' +
                ", 6s='" + six + '\'' +
                '}';
    }
}
