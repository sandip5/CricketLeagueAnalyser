package com.bridgelabz.cricketleagueanalyser.models;

import com.opencsv.bean.CsvBindByName;

public class MostWicketsCSV {
        @CsvBindByName(column = "PLAYER", required = true)
        public String player;

        @CsvBindByName(column = "Mat", required = true)
        public int match;

        @CsvBindByName(column = "Inns", required = true)
        public int innings;

        @CsvBindByName(column = "Ov", required = true)
        public double over;

        @CsvBindByName(column = "Runs", required = true)
        public int runs;

        @CsvBindByName(column = "Wkts", required = true)
        public int wkts;

        @CsvBindByName(column = "Avg", required = true)
        public double average;

        @CsvBindByName(column = "SR", required = true)
        public double strikeRate;

        @CsvBindByName(column = "4w", required = true)
        public int fourWkts;

        @CsvBindByName(column = "5w", required = true)
        public int fiveWkts;

        @CsvBindByName(column = "Econ", required = true)
        public double economy;

    @Override
    public String toString() {
        return "MostWicketsCSV{" +
                ", PLAYER='" + player + '\'' +
                ", Mat='" + match + '\'' +
                ", Inns='" + innings + '\'' +
                ", OV='" + over + '\'' +
                ", Runs='" + runs + '\'' +
                ", Wkts='" + wkts + '\'' +
                ", Avg='" + average + '\'' +
                ", SR='" + strikeRate + '\'' +
                ", 4w='" + fourWkts + '\'' +
                ", 5w='" + fiveWkts + '\'' +
                ", Econ='" + economy + '\'' +
                '}';
    }
}
