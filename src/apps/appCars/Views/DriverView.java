package apps.appCars.Views;

//Написать метод который позволяет управлять автомобилем группе людей,
//        только тем, кто имеет водительское удостоверение, паспорт и
//        отсутствие штрафов в последних 365 дней года.

import apps.appCars.base.Audit;
import apps.appCars.models.Driver;

import java.util.*;

public class DriverView implements Audit {

    List<Driver> allowsDriveCar;
    List<Driver> notAllowsDriveCar;

    public void showResult() {
        System.out.print("---DRIVER INFORMATION---\n");

        getNewList();

        Map<String, List<Driver>> map = new HashMap<>();
        map.put("\n---DRIVERS WHO ARE ALLOWED TO DRIVE---", allowsDriveCar);
        map.put("\n\n---DRIVERS WHO ARE NOT ALLOWED TO DRIVE---", notAllowsDriveCar);

        System.out.println(map);
    }

    // get two new list (allowed/not allowed)
    private void getNewList() {
        allowsDriveCar = new ArrayList<>();
        notAllowsDriveCar = new ArrayList<>();

        for (int i = 0; i < getDrivers().size(); i++) {
            if (sortList(getDrivers().get(i))) {
                allowsDriveCar.add(getDrivers().get(i));
            } else {
                notAllowsDriveCar.add(getDrivers().get(i));
            }
        }
    }

    // checking for conditions
    private boolean sortList(Driver driver) {
        return passport(driver) && driversLicense(driver) && driversFine(driver);
    }

    // list drivers
    private List<Driver> getDrivers() {
        List<Driver> drivers = new ArrayList<>();
        drivers.add(new Driver("Tony", 18, "yes", 0));
        drivers.add(new Driver("Tom", 12, "yes", 0));
        drivers.add(new Driver("Anna", 23, "yes", 0));
        drivers.add(new Driver("Josh", 34, "no", 0));
        drivers.add(new Driver("Mark", 42, "yes", 3));
        drivers.add(new Driver("Inna", 20, "yes", 0));

        return drivers;
    }

    // driver licence
    @Override
    public boolean driversLicense(Driver driver) {
        return (Objects.equals(driver.licence, "yes"));
    }

    // driver passport
    @Override
    public boolean passport(Driver driver) {
        return driver.age >= 14;
    }

    // the number of driver fines or days without a fine
    @Override
    public boolean driversFine(Driver driver) {
        return driver.fine == 0;
    }
}
