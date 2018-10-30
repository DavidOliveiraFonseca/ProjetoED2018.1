import javafx.scene.Group;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class NoSeq extends GridPane{

	Rectangle valorRec;
	Text valorText;
	StackPane valorStack;
	
	Rectangle noRec;
	Arrow noArrow;
	Group noGroup;
	
	public NoSeq() {			
		valorText = new Text();
		valorText.setFont(Font.font("Cambria", 32));
		valorRec = new Rectangle(70.0f, 70.0f);
		valorRec.setStroke(Color.BLACK);
		valorRec.setStrokeWidth(3);
		valorRec.setFill(Color.WHITE);
		valorStack = new StackPane(valorText, valorRec);
		valorText.toFront();
				
		
		this.add(valorStack, 0, 0);
	}
}

