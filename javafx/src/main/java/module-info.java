module org.example.javafx {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;

    opens org.example.javafx to javafx.fxml;
    exports org.example.javafx;
}