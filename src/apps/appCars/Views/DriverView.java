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

    private boolean sortList(Driver driver) {
        return passport(driver) && driversLicense(driver) && driversFine(driver);
    }


    private List<Driver> getDrivers() {
        Driver driver1 = new Driver();
        driver1.name = "Tony";
        driver1.age = 18;
        driver1.licence = "yes";
        driver1.fine = 0;

        Driver driver2 = new Driver();
        driver2.name = "Tom";
        driver2.age = 12;
        driver2.licence = "yes";
        driver2.fine = 0;

        Driver driver3 = new Driver();
        driver3.name = "Anna";
        driver3.age = 23;
        driver3.licence = "yes";
        driver3.fine = 0;

        Driver driver4 = new Driver();
        driver4.name = "Josh";
        driver4.age = 34;
        driver4.licence = "no";
        driver4.fine = 0;

        Driver driver5 = new Driver();
        driver5.name = "Mark";
        driver5.age = 42;
        driver5.licence = "yes";
        driver5.fine = 3;

        List<Driver> drivers = new ArrayList<>();
        drivers.add(driver1);
        drivers.add(driver2);
        drivers.add(driver3);
        drivers.add(driver4);
        drivers.add(driver5);

        return drivers;
    }

    @Override
    public boolean driversLicense(Driver driver) {
        return (Objects.equals(driver.licence, "yes"));
    }

    @Override
    public boolean passport(Driver driver) {
        return driver.age >= 14;
    }

    @Override
    public boolean driversFine(Driver driver) {
        return driver.fine == 0;
    }
}
