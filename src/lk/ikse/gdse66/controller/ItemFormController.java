package lk.ikse.gdse66.controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ikse.gdse66.bo.BoFactory;
import lk.ikse.gdse66.bo.BoType;
import lk.ikse.gdse66.bo.custom.ItemBo;
import lk.ikse.gdse66.config.SessionFactoryConfig;
import lk.ikse.gdse66.dto.ItemDto;
import org.hibernate.Session;

import java.io.IOException;
import java.net.URL;

public class ItemFormController {
    public AnchorPane root;
    public TextField txtCode;
    public TextField txtDescription;
    public TextField txtQty;
    public TextField txtPrice;

    private final ItemBo bo = BoFactory.getBo(BoType.ITEM);

    private Session session;

    public ItemFormController(){session = SessionFactoryConfig.getInstance().getSession();
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

    public void btnSaveOnAction(ActionEvent event) {
        String code = txtCode.getText();
        String description = txtDescription.getText();
        double price = Double.parseDouble(txtPrice.getText());
        int qty = Integer.parseInt(txtQty.getText());

        ItemDto dto = new ItemDto(code, description, price, qty);

        try {
            boolean isSaved = bo.saveItem(dto);

            if (isSaved) {
                new Alert(Alert.AlertType.CONFIRMATION, "Item Saved!").show();
            }
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    public void btnUpdateOnAction(ActionEvent event) {

        String code = txtCode.getText();
        String description = txtDescription.getText();
        double price = Double.parseDouble(txtPrice.getText());
        int qty = Integer.parseInt(txtQty.getText());

        ItemDto dto = new ItemDto(code, description, price, qty);

        try {
            boolean isUpdate = bo.updateItem(dto);

            if (isUpdate) {
                new Alert(Alert.AlertType.CONFIRMATION, "Item Update!").show();
            }
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    public void btnDeleteOnAction(ActionEvent event) {

        String code = txtCode.getText();

        ItemDto dto = new ItemDto();

        try {
            boolean isDeleted = bo.deleteItem(code);
            if (isDeleted){
                new Alert(Alert.AlertType.CONFIRMATION,"Item Deleted!").show();

            }
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        }
    }
}
