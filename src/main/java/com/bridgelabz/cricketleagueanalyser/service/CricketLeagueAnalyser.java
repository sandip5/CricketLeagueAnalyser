package com.bridgelabz.cricketleagueanalyser.service;

import com.bridgelabz.cricketleagueanalyser.exception.CSVBuilderException;
import com.bridgelabz.cricketleagueanalyser.exception.CricketLeagueException;
import com.bridgelabz.cricketleagueanalyser.models.MostRunsCSV;
import com.bridgelabz.cricketleagueanalyser.models.MostWicketsCSV;
import com.bridgelabz.cricketleagueanalyser.utility.CSVBuilderFactory;
import com.bridgelabz.cricketleagueanalyser.utility.ICSVBuilder;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;

public class CricketLeagueAnalyser {
    List<MostRunsCSV> iplListMostRun;
    List<MostWicketsCSV> iplListMostWickets;

    public <E> List loadRunFactsSheetCSV(Class<E> iplClass, String csvFilePath) throws CricketLeagueException {
        try (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath))) {
            ICSVBuilder csvBuilder = CSVBuilderFactory.createCSVBuilder();
            iplListMostRun = csvBuilder.getCSVFileList(reader, MostRunsCSV.class);
            return iplListMostRun;
        } catch (RuntimeException e) {
            throw new CricketLeagueException("Delimiter Or Header Problem",
                    CricketLeagueException.ExceptionType.DELIMITER_AND_HEADER_PROBLEM);
        } catch (IOException e) {
            throw new CricketLeagueException("Wrong File Or Path",
                    CricketLeagueException.ExceptionType.CENSUS_FILE_PROBLEM);
        } catch (CSVBuilderException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List loadWicketFactsSheetCSV(String csvFilePath) throws CricketLeagueException {
        try (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath))) {
            ICSVBuilder csvBuilder = CSVBuilderFactory.createCSVBuilder();
            iplListMostWickets = csvBuilder.getCSVFileList(reader, MostWicketsCSV.class);
            return iplListMostWickets;
        } catch (RuntimeException e) {
            throw new CricketLeagueException("Delimiter Or Header Problem",
                    CricketLeagueException.ExceptionType.DELIMITER_AND_HEADER_PROBLEM);
        } catch (IOException e) {
            throw new CricketLeagueException("Wrong File Or Path",
                    CricketLeagueException.ExceptionType.CENSUS_FILE_PROBLEM);
        } catch (CSVBuilderException e) {
            e.printStackTrace();
        }
        return null;
    }



    public String getSortedBattingAverage() {
        Comparator<MostRunsCSV> iplComparator = Comparator.comparing(census -> census.avg);
        iplListMostRun.sort(iplComparator);
        System.out.println(iplListMostRun);
        return new Gson().toJson(iplListMostRun);
    }

    public String getSortedStrikeRate() {
        Comparator<MostRunsCSV> iplComparator = Comparator.comparing(census -> census.strikeRate);
        iplListMostRun.sort(iplComparator);
        System.out.println(iplListMostRun);
        return new Gson().toJson(iplListMostRun);
    }

    public String getSortedSix() {
        Comparator<MostRunsCSV> iplComparator = Comparator.comparing(census -> census.six);
        iplListMostRun.sort(iplComparator);
        System.out.println(iplListMostRun);
        return new Gson().toJson(iplListMostRun);
    }

    public String getSortedFour() {
        Comparator<MostRunsCSV> iplComparator = Comparator.comparing(census -> census.fours);
        iplListMostRun.sort(iplComparator);
        System.out.println(iplListMostRun);
        return new Gson().toJson(iplListMostRun);
    }

    public String getSortedRuns() {
        Comparator<MostRunsCSV> iplComparator = Comparator.comparing(census -> census.run);
        iplListMostRun.sort(iplComparator);
        System.out.println(iplListMostRun);
        return new Gson().toJson(iplListMostRun);
    }

    public String getSortedBowlingAverage() {
        Comparator<MostWicketsCSV> iplComparator = Comparator.comparing(census -> census.average);
        iplListMostWickets.sort(iplComparator);
        System.out.println(iplListMostWickets);
        return new Gson().toJson(iplListMostWickets);
    }

    public String getSortedBowlingStrikeRate() {
        Comparator<MostWicketsCSV> iplComparator = Comparator.comparing(census -> census.strikeRate);
        iplListMostWickets.sort(iplComparator);
        System.out.println(iplListMostWickets);
        return new Gson().toJson(iplListMostWickets);
    }

    public String getSortedBowlingEconomy() {
        Comparator<MostWicketsCSV> iplComparator = Comparator.comparing(census -> census.economy);
        iplListMostWickets.sort(iplComparator);
        System.out.println(iplListMostWickets);
        return new Gson().toJson(iplListMostWickets);
    }

    public String getSortedWickets() {
        Comparator<MostWicketsCSV> iplComparator = Comparator.comparing(census -> census.wkts);
        iplListMostWickets.sort(iplComparator);
        System.out.println(iplListMostWickets);
        return new Gson().toJson(iplListMostWickets);
    }

    public String getSortedHundred() {
        Comparator<MostRunsCSV> iplComparator = Comparator.comparing(census -> census.hundred);
        iplListMostRun.sort(iplComparator);
        System.out.println(iplListMostRun);
        return new Gson().toJson(iplListMostRun);
    }
}

