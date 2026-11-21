import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;



public class SortLevelExp extends HBox {

    private final Button levelL = new Button("Level 1");
    private final Button expL = new Button("0/100 EXP");
    private final ProgressBar expBar = new ProgressBar(0);
    private final ExpSystem expSystem;

    public SortLevelExp(ExpSystem expSystem) {

        this.expSystem = expSystem;

        setSpacing(20); //spacing between
        setAlignment(Pos.TOP_LEFT);

        expBar.setPrefWidth(120);
        expBar.setPrefHeight(10);

        expBar.setStyle("-fx-accent: #30558F"); //blue theme

        expL.setPrefWidth(120);

        VBox expContainer = new VBox(4, expL, expBar);
        expContainer.setAlignment(Pos.TOP_CENTER);

        getChildren().addAll(levelL, expContainer);
        updateDisplay();
    }

    public void updateDisplay() {
        levelL.setText("Level " + expSystem.getLevel());
        if (expSystem.isMaxLevel()) {
            expL.setText("Max Level");
        } else {
            expL.setText(expSystem.getExpInLevel() + "/" + expSystem.getNextLevelExp() + " EXP");
        }

        //update bar
        expBar.setProgress(expSystem.getProgressToNextLevel());
    }
}
