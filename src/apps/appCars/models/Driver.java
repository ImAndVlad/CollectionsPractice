package apps.appCars.models;

public class Driver {

    public String name;
    public int age;
    public String licence;
    public int fine;


    @Override
    public String toString() {
        return "\nDriver name: " + name + " Age: " + age +
                " Driver's licence: " + licence + " Driver's fine " + fine;
    }
}
