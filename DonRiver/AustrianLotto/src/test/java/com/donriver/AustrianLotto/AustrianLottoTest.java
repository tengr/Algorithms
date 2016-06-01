package com.donriver.AustrianLotto;

import java.io.*;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import java.util.Arrays;


public class AustrianLottoTest extends TestCase{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AustrianLottoTest(String name)
    {
        super(name);
    }	
    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AustrianLottoTest.class );
    }
    
    public void testFile() throws InvalidInputException, FileNotFoundException, IOException{
        AustrianLotto austrianLotto = new AustrianLotto();
        BufferedReader br = null;
        br = new BufferedReader(new FileReader("src/test/resources/testcases.txt"));
        while (true) {
        	String line = br.readLine();
        	if(line == null) break;
        	if(line.length() == 0) continue;
            Data data = InputParser.parse(line, ParseMode.TEST);
            assert(Arrays.equals(data.ret, austrianLotto.evaluate(data.drawing, data.picks)));
       }
       if(br != null) br.close();
    }

    public void testMultiplePicksPartiallyCorrect() throws InvalidInputException{
        AustrianLotto austrianLotto = new AustrianLotto();
    	int[] expectedResult = { 1,  0,  2,  0,  0,  0,  0 };
        String drawing = "3 11 18 23 37 45";
        String[] picks = {"4 7 14 30 33 35", "1 11 12 25 37 38", "11 18 19 20 21 22"};
        assert(Arrays.equals(expectedResult, austrianLotto.evaluate(drawing, picks)));
    }

    public void testSinglePickFullyCorrect() throws InvalidInputException{
        AustrianLotto austrianLotto = new AustrianLotto();
        int[] expectedResult = { 0,  0,  0,  0,  0,  0,  1 };
        String drawing = "3 18 23 11 37 45";
        String[] picks = {"3 11 18 23 37 45"};
        assert(Arrays.equals(expectedResult, austrianLotto.evaluate(drawing, picks)));
    }

    public void testSinglePickPartiallyCorrect() throws InvalidInputException{
        AustrianLotto austrianLotto = new AustrianLotto();
        int[] expectedResult = { 0,  0,  0,  1,  0,  0,  0 };
        String drawing = "42 26 33 2 13 14";
        String[] picks = {"13 4 36 42 26 12"};
        assert(Arrays.equals(expectedResult, austrianLotto.evaluate(drawing, picks)));
    }
	
}