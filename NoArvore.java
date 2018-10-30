import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class NoArvore extends StackPane{
	
	Circle circle;
	Arrow[] arrow;
	Text text;
	
	public NoArvore(String valor) {
		circle = new Circle(40, 40, 35);
		circle.setStroke(Color.BLACK);
		circle.setStrokeWidth(3);
		circle.setFill(Color.WHITE);
		arrow = new Arrow[2];
//		arrow[0] = new Arrow(35, 35, , 35);
//		arrow[1] = new Arrow(0, 0, 40, 70);
//		arrow[0].setStrokeWidth(3);
//		arrow[1].setStrokeWidth(3);
		text = new Text(valor);
		text.setFont(Font.font("Cambria", 32));
		
		this.getChildren().addAll(circle, text, arrow[0], arrow[1]);
	}
}
