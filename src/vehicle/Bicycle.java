public class Bicycle extends Vehicle {
    public Bicycle(String brand, int speed) { super(brand, speed); }
    @Override public void move() { System.out.println(brand + " bicycle moves at " + speed); }
}
