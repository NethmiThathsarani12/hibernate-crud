package lk.ikse.gdse66.controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ikse.gdse66.bo.BoFactory;
import lk.ikse.gdse66.bo.BoType;
import lk.ikse.gdse66.bo.custom.OrderBo;
import lk.ikse.gdse66.config.SessionFactoryConfig;
import lk.ikse.gdse66.dto.OrderDto;
import org.hibernate.Session;

import java.io.IOException;
import java.net.URL;

public class OrderFormController {
    public AnchorPane root;
    public Label lblTotal;
    public TextField txtOrderId;
    public TextField txtQty;
    public TextField txtDescription;
    public TextField txtPrice;
    public TextField txtCustId;
    public TextField txtItemCode;

    private OrderBo bo = BoFactory.getBo(BoType.ORDER);

    private Session session;

    public OrderFormController(){
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

    public void btnDoneOnAction(ActionEvent event) {
        String oid = txtOrderId.getText();
        String cid = txtCustId.getText();
        String icode = txtItemCode.getText();
        int qty = Integer.parseInt(txtQty.getText());
        double price = Double.parseDouble(txtPrice.getText());
        double total = Double.parseDouble(lblTotal.getText());

        OrderDto dto = new OrderDto(oid,icode,qty,price,cid,total);

        try {
            boolean isSaved = bo.saveOrder(dto);
            if (isSaved){
                new Alert(Alert.AlertType.CONFIRMATION,"Order Saved!").show();
            }

        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        }
    }

    public void btnAddOnAction(ActionEvent event) {
        double total = Double.parseDouble(txtPrice.getText()) * Integer.parseInt(txtQty.getText());
        lblTotal.setText(String.valueOf(total));
    }
}
