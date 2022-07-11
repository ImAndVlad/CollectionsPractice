package app.appCats;

public class Cat {

    public String name;
    public String address;

    public Cat(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "\nCat name: " + name + " address: " + address;
    }
}
