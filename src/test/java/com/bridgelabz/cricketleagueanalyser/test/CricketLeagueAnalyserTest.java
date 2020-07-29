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
            List numOfRecords = cricketLeagueAnalyser.loadRunFactsSheetCSV(MostRunsCSV.class, FACT_SHEET_MOST_RUNS_CSV_FILE_PATH);
            Assert.assertEquals(101, numOfRecords.size());
        } catch (CricketLeagueException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenIPLCSV_WhenSortedOnBattingAverage_ShouldReturnTopCricketerBattingAverage() {
        CricketLeagueAnalyser cricketLeagueAnalyser = new CricketLeagueAnalyser();
        try {
            cricketLeagueAnalyser.loadRunFactsSheetCSV(MostRunsCSV.class, FACT_SHEET_MOST_RUNS_CSV_FILE_PATH);
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
            cricketLeagueAnalyser.loadRunFactsSheetCSV(MostRunsCSV.class, FACT_SHEET_MOST_RUNS_CSV_FILE_PATH);
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
            cricketLeagueAnalyser.loadRunFactsSheetCSV(MostRunsCSV.class, FACT_SHEET_MOST_RUNS_CSV_FILE_PATH);
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
            cricketLeagueAnalyser.loadRunFactsSheetCSV(MostRunsCSV.class, FACT_SHEET_MOST_RUNS_CSV_FILE_PATH);
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
            cricketLeagueAnalyser.loadRunFactsSheetCSV(MostRunsCSV.class, FACT_SHEET_MOST_RUNS_CSV_FILE_PATH);
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
            cricketLeagueAnalyser.loadRunFactsSheetCSV(MostRunsCSV.class, FACT_SHEET_MOST_RUNS_CSV_FILE_PATH);
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
            cricketLeagueAnalyser.loadRunFactsSheetCSV(MostRunsCSV.class, FACT_SHEET_MOST_RUNS_CSV_FILE_PATH);
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
            Assert.assertEquals(99, numOfRecords.size());
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

    @Test
    public void givenIPLCSV_WhenSortedOnBowlingStrikeRate_ShouldReturnTopCricketer() {
        CricketLeagueAnalyser cricketLeagueAnalyser = new CricketLeagueAnalyser();
        try {
            cricketLeagueAnalyser.loadWicketFactsSheetCSV(FACT_SHEET_MOST_WICKETS_CSV_FILE_PATH);
            String sortedBowlingStrikeRate = cricketLeagueAnalyser.getSortedBowlingStrikeRate();
            MostWicketsCSV[] mostBowlCSV = new Gson().fromJson(sortedBowlingStrikeRate, MostWicketsCSV[].class);
            Assert.assertEquals(120.0, mostBowlCSV[mostBowlCSV.length-1].strikeRate,0.0);
            Assert.assertEquals("Krishnappa Gowtham", mostBowlCSV[mostBowlCSV.length-1].player);
        } catch (CricketLeagueException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenIPLCSV_WhenSortedOnBowlingEconomy_ShouldReturnTopCricketer() {
        CricketLeagueAnalyser cricketLeagueAnalyser = new CricketLeagueAnalyser();
        try {
            cricketLeagueAnalyser.loadWicketFactsSheetCSV(FACT_SHEET_MOST_WICKETS_CSV_FILE_PATH);
            String sortedBowlingEconomy = cricketLeagueAnalyser.getSortedBowlingEconomy();
            MostWicketsCSV[] mostBowlCSV = new Gson().fromJson(sortedBowlingEconomy, MostWicketsCSV[].class);
            Assert.assertEquals(12.0, mostBowlCSV[mostBowlCSV.length-1].strikeRate,0.0);
            Assert.assertEquals("Ben Cutting", mostBowlCSV[mostBowlCSV.length-1].player);
        } catch (CricketLeagueException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenIPLCSV_WhenSortedOnBowlingStrikeRate_ShouldReturnTopCricketerWith5W4W() {
        CricketLeagueAnalyser cricketLeagueAnalyser = new CricketLeagueAnalyser();
        try {
            cricketLeagueAnalyser.loadWicketFactsSheetCSV(FACT_SHEET_MOST_WICKETS_CSV_FILE_PATH);
            String sortedBowlingStrikeRate = cricketLeagueAnalyser.getSortedBowlingStrikeRate();
            MostWicketsCSV[] mostBowlCSV = new Gson().fromJson(sortedBowlingStrikeRate, MostWicketsCSV[].class);
            Assert.assertEquals(120.0, mostBowlCSV[mostBowlCSV.length-1].strikeRate,0.0);
            Assert.assertEquals("Krishnappa Gowtham", mostBowlCSV[mostBowlCSV.length-1].player);
            Assert.assertEquals(0, mostBowlCSV[mostBowlCSV.length-1].fourWkts);
            Assert.assertEquals(0, mostBowlCSV[mostBowlCSV.length-1].fiveWkts);
        } catch (CricketLeagueException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenIPLCSV_WhenSortedOnBowlingAverage_ShouldReturnTopCricketerWithBestStrikeRate() {
        CricketLeagueAnalyser cricketLeagueAnalyser = new CricketLeagueAnalyser();
        try {
            cricketLeagueAnalyser.loadWicketFactsSheetCSV(FACT_SHEET_MOST_WICKETS_CSV_FILE_PATH);
            String sortedBowlingAverage = cricketLeagueAnalyser.getSortedBowlingAverage();
            String sortedBowlingStrikeRate = cricketLeagueAnalyser.getSortedBowlingStrikeRate();
            MostWicketsCSV[] mostBowlAvgCSV = new Gson().fromJson(sortedBowlingAverage, MostWicketsCSV[].class);
            MostWicketsCSV[] mostBowlStrikeRateCSV = new Gson().fromJson(sortedBowlingStrikeRate, MostWicketsCSV[].class);
            Assert.assertEquals(120.0, mostBowlAvgCSV[mostBowlAvgCSV.length-1].strikeRate,0.0);
            Assert.assertEquals("Krishnappa Gowtham", mostBowlAvgCSV[mostBowlAvgCSV.length-1].player);
            Assert.assertEquals(120.0, mostBowlStrikeRateCSV[mostBowlStrikeRateCSV.length-1].strikeRate,0.0);
            Assert.assertEquals("Krishnappa Gowtham", mostBowlStrikeRateCSV[mostBowlStrikeRateCSV.length-1].player);
        } catch (CricketLeagueException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenIPLCSV_WhenSortedOnWickets_ShouldReturnTopCricketerNameWithBowlingAverage() {
        CricketLeagueAnalyser cricketLeagueAnalyser = new CricketLeagueAnalyser();
        try {
            cricketLeagueAnalyser.loadWicketFactsSheetCSV(FACT_SHEET_MOST_WICKETS_CSV_FILE_PATH);
            String sortedWickets = cricketLeagueAnalyser.getSortedWickets();
            MostWicketsCSV[] mostBowlCSV = new Gson().fromJson(sortedWickets, MostWicketsCSV[].class);
            Assert.assertEquals(26, mostBowlCSV[mostBowlCSV.length-1].wkts);
            Assert.assertEquals("Imran Tahir", mostBowlCSV[mostBowlCSV.length-1].player);
        } catch (CricketLeagueException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void givenIPLCSV_WhenSortedOnBattingAverageAndBallingAverage_ShouldReturnTopCricketerName() {
        CricketLeagueAnalyser cricketLeagueAnalyser = new CricketLeagueAnalyser();
        try {
            cricketLeagueAnalyser.loadRunFactsSheetCSV(MostRunsCSV.class, FACT_SHEET_MOST_RUNS_CSV_FILE_PATH);
            String sortedBattingAverage = cricketLeagueAnalyser.getSortedBattingAverage();
            MostRunsCSV[] mostRunsCSVS = new Gson().fromJson(sortedBattingAverage, MostRunsCSV[].class);
            Assert.assertEquals(83.2, mostRunsCSVS[mostRunsCSVS.length-1].avg,0.0);
            Assert.assertEquals("MS Dhoni", mostRunsCSVS[mostRunsCSVS.length-1].player);
            cricketLeagueAnalyser.loadWicketFactsSheetCSV(FACT_SHEET_MOST_WICKETS_CSV_FILE_PATH);
            String sortedBowlingAverage = cricketLeagueAnalyser.getSortedBowlingAverage();
            MostWicketsCSV[] mostBowlCSV = new Gson().fromJson(sortedBowlingAverage, MostWicketsCSV[].class);
            Assert.assertEquals(166.0, mostBowlCSV[mostBowlCSV.length-1].average,0.0);
            Assert.assertEquals("Krishnappa Gowtham", mostBowlCSV[mostBowlCSV.length-1].player);
        } catch (CricketLeagueException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenIPLCSV_WhenSortedOnHundred_ShouldReturnTopCricketerBattingAverage() {
        CricketLeagueAnalyser cricketLeagueAnalyser = new CricketLeagueAnalyser();
        try {
            cricketLeagueAnalyser.loadRunFactsSheetCSV(MostRunsCSV.class, FACT_SHEET_MOST_RUNS_CSV_FILE_PATH);
            String sortedHundred = cricketLeagueAnalyser.getSortedHundred();
            MostRunsCSV[] mostRunsCSVS = new Gson().fromJson(sortedHundred, MostRunsCSV[].class);
            Assert.assertEquals(1, mostRunsCSVS[mostRunsCSVS.length-1].hundred);
            Assert.assertEquals("Sanju Samson", mostRunsCSVS[mostRunsCSVS.length-1].player);
        } catch (CricketLeagueException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenIPLCSV_WhenSortedOnHundredAndFifty_ShouldReturnTopCricketerBattingAverage() {
        CricketLeagueAnalyser cricketLeagueAnalyser = new CricketLeagueAnalyser();
        try {
            cricketLeagueAnalyser.loadRunFactsSheetCSV(MostRunsCSV.class, FACT_SHEET_MOST_RUNS_CSV_FILE_PATH);
            String sortedHundred = cricketLeagueAnalyser.getSortedHundred();
            MostRunsCSV[] mostRunsCSVS = new Gson().fromJson(sortedHundred, MostRunsCSV[].class);
            Assert.assertEquals(1, mostRunsCSVS[mostRunsCSVS.length-1].hundred);
            Assert.assertEquals("Sanju Samson", mostRunsCSVS[mostRunsCSVS.length-1].player);
        } catch (CricketLeagueException e) {
            e.printStackTrace();
        }
    }
}
