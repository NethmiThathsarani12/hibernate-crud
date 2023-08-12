package lk.ikse.gdse66.controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import lk.ikse.gdse66.bo.BoFactory;
import lk.ikse.gdse66.bo.BoType;
import lk.ikse.gdse66.bo.custom.CustomerBo;
import lk.ikse.gdse66.config.SessionFactoryConfig;
import lk.ikse.gdse66.dto.CustomerDto;
import org.hibernate.Session;

import java.io.IOException;
import java.net.URL;

public class CustomerFormController {
    public Button root;
    public TextField txtId;
    public TextField txtName;
    public TextField txtAddress;
    public TextField txtTp;

    private CustomerBo bo = BoFactory.getBo(BoType.CUSTOMER);

    private  Session session;

    public CustomerFormController(){
        session = SessionFactoryConfig.getInstance().getSession();
    }

    public void navigateToHome(MouseEvent event) throws IOException {

        URL resource = this.getClass().getResource("/lk/ikse/gdse66/view/main-form.fxml");
        Parent root = FXMLLoader.load(resource);
        Scene scene = new Scene(root);
        Stage primaryStage = (Stage) (this.root.getScene().getWindow());
        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();
        Platform.runLater(() -> primaryStage.sizeToScene());
    }

    @FXML
     void btnSaveOnAction(ActionEvent event) {

        String id = txtId.getText();
        String name = txtName.getText();
        String address = txtAddress.getText();
        int tp = Integer.parseInt(txtTp.getText());

        CustomerDto dto = new CustomerDto(id, name, address, tp);
        try {
            boolean isSaved = bo.saveCustomer(dto);

            if(isSaved) {
                new Alert(Alert.AlertType.CONFIRMATION, "Customer Saved!").show();
            }
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }

    }

    public void btnUpdateOnAction(ActionEvent event) {
        String id = txtId.getText();
        String name = txtName.getText();
        String address = txtAddress.getText();
        int tp = Integer.parseInt(txtTp.getText());

        CustomerDto dto = new CustomerDto(id,name,address,tp);

        try {
            boolean isUpdate = bo.updateCustomer(dto);
            if (isUpdate){
                new Alert(Alert.AlertType.CONFIRMATION,"CustomerUpdate!").show();
            }
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    public void btnDeleteOnAction(ActionEvent event) throws Exception {
//        String id = txtId.getText();
//        String name = txtName.getText();
//        String address = txtAddress.getText();
//        int tp = Integer.parseInt(txtTp.getText());
//
//        CustomerDto dto = new CustomerDto(id,name,address,tp);
//        try {
//            boolean isDelete = bo.deleteCustomer(dto);
//            if (isDelete){
//                new Alert(Alert.AlertType.CONFIRMATION,"Customer Deleted").show();
//            }
//        } catch (Exception e) {
//            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
//        }

        String id = txtId.getText();

       CustomerDto dto = new CustomerDto();



        try {
            boolean isDelete = bo.deleteCustomer(id);
            if (isDelete){
                new Alert(Alert.AlertType.CONFIRMATION,"Customer Deleted!").show();
            }

        }catch (Exception e){
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();

        }
    }
}
