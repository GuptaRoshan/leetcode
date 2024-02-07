package concept.enumExample;


enum Planet {
    MERCURY(3.303e+23, 2.4397e6),
    VENUS(4.869e+24, 6.0518e6),
    EARTH(5.976e+24, 6.37814e6);

    private final double mass;   // in kilograms
    private final double radius; // in meters

    /**
     * enum constructor called separately for each constant
     **/
    Planet(double mass, double radius) {
        this.mass = mass;
        this.radius = radius;
    }

    public double getMass() {
        return mass;
    }

    public double getRadius() {
        return radius;
    }

}

public class TextEnum {
    public static void main(String[] args) {
        Planet earth = Planet.EARTH;
        System.out.println("Mass of Earth: " + earth.getMass() + " kg");
        System.out.println("Radius of Earth: " + earth.getRadius() + " m");
    }
}
