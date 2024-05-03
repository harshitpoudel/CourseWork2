import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.Panel;

public class GadgetShop {
    private ArrayList<Gadget> gadgets; // ArrayList to store gadgets
    private JFrame frame; // Main JFrame for the GUI
    private JTextField modelField, priceField, sizeField, weightField, creditField, memoryField, phoneNumberField, durationField, downloadSizeField, displayNumberField; // TextFields for input
    private JTextArea outputArea; // TextArea for output

    // Constructor to initialize the GUI
    public GadgetShop() {
        gadgets = new ArrayList<>(); // Initialize ArrayList
        frame = new JFrame(); // Initialize JFrame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Set close operation
        frame.setLayout(new BorderLayout()); // Set layout for frame

        // Create JPanel as content pane with GridLayout
        JPanel contentPane = new JPanel();
        contentPane.setLayout(new GridLayout(0, 4, 5, 5)); // 4 columns, variable rows, with 5px horizontal and vertical gaps
        contentPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Set border

        frame.setContentPane(contentPane); // Set content pane of frame

        // Create labels and text fields for various gadget attributes
        JLabel modelLabel = new JLabel("Model:");
        modelField = new JTextField();
        contentPane.add(modelLabel);
        contentPane.add(modelField);

        JLabel priceLabel = new JLabel("Price (£):");
        priceField = new JTextField();
        contentPane.add(priceLabel);
        contentPane.add(priceField);

        JLabel sizeLabel = new JLabel("Size:");
        sizeField = new JTextField();
        contentPane.add(sizeLabel);
        contentPane.add(sizeField);

        JLabel weightLabel = new JLabel("Weight (g):");
        weightField = new JTextField();
        contentPane.add(weightLabel);
        contentPane.add(weightField);

        JLabel creditLabel = new JLabel("Initial Credit (for mobile):");
        creditField = new JTextField();
        contentPane.add(creditLabel);
        contentPane.add(creditField);

        // Buttons for adding mobile and MP3 gadgets
        JButton addMobileButton = new JButton("Add Mobile");
        addMobileButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addMobile();
            }
        });
        contentPane.add(addMobileButton);

        JButton addMP3Button = new JButton("Add MP3");
        addMP3Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addMP3();
            }
        });
        contentPane.add(addMP3Button);

        JLabel memoryLabel = new JLabel("Initial Memory (for MP3):");
        memoryField = new JTextField();
        contentPane.add(memoryLabel);
        contentPane.add(memoryField);

        JLabel phoneNumberLabel = new JLabel("Phone Number:");
        phoneNumberField = new JTextField();
        contentPane.add(phoneNumberLabel);
        contentPane.add(phoneNumberField);

        JLabel durationLabel = new JLabel("Duration (minutes):");
        durationField = new JTextField();
        contentPane.add(durationLabel);
        contentPane.add(durationField);

        JLabel downloadSizeLabel = new JLabel("Download Size (MB):");
        downloadSizeField = new JTextField();
        contentPane.add(downloadSizeLabel);
        contentPane.add(downloadSizeField);

        JLabel displayNumberLabel = new JLabel("Display Number:");
        displayNumberField = new JTextField();
        contentPane.add(displayNumberLabel);
        contentPane.add(displayNumberField);

        // Buttons for displaying all gadgets, making a call, downloading music, clearing fields, and quitting the shop
        JButton displayAllButton = new JButton("Display All");
        displayAllButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                displayAll();
            }
        });
        contentPane.add(displayAllButton);

        JButton makeCallButton = new JButton("Make A Call");
        makeCallButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                makeCall();
            }
        });
        contentPane.add(makeCallButton);

        JButton downloadMusicButton = new JButton("Download Music");
        downloadMusicButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                downloadMusic();
            }
        });
        contentPane.add(downloadMusicButton);

        JButton clearButton = new JButton("Clear");
        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clearFields();
            }
        });
        contentPane.add(clearButton);

        JButton quitButton = new JButton("Leave Shop");
        quitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        contentPane.add(quitButton);

        // TextArea for displaying output
        outputArea = new JTextArea(1, 1);
        JScrollPane scrollPane = new JScrollPane(outputArea);
        contentPane.add(scrollPane, BorderLayout.CENTER);

        frame.pack(); // Pack the components
        frame.setVisible(true); // Make the frame visible
    }

    // Method to show error message dialog
    private void showError(String errorMessage) {
        JOptionPane.showMessageDialog(frame, errorMessage, "Error", JOptionPane.ERROR_MESSAGE);
    }

    // Method to add a mobile gadget
    private void addMobile() {
        // Retrieve input values
        String model = modelField.getText();
        String priceText = priceField.getText();
        String size = sizeField.getText();
        String weightText = weightField.getText();
        String creditText = creditField.getText();

        // Validate input
        if (model.isEmpty() || priceText.isEmpty() || size.isEmpty() || weightText.isEmpty() || creditText.isEmpty()) {
            showError("Please fill in all fields.");
            return;
        }

        double price;
        int weight, credit;

        try {
            price = Double.parseDouble(priceText);
            weight = Integer.parseInt(weightText);
            credit = Integer.parseInt(creditText);
        } catch (NumberFormatException e) {
            showError("Price, weight, and credit must be numeric values.");
            return;
        }

        // Create and add a mobile gadget to the ArrayList
        gadgets.add(new Mobile(model, price, size, weight, credit));
        clearFields(); // Clear input fields
        outputArea.append("Mobile added: " + model + "\n"); // Display output message
        JOptionPane.showMessageDialog(frame, "Mobile added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE); // Show success dialog
    }

    // Method to add an MP3 gadget
    private void addMP3() {
        // Retrieve input values
        String model = modelField.getText();
        String priceText = priceField.getText();
        String size = sizeField.getText();
        String weightText = weightField.getText();
        String memoryText = memoryField.getText();

        // Validate input
        if (model.isEmpty() || priceText.isEmpty() || size.isEmpty() || weightText.isEmpty() || memoryText.isEmpty()) {
            showError("Please fill in all fields.");
            return;
        }

        double price;
        int weight, memory;

        try {
            price = Double.parseDouble(priceText);
            weight = Integer.parseInt(weightText);
            memory = Integer.parseInt(memoryText);

        } catch (NumberFormatException e) {
            showError("Price, weight, and memory must be numeric values.");
            return;
        }

        // Create and add an MP3 gadget to the ArrayList
        gadgets.add(new MP3(model, price, size, weight, memory));
        clearFields(); // Clear input fields
        outputArea.append("MP3 added: " + model + "\n"); // Display output message
        JOptionPane.showMessageDialog(frame, "MP3 added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE); // Show success dialog
    }

    // Method to make a call with a mobile gadget
    private void makeCall() {
        // Retrieve input values
        String phoneNumber = phoneNumberField.getText();
        String durationText = durationField.getText();
        String displayNumberText = displayNumberField.getText();

        // Validate input
        if (phoneNumber.isEmpty() || durationText.isEmpty() || displayNumberText.isEmpty()) {
            showError("Please fill in all fields.");
            return;
        }

        int duration, displayNumber;

        try {
            duration = Integer.parseInt(durationText);
            displayNumber = Integer.parseInt(displayNumberText);

            if (displayNumber < 0 || displayNumber >= gadgets.size()) {
                showError("Invalid display number.");
                return;
            }

            if (!(gadgets.get(displayNumber) instanceof Mobile)) {
                showError("The selected gadget is not a mobile.");
                return;
            }

            JOptionPane.showMessageDialog(frame, "Calling!!"); // Show calling message

            // Make the call using the selected mobile gadget
            Mobile mobile = (Mobile) gadgets.get(displayNumber);
            mobile.makeCall(phoneNumber, duration);

        } catch (NumberFormatException e) {
            showError("Duration and display number must be numeric values.");
        }
    }

    // Method to download music to an MP3 gadget
    private void downloadMusic() {
        // Retrieve input values
        String downloadSizeText = downloadSizeField.getText();
        String displayNumberText = displayNumberField.getText();

        // Validate input
        if (downloadSizeText.isEmpty() || displayNumberText.isEmpty()) {
            showError("Please fill in all fields.");
            return;
        }

        int downloadSize, displayNumber;

        try {
            downloadSize = Integer.parseInt(downloadSizeText);
            displayNumber = Integer.parseInt(displayNumberText);

            if (!(gadgets.get(displayNumber) instanceof MP3)) {
                showError("The selected gadget is not an MP3 player.");
                return;
            }

            JOptionPane.showMessageDialog(frame, "Downloading music"); // Show downloading message
            // Download music to the selected MP3 gadget
            MP3 mp3 = (MP3) gadgets.get(displayNumber);
            mp3.downloadMusic(downloadSize);
        } catch (NumberFormatException e) {
            showError("The size and display number should be numeric values.");
        } catch (IndexOutOfBoundsException e) {
            showError("Invalid display number.");
        }
    }

    // Method to display all gadgets
    private void displayAll() {
        if (gadgets.isEmpty()) {
            outputArea.append("No gadgets to display.\n");
            return;
        }

        outputArea.setText(""); // Clear previous output

        // Iterate through gadgets and display each one
        for (int i = 0; i < gadgets.size(); i++) {
            Gadget gadget = gadgets.get(i);
            outputArea.append("Gadget " + i + ":\n");
            gadget.display();
            outputArea.append("\n");
        }
    }

    // Method to clear input fields
    private void clearFields() {
        // Clear all input fields
        modelField.setText("");
        priceField.setText("");
        sizeField.setText("");
        weightField.setText("");
        creditField.setText("");
        memoryField.setText("");
        phoneNumberField.setText("");
        durationField.setText("");
        downloadSizeField.setText("");
        displayNumberField.setText("");
    }

    // Main method to start the program
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new GadgetShop(); // Create an instance of GadgetShop
            }
        });
    }
}
