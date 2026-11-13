import java.io.FileWriter;
import java.io.IOException;

public abstract class WeatherStation {
    String stationName;
    String location;
    double temperature;
    double humidity;

    public WeatherStation(String stationName, String location, double temperature, double humidity) {
        this.stationName = stationName;
        this.location = location;
        this.temperature = temperature;
        this.humidity = humidity;
    }
    public WeatherStation(String stationName, String location) { this(stationName, location, 0, 0); }
    public WeatherStation() { this("Random Station", "Unknown", Math.random() * 40, Math.random() * 100); }

    public void recordMeasurement(double temperature, double humidity) throws InvalidWeatherDataException {
        if (temperature < -80 || temperature > 100 || humidity < 0 || humidity > 100)
            throw new InvalidWeatherDataException("Invalid weather data");
        this.temperature = temperature;
        this.humidity = humidity;
        System.out.println("New data recorded for: " + stationName);
    }

    public abstract void analyzeData(double... dataPoints) throws NoDataPointsException;

    public void saveReport() {
        try {
            FileWriter writer = new FileWriter("weather_report.txt", true);
            writer.write(stationName + ", " + location + ", " + temperature + ", " + humidity + System.lineSeparator());
            writer.close();
            System.out.println("Report saved");
        } catch (IOException e) { System.out.println(e.getMessage()); }
    }

    protected void printAverage(double... dataPoints) throws NoDataPointsException {
        if (dataPoints.length == 0) throw new NoDataPointsException("No data points");
        double sum = 0;
        for (double value : dataPoints) sum += value;
        System.out.println("Average temperature: " + (sum / dataPoints.length) + "°C");
    }
}
