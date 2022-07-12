package apps.appCars.models;

public class Driver {

    public String name;
    public int age;
    public String licence;
    public int fine;

    public Driver(String name, int age, String licence, int fine) {
        this.name = name;
        this.age = age;
        this.licence = licence;
        this.fine = fine;
    }

    @Override
    public String toString() {
        return "\nDriver name: " + name + " Age: " + age +
                " Driver's licence: " + licence + " Driver's fine " + fine;
    }
}
