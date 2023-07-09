module com.example.basicprojecttime {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;

    opens com.example.basicprojecttime to javafx.fxml;
    exports com.example.basicprojecttime;
}