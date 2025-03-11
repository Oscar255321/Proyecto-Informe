package com.example.informe_paperformat;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;

import javax.swing.JFrame;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.swing.JRViewer;

public class PaperformatRecords extends JFrame {

  private static final long serialVersionUID = 1L;

  public void mostrarReport() throws JRException, ClassNotFoundException, SQLException {
    Connection conexionBBDD = getConnection();

    String reportSrcFile = "src/main/java/com/example/informe_paperformat/PaperFormat_A4.jrxml";

    JasperReport jasperReport = JasperCompileManager.compileReport(reportSrcFile);

    HashMap<String, Object> parameters = new HashMap<String, Object>();

    JasperPrint print = JasperFillManager.fillReport(jasperReport, parameters, conexionBBDD);
    JRViewer viewer = new JRViewer(print);
    viewer.setOpaque(true);
    viewer.setVisible(true);
    this.add(viewer);
    this.setSize(800, 600);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setVisible(true);
    System.out.println("Informe generado correctamente!");
  }

  public static Connection getConnection() {
    Connection connection = null;
    String dbName = "Empresa_db";
    String dbPort = "5432";
    String username = "odoo";
    String password = "odoo";

    try {
      Class.forName("org.postgresql.Driver");
      String url = "jdbc:postgresql://localhost:" + dbPort + "/" + dbName;
      connection = DriverManager.getConnection(url, username, password);
    } catch (ClassNotFoundException | SQLException e) {
      e.printStackTrace();
      System.exit(-1);
    }
    return connection;
  }

  public static void main(String[] args) {
    try {
      new PaperformatRecords().mostrarReport();
    } catch (JRException | ClassNotFoundException | SQLException e) {
      e.printStackTrace();
    }
  }
}


