package com.bridgelabz.cricketleagueanalyser.test;

import com.bridgelabz.cricketleagueanalyser.exception.CricketLeagueException;
import com.bridgelabz.cricketleagueanalyser.models.MostRunsCSV;
import com.bridgelabz.cricketleagueanalyser.models.MostWicketsCSV;
import com.bridgelabz.cricketleagueanalyser.service.CricketLeagueAnalyser;
import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class CricketLeagueAnalyserTest {
    String FACT_SHEET_MOST_RUNS_CSV_FILE_PATH =
            "./src/test/resources/Day16 Data_01 IPL2019FactsheetMostRuns.csv";
    String FACT_SHEET_MOST_WICKETS_CSV_FILE_PATH =
            "./src/test/resources/Day16 Data_02 IPL2019FactsheetMostWkts.csv";

    @Test
    public void givenIPLCSVFile_ReturnsCorrectRecords() {
        try {
            CricketLeagueAnalyser cricketLeagueAnalyser = new CricketLeagueAnalyser();
            List numOfRecords = cricketLeagueAnalyser.loadRunFactsSheetCSV(FACT_SHEET_MOST_RUNS_CSV_FILE_PATH);
            Assert.assertEquals(101, numOfRecords.size());
        } catch (CricketLeagueException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenIPLCSV_WhenSortedOnBattingAverage_ShouldReturnTopCricketerBattingAverage() {
        CricketLeagueAnalyser cricketLeagueAnalyser = new CricketLeagueAnalyser();
        try {
            cricketLeagueAnalyser.loadRunFactsSheetCSV(FACT_SHEET_MOST_RUNS_CSV_FILE_PATH);
            String sortedBattingAverage = cricketLeagueAnalyser.getSortedBattingAverage();
            MostRunsCSV[] mostRunsCSVS = new Gson().fromJson(sortedBattingAverage, MostRunsCSV[].class);
            Assert.assertEquals(83.2, mostRunsCSVS[mostRunsCSVS.length-1].avg,0.0);
            Assert.assertEquals("MS Dhoni", mostRunsCSVS[mostRunsCSVS.length-1].player);
        } catch (CricketLeagueException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenIPLCSV_WhenSortedOnStrikingRate_ShouldReturnTopCricketerStrikingRate() {
        CricketLeagueAnalyser cricketLeagueAnalyser = new CricketLeagueAnalyser();
        try {
            cricketLeagueAnalyser.loadRunFactsSheetCSV(FACT_SHEET_MOST_RUNS_CSV_FILE_PATH);
            String sortedStrikeRate = cricketLeagueAnalyser.getSortedStrikeRate();
            MostRunsCSV[] mostRunsCSVS = new Gson().fromJson(sortedStrikeRate, MostRunsCSV[].class);
            Assert.assertEquals(333.33, mostRunsCSVS[mostRunsCSVS.length-1].strikeRate,0.0);
            Assert.assertEquals("Ishant Sharma",mostRunsCSVS[mostRunsCSVS.length-1].player);
        } catch (CricketLeagueException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenIPLCSV_WhenSortedOnSixAndFour_ShouldReturnTopCricketerSixAndFour() {
        CricketLeagueAnalyser cricketLeagueAnalyser = new CricketLeagueAnalyser();
        try {
            cricketLeagueAnalyser.loadRunFactsSheetCSV(FACT_SHEET_MOST_RUNS_CSV_FILE_PATH);
            String sortedSix = cricketLeagueAnalyser.getSortedSix();
            String sortedFour = cricketLeagueAnalyser.getSortedFour();
            MostRunsCSV[] sixCSV = new Gson().fromJson(sortedSix, MostRunsCSV[].class);
            MostRunsCSV[] fourCSV = new Gson().fromJson(sortedFour, MostRunsCSV[].class);
            Assert.assertEquals(52, sixCSV[sixCSV.length-1].six,0.0);
            Assert.assertEquals("Andre Russell", sixCSV[sixCSV.length-1].player);
            Assert.assertEquals(64,fourCSV[fourCSV.length-1].fours);
            Assert.assertEquals("Shikhar Dhawan",fourCSV[fourCSV.length-1].player);
        } catch (CricketLeagueException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenIPLCSV_WhenSortedOnSixAndFour_ShouldReturnTopCricketerStrikeRate() {
        CricketLeagueAnalyser cricketLeagueAnalyser = new CricketLeagueAnalyser();
        try {
            cricketLeagueAnalyser.loadRunFactsSheetCSV(FACT_SHEET_MOST_RUNS_CSV_FILE_PATH);
            String sortedSix = cricketLeagueAnalyser.getSortedSix();
            String sortedFour = cricketLeagueAnalyser.getSortedFour();
            MostRunsCSV[] sixCSV = new Gson().fromJson(sortedSix, MostRunsCSV[].class);
            MostRunsCSV[] fourCSV = new Gson().fromJson(sortedFour, MostRunsCSV[].class);
            Assert.assertEquals(204.81, sixCSV[sixCSV.length-1].strikeRate,0.0);
            Assert.assertEquals("Andre Russell", sixCSV[sixCSV.length-1].player);
            Assert.assertEquals(135.67,fourCSV[fourCSV.length-1].strikeRate,0.0);
            Assert.assertEquals("Shikhar Dhawan",fourCSV[fourCSV.length-1].player);
        } catch (CricketLeagueException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenIPLCSV_WhenSortedOnStrikingRate_ShouldReturnTopCricketerStrikingRateWithSixFour() {
        CricketLeagueAnalyser cricketLeagueAnalyser = new CricketLeagueAnalyser();
        try {
            cricketLeagueAnalyser.loadRunFactsSheetCSV(FACT_SHEET_MOST_RUNS_CSV_FILE_PATH);
            String sortedStrikeRate = cricketLeagueAnalyser.getSortedStrikeRate();
            MostRunsCSV[] mostRunsCSVS = new Gson().fromJson(sortedStrikeRate, MostRunsCSV[].class);
            Assert.assertEquals(333.33, mostRunsCSVS[mostRunsCSVS.length-1].strikeRate,0.0);
            Assert.assertEquals("Ishant Sharma",mostRunsCSVS[mostRunsCSVS.length-1].player);
            Assert.assertEquals(1,mostRunsCSVS[mostRunsCSVS.length-1].six);
            Assert.assertEquals(1,mostRunsCSVS[mostRunsCSVS.length-1].fours);
        } catch (CricketLeagueException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenIPLCSV_WhenSortedOnAverage_ShouldReturnTopCricketerAverageWithStrikingRate() {
        CricketLeagueAnalyser cricketLeagueAnalyser = new CricketLeagueAnalyser();
        try {
            cricketLeagueAnalyser.loadRunFactsSheetCSV(FACT_SHEET_MOST_RUNS_CSV_FILE_PATH);
            String sortedBattingAverage = cricketLeagueAnalyser.getSortedBattingAverage();
            MostRunsCSV[] mostRunsCSVS = new Gson().fromJson(sortedBattingAverage, MostRunsCSV[].class);
            Assert.assertEquals(83.2, mostRunsCSVS[mostRunsCSVS.length-1].avg,0.0);
            Assert.assertEquals("MS Dhoni", mostRunsCSVS[mostRunsCSVS.length-1].player);
            Assert.assertEquals(134.62, mostRunsCSVS[mostRunsCSVS.length-1].strikeRate,0.0);
        } catch (CricketLeagueException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenIPLCSV_WhenSortedOnRuns_ShouldReturnTopCricketerRunsWithAverage() {
        CricketLeagueAnalyser cricketLeagueAnalyser = new CricketLeagueAnalyser();
        try {
            cricketLeagueAnalyser.loadRunFactsSheetCSV(FACT_SHEET_MOST_RUNS_CSV_FILE_PATH);
            String sortedRun = cricketLeagueAnalyser.getSortedRuns();
            MostRunsCSV[] mostRunsCSVS = new Gson().fromJson(sortedRun, MostRunsCSV[].class);
            Assert.assertEquals(692, mostRunsCSVS[mostRunsCSVS.length-1].run);
            Assert.assertEquals("David Warner", mostRunsCSVS[mostRunsCSVS.length-1].player);
            Assert.assertEquals(69.2, mostRunsCSVS[mostRunsCSVS.length-1].avg,0.0);
        } catch (CricketLeagueException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void givenIPLCSVWicketFile_ReturnsCorrectRecords() {
        try {
            CricketLeagueAnalyser cricketLeagueAnalyser = new CricketLeagueAnalyser();
            List numOfRecords = cricketLeagueAnalyser.loadWicketFactsSheetCSV(FACT_SHEET_MOST_WICKETS_CSV_FILE_PATH);
            Assert.assertEquals(101, numOfRecords.size());
        } catch (CricketLeagueException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void givenIPLCSV_WhenSortedOnBowlingAverage_ShouldReturnTopCricketer() {
        CricketLeagueAnalyser cricketLeagueAnalyser = new CricketLeagueAnalyser();
        try {
            cricketLeagueAnalyser.loadWicketFactsSheetCSV(FACT_SHEET_MOST_WICKETS_CSV_FILE_PATH);
            String sortedBowlingAverage = cricketLeagueAnalyser.getSortedBowlingAverage();
            MostWicketsCSV[] mostBowlCSV = new Gson().fromJson(sortedBowlingAverage, MostWicketsCSV[].class);
            Assert.assertEquals(166.0, mostBowlCSV[mostBowlCSV.length-1].average,0.0);
            Assert.assertEquals("Krishnappa Gowtham", mostBowlCSV[mostBowlCSV.length-1].player);
        } catch (CricketLeagueException e) {
            e.printStackTrace();
        }
    }
}
