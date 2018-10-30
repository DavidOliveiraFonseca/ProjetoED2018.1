import javafx.scene.Group;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class NoLista extends GridPane{

	Rectangle valorRec;
	Text valorText;
	StackPane valorStack;
	
	Rectangle noRec;
	Arrow noArrow;
	Group noGroup;
	
	public NoLista(String valor) {			
		valorText = new Text(valor);
		valorText.setFont(Font.font("Cambria", 32));
		valorRec = new Rectangle(70.0f, 70.0f);
		valorRec.setStroke(Color.BLACK);
		valorRec.setStrokeWidth(3);
		valorRec.setFill(Color.WHITE);
		valorStack = new StackPane(valorText, valorRec);
		valorText.toFront();
				
		noRec = new Rectangle(70.0f, 70.0f);
		noRec.setStroke(Color.BLACK);
		noRec.setStrokeWidth(3);
		noRec.setFill(Color.WHITE);
		noArrow = new Arrow(noRec.getLayoutX() + 35, noRec.getLayoutY() + 35, (noRec.getLayoutX() + 35) * 3, (noRec.getLayoutX() + 35));
		noArrow.setStrokeWidth(3);
		noGroup = new Group(noRec, noArrow);

		this.add(valorStack, 0, 0);
		this.add(noGroup, 1, 0);
	}
}
