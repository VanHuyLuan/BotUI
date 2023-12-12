package com.example.botui;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    @FXML
    private TextField chat;

    @FXML
    private VBox chatBox_1;

    @FXML
    private Button phone;

    @FXML
    private Button cam;

    @FXML
    private TextArea chat_box;

    @FXML
    private ImageView image_bot1;

    @FXML
    private ImageView im_bot1;

    @FXML
    private ScrollPane scrollPane;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        init();
    }

    public void init(){
        image_bot1.setClip(new Circle(20 , 20 , 20));
        im_bot1.setClip(new Circle(20, 20 , 20));
    }

    private void scrollDown() {
        scrollPane.setVvalue(scrollPane.getVmax());
    }

    public void SendAction(ActionEvent event){
        String chat_mes = chat.getText();
        String bot_mes = chat_mes.toLowerCase();
        appendMessage( chat_mes);
        chat.setText("");
        String image_bot = "/com/example/css/image/pc.jpg";
        String imagePath = getClass().getResource(image_bot).toExternalForm();
        if(bot_mes.contains("hi")){
            botMessage( "Hello" , imagePath);
        }
        else if(bot_mes.contains("nice to meet you")){
            botMessage( "Nice to meet you too." , imagePath);
        }
        else{
            botMessage("I don't understand you!" , imagePath);
        }
        scrollDown();
    }

    private void botMessage(String message, String imagePath) {
        Label label = new Label(message);
        label.getStyleClass().add("bot-message");

        // Tạo một ImageView để hiển thị ảnh
        ImageView imageView = new ImageView(new Image(imagePath));
        imageView.setClip(new Circle(20, 20, 20));
        imageView.setFitHeight(50); // Điều chỉnh kích thước ảnh theo ý muốn
        imageView.setPreserveRatio(true);

        HBox messageContainer = new HBox(imageView, label);
        messageContainer.getStyleClass().add("message-container");
        messageContainer.setAlignment(Pos.CENTER_LEFT);

        Platform.runLater(() -> {
            chatBox_1.getChildren().add(messageContainer);
            label.setWrapText(true); // Enable text wrapping
        });
    }

    private void appendMessage( String message) {
        Label label = new Label(String.format( message));
        label.getStyleClass().add("user-message");

        HBox messageContainer = new HBox(label);
        messageContainer.getStyleClass().add("message-container");
        messageContainer.setAlignment(Pos.CENTER_RIGHT);

        Platform.runLater(() -> {
            chatBox_1.getChildren().add(messageContainer);
            label.setWrapText(true); // Enable text wrapping
        });
    }


}
