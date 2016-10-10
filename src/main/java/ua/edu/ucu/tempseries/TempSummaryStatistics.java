package ua.edu.ucu.tempseries;

public class TempSummaryStatistics {
    private double avgTemp;
    private double devTemp;
    private double minTemp;
    private double maxTemp;
    TempSummaryStatistics(double avgTemp,double devTemp , double minTemp, double maxTemp){
        this.minTemp = minTemp;
        this.maxTemp = maxTemp;
        this.devTemp = devTemp;
        this.avgTemp = avgTemp;
    }

    public double getAvgTemp() {
        return avgTemp;
    }

    public double getMinTemp() {
        return minTemp;
    }

    public double getDevTemp() {
        return devTemp;
    }

    public double getMaxTemp() {
        return maxTemp;
    }
}
