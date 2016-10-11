package ua.edu.ucu.tempseries;

import org.junit.Test;

import java.util.InputMismatchException;

import static org.junit.Assert.assertEquals;

public class TemperatureSeriesAnalysisTest {


    @Test
    public void testMax() {
        double[] temperatureSeries = {3.0, -5.0, 1.0, 5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 5.0;

        double actualResult = seriesAnalysis.max();

        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testMin() {
        double[] temperatureSeries = {3.0, -5.0, 1.0, 5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = -5.0;

        double actualResult = seriesAnalysis.min();

        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testDeviation() {
        double[] temperatureSeries = {2.0, -2.0, -2.0, 2.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 2.0;

        double actualResult = seriesAnalysis.deviation();

        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testFindElementClosestToZero() {
        double[] temperatureSeries = {3.0, -5.0, 1.0, 5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 1.0;

        double actualResult = seriesAnalysis.findTempClosestToZero();

        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testFindElementClosestToValue() {
        double[] temperatureSeries = {3.0, -5.0, 1.0, 5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 5.0;
        double testVal = 10.0;

        double actualResult = seriesAnalysis.findTempClosestToValue(testVal);

        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testAverage() {
        double[] temperatureSeries = {3.0, -5.0, 1.0, 5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 1.0;

        double actualResult = seriesAnalysis.average();

        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testFindElLessThenValue() {
        // setup input data and expected result
        double[] temperatureSeries = {3.0, -5.0, 1.0, 5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double[] expResult = {-5.0, 1.0};
        double testValue = 2.0;
        // call tested method
        double[] actualResult = seriesAnalysis.findTempsLessThen(testValue);

        // compare expected result with actual result
        assertEquals(expResult.length, actualResult.length);
        assertEquals(expResult[1], actualResult[1], 0.00001);
        assertEquals(expResult[0], actualResult[0], 0.00001);
    }

    @Test
    public void testFindElGreaterThenValue() {
        // setup input data and expected result
        double[] temperatureSeries = {3.0, -5.0, 1.0, 5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double[] expResult = {3.0, 5.0};
        double testValue = 2.0;
        // call tested method
        double[] actualResult = seriesAnalysis.findTempsGreaterThen(testValue);

        // compare expected result with actual result
        assertEquals(expResult.length, actualResult.length);
        assertEquals(expResult[1], actualResult[1], 0.00001);
        assertEquals(expResult[0], actualResult[0], 0.00001);
    }

    @Test
    public void testSummaryStatistics() {
        // setup input data and expected result
        double[] temperatureSeries = {-1.0, 1.0, 2.0, 0.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = -1.0;
        double expAvg = 0.5;
        double expDev = 1.118033988749895;
        double expMax = 2.0;
        double expMin = -1.0;
        // call tested method
        TempSummaryStatistics actualResult = seriesAnalysis.summaryStatistics();
        // compare expected result with actual result
        assertEquals(expAvg, actualResult.getAvgTemp(), 0.00001);
        assertEquals(expDev, actualResult.getDevTemp(), 0.00001);
        assertEquals(expMax, actualResult.getMaxTemp(), 0.00001);
        assertEquals(expMin, actualResult.getMinTemp(), 0.00001);
    }

    @Test
    public void testAverageWithOneElementArray() {
        // setup input data and expected result
        double[] temperatureSeries = {-1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = -1.0;

        // call tested method
        double actualResult = seriesAnalysis.average();

        // compare expected result with actual result
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testMinWithOneElementArray() {
        // setup input data and expected result
        double[] temperatureSeries = {-1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = -1.0;

        // call tested method
        double actualResult = seriesAnalysis.min();

        // compare expected result with actual result
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testMaxWithOneElementArray() {
        // setup input data and expected result
        double[] temperatureSeries = {-1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = -1.0;

        // call tested method
        double actualResult = seriesAnalysis.max();

        // compare expected result with actual result
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testDeviationWithOneElementArray() {
        // setup input data and expected result
        double[] temperatureSeries = {-1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 0.0;

        // call tested method
        double actualResult = seriesAnalysis.deviation();

        // compare expected result with actual result
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testFindElClosestToZeroWithOneElementArray() {
        // setup input data and expected result
        double[] temperatureSeries = {-1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = -1.0;

        // call tested method
        double actualResult = seriesAnalysis.findTempClosestToZero();

        // compare expected result with actual result
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testFindElClosestToValueWithOneElementArray() {
        // setup input data and expected result
        double[] temperatureSeries = {-1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = -1.0;
        double testValue = 1.1;
        // call tested method
        double actualResult = seriesAnalysis.findTempClosestToValue(testValue);

        // compare expected result with actual result
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testFindElLessThenValueWithOneElementArray() {
        // setup input data and expected result
        double[] temperatureSeries = {-1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double[] expResult = {-1.0};
        double testValue = 100.0;
        // call tested method
        double[] actualResult = seriesAnalysis.findTempsLessThen(testValue);

        // compare expected result with actual result
        assertEquals(expResult[0], actualResult[0], 0.00001);
    }

    @Test
    public void testFindElGreaterThenValueWithOneElementArray() {
        // setup input data and expected result
        double[] temperatureSeries = {-1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double[] expResult = {-1.0};
        double testValue = -100.0;
        // call tested method
        double[] actualResult = seriesAnalysis.findTempsGreaterThen(testValue);

        // compare expected result with actual result
        assertEquals(expResult[0], actualResult[0], 0.00001);
    }

    @Test
    public void testSummaryStatisticsWithOneElementArray() {
        // setup input data and expected result
        double[] temperatureSeries = {-1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = -1.0;

        // call tested method
        TempSummaryStatistics actualResult = seriesAnalysis.summaryStatistics();
        // compare expected result with actual result
        assertEquals(expResult, actualResult.getAvgTemp(), 0.00001);
        assertEquals(0.0, actualResult.getDevTemp(), 0.00001);
        assertEquals(expResult, actualResult.getMaxTemp(), 0.00001);
        assertEquals(expResult, actualResult.getMinTemp(), 0.00001);
    }

    @Test
    public void testAddWithOneElementArray() {
        // setup input data and expected result
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double[] expResult = {-1.0};
        double[] testExample = {-1.0};

        // call tested method
        int actualResult = seriesAnalysis.addTemps(testExample[0]);
        int expReturn = 1;
        int expCapacity = 1;
        // compare expected result with actual result
        //funciton return test
        assertEquals(expReturn, actualResult);
        //data used control test
        assertEquals(seriesAnalysis.dataUsed, expReturn);
        //data capacity control test
        assertEquals(expCapacity, seriesAnalysis.dataCapacity);
        //first element test
        assertEquals(expResult[0], seriesAnalysis.getExactTempValue(0), 0.00001);
    }


    @Test
    public void testAddWithTwoElementsArray() {
        // setup input data and expected result
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double[] expResult = {-1.0, -2.1};
        double[] testExample = {-1.0, -2.1};

        // call tested method
        int actualResult = seriesAnalysis.addTemps(testExample[0], testExample[1]);
        int expReturn = 2;
        int expCapacity = 2;
        // compare expected result with actual result
        //funciton return test
        assertEquals(expReturn, actualResult);
        //data used control test
        assertEquals(seriesAnalysis.dataUsed, expReturn);
        //data capacity control test
        assertEquals(expCapacity, seriesAnalysis.dataCapacity);
        //first element test
        assertEquals(expResult[0], seriesAnalysis.getExactTempValue(0), 0.00001);
        //second element test
        assertEquals(expResult[1], seriesAnalysis.getExactTempValue(1), 0.00001);
    }


    @Test(expected = IllegalArgumentException.class)
    public void testAverageWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        // expect exception here
        seriesAnalysis.average();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMinWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        // expect exception here
        seriesAnalysis.min();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMaxWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        // expect exception here
        seriesAnalysis.max();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDeviationWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        // expect exception here
        seriesAnalysis.deviation();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testClosesttoZeroWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        // expect exception here
        seriesAnalysis.findTempClosestToZero();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testClosesttoValueWithEmptyArray() {
        double[] temperatureSeries = {};
        double testTempValue = 0;
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        // expect exception here
        seriesAnalysis.findTempClosestToValue(testTempValue);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindTempsLessThenWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double testTempValue = 1.0;
        // expect exception here
        seriesAnalysis.findTempsLessThen(testTempValue);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindTempsGreaterThenWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double testTempValue = 1.0;
        // expect exception here
        seriesAnalysis.findTempsGreaterThen(testTempValue);
    }

    @Test(expected = InputMismatchException.class)
    public void testAddInvalidElementsArray() {
        // setup input data and expected result
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double[] testExample = {-1.0, -300.1};
        // expect exception here
        seriesAnalysis.addTemps(testExample);
    }


    @Test(expected = IllegalArgumentException.class)
    public void testSummartyStatisticsWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        // expect exception here
        seriesAnalysis.summaryStatistics();
    }


}
