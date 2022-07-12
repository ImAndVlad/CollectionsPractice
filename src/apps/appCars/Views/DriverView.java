package apps.appCars.Views;

//Написать метод который позволяет управлять автомобилем группе людей,
//        только тем, кто имеет водительское удостоверение, паспорт и
//        отсутствие штрафов в последних 365 дней года.

import apps.appCars.base.Audit;
import apps.appCars.models.Driver;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DriverView implements Audit {



    public void showResult() {

        System.out.println(passport(getDrivers().get(0).age));
        System.out.println(driversFine(getDrivers().get(0).age));

    }

    private List<Driver> getDrivers() {
        List<Driver> drivers = new ArrayList<>();

        drivers.add(new Driver("Tony", 18));
        drivers.add(new Driver("Anna",23));
        drivers.add(new Driver("Tom", 12));
        drivers.add(new Driver("Josh", 39));

        return drivers;
    }

    private int getNum() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("""
                1 - yes
                2 - no
                ENTER:\040""");

        return scanner.nextInt();
    }

    @Override
    public boolean driversLicense(int age) {
        System.out.println("Driver's licence");
        return passport(age) && getNum() == 1;
    }

    @Override
    public boolean passport(int age) {
        return age >= 14;
    }

    @Override
    public boolean driversFine(int age) {
        if (driversLicense(age))
            System.out.println("Driver's Fine");
        else
            return false;
        return  getNum() == 1;
    }
}
