module edu.virginia.cs.javafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens edu.virginia.cs.javaFXNumberApp to javafx.fxml;
    exports edu.virginia.cs.javaFXNumberApp;
}