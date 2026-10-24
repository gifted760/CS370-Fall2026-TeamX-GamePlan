import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
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

        // Buttons (edit and delete functionality will be added later)
        Button addButton = new Button("Add Task");
        Button editButton = new Button("Edit Task");
        Button deleteButton = new Button("Delete Task");

        // Button action when clicked
        addButton.setOnAction(e -> openAddTaskDialog(stage));

        HBox buttonPanel = new HBox(10, addButton, deleteButton, editButton);
        buttonPanel.setAlignment(Pos.CENTER_LEFT);
        buttonPanel.setPadding(new Insets(10));
        
        topSection.getChildren().add(buttonPanel);

        // Sort button, level, and EXP display
        SortLevelExp sortLevelExp = new SortLevelExp();
        sortLevelExp.setAlignment(Pos.CENTER_LEFT);
        sortLevelExp.setPadding(new Insets(10));
        topSection.getChildren().add(sortLevelExp);

        // Display window
        Scene scene = new Scene(root, 800, 500);
        stage.setTitle("GamePlan - Task Manager");
        stage.setScene(scene);
        stage.show();
    }

    private void openAddTaskDialog(Stage owner) {
        Stage addTaskDialog = new Stage();
        addTaskDialog.initOwner(owner);
        addTaskDialog.initModality(Modality.WINDOW_MODAL);
        addTaskDialog.setTitle("Add New Task");

        BorderPane dialogRoot = new BorderPane();

        Label titleLabel = new Label("Add New Task");
        titleLabel.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");
        BorderPane.setAlignment(titleLabel, Pos.CENTER);
        dialogRoot.setTop(titleLabel);

        addTaskDialog.setScene(new Scene(dialogRoot, 400, 350));
        addTaskDialog.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
