module org.stevenbruce.occ.proj3 {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.stevenbruce.occ.proj3 to javafx.fxml;
    exports org.stevenbruce.occ.proj3;
}