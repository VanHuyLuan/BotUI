package com.example.botui;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class HelloController {

    @FXML
    private TextField chat;

    @FXML
    private TextArea chat_box;

    @FXML
    private Button phone;

    @FXML
    private Button cam;

    public void SendAction(ActionEvent event){
        String chat_mes = chat.getText();
        String bot_mes = chat_mes.toLowerCase();
        appendMessage("You", chat_mes);
        chat.setText("");
        if(bot_mes.contains("hi")){
            botMessage("Bot", "Hello");
        }
        else if(bot_mes.contains("nice to meet you")){
            botMessage("Bot", "Nice to meet you too.");
        }
        else{
            botMessage("Bot", "I don't understand you!");
        }
    }

    private void botMessage(String sender, String message) {
        String formattedMessage = String.format("%s-> %s\n", sender, message);

        chat_box.appendText(formattedMessage);
    }

    private void appendMessage(String sender, String message) {
        String formattedMessage = String.format("%s-> %s\n", sender, message);
        chat_box.appendText(formattedMessage);
        chat_box.getStyleClass().add("user-message");
    }
}
