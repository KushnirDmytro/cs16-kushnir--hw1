package ua.edu.ucu.tempseries;
import java.math.*;
import java.awt.geom.Arc2D;
import java.util.InputMismatchException;

import static java.lang.Double.MAX_VALUE;
import static java.lang.Math.abs;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;


public class TemperatureSeriesAnalysis {
    double [] temperatureData;
    int dataUsed;
    int dataCapacity;

    public double[] getAllTempValues(){
        return this.temperatureData;
    }

    public double getExactTempValue(int indx){
        return this.temperatureData[indx];
    }

    public TemperatureSeriesAnalysis() {
    }

    public TemperatureSeriesAnalysis(double[] temperatureSeries) {
        this.dataUsed = temperatureSeries.length;
        this.dataCapacity = temperatureSeries.length;
        temperatureData = temperatureSeries;

    }

    private void checkForData(){
        if (dataUsed == 0){
            throw new IllegalArgumentException();
        }
    }


    public double average() {
        checkForData();
        double avarageSum = 0;
        for (int i = 0; i < this.dataUsed ; ++i ){
            avarageSum += temperatureData[i] ;
        }
        return (avarageSum / dataUsed);
    }

    public double deviation() {
        checkForData();
        double averageVal = average();
        double differenceSqSum = 0;
        for (double thisTemp : temperatureData){
            differenceSqSum += pow((averageVal - thisTemp), 2 ) ;
        }
        return sqrt( differenceSqSum / dataUsed );
    }

    public double min() {
        checkForData();
        Double minVal = MAX_VALUE;
        for(double thisTemp: temperatureData){
            if (minVal > thisTemp){
                minVal = thisTemp;
            }
        }
        return minVal;
    }

    public double max() {
        checkForData();
        Double maxVal = Double.NEGATIVE_INFINITY;
        for(double thisTemp: temperatureData){
            if (maxVal < thisTemp) {
                maxVal = thisTemp;
            }
        }
        return maxVal;
    }

    public double findTempClosestToZero() {
        checkForData();
        double closestDifVal = MAX_VALUE;
        double closestDifAbsVal = MAX_VALUE;
        for(int indx = 0; indx < this.dataUsed; ++indx){
            if (closestDifAbsVal > abs(this.temperatureData[indx])){
                closestDifVal = this.temperatureData[indx];
                closestDifAbsVal = abs(closestDifVal);
            }
            else if ( closestDifAbsVal == abs(this.temperatureData[indx]) ){
                if (closestDifAbsVal < this.temperatureData[indx])
                    closestDifVal = this.temperatureData[indx];
            }
        }
        return closestDifVal;
    }

    public double findTempClosestToValue(double tempValue) {
        checkForData();
        double closestTempVal = Double.MAX_VALUE;
        if (tempValue == 0.0){
            return findTempClosestToZero();
        }
        for (double thisVal : this.temperatureData){
            if (abs(thisVal - tempValue) < abs(closestTempVal - tempValue) ) {
                closestTempVal = thisVal;
            }
        }
        return closestTempVal;
    }

    public double[] findTempsLessThen(double tempValue) {
        checkForData();
        double [] tempArray = new double[dataUsed];
        int arrayUsed = 0;
        for (double thisTemp : this.temperatureData){
            if (thisTemp < tempValue)
                tempArray[arrayUsed++] = thisTemp;
        }
        double [] finalArray = new double[arrayUsed];
        System.arraycopy(tempArray, 0, finalArray, 0, arrayUsed);
        return finalArray;
    }

    public double[] findTempsGreaterThen(double tempValue) {
        checkForData();
        double [] tempArray = new double[dataUsed];
        int arrayUsed = 0;
        for (double thisTemp : this.temperatureData){
            if (thisTemp >= tempValue)
                tempArray[arrayUsed++] = thisTemp;
        }
        double [] finalArray = new double[arrayUsed];
        System.arraycopy(tempArray, 0, finalArray, 0, arrayUsed);
        return finalArray;
    }

    public TempSummaryStatistics summaryStatistics() {
        checkForData();
        return new TempSummaryStatistics(average(), deviation(),  min(), max() );
    }

    private double[] extendCapacity (){
        this.dataCapacity = this.dataCapacity * 2 ;
        double [] newArray = new double[this.dataCapacity];
        System.arraycopy(this.temperatureData, 0, newArray, 0, dataUsed);
        return newArray;
    }

    public int addTemps(double... temps) {
        for (double tempValue : temps){
            if (tempValue < -273.0)
                throw new InputMismatchException();
        }
        if (this.dataUsed + temps.length > this.dataCapacity) do {
            if (this.dataCapacity == 0){
                this.dataCapacity = 1;
                this.temperatureData = new double [1];
            } else {
                double[] extendedArray = extendCapacity();
                System.arraycopy(this.temperatureData, 0, extendedArray, 0, this.dataUsed);
                this.temperatureData = extendedArray;
            }
        }while(this.dataUsed + temps.length > this.dataCapacity);
        System.arraycopy(temps, 0, this.temperatureData, dataUsed, temps.length);
        this.dataUsed += temps.length;
        return this.dataUsed;
    }
}
