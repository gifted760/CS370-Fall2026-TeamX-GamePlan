package com.gameplan;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MainWindow extends Application {

    @Override
    public void start(Stage stage) {
        // Main window layout
        BorderPane root = new BorderPane();

        // Title
        Label titleLabel = new Label("Welcome to GamePlan, let's get started!");
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
        buttonPanel.setAlignment(Pos.CENTER);

        // Level/EXP display and sort buttons
        SortLevelExp sortLevelExp = new SortLevelExp();

        // One row: level/EXP, task buttons, then a spacer pushing the sort buttons right
        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);

        HBox toolbar = new HBox(20, sortLevelExp.getLevelExp(), buttonPanel, spacer, sortLevelExp.getSortButtons());
        toolbar.setAlignment(Pos.CENTER_LEFT);
        toolbar.setPadding(new Insets(10));
        topSection.getChildren().add(toolbar);

        // Calendar view button (functionality will be added later)
        ImageView calendarIcon = new ImageView(new Image(getClass().getResourceAsStream("/calendar.png")));
        calendarIcon.setFitWidth(24);
        calendarIcon.setFitHeight(24);
        calendarIcon.setPreserveRatio(true);
        calendarIcon.setSmooth(true);

        Button calendarButton = new Button();
        calendarButton.setGraphic(calendarIcon);
        HBox bottomSection = new HBox(calendarButton);
        bottomSection.setAlignment(Pos.CENTER_RIGHT);
        bottomSection.setPadding(new Insets(10));
        root.setBottom(bottomSection);

        // Display window
        Scene scene = new Scene(root, 800, 500);
        stage.setTitle("GamePlan - The ULTIMATE Task Manager");
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
