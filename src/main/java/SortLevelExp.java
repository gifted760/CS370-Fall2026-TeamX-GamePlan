import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;




public class SortLevelExp extends HBox{
    public SortLevelExp(){

        setSpacing(20); //spacing between

        Button sortB = new Button("Sort"); //sort button

        Label levelL = new Label("Level"); //Level label

        Label expL = new Label("0/5 EXP"); //Exp label

        getChildren().addAll(sortB, levelL, expL);
    }
}
