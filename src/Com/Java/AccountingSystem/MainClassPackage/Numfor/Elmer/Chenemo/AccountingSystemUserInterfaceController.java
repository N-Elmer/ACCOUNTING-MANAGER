package Com.Java.AccountingSystem.MainClassPackage.Numfor.Elmer.Chenemo;

import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javax.swing.JOptionPane;
//import org.apache.poi.hssf.usermodel.HSSFWorkbook;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Workbook;

import Com.Java.AccountingSystem.ModelClassPackage.Numfor.Elmer.Chenemo.SalesModel;
import Com.Java.AccountingSystem.DALPackage.Numfor.Elmer.Chenemo.SalesChartDAO;
import Com.Java.AccountingSystem.DALPackage.Numfor.Elmer.Chenemo.SalesStatisticsDAO;
import Com.Java.AccountingSystem.DALPackage.Numfor.Elmer.Chenemo.SalesDAO;

public class AccountingSystemUserInterfaceController implements Initializable {

    @FXML
    private ImageView salesFileImageView;

    @FXML
    private TextField salesPathTextField;

    @FXML
    private TableView<SalesModel> salesDataTable;

    @FXML
    private TableColumn<SalesModel, String> salesIdColumn;

    @FXML
    private TableColumn<SalesModel, String> salesCustomerColumn;

    @FXML
    private TableColumn<SalesModel, String> salesPhoneColumn;

    @FXML
    private TableColumn<SalesModel, String> salesDescriptionColumn;

    @FXML
    private TableColumn<SalesModel, String> salesQuantityColumn;

    @FXML
    private TableColumn<SalesModel, String> salesPaidColumn;

    @FXML
    private TableColumn<SalesModel, String> salesDateColumn;

    @FXML
    private ListView salesFileListView;

    @FXML
    private ImageView rentsFileImageView;

    @FXML
    private TextField rentsPathTextField;

    @FXML
    private ListView rentsFileListView;

    @FXML
    private TextField salesTotalDisplay1;

    @FXML
    private TextField rentsTotalDisplay1;

    @FXML
    private TextField incomeTotalDisplay1;

    @FXML
    private AreaChart<String, Double> salesChart;

    @FXML
    private TextField salesTotalDisplay2;

    @FXML
    private TextField rentsTotalDisplay2;

    @FXML
    private TextField incomeTotalDisplay2;

    @FXML
    private BarChart<String, Double> rentsChart;

    ObservableList<SalesModel> salesList = FXCollections.observableArrayList();

    ObservableList salesChartList = FXCollections.observableArrayList();

