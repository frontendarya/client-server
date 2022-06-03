package com.example.democlient;

import com.shared.dto.Message;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Label label_name;

    @FXML
    private Button button_next;

    @FXML
    private RadioButton rb_1, rb_2, rb_3;

    @FXML
    private void initialize() {
        ToggleGroup group = new ToggleGroup();
        rb_1.setToggleGroup(group);
        rb_2.setToggleGroup(group);
        rb_3.setToggleGroup(group);
    }

    public void getChoice(ActionEvent event) {
        if (rb_1.isSelected()){
            label_name.setText("Hi");
        }
    }


//    public void switchToScene2(ActionEvent event) throws IOException {
//        Parent root = FXMLLoader.load(getClass().getResource("second_view.fxml"));
//        stage = ((Stage)((Node)event.getSource()).getScene().getWindow());
//        scene = new Scene(root);
//        stage.setScene(scene);
//        stage.show();
//    }

}
