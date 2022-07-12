package apps.appCars.base;

import apps.appCars.models.Driver;

public interface Audit {

    boolean driversLicense(Driver driver);

    boolean passport(Driver driver);

    boolean driversFine(Driver driver);
}
