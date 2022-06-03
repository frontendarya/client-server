package com.example.democlient;

import java.io.*;
import java.net.*;
import com.shared.dto.Message;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import static javafx.scene.text.TextAlignment.CENTER;

public class Client extends Application {

    ObjectOutputStream toServer = null;
    ObjectInputStream fromServer = null;
    Socket socket;

    @Override
    public void start(Stage stage) {
        Label label_tittle1 = new Label("Клиент-серверное приложение по выбору текстов \nюмористического характера, реализованное на JavaFx");
        label_tittle1.setTextAlignment(CENTER);
        label_tittle1.setFont(new Font("Arial", 18));
        label_tittle1.setAlignment(Pos.CENTER);
        AnchorPane.setTopAnchor(label_tittle1, 10.0);
        AnchorPane.setLeftAnchor(label_tittle1, 60.0);
        AnchorPane.setRightAnchor(label_tittle1, 60.0);

        RadioButton rb_nationality = new RadioButton("По национальности");
        rb_nationality.setFont(new Font("Arial", 14));
        rb_nationality.setStyle("-fx-focus-traversable: false;");
        AnchorPane.setTopAnchor(rb_nationality, 150.0);
//        AnchorPane.setBottomAnchor(rb_nationality, 80.0);
        AnchorPane.setLeftAnchor(rb_nationality, 150.0);

        RadioButton rb_profession = new RadioButton("По профессии");
        rb_profession.setStyle("-fx-focus-traversable: false;");
        rb_profession.setFont(new Font("Arial", 14));
        AnchorPane.setTopAnchor(rb_profession, 200.0);
        AnchorPane.setLeftAnchor(rb_profession, 150.0);
//        AnchorPane.setBottomAnchor(rb_profession, 60.0);

        Button button_next = new Button("Дальше");
        button_next.setFont(new Font("Arial", 12));
        button_next.setStyle("-fx-background-color: #A8AB74; -fx-border-color: #A8AB74; ");
        AnchorPane.setTopAnchor(button_next, 300.0);
        AnchorPane.setRightAnchor(button_next, 20.0);
        AnchorPane.setBottomAnchor(button_next, 40.0);

        Label label_exeption1 = new Label();
        AnchorPane.setBottomAnchor(label_exeption1, 10.0);
        AnchorPane.setRightAnchor(label_exeption1, 60.0);
        AnchorPane.setLeftAnchor(label_exeption1, 30.0);


        ToggleGroup group = new ToggleGroup();
        rb_nationality.setToggleGroup(group);
        rb_profession.setToggleGroup(group);

        AnchorPane root = new AnchorPane(label_tittle1, rb_nationality, rb_profession, button_next, label_exeption1);
        root.setStyle("-fx-background-color: #EFF0EB;");



        Label label_tittle2 = new Label("Клиент-серверное приложение по выбору текстов \nюмористического характера, реализованное на JavaFx");
        label_tittle2.setTextAlignment(CENTER);
        label_tittle2.setFont(new Font("Arial", 18));
        label_tittle2.setAlignment(Pos.CENTER);
        AnchorPane.setTopAnchor(label_tittle2, 10.0);
        AnchorPane.setLeftAnchor(label_tittle2, 60.0);
        AnchorPane.setRightAnchor(label_tittle2, 60.0);

        RadioButton rb_american = new RadioButton("Американец");
        rb_american.setStyle("-fx-focus-traversable: false;");
        rb_american.setFont(new Font("Arial", 14));
        AnchorPane.setTopAnchor(rb_american, 150.0);
        AnchorPane.setLeftAnchor(rb_american, 150.0);

        RadioButton rb_jew = new RadioButton("Еврей");
        rb_jew.setStyle("-fx-focus-traversable: false;");
        rb_jew.setFont(new Font("Arial", 14));
        AnchorPane.setTopAnchor(rb_jew, 200.0);
        AnchorPane.setLeftAnchor(rb_jew, 150.0);

        RadioButton rb_chukchi = new RadioButton("Чукча");
        rb_chukchi.setStyle("-fx-focus-traversable: false;");
        rb_chukchi.setFont(new Font("Arial", 14));
        AnchorPane.setTopAnchor(rb_chukchi, 250.0);
        AnchorPane.setLeftAnchor(rb_chukchi, 150.0);

        Button button_next_nationality2 = new Button("Дальше");
        button_next_nationality2.setFont(new Font("Arial", 12));
        button_next_nationality2.setStyle("-fx-background-color: #A8AB74; -fx-border-color: #A8AB74; ");
        AnchorPane.setTopAnchor(button_next_nationality2, 300.0);
        AnchorPane.setRightAnchor(button_next_nationality2, 20.0);
        AnchorPane.setBottomAnchor(button_next_nationality2, 40.0);

        Label label_exeption2 = new Label();
        AnchorPane.setBottomAnchor(label_exeption2, 10.0);
        AnchorPane.setRightAnchor(label_exeption2, 60.0);
        AnchorPane.setLeftAnchor(label_exeption2, 30.0);

        ToggleGroup group_1 = new ToggleGroup();
        rb_american.setToggleGroup(group_1);
        rb_jew.setToggleGroup(group_1);
        rb_chukchi.setToggleGroup(group_1);

        AnchorPane root_nationality = new AnchorPane(label_exeption2, rb_american, rb_jew, rb_chukchi, button_next_nationality2, label_tittle2);
        root_nationality.setStyle("-fx-background-color: #EFF0EB;");




        Label label_tittle3 = new Label("Клиент-серверное приложение по выбору текстов \nюмористического характера, реализованное на JavaFx");
        label_tittle3.setTextAlignment(CENTER);
        label_tittle3.setFont(new Font("Arial", 18));
        label_tittle3.setAlignment(Pos.CENTER);
        AnchorPane.setTopAnchor(label_tittle3, 10.0);
        AnchorPane.setLeftAnchor(label_tittle3, 60.0);
        AnchorPane.setRightAnchor(label_tittle3, 60.0);

        RadioButton rb_proger = new RadioButton("Программист");
        rb_proger.setStyle("-fx-focus-traversable: false;");
        rb_proger.setFont(new Font("Arial", 14));
        AnchorPane.setTopAnchor(rb_proger, 150.0);
        AnchorPane.setLeftAnchor(rb_proger, 150.0);

        RadioButton rb_doctor = new RadioButton("Доктор");
        rb_doctor.setStyle("-fx-focus-traversable: false;");
        rb_doctor.setFont(new Font("Arial", 14));
        AnchorPane.setTopAnchor(rb_doctor, 200.0);
        AnchorPane.setLeftAnchor(rb_doctor, 150.0);

        RadioButton rb_shtirlic = new RadioButton("Штирлиц (разведчик)");
        rb_shtirlic.setStyle("-fx-focus-traversable: false;");
        rb_shtirlic.setFont(new Font("Arial", 14));
        AnchorPane.setTopAnchor(rb_shtirlic, 250.0);
        AnchorPane.setLeftAnchor(rb_shtirlic, 150.0);

        ToggleGroup group_2 = new ToggleGroup();
        rb_proger.setToggleGroup(group_2);
        rb_doctor.setToggleGroup(group_2);
        rb_shtirlic.setToggleGroup(group_2);

        Button button_next_profession2 = new Button("Дальше");
        button_next_profession2.setFont(new Font("Arial", 12));
        button_next_profession2.setStyle("-fx-background-color: #A8AB74; -fx-border-color: #A8AB74; ");
        AnchorPane.setTopAnchor(button_next_profession2, 300.0);
        AnchorPane.setRightAnchor(button_next_profession2, 20.0);
        AnchorPane.setBottomAnchor(button_next_profession2, 40.0);

        Label label_exeption3 = new Label();
        AnchorPane.setBottomAnchor(label_exeption3, 10.0);
        AnchorPane.setRightAnchor(label_exeption3, 60.0);
        AnchorPane.setLeftAnchor(label_exeption3, 30.0);

        AnchorPane root_profession = new AnchorPane(label_exeption3, rb_proger, rb_doctor, rb_shtirlic, button_next_profession2, label_tittle3);
        root_profession.setStyle("-fx-background-color: #EFF0EB;");



        Label label_tittle4 = new Label("Клиент-серверное приложение по выбору текстов \nюмористического характера, реализованное на JavaFx");
        label_tittle4.setTextAlignment(CENTER);
        label_tittle4.setFont(new Font("Arial", 18));
        label_tittle4.setAlignment(Pos.CENTER);
        AnchorPane.setTopAnchor(label_tittle4, 10.0);
        AnchorPane.setLeftAnchor(label_tittle4, 60.0);
        AnchorPane.setRightAnchor(label_tittle4, 60.0);

        Label label_result = new Label();
        label_result.setTextAlignment(CENTER);
        label_result.setFont(new Font("Arial", 14));
        AnchorPane.setTopAnchor(label_result, 100.0);
        AnchorPane.setLeftAnchor(label_result, 50.0);
        AnchorPane.setRightAnchor(label_result, 50.0);
        AnchorPane.setBottomAnchor(label_result, 50.0);

        Button button_again = new Button("Ещё один");
        button_again.setFont(new Font("Arial", 12));
        button_again.setStyle("-fx-background-color: #A8AB74; -fx-border-color: #A8AB74; ");
        AnchorPane.setTopAnchor(button_again, 300.0);
        AnchorPane.setRightAnchor(button_again, 20.0);
        AnchorPane.setBottomAnchor(button_again, 40.0);


        Label label_exeption4 = new Label();
        AnchorPane.setBottomAnchor(label_exeption4, 10.0);
        AnchorPane.setRightAnchor(label_exeption4, 60.0);
        AnchorPane.setLeftAnchor(label_exeption4, 30.0);

        AnchorPane root_result = new AnchorPane(label_exeption4, label_result, button_again, label_tittle4);
        root_result.setStyle("-fx-background-color: #D1D7D7;");




        Scene scene = new Scene(root, 600, 400);
        Scene scene_nationality = new Scene(root_nationality, 600, 400);
        Scene scene_profession = new Scene(root_profession, 600, 400);
        Scene scene_result = new Scene(root_result, 600, 400);
        stage.setScene(scene);

        stage.setTitle("Wow!");

        stage.show();

        try {
            socket = new Socket("localhost", 8182);
            toServer = new ObjectOutputStream(socket.getOutputStream());
            fromServer = new ObjectInputStream(socket.getInputStream());
        } catch (Exception e) {
            label_exeption1.setText(e.toString() + '\n');

        }
        button_next.setOnAction(e -> {
            try {
                if (rb_profession.isSelected() & rb_nationality.isSelected()) {
                    label_exeption1.setText("only one");
                } else if (rb_nationality.isSelected()) {
                    stage.setScene(scene_nationality);
                } else if (rb_profession.isSelected()) {
                    stage.setScene(scene_profession);
                }
            } catch (Exception e2) {
                label_exeption1.setText(e2.toString() + '\n');
            }
        });

        button_next_profession2.setOnAction(e -> {
            try {
                if (rb_doctor.isSelected() & rb_shtirlic.isSelected() & rb_proger.isSelected()) {
                    label_exeption3.setText("only one");
                }
                RadioButton selection = (RadioButton) group_2.getSelectedToggle();
                Message message = Message.single(selection.getText());
                toServer.writeObject(message);
                stage.setScene(scene_result);
                Message result = (Message) fromServer.readObject();
                label_result.setText(result.getPayload() + '\n');
            } catch (Exception e2) {
                label_exeption3.setText(e2.toString() + '\n');
            }
        });

        button_next_nationality2.setOnAction(e -> {
            try {
                if (rb_jew.isSelected() & rb_american.isSelected() & rb_chukchi.isSelected()) {
                    label_exeption2.setText("only one");
                }
                RadioButton selection = (RadioButton) group_1.getSelectedToggle();
                Message message = Message.single(selection.getText());
                toServer.writeObject(message);
                stage.setScene(scene_result);
                Message result = (Message) fromServer.readObject();
                label_result.setText(result.getPayload() + '\n');
            } catch (Exception e2) {
                label_exeption2.setText(e2.toString() + '\n');
            }
        });

        button_again.setOnAction(e -> {
            try {
                button_again.setStyle("-fx-background-color: #66734A;");
                stage.setScene(scene);
            } catch (Exception e2) {
                label_exeption4.setText(e2.toString() + '\n');
            }
        });

    }
        public static void main (String[]args){
            Application.launch(args);
        }
    }
