package lk.ikse.gdse66.controller;

import javafx.animation.FadeTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainFormControlle {
    public AnchorPane root;
    public ImageView imgCustomer;
    public Label lblMenu;
    public Label lblDescription;
    public ImageView imgItem;
    public ImageView imgOrder;

    public void initialize(URL url, ResourceBundle rb) {
        FadeTransition fadeIn = new FadeTransition(Duration.millis(2000), root);
        fadeIn.setFromValue(0.0);
        fadeIn.setToValue(1.0);
        fadeIn.play();
    }

    public void navigate(MouseEvent event) throws IOException {

        if (event.getSource() instanceof ImageView) {
            ImageView icon = (ImageView) event.getSource();

            Parent root = null;

            switch (icon.getId()) {
                case "imgCustomer":
                    root = FXMLLoader.load(this.getClass().getResource("/lk/ikse/gdse66/view/customer-form.fxml"));
                    break;
                case "imgItem":
                    root = FXMLLoader.load(this.getClass().getResource("/lk/ikse/gdse66/view/item-form.fxml"));
                    break;
                case "imgOrder":
                    root = FXMLLoader.load(this.getClass().getResource("/lk/ikse/gdse66/view/order-form.fxml"));
                    break;
                case "imgViewOrders":
                    root = null;
                    break;
            }

            if (root != null) {
                Scene subScene = new Scene(root);
                Stage primaryStage = (Stage) this.root.getScene().getWindow();
                primaryStage.setScene(subScene);
                primaryStage.centerOnScreen();

                TranslateTransition tt = new TranslateTransition(Duration.millis(350), subScene.getRoot());
                tt.setFromX(-subScene.getWidth());
                tt.setToX(0);
                tt.play();

            }
        }

    }

    public void playMouseEnterAnimation(MouseEvent event) {
        if (event.getSource() instanceof ImageView) {
            ImageView icon = (ImageView) event.getSource();

            switch (icon.getId()) {
                case "imgCustomer":
                    lblMenu.setText("Manage Customers");
                    lblDescription.setText("Click to add, edit, delete, search or lk.ijse.pos.view customers");
                    break;
                case "imgItem":
                    lblMenu.setText("Manage Items");
                    lblDescription.setText("Click to add, edit, delete, search or lk.ijse.pos.view items");
                    break;
                case "imgOrder":
                    lblMenu.setText("Place Orders");
                    lblDescription.setText("Click here if you want to place a new order");
                    break;
                case "imgViewOrders":
                    lblMenu.setText("Search Orders");
                    lblDescription.setText("Click if you want to search orders");
                    break;
            }

            ScaleTransition scaleT = new ScaleTransition(Duration.millis(200), icon);
            scaleT.setToX(1.2);
            scaleT.setToY(1.2);
            scaleT.play();

            DropShadow glow = new DropShadow();
            glow.setColor(Color.CORNFLOWERBLUE);
            glow.setWidth(20);
            glow.setHeight(20);
            glow.setRadius(20);
            icon.setEffect(glow);
        }

    }

    public void playMouseExitAnimation(MouseEvent event) {
        if (event.getSource() instanceof ImageView) {
            ImageView icon = (ImageView) event.getSource();
            ScaleTransition scaleT = new ScaleTransition(Duration.millis(200), icon);
            scaleT.setToX(1);
            scaleT.setToY(1);
            scaleT.play();

            icon.setEffect(null);
            lblMenu.setText("Welcome");
            lblDescription.setText("Please select one of above main operations to proceed");
        }
    }
}