    ObservableList rentsChartList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        salesIdColumn.setCellValueFactory(new PropertyValueFactory<>("Id"));
        salesCustomerColumn.setCellValueFactory(new PropertyValueFactory<>("Customername"));
        salesPhoneColumn.setCellValueFactory(new PropertyValueFactory<>("Phonenumber"));
        salesDescriptionColumn.setCellValueFactory(new PropertyValueFactory<>("Cardescription"));
        salesQuantityColumn.setCellValueFactory(new PropertyValueFactory<>("Quantity"));
        salesPaidColumn.setCellValueFactory(new PropertyValueFactory<>("Totalamount"));
        salesDateColumn.setCellValueFactory(new PropertyValueFactory<>("Date"));
        salesList = SalesDAO.getTableData();
        salesDataTable.setItems(salesList);
        salesDataTable.setEditable(true);
        salesDataTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        salesFileListView.setItems(getDatass());
        salesFileListView.setEditable(true);
        salesFileListView.setCellFactory(TextFieldListCell.forListView());
        salesFileListView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

    }

    private final ObservableList<String> getDatass() {
        ObservableList<String> datass = FXCollections.observableArrayList();
        datass.add(new String("Sales Report1.jpg"));
        datass.add(new String("Sales Report2.jpg"));
        datass.add(new String("Sales Report3.jpg"));
        return datass;
    }

    private final ObservableList<String> getDatass2() {
        ObservableList<String> datass2 = FXCollections.observableArrayList();
        datass2.add(new String("Reports Report1.jpg"));
        datass2.add(new String("Reports Report2.jpg"));
        datass2.add(new String("Reports Report3.jpg"));
        return datass2;
    }

    @FXML
    private void quitMenuButtonHandler(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    private void deleteMenuButtonHandler(ActionEvent event) {
        ObservableList<String> selectedCells, allDatass;
        allDatass = salesFileListView.getItems();
        selectedCells = salesFileListView.getSelectionModel().getSelectedItems();
        for (String datass : selectedCells) {
            allDatass.remove(datass);
        }

        salesFileImageView.setImage(null);

        ObservableList<String> selectedCells2, allDatass2;
        allDatass2 = rentsFileListView.getItems();
        selectedCells2 = rentsFileListView.getSelectionModel().getSelectedItems();
        for (String datass : selectedCells2) {
            allDatass2.remove(datass);
        }

        rentsFileImageView.setImage(null);
    }

    @FXML
    private void openAllMenuButtonHandler(ActionEvent event) {
        FileChooser filechooser = new FileChooser();
        filechooser.setTitle("Select Report");
        filechooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Images", "*.png", "*.jpg", "*.jpeg"));
        File selectedFile = filechooser.showOpenDialog(null);
        if (selectedFile != null) {
            Image image = new Image(selectedFile.toURI().toString());
            salesFileImageView.setImage(image);
            salesFileListView.getItems().add(selectedFile.getName());
            salesPathTextField.setText(selectedFile.getAbsolutePath());
        } else {
            System.out.println("ERROR");
        }

        FileChooser filechooser2 = new FileChooser();
        filechooser2.setTitle("Select Report");
        filechooser2.getExtensionFilters().add(new FileChooser.ExtensionFilter("Images", "*.png", "*.jpg", "*.jpeg"));
        File selectedFile2 = filechooser2.showOpenDialog(null);
        if (selectedFile != null) {
            Image image = new Image(selectedFile2.toURI().toString());
            rentsFileImageView.setImage(image);
            rentsFileListView.getItems().add(selectedFile2.getName());
            rentsPathTextField.setText(selectedFile2.getAbsolutePath());
        } else {
            System.out.println("ERROR");
        }
    }

//    @FXML
//    private void saveAllMenuButtonHandler(ActionEvent event) throws FileNotFoundException, IOException {
//        Workbook workbook = new HSSFWorkbook();
//        Sheet spreadsheet = workbook.createSheet("Sales Report");
//
//        Row row = spreadsheet.createRow(0);
//
//        for (int j = 0; j < salesDataTable.getColumns().size(); j++) {
//            row.createCell(j).setCellValue(salesDataTable.getColumns().get(j).getText());
//        }
//
//        for (int i = 0; i < salesDataTable.getItems().size(); i++) {
//            row = spreadsheet.createRow(i + 1);
//            for (int j = 0; j < salesDataTable.getColumns().size(); j++) {
//                if (salesDataTable.getColumns().get(j).getCellData(i) != null) {
//                    row.createCell(j).setCellValue(salesDataTable.getColumns().get(j).getCellData(i).toString());
//                } else {
//                    row.createCell(j).setCellValue("");
//                }
//            }
//        }
//        FileChooser fileChooser = new FileChooser();
//        fileChooser.getExtensionFilters().addAll(
//                new FileChooser.ExtensionFilter("XLSX files (.xlsx)", ".xlsx"),
//                new FileChooser.ExtensionFilter("XLS files (.xls)", ".xls"),
//                new FileChooser.ExtensionFilter("ODS files (.ods)", ".ods"),
//                new FileChooser.ExtensionFilter("CSV files (.csv)", ".csv"),
//                new FileChooser.ExtensionFilter("HTML files (.html)", ".html")
//        );
//        File saveFile = fileChooser.showSaveDialog(salesDataTable.getScene().getWindow());
//        FileOutputStream fileOut1 = new FileOutputStream("Sales Report.xls");
//        FileOutputStream fileOut2 = new FileOutputStream("Sales Report.jpg");
//        workbook.write(fileOut1);
//        workbook.write(fileOut2);
//        fileOut1.close();
//        fileOut2.close();
//
//        Workbook workbook2 = new HSSFWorkbook();
//        Sheet spreadsheet2 = workbook2.createSheet("Rents Report");
//
//        Row row2 = spreadsheet2.createRow(0);
//
//        FileChooser fileChooser2 = new FileChooser();
//        fileChooser.getExtensionFilters().addAll(
//                new FileChooser.ExtensionFilter("XLSX files (.xlsx)", ".xlsx"),
//                new FileChooser.ExtensionFilter("XLS files (.xls)", ".xls"),
//                new FileChooser.ExtensionFilter("ODS files (.ods)", ".ods"),
//                new FileChooser.ExtensionFilter("CSV files (.csv)", ".csv"),
//                new FileChooser.ExtensionFilter("HTML files (.html)", ".html")
//        );
//        FileOutputStream fileOut3 = new FileOutputStream("Rents Report.xls");
//        FileOutputStream fileOut4 = new FileOutputStream("Rents Report.jpg");
//        workbook2.write(fileOut3);
//        workbook2.write(fileOut4);
//        fileOut3.close();
//        fileOut4.close();
//    }

    @FXML
    private void facebookMenuButtonHandler(ActionEvent event) throws URISyntaxException {
        try {
            Desktop.getDesktop().browse(new URL("https://www.facebook.com/terraxscitech/").toURI());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void instagramMenuButtonHandler(ActionEvent event) {
        try {
            Desktop.getDesktop().browse(new URL("https://www.instagram.com/terraxscitech/").toURI());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void generateAllAnalyticsMenuButtonHandler(ActionEvent event) {
        salesChartList = SalesChartDAO.getChartData();
        XYChart.Series<String, Double> series = new XYChart.Series(salesChartList);
        salesChart.getData().add(series);

        String salesSumCommand = SalesStatisticsDAO.getStatisticsData().toString();
        salesTotalDisplay1.setText(salesSumCommand + " FCFA");

        rentsChartList = SalesChartDAO.getChartData();
        XYChart.Series<String, Double> series2 = new XYChart.Series(rentsChartList);
        rentsChart.getData().add(series2);

        String salesSumCommand2 = SalesStatisticsDAO.getStatisticsData().toString();
        rentsTotalDisplay2.setText(salesSumCommand2 + " FCFA");

        JOptionPane.showMessageDialog(null, "Sales Analytics Successfully Generated");

    }

    @FXML
    private void refreshAllDatabaseMenuButtonHandler(ActionEvent event) {
        try {
            salesIdColumn.setCellValueFactory(new PropertyValueFactory<>("Id"));
            salesCustomerColumn.setCellValueFactory(new PropertyValueFactory<>("Customername"));
            salesPhoneColumn.setCellValueFactory(new PropertyValueFactory<>("Phonenumber"));
            salesDescriptionColumn.setCellValueFactory(new PropertyValueFactory<>("Cardescription"));
            salesQuantityColumn.setCellValueFactory(new PropertyValueFactory<>("Quantity"));
            salesPaidColumn.setCellValueFactory(new PropertyValueFactory<>("Totalamount"));
            salesDateColumn.setCellValueFactory(new PropertyValueFactory<>("Date"));
            salesList = SalesDAO.getTableData();
            salesDataTable.setItems(salesList);
            salesDataTable.setEditable(true);
            salesDataTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
            JOptionPane.showMessageDialog(null, "Sales Worksheet Successfully Updated");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    @FXML
    private void refreshSalesDatabaseButtonHandler(ActionEvent event) {
        try {
            salesIdColumn.setCellValueFactory(new PropertyValueFactory<>("Id"));
            salesCustomerColumn.setCellValueFactory(new PropertyValueFactory<>("Customername"));
            salesPhoneColumn.setCellValueFactory(new PropertyValueFactory<>("Phonenumber"));
            salesDescriptionColumn.setCellValueFactory(new PropertyValueFactory<>("Cardescription"));
            salesQuantityColumn.setCellValueFactory(new PropertyValueFactory<>("Quantity"));
            salesPaidColumn.setCellValueFactory(new PropertyValueFactory<>("Totalamount"));
            salesDateColumn.setCellValueFactory(new PropertyValueFactory<>("Date"));
            salesList = SalesDAO.getTableData();
            salesDataTable.setItems(salesList);
            salesDataTable.setEditable(true);
            salesDataTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
            JOptionPane.showMessageDialog(null, "Sales Worksheet Successfully Updated");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

//    @FXML
//    private void generateSalesReportButtonHandler(ActionEvent event) throws FileNotFoundException, IOException {
//        Workbook workbook = new HSSFWorkbook();
//        Sheet spreadsheet = workbook.createSheet("Sales Report");
//
//        Row row = spreadsheet.createRow(0);
//
//        for (int j = 0; j < salesDataTable.getColumns().size(); j++) {
//            row.createCell(j).setCellValue(salesDataTable.getColumns().get(j).getText());
//        }
//
//        for (int i = 0; i < salesDataTable.getItems().size(); i++) {
//            row = spreadsheet.createRow(i + 1);
//            for (int j = 0; j < salesDataTable.getColumns().size(); j++) {
//                if (salesDataTable.getColumns().get(j).getCellData(i) != null) {
//                    row.createCell(j).setCellValue(salesDataTable.getColumns().get(j).getCellData(i).toString());
//                } else {
//                    row.createCell(j).setCellValue("");
//                }
//            }
//        }
//        FileChooser fileChooser = new FileChooser();
//        fileChooser.getExtensionFilters().addAll(
//                new FileChooser.ExtensionFilter("XLSX files (.xlsx)", ".xlsx"),
//                new FileChooser.ExtensionFilter("XLS files (.xls)", ".xls"),
//                new FileChooser.ExtensionFilter("ODS files (.ods)", ".ods"),
//                new FileChooser.ExtensionFilter("CSV files (.csv)", ".csv"),
//                new FileChooser.ExtensionFilter("HTML files (.html)", ".html")
//        );
//        File saveFile = fileChooser.showSaveDialog(salesDataTable.getScene().getWindow());
//        FileOutputStream fileOut1 = new FileOutputStream("Sales Report.xls");
//        FileOutputStream fileOut2 = new FileOutputStream("Sales Report.jpg");
//        workbook.write(fileOut1);
//        workbook.write(fileOut2);
//        fileOut1.close();
//        fileOut2.close();
//    }

    @FXML
    private void addSalesPreviewButtonHandler(ActionEvent event) {
        FileChooser filechooser = new FileChooser();
        filechooser.setTitle("Select Report");
        filechooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Images", "*.png", "*.jpg", "*.jpeg"));
        File selectedFile = filechooser.showOpenDialog(null);
        if (selectedFile != null) {
            Image image = new Image(selectedFile.toURI().toString());
            salesFileImageView.setImage(image);
            salesFileListView.getItems().add(selectedFile.getName());
            salesPathTextField.setText(selectedFile.getAbsolutePath());
        } else {
            System.out.println("ERROR");
        }
    }

    @FXML
    private void deleteSalesPreviewButtonHandler(ActionEvent event) {
        ObservableList<String> selectedCells, allDatass;
        allDatass = salesFileListView.getItems();
        selectedCells = salesFileListView.getSelectionModel().getSelectedItems();
        for (String datass : selectedCells) {
            allDatass.remove(datass);
        }

        salesFileImageView.setImage(null);
    }

//    @FXML
//    private void generateRentsReportButtonHandler(ActionEvent event) throws FileNotFoundException, IOException {
//        Workbook workbook = new HSSFWorkbook();
//        Sheet spreadsheet = workbook.createSheet("Rents Report");
//
//        Row row = spreadsheet.createRow(0);
//
//        FileChooser fileChooser = new FileChooser();
//        fileChooser.getExtensionFilters().addAll(
//                new FileChooser.ExtensionFilter("XLSX files (.xlsx)", ".xlsx"),
//                new FileChooser.ExtensionFilter("XLS files (.xls)", ".xls"),
//                new FileChooser.ExtensionFilter("ODS files (.ods)", ".ods"),
//                new FileChooser.ExtensionFilter("CSV files (.csv)", ".csv"),
//                new FileChooser.ExtensionFilter("HTML files (.html)", ".html")
//        );
//        FileOutputStream fileOut3 = new FileOutputStream("Rents Report.xls");
//        FileOutputStream fileOut4 = new FileOutputStream("Rents Report.jpg");
//        workbook.write(fileOut3);
//        workbook.write(fileOut4);
//        fileOut3.close();
//        fileOut4.close();
//    }

    @FXML
    private void addRentsPreviewButtonHandler(ActionEvent event) {
        FileChooser filechooser = new FileChooser();
        filechooser.setTitle("Select Report");
        filechooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Images", "*.png", "*.jpg", "*.jpeg"));
        File selectedFile = filechooser.showOpenDialog(null);
        if (selectedFile != null) {
            Image image = new Image(selectedFile.toURI().toString());
            rentsFileImageView.setImage(image);
            rentsFileListView.getItems().add(selectedFile.getName());
            rentsPathTextField.setText(selectedFile.getAbsolutePath());
        } else {
            System.out.println("ERROR");
        }
    }

    @FXML
    private void deleteRentsPreviewButtonHandler(ActionEvent event) {
        ObservableList<String> selectedCells2, allDatass2;
        allDatass2 = rentsFileListView.getItems();
        selectedCells2 = rentsFileListView.getSelectionModel().getSelectedItems();
        for (String datass : selectedCells2) {
            allDatass2.remove(datass);
        }

        rentsFileImageView.setImage(null);
    }

    @FXML
    private void generateSalesAnalyticsButtonHandler(ActionEvent event) throws SQLException {
        salesChartList = SalesChartDAO.getChartData();
        XYChart.Series<String, Double> series = new XYChart.Series(salesChartList);
        salesChart.getData().add(series);

        String salesSumCommand = SalesStatisticsDAO.getStatisticsData().toString();
        salesTotalDisplay1.setText(salesSumCommand + " FCFA");

        JOptionPane.showMessageDialog(null, "Sales Analytics Successfully Generated");
    }

    @FXML
    private void generateRentsAnalyticsButtonHandler(ActionEvent event) {
        rentsChartList = SalesChartDAO.getChartData();
        XYChart.Series<String, Double> series = new XYChart.Series(rentsChartList);
        rentsChart.getData().add(series);

        String salesSumCommand = SalesStatisticsDAO.getStatisticsData().toString();
        rentsTotalDisplay2.setText(salesSumCommand + " FCFA");

        JOptionPane.showMessageDialog(null, "Rents Analytics Successfully Generated");
    }

}
