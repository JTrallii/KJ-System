module system.kj.kjsystem {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;

    opens system.kj.kjsystem to javafx.fxml;
    exports system.kj.kjsystem;
}