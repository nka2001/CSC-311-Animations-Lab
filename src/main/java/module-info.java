module com.mycompany.animationlab {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.animationlab to javafx.fxml;
    exports com.mycompany.animationlab;
}
