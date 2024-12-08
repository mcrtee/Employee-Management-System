package com.example.assignment10;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class EmployeeController {
    @FXML private TableView<Employee> employeeTable;
    @FXML private TableColumn<Employee, String> nameColumn;
    @FXML private TableColumn<Employee, String> typeColumn;
    @FXML private TableColumn<Employee, Double> salaryColumn;
    @FXML private TextField nameField;
    @FXML private ComboBox<String> typeDropdown;
    @FXML private TextField hourlyRateField;
    @FXML private TextField hoursField;

    private ObservableList<Employee> employees;

    public void initialize() {
        employees = FXCollections.observableArrayList();
        employeeTable.setItems(employees);

        typeDropdown.setItems(FXCollections.observableArrayList("Full-time", "Part-time", "Contractor"));

        nameColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getName()));
        typeColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getClass().getSimpleName()));
        salaryColumn.setCellValueFactory(data -> new SimpleDoubleProperty(data.getValue().calculateSalary()).asObject());
    }

    @FXML
    private void addEmployee() {
        String name = nameField.getText();
        String type = typeDropdown.getValue();
        double hourlyRate = Double.parseDouble(hourlyRateField.getText());
        int hours = Integer.parseInt(hoursField.getText());

        if (type.equals("Full-time")) {
            employees.add(new FullTimeEmployee(name, hourlyRate));
        } else if (type.equals("Part-time")) {
            employees.add(new PartTimeEmployee(name, hourlyRate, hours));
        } else if (type.equals("Contractor")) {
            employees.add(new Contractor(name, hourlyRate, hours));
        }
        clearFields();
    }

    @FXML
    private void calculateSalaries() {
        employeeTable.refresh();
    }

    private void clearFields() {
        nameField.clear();
        typeDropdown.setValue(null);
        hourlyRateField.clear();
        hoursField.clear();
    }
}
