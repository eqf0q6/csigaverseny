package csigaverseny;

/**
 *
 * @author Sandor Kollarits
 */
public class Snail {

    private String color;
    private boolean booster;
    private double speed;
    private double distance;

    // Konstruktor
    public Snail(String color, boolean booster, double speed, double distance) {
        this.color = color;
        this.booster = booster;
        this.speed = speed;
        this.distance = distance;
    }

    // Getterek és setterek
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean hasBooster() {
        return booster;
    }

    public void setBooster(boolean booster) {
        this.booster = booster;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public static Snail getSnail(String color, boolean booster, int speed, int distance) {
        return new Snail(color, booster, speed, distance);
    }

    @Override
    public String toString() {
        return "Snail{"
                + "color='" + color + '\''
                + ", distance=" + distance
                + '}';
    }
}
