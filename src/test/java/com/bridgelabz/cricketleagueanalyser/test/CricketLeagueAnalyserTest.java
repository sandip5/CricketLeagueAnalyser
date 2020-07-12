package com.bridgelabz.cricketleagueanalyser.test;

import com.bridgelabz.cricketleagueanalyser.exception.CricketLeagueException;
import com.bridgelabz.cricketleagueanalyser.models.MostRunsCSV;
import com.bridgelabz.cricketleagueanalyser.service.CricketLeagueAnalyser;
import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class CricketLeagueAnalyserTest {
    String FACT_SHEET_MOST_RUNS_CSV_FILE_PATH =
            "./src/test/resources/Day16 Data_01 IPL2019FactsheetMostRuns.csv";

    @Test
    public void givenIPLCSVFile_ReturnsCorrectRecords() {
        try {
            CricketLeagueAnalyser cricketLeagueAnalyser = new CricketLeagueAnalyser();
            List numOfRecords = cricketLeagueAnalyser.loadFactsSheetCSV(FACT_SHEET_MOST_RUNS_CSV_FILE_PATH);
            Assert.assertEquals(101, numOfRecords.size());
        } catch (CricketLeagueException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenIPLCSV_WhenSortedOnBattingAverage_ShouldReturnTopCricketerBattingAverage() {
        CricketLeagueAnalyser cricketLeagueAnalyser = new CricketLeagueAnalyser();
        try {
            cricketLeagueAnalyser.loadFactsSheetCSV(FACT_SHEET_MOST_RUNS_CSV_FILE_PATH);
            String sortedBattingAverage = cricketLeagueAnalyser.getSortedBattingAverage();
            MostRunsCSV[] mostRunsCSVS = new Gson().fromJson(sortedBattingAverage, MostRunsCSV[].class);
            Assert.assertEquals(83.2, mostRunsCSVS[mostRunsCSVS.length-1].avg,0.0);
        } catch (CricketLeagueException e) {
            e.printStackTrace();
        }
    }
}
