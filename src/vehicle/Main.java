public class Main {
    public static void main(String[] args) { task1(); }
    public static void task1() {
        Vehicle car = new Car("Mercedes", 80);
        Vehicle bike = new Bicycle("Trek", 20);
        car.move(); bike.move();
    }
}
