package com.example.demoserver;

import java.io.*;
import java.net.*;
import java.util.*;

import com.shared.dto.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class Server extends Application {

    private int clientNo = 0;
    private TextArea ta = new TextArea();
    String[]  roles  = new String[] {"Правда, думай сам)",
            "Ложь! Скажи, что ты никогда не прогуливал универ",
            "Ложь! Скажи, что у тебя аллергия на чёрную икру",
            "Ложь! Скажи, что ты не ел яблок",
            "Ложь! Скажи, что у тебя шесть пальцев на ноге",
            "Ложь! Скажи, что в детстве ты хотел сменить пол"};

    @Override
    public void start (Stage primaryStage) throws Exception {
        ta.setEditable(false);

        Scene scene = new Scene(new ScrollPane(ta), 450, 200);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Server");
        primaryStage.show();

        new Thread( () -> {
            try {
                ServerSocket serverSocket = new ServerSocket(8182);
                Platform.runLater( () -> {
                    ta.appendText("Server started time " + new Date() + '\n');
                });

                while (true) {
                    Socket socket = serverSocket.accept();
                    clientNo++;
                    ThreadClient client = new ThreadClient(socket);

                    Platform.runLater( () -> {
                        ta.appendText("Starting client " + clientNo + " at " + new Date() + '\n');
                        ta.appendText("Client " + clientNo + " IP Address is " + socket.getInetAddress().getHostAddress() + '\n');
                    });

                    new Thread(client).start();
                }
            } catch (Exception e) {
                ta.appendText(e.toString() + '\n');
            }
        }).start();
    }

    class ThreadClient implements Runnable {
        ObjectInputStream in;
        ObjectOutputStream out;
        Socket socket;

        ThreadClient(Socket socket) throws IOException {
            this.socket = socket;
            in = new ObjectInputStream(socket.getInputStream());
            out = new ObjectOutputStream(socket.getOutputStream());
        }
            @Override
            public void run () {
                while (true) {
                    try {
                        Message message = (Message) in.readObject();
                        if (equals("Штирлиц (разведчик)", message.getPayload()) ){
                            Message msg = Message.single("В дверь никто не постучал\n" +
                                    "-\"Отец\" – подумал Штирлиц, и заплакал.");
                            out.writeObject(msg);
                        } else if(equals("Доктор", message.getPayload()) ){
                            Message msg = Message.single("- Доктор, вы должны мне помочь, мне постоянно кажется, что я мотылек.\n" +
                                    " - Тогда вам нужно обращаться не ко мне, а к психиатру. \n" +
                                    "- Так я к нему и шел, но у вас свет горит...");
                            out.writeObject(msg);
                        } else if(equals("Программист", message.getPayload()) ){
                            Message msg = Message.single("Сидит программист глубоко в отладке. Подходит сынишка:\n" +
                                    " - Папа, почему солнышко каждый день встает на востоке, а садится на западе?\n" +
                                    " - Ты это проверял? \n" +
                                    "- Проверял. \n" +
                                    "- Хорошо проверял? \n" +
                                    "- Хорошо.\n" +
                                    " - Работает? \n" +
                                    "- Работает. \n" +
                                    "- Каждый день работает? \n" +
                                    "- Да, каждый день. \n" +
                                    "- Тогда ради бога, сынок, ничего не трогай, ничего не меняй.");
                            out.writeObject(msg);
                        } else if(equals("Чукча", message.getPayload()) ){
                            Message msg = Message.single("Идет чукча по дороге, увидел валяется зеркало, он его поднял, посмотрел\n" +
                                    "в него: \"О, мое!!!\"");
                            out.writeObject(msg);
                        } else if(equals("Еврей", message.getPayload()) ){
                            Message msg = Message.single("Идет по улице еврей, видит кошелек, \n" +
                                    "заглядывает туда, а там не хватает");
                            out.writeObject(msg);
                        } else if(equals("Американец", message.getPayload()) ){
                            Message msg = Message.single("Американские школьники с нетерпением ждут каникул. \n" +
                                    "Теперь никаких уроков и тебя не убьют в школе как минимум до осени.");
                            out.writeObject(msg);
                        }

                        ta.appendText("Joke sent\n");
                        Platform.runLater(() -> {
                            ta.appendText("Text received from client: " + message + '\n');
                        });
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        public static boolean equals(String str1, String str2) {
            return str1 == null ? str2 == null : str1.equals(str2);
        }
    }

    public static void main(String[] args) {
            Application.launch(args);
        }
}