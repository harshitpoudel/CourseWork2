public class MP3 extends Gadget {
    private int availableMemory; // Available memory of the MP3 player

    // Constructor to initialize an MP3 object with model, price, size, weight, and available memory
    public MP3(String model, double price, String size, int weight, int availableMemory) {
        super(model, price, size, weight); // Call the constructor of the superclass (Gadget)
        this.availableMemory = availableMemory;
    }

    // Method to download music to the MP3 player
    public void downloadMusic(int downloadSize) {
        if (downloadSize > 0) {
            if (downloadSize <= availableMemory) {
                availableMemory -= downloadSize;
                System.out.println("Music downloaded. Remaining memory: " + availableMemory + " MB");
            } else {
                System.out.println("Insufficient memory to download music.");
            }
        } else {
            System.out.println("Invalid download size. Please enter a positive number of MB.");
        }
    }

    // Method to delete music from the MP3 player
    public void deleteMusic(int deleteSize) {
        if (deleteSize > 0) {
            availableMemory += deleteSize;
            System.out.println("Music deleted. Available memory: " + availableMemory + " MB");
        } else {
            System.out.println("Invalid delete size. Please enter a positive number of MB.");
        }
    }
   
    // Method to display detailed information about the MP3 player
    @Override
    public void displayDetails() {
        super.displayDetails(); // Call the displayDetails method of the superclass (Gadget)
        System.out.println("Available memory: " + availableMemory + " MB");
    }
}
