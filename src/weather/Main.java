public class Main {
    public static void main(String[] args) { task1(); }
    public static void task1() {
        UrbanWeatherStation city = new UrbanWeatherStation("City", "Tbilisi", 20, 60, 5);
        RuralWeatherStation village = new RuralWeatherStation("Village", "Kareli", 18, 50, 700);
        try {
            city.recordMeasurement(24, 65);
            city.analyzeData(20, 22, 24);
            village.analyzeData(15, 17, 19);
        } catch (InvalidWeatherDataException | NoDataPointsException e) {
            System.out.println(e.getMessage());
        }
        city.saveReport();
    }
}
