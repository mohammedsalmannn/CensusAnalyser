package com.bridgelabz;

import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;


public class CensusAnalyserTest {

    private static final String CORRECT_FILE_PATH = "C:\\Users\\SalmaN\\IdeaProjects\\CensusAnalyser\\src\\test\\resources";
    private static final String WRONG_FILE_PATH = "C:\\Users\\SalmaN\\IdeaProjects\\CensusAnalyser\\src\\main\\resources";
    private static final String WRONG_CSV_TYPE = "./src/test/resources/wrongFile.txt";
    private static final String STATE_CODE_FILE_PATH = "\"C:\\Users\\SalmaN\\IdeaProjects\\CensusAnalyser\\src\\test\\resources\\IndianStateCode.csv\"";
    private static final String Wrong_STATE_CODE_FILE_TYPE = "\"C:\\Users\\SalmaN\\IdeaProjects\\CensusAnalyser\\src\\test\\resources\\IndianStateCode.pdf\"";



    @Test
    public void givenIndianCensusCSVFileReturnsCorrectRecords() {
        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser();
            Long numOfRecords = censusAnalyser.loadIndiaCensusData(CORRECT_FILE_PATH);
            Assert.assertEquals(java.util.Optional.of(29), java.util.Optional.of(numOfRecords));
        } catch (CensusAnalyserException e) {
        }
    }

    @Test
    public void givenWrongFilePthThrowCustomException() {

        try{
            CensusAnalyser censusAnalyser = new CensusAnalyser();
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusAnalyserException.class);
            censusAnalyser.loadIndiaCensusData(WRONG_FILE_PATH);
        } catch (CensusAnalyserException e) {
            System.out.println(e.type);
            Assert.assertEquals(CensusAnalyserException.ExceptionType.FILE_PROBLEM,e.type);
        }
    }
    @Test
    public void givenIndiaCensusData_WhenWrongType_ShouldThrowException() {
        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser();
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusAnalyserException.class);
            censusAnalyser.loadIndiaCensusData(WRONG_CSV_TYPE);
        }catch (CensusAnalyserException e){
            Assert.assertEquals(CensusAnalyserException.ExceptionType.NOT_A_CSV_TYPE,e.type);
        }
    }

    @Test
    public void givenIndiaCensusData_WhenDelimiterIncorrect_ShouldThrowException() {
        try{
            CensusAnalyser censusAnalyser = new CensusAnalyser();
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusAnalyserException.class);
            censusAnalyser.loadIndiaCensusData(STATE_CODE_FILE_PATH);
        }catch(CensusAnalyserException  e){
            Assert.assertEquals(CensusAnalyserException.ExceptionType.NOT_A_CSV_TYPE_OR_HEADERS_INVALID,e.type);
        }
    }

    @Test
    public void givenIndianStateCodeCSVFileReturnsCorrectRecords() {
        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser();
            Long numOfRecords = censusAnalyser.loadIndiaCensusData(STATE_CODE_FILE_PATH);
            Assert.assertEquals(java.util.Optional.of(37), java.util.Optional.of(numOfRecords));
        } catch (CensusAnalyserException e) { }
    }

    @Test
    public void givenIndiaStateCode_WhenWrongType_ShouldThrowRunTimeException() {
        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser();
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusAnalyserException.class);
            censusAnalyser.loadIndiaCensusData(Wrong_STATE_CODE_FILE_TYPE);
        }catch (CensusAnalyserException e){
            Assert.assertEquals(CensusAnalyserException.ExceptionType.NOT_A_CSV_TYPE_OR_HEADERS_INVALID, e.type);
        }
    }
}