module com.example.informe_paperformat {
  requires javafx.controls;
  requires javafx.fxml;
  requires java.sql;
  requires java.desktop;
  requires jasperreports;

  opens com.example.informe_paperformat to javafx.fxml;
  exports com.example.informe_paperformat;
}