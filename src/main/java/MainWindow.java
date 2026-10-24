import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainWindow extends Application {

    @Override
    public void start(Stage stage) {
        // Main window layout
        BorderPane root = new BorderPane();

        // Title
        Label titleLabel = new Label("Welcome to GamePlan!");
        titleLabel.setStyle("-fx-font-size: 26px; -fx-font-weight: bold;");

        VBox topSection = new VBox(titleLabel); 
        topSection.setAlignment(Pos.CENTER);
        topSection.setPadding(new Insets(20));
        root.setTop(topSection);

        // Placeholder task list
        Label taskLabel = new Label("Your tasks will appear here.");
        VBox centerSection = new VBox(taskLabel);
        centerSection.setAlignment(Pos.CENTER);
        root.setCenter(centerSection);

        // Buttons (functionality will be added later)
        Button addButton = new Button("Add Task");
        Button editButton = new Button("Edit Task");
        Button deleteButton = new Button("Delete Task");

        HBox buttonPanel = new HBox(10, addButton, deleteButton, editButton);
        buttonPanel.setAlignment(Pos.CENTER_LEFT);
        buttonPanel.setPadding(new Insets(10));
        
        topSection.getChildren().add(buttonPanel);

        // Display window
        Scene scene = new Scene(root, 800, 500);
        stage.setTitle("GamePlan - Task Manager");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}