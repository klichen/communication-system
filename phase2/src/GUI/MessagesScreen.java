package GUI;

import ControllerLayer.GUIControllers.MessageScreenController;
import ControllerLayer.GUIControllers.SingleMessageScreenController;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.*;
import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;

import java.util.List;

public class MessagesScreen implements ListScreenInterface{
    private SingleMessageScreenController controller;
    private final MessageScreenController thisController = new MessageScreenController();

    @Override
    public void display(List<String> names, List<String> messages) {
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("My Messages");
        window.setMinWidth(300);
        window.setMinHeight(500);

        Label message = new Label("Choose a message to view:");


        VBox layout = new VBox(10);
        layout.getChildren().add(message);
        layout.setAlignment(Pos.CENTER);
        int i = 0;
        for(String name:names){
            Button nameButton = new Button(i+1 + name);
            layout.getChildren().add(nameButton);
            String m = messages.get(i);
            nameButton.setOnAction(e -> {
                SingleMessageScreen msgScreen= new SingleMessageScreen();
                msgScreen.display("Message from " + name, m);

                controller = msgScreen.getController();
                controller.setMessage(m);
            });
            i++;
        }
        Button sentMessages = new Button("My Sent Messages");
        sentMessages.setOnAction(e -> {
            thisController.setOpenSent(true);
            window.close();
        });
        layout.getChildren().add(sentMessages);


        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(layout);
        scrollPane.setFitToWidth(true);

        Scene scene = new Scene(scrollPane, 300, 500);
        window.setScene(scene);
        window.showAndWait();
    }
    public SingleMessageScreenController getController(){
        return controller;
    }
    public MessageScreenController getThisController(){
        return thisController;
    }
}
