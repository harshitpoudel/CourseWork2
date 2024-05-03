public class Gadget {
    private String model; // The model of the gadget
    private double price; // The price of the gadget
    private String size; // The size of the gadget
    private int weight; // The weight of the gadget

    // Constructor to initialize a Gadget object with model, price, size, and weight
    public Gadget(String model, double price, String size, int weight) {
        this.model = model;
        this.price = price;
        this.size = size;
        this.weight = weight;
    }

    // Method to display basic information about the gadget
    public void display() {
        System.out.println("Model: " + model);
        System.out.println("Price: £" + price);
        System.out.println("Size: " + size);
        System.out.println("Weight: " + weight + "g");
    }

    // Method to display detailed information about the gadget (same as display() in this case)
    public void displayDetails() {
        System.out.println("Model: " + model);
        System.out.println("Price: £" + price);
        System.out.println("Size: " + size);
        System.out.println("Weight: " + weight + "g");
    }
}
