module com.example.assignment10 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.assignment10 to javafx.fxml;
    exports com.example.assignment10;
}