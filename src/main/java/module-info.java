module com.example.informe_paperformat {
  requires javafx.controls;
  requires javafx.fxml;

  opens com.example.informe_paperformat to javafx.fxml;
  exports com.example.informe_paperformat;
}