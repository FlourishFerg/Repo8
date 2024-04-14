module com.example.repo8 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.repo8 to javafx.fxml;
    exports com.example.repo8;
}