public class UrbanWeatherStation extends WeatherStation {
    double trafficImpact;
    public UrbanWeatherStation(String stationName, String location, double temperature, double humidity, double trafficImpact) {
        super(stationName, location, temperature, humidity);
        this.trafficImpact = trafficImpact;
    }
    @Override public void analyzeData(double... dataPoints) throws NoDataPointsException {
        printAverage(dataPoints);
    }
}
