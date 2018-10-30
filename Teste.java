import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Teste extends Application{
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage arg0) throws Exception {		
		Stage stage = new Stage();
		Group root = new Group();
		Scene scene = new Scene(root, 600, 480);

		GridPane gridPane =  new GridPane();
		
		
		NoArvore noArvore = new NoArvore("1");
		NoArvore noArvore2 = new NoArvore("1");
		NoArvore noArvore3 = new NoArvore("1");
		NoArvore noArvore4 = new NoArvore("1");
		NoArvore noArvore5 = new NoArvore("1");
		
		
		gridPane.add(noArvore, 100, 0);
		gridPane.add(noArvore2, 98, 1);
		gridPane.add(noArvore3, 102, 1);
		gridPane.add(noArvore4, 96, 2);
		gridPane.add(noArvore5, 104, 2);		

		root.getChildren().addAll(gridPane);	
		stage.setScene(scene);
		stage.show();
	}
}
