package com.bridgelabz.cricketleagueanalyser.service;

import com.bridgelabz.cricketleagueanalyser.exception.CSVBuilderException;
import com.bridgelabz.cricketleagueanalyser.exception.CricketLeagueException;
import com.bridgelabz.cricketleagueanalyser.models.MostRunsCSV;
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
    List<MostRunsCSV> iplList;

    public List loadFactsSheetCSV(String csvFilePath) throws CricketLeagueException {
        try (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));) {
            ICSVBuilder csvBuilder = CSVBuilderFactory.createCSVBuilder();
            iplList = csvBuilder.getCSVFileList(reader, MostRunsCSV.class);
            return iplList;
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
        iplList.sort(iplComparator);
        System.out.println(iplList);
        String sorteBattingAvgJSON = new Gson().toJson(iplList);
        return sorteBattingAvgJSON;
    }

}
