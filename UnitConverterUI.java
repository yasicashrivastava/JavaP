import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UnitConverterUI extends JFrame implements ActionListener {
    // Components
    private JComboBox<String> conversionTypeComboBox;
    private JTextField inputField, resultField;
    private JComboBox<String> unitComboBox;
    private JButton convertButton;

    public UnitConverterUI() {
        // Frame settings
        setTitle("Unit Converter");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 2, 10, 10)); // Grid layout for easy positioning

        // Labels and combo boxes
        JLabel selectConversionLabel = new JLabel("Select Conversion Type:");
        conversionTypeComboBox = new JComboBox<>(new String[]{"Length", "Weight", "Temperature"});
        conversionTypeComboBox.addActionListener(this);

        JLabel selectUnitLabel = new JLabel("Select Unit:");
        unitComboBox = new JComboBox<>();

        JLabel inputLabel = new JLabel("Enter Value:");
        inputField = new JTextField();

        JLabel resultLabel = new JLabel("Converted Value:");
        resultField = new JTextField();
        resultField.setEditable(false);

        convertButton = new JButton("Convert");
        convertButton.addActionListener(this);

        // Adding components to the frame
        add(selectConversionLabel);
        add(conversionTypeComboBox);
        add(selectUnitLabel);
        add(unitComboBox);
        add(inputLabel);
        add(inputField);
        add(resultLabel);
        add(resultField);
        add(new JLabel()); // Empty cell
        add(convertButton);

        // Set initial unit options
        updateUnits("Length");

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == conversionTypeComboBox) {
            String selectedType = (String) conversionTypeComboBox.getSelectedItem();
            updateUnits(selectedType);
        } else if (e.getSource() == convertButton) {
            convert();
        }
    }

    // Update units based on selected conversion type
    private void updateUnits(String conversionType) {
        unitComboBox.removeAllItems();
        switch (conversionType) {
            case "Length":
                unitComboBox.addItem("Meters to Kilometers");
                unitComboBox.addItem("Kilometers to Meters");
                unitComboBox.addItem("Miles to Kilometers");
                unitComboBox.addItem("Kilometers to Miles");
                break;
            case "Weight":
                unitComboBox.addItem("Kilograms to Pounds");
                unitComboBox.addItem("Pounds to Kilograms");
                break;
            case "Temperature":
                unitComboBox.addItem("Celsius to Fahrenheit");
                unitComboBox.addItem("Fahrenheit to Celsius");
                break;
        }
    }

    // Perform the conversion based on user input
    private void convert() {
        String selectedUnit = (String) unitComboBox.getSelectedItem();
        double inputValue = Double.parseDouble(inputField.getText());
        double result = 0;

        switch (selectedUnit) {
            // Length conversions
            case "Meters to Kilometers":
                result = inputValue / 1000;
                break;
            case "Kilometers to Meters":
                result = inputValue * 1000;
                break;
            case "Miles to Kilometers":
                result = inputValue * 1.60934;
                break;
            case "Kilometers to Miles":
                result = inputValue / 1.60934;
                break;
            // Weight conversions
            case "Kilograms to Pounds":
                result = inputValue * 2.20462;
                break;
            case "Pounds to Kilograms":
                result = inputValue / 2.20462;
                break;
            // Temperature conversions
            case "Celsius to Fahrenheit":
                result = (inputValue * 9 / 5) + 32;
                break;
            case "Fahrenheit to Celsius":
                result = (inputValue - 32) * 5 / 9;
                break;
        }

        resultField.setText(String.format("%.2f", result));
    }

    public static void main(String[] args) {
        // Run the Unit Converter UI
        SwingUtilities.invokeLater(UnitConverterUI::new);
    }
}
