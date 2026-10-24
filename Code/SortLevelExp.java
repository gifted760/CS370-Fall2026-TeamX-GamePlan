import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;




public class SortLevelExp extends HBox{
    public SortLevelExp(){

        setSpacing(20); //spacing between

        Button sortB = new Button("Sort"); //sort button

        Button levelL = new Button("Level"); //Level label

        Button expL = new Button("0/5 EXP"); //Exp label

        getChildren().addAll(sortB, levelL, expL);
    }
}
