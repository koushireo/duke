import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.text.Font;
import javafx.scene.*;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Region;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.io.IOException;

public class HelloWorld extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) {
        AnchorPane root = new AnchorPane();
        Rectangle a = new Rectangle(163,0,400,300);
        Rectangle r = new Rectangle(0,0,163,300);
        r.setFill(Color.rgb(43,43,43));
        a.setFill(Color.rgb(86,86,86));
        root.getChildren().add(a);
        root.getChildren().add(r);

        FileInputStream is = null;
        try {
            is = new FileInputStream("pic\\duke.PNG");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Image image = new Image(is);
        ImageView name = new ImageView();
        name.setImage(image);
        root.getChildren().add(name);
        root.setLeftAnchor(name,0.0);
        root.setBottomAnchor(name,0.0);

        Button addButton = new Button("Add");
        Button listButton = new Button("List");
        Button doneButton = new Button("Done");
        Button deleteButton = new Button("Delete");
        Button findButton = new Button("Find");
        Button saveButton = new Button("Save");
        Button loadButton = new Button("Load");
        addButton.setPrefWidth(163.0);
        listButton.setPrefWidth(163.0);
        doneButton.setPrefWidth(163.0);
        deleteButton.setPrefWidth(163.0);
        findButton.setPrefWidth(163.0);
        saveButton.setPrefWidth(163.0);
        loadButton.setPrefWidth(163.0);
        root.getChildren().addAll(addButton,listButton,doneButton,deleteButton,findButton,saveButton,loadButton);
        root.setLeftAnchor(addButton,0.0);
        root.setLeftAnchor(listButton,0.0);
        root.setLeftAnchor(doneButton,0.0);

        root.setLeftAnchor(deleteButton,0.0);
        root.setLeftAnchor(findButton,0.0);
        root.setLeftAnchor(saveButton,0.0);
        root.setLeftAnchor(loadButton,0.0);
        root.setTopAnchor(addButton,0.0);
        root.setTopAnchor(listButton,30.0);
        root.setTopAnchor(doneButton,60.0);
        root.setTopAnchor(deleteButton,90.0);
        root.setTopAnchor(findButton,120.0);
        root.setTopAnchor(saveButton,150.0);
        root.setTopAnchor(loadButton,180.0);


        ScrollPane scroll = new ScrollPane();
        scroll.setPrefSize(400, 270);
        scroll.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scroll.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        scroll.setVvalue(1.0);
        scroll.setFitToWidth(true);
        scroll.setBackground(new Background(new BackgroundFill(Color.rgb(0,199,255), null, null)));
        root.getChildren().add(scroll);
        root.setRightAnchor(scroll,0.0);
        root.setTopAnchor(scroll,0.0);

        VBox dialogContainer = new VBox();
        scroll.setContent(dialogContainer);
        dialogContainer.setPrefHeight(270);
        dialogContainer.setPrefWidth(400);
        dialogContainer.heightProperty().addListener((observable) -> scroll.setVvalue(1.0));
        root.getChildren().add(dialogContainer);
        root.setRightAnchor(dialogContainer,0.0);


        TextField userInput = new TextField();
        userInput.setEditable(false);
        userInput.setDisable(true);
        userInput.setPrefWidth(350.0);
        root.getChildren().add(userInput);
        root.setRightAnchor(userInput,47.0);
        root.setBottomAnchor(userInput,0.0);

        Button sendButton = new Button("Send");
        Button sendaddButton = new Button("Send");
        Button senddoneButton = new Button("Send");
        Button senddeleteButton = new Button("Send");
        Button sendfindButton = new Button("Send");
        root.getChildren().add(sendButton);
        root.getChildren().add(sendaddButton);
        root.getChildren().add(senddoneButton);
        root.getChildren().add(senddeleteButton);
        root.getChildren().add(sendfindButton);
        root.setRightAnchor(sendButton,0.0);
        root.setBottomAnchor(sendButton,0.0);
        root.setRightAnchor(sendaddButton,0.0);
        root.setBottomAnchor(sendaddButton,0.0);
        root.setRightAnchor(senddoneButton,0.0);
        root.setBottomAnchor(senddoneButton,0.0);
        root.setRightAnchor(senddeleteButton,0.0);
        root.setBottomAnchor(senddeleteButton,0.0);
        root.setRightAnchor(sendfindButton,0.0);
        root.setBottomAnchor(sendfindButton,0.0);
        sendaddButton.setManaged(false);
        sendaddButton.setVisible(false);
        senddoneButton.setManaged(false);
        senddoneButton.setVisible(false);
        senddeleteButton.setManaged(false);
        senddeleteButton.setVisible(false);
        sendfindButton.setManaged(false);
        sendfindButton.setVisible(false);

        task todo = new task();

        addButton.setOnMouseClicked((event) -> {
            senddoneButton.setManaged(false);
            senddoneButton.setVisible(false);
            senddeleteButton.setManaged(false);
            senddeleteButton.setVisible(false);
            sendfindButton.setManaged(false);
            sendfindButton.setVisible(false);
            userInput.setEditable(true);
            userInput.setDisable(false);
            sendaddButton.setManaged(true);
            sendaddButton.setVisible(true);
            sendButton.setManaged(false);
        });

        sendaddButton.setOnMouseClicked((event1)-> {
            String response = userInput.getText();
            String[] instruction = response.split(" ");
            dialogContainer.getChildren().add(new Label(instruction[0]));
            if ((!instruction[0].equals("todo")) && (!instruction[0].equals("deadline")) && (!instruction[0].equals("event"))) {
                dialogContainer.getChildren().add(new Label("Unrecognised command"));
            } else if (instruction.length < 2) {
                dialogContainer.getChildren().add(new Label("Please fill in the description of " + instruction[0]));
            } else if (!instruction[0].equals("todo") && !response.contains("/")) {
                dialogContainer.getChildren().add(new Label("Please fill in the time for " + instruction[0]));
            } else {
                ArrayList<String> temp = todo.add(response);
                for (int i = 0; i < temp.size(); i ++) {
                    dialogContainer.getChildren().add(new Label(temp.get(i)));
                }
            }
            userInput.clear();
            userInput.setEditable(false);
            userInput.setDisable(true);
            sendaddButton.setManaged(false);
            sendaddButton.setVisible(false);
            sendButton.setManaged(true);
        });

        listButton.setOnMouseClicked((event2) -> {
            dialogContainer.getChildren().add(new Label("Here are the tasks in your list:"));
            ArrayList<String> temp = todo.list();
            for (int i = 0; i < temp.size(); i ++) {
                dialogContainer.getChildren().add(new Label(temp.get(i)));
            }
        });

        doneButton.setOnMouseClicked((event3) -> {
            sendaddButton.setManaged(false);
            sendaddButton.setVisible(false);
            senddeleteButton.setManaged(false);
            senddeleteButton.setVisible(false);
            sendfindButton.setManaged(false);
            sendfindButton.setVisible(false);
            dialogContainer.getChildren().add(new Label("Here are the tasks in your list:"));
            ArrayList<String> temp = todo.list();
            for (int i = 0; i < temp.size(); i ++) {
                dialogContainer.getChildren().add(new Label(temp.get(i)));
            }
            dialogContainer.getChildren().add(new Label("Which have you done?"));
            userInput.setEditable(true);
            userInput.setDisable(false);
            senddoneButton.setManaged(true);
            senddoneButton.setVisible(true);
            sendButton.setManaged(false);
        });

        senddoneButton.setOnMouseClicked((event4)-> {
            String response = userInput.getText();
            try {
                int b = Integer.parseInt(response);
                if (b < todo.size() + 1) {
                    ArrayList<String> temp = todo.donezo(b);
                    for (int i = 0; i < temp.size(); i ++) {
                        dialogContainer.getChildren().add(new Label(temp.get(i)));
                    }
                } else {
                    dialogContainer.getChildren().add(new Label("Out of range"));
                }
            } catch (NumberFormatException e) {
                dialogContainer.getChildren().add(new Label("Invalid input"));
                dialogContainer.getChildren().add(new Label("done"));
            }
            userInput.clear();
            userInput.setEditable(false);
            userInput.setDisable(true);
            senddoneButton.setManaged(false);
            senddoneButton.setVisible(false);
            sendButton.setManaged(true);
        });

        deleteButton.setOnMouseClicked((event5) -> {
            sendaddButton.setManaged(false);
            sendaddButton.setVisible(false);
            senddoneButton.setManaged(false);
            senddoneButton.setVisible(false);
            sendfindButton.setManaged(false);
            sendfindButton.setVisible(false);
            dialogContainer.getChildren().add(new Label("Here are the tasks in your list:"));
            ArrayList<String> temp = todo.list();
            for (int i = 0; i < temp.size(); i ++) {
                dialogContainer.getChildren().add(new Label(temp.get(i)));
            }
            dialogContainer.getChildren().add(new Label("Which would you like to delete?"));
            userInput.setEditable(true);
            userInput.setDisable(false);
            senddeleteButton.setManaged(true);
            senddeleteButton.setVisible(true);
            sendButton.setManaged(false);
        });

        senddeleteButton.setOnMouseClicked((event6)-> {
            String response = userInput.getText();
            try {
                int b = Integer.parseInt(response);
                if (b < todo.size() + 1) {
                    ArrayList<String> temp = todo.delete(b);
                    for (int i = 0; i < temp.size(); i ++) {
                        dialogContainer.getChildren().add(new Label(temp.get(i)));
                    }
                } else {
                    dialogContainer.getChildren().add(new Label("Out of range"));
                }
            } catch (NumberFormatException e) {
                dialogContainer.getChildren().add(new Label("Invalid input"));
                dialogContainer.getChildren().add(new Label("delete"));
            }
            userInput.clear();
            userInput.setEditable(false);
            userInput.setDisable(true);
            senddeleteButton.setManaged(false);
            senddeleteButton.setVisible(false);
            sendButton.setManaged(true);
        });

        findButton.setOnMouseClicked((event7) -> {
            sendaddButton.setManaged(false);
            sendaddButton.setVisible(false);
            senddoneButton.setManaged(false);
            senddoneButton.setVisible(false);
            senddeleteButton.setManaged(false);
            senddeleteButton.setVisible(false);
            dialogContainer.getChildren().add(new Label("Enter keyword:"));
            userInput.setEditable(true);
            userInput.setDisable(false);
            sendfindButton.setManaged(true);
            sendfindButton.setVisible(true);
            sendButton.setManaged(false);
        });

        sendfindButton.setOnMouseClicked((event8)-> {
            String response = userInput.getText();
            ArrayList<String> temp = todo.find(response);
            for (int i = 0; i < temp.size(); i ++) {
                dialogContainer.getChildren().add(new Label(temp.get(i)));
            }
            userInput.clear();
            userInput.setEditable(false);
            userInput.setDisable(true);
            sendfindButton.setManaged(false);
            sendfindButton.setVisible(false);
            sendButton.setManaged(true);
        });

        saveButton.setOnMouseClicked((event9) -> {
            try {
                ArrayList<String> temp = todo.save();
                for (int i = 0; i < temp.size(); i ++) {
                    dialogContainer.getChildren().add(new Label(temp.get(i)));
                }
            }
            catch (IOException e) {
                System.out.println("Save failed");
            }
        });

        loadButton.setOnMouseClicked((event10) -> {
            try {
                ArrayList<String> temp = todo.load();
                for (int i = 0; i < temp.size(); i ++) {
                    dialogContainer.getChildren().add(new Label(temp.get(i)));
                }
                temp.clear();
                temp = todo.list();
                for (int i = 0; i < temp.size(); i ++) {
                    dialogContainer.getChildren().add(new Label(temp.get(i)));
                }
            }
            catch (IOException e) {
                System.out.println("Load failed");
            }
        });

        Scene scene = new Scene(root); // Setting the scene to be our Label
        stage.setTitle("Duke");
        stage.setResizable(false);
        stage.setMinHeight(300.0);
        stage.setMinWidth(563.0);
        stage.setScene(scene); // Setting the stage to show our screen
        stage.show(); // Render the stage.
    }
}