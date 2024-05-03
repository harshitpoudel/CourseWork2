public class Mobile extends Gadget {
    private int creditMinutes; // Credit minutes available for the mobile

    // Constructor to initialize a Mobile object with model, price, size, weight, and credit minutes
    public Mobile(String model, double price, String size, int weight, int creditMinutes) {
        super(model, price, size, weight); // Call the constructor of the superclass (Gadget)
        this.creditMinutes = creditMinutes;
    }

    // Method to add credit minutes to the mobile
    public void addCredit(int additionalMinutes) {
        if (additionalMinutes > 0) {
            creditMinutes += additionalMinutes;
            System.out.println("Added " + additionalMinutes + " minutes of credit.");
        } else {
            System.out.println("Invalid amount. Please enter a positive number of minutes.");
        }
    }

    // Method to make a call from the mobile
    public void makeCall(String phoneNumber, int callDuration) {
        if (callDuration > 0) {
            if (creditMinutes >= callDuration) {
                creditMinutes -= callDuration;
                System.out.println("Making call to " + phoneNumber + " for " + callDuration + " minutes.");
            } else {
                System.out.println("Insufficient credit to make the call.");
            }
        } else {
            System.out.println("Invalid call duration. Please enter a positive number of minutes.");
        }
    }
    
    // Method to display detailed information about the mobile
    @Override
    public void displayDetails() {
        super.displayDetails(); // Call the displayDetails method of the superclass (Gadget)
        System.out.println("Credit minutes remaining: " + creditMinutes);
    }
}
