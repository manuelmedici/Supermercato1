module net.imparndo.supermercato {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires java.desktop;

    opens net.imparndo.supermercato to javafx.fxml;
    exports net.imparndo.supermercato;
}