package apps.appCars.base;

public interface Audit {

    boolean driversLicense(int age);

    boolean passport(int age);

    boolean driversFine(int age);
}
