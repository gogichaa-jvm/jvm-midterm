public class RuralWeatherStation extends WeatherStation {
    double altitude;
    public RuralWeatherStation(String stationName, String location, double temperature, double humidity, double altitude) {
        super(stationName, location, temperature, humidity);
        this.altitude = altitude;
    }
    @Override public void analyzeData(double... dataPoints) throws NoDataPointsException {
        printAverage(dataPoints);
    }
}
