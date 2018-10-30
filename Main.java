
import java.io.FileInputStream;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.Group;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;

public class Main extends Application {
	
	public static void main(String[] args) {
		launch(args);
	}
	
	
	
	@Override
	public void start(Stage stage) throws Exception {
		
		
		GridPane root = new GridPane();
		root.setHgap(8);
		root.setVgap(5);
		
		root.setPadding(new Insets(6));
		
		// Botões principais
		Button listaSeqButton = new Button("Lista Seq.");
		listaSeqButton.setMinWidth(150);
		root.add(listaSeqButton, 0, 0);
		Button LSEButton = new Button("Lista Enc.");
		root.add(LSEButton, 0, 1);
		LSEButton.setMinWidth(150);
		Button pilhaSeqButton =new Button("Pilha Seq.");
		root.add(pilhaSeqButton, 0, 2);
		pilhaSeqButton.setMinWidth(150);

		Button filaSeqButton = new Button("Fila Seq.");
		root.add(filaSeqButton, 0, 4);
		filaSeqButton.setMinWidth(150);
		Button ABPButton = new Button("ABP");
		root.add(ABPButton, 0, 5);
		ABPButton.setMinWidth(150);
		
		
		// Botões
		Button insereButton = new Button("Insere");
		Button removeButton = new Button("Remove");
		Button buscaPosicaoButton = new Button("Por posição");
		Button buscaElementoButton = new Button("Por elemento");
		Button tamanhoButton = new Button("Tamanho");
		
		// TextFields
		TextField inserePosicaoTextField = new TextField();
		inserePosicaoTextField.setPromptText("Posição");
		
		TextField insereElementoTextField = new TextField();
		insereElementoTextField.setPromptText("Elemento");
		
		TextField removeElementoTextField = new TextField();
		removeElementoTextField.setPromptText("Posição");
		
		TextField buscaTextField = new TextField();
		buscaTextField.setPromptText("Busca");
		
		
		
		// labels
		Label insereLabel = new Label("Insere: ");
		Label removeLabel = new Label("Remove: ");
		Label buscaLabel = new Label("Busca: ");
		Label tamanhoLabel = new Label("Tamanho: ");
		Label tamanhoMostraLabel = new Label();
		Label topoLabel = new Label("Topo: ");
		Label topoMostraLabel = new Label();
		Label primeiroLabel = new Label("Primeiro");
		Label primeiroMostraLabel = new Label();
		Label respostaLabel = new Label();
		Label exibeABP = new Label();
		
		FileInputStream input = new FileInputStream("C:/Users/David/UFPB/ProjetoED/src/shape_square-512.png");
	    Image image = new Image(input);
	    ImageView imageView = new ImageView(image);
		
		
		// Lista Sequencial
		listaSeqButton.setOnMouseClicked((new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				ListaSeq listaSeq = new ListaSeq();
				
				Stage stage = new Stage();
								
				GridPane menu = new GridPane();
				menu.setHgap(8);
				menu.setVgap(5);
				menu.setPadding(new Insets(6));
				menu.setMaxWidth(10000);
				
				
				menu.add(insereLabel, 0, 0);
				menu.add(inserePosicaoTextField, 1, 0);
				menu.add(insereElementoTextField, 2, 0);
				menu.add(insereButton, 3, 0);
				
				menu.add(removeLabel, 0, 1);
				menu.add(removeButton, 2, 1);
				menu.add(removeElementoTextField, 1, 1);
				
				menu.add(buscaLabel, 0, 2);
				menu.add(buscaTextField, 1, 2);
				menu.add(buscaPosicaoButton, 2, 2);
				menu.add(buscaElementoButton, 3, 2);
				menu.add(respostaLabel, 4, 2);
				
				menu.add(tamanhoLabel, 0, 3);
				menu.add(tamanhoMostraLabel, 1, 3);
//				menu.setGridLinesVisible(true);
				
				
				Group group = new Group();							
				menu.add(group, 0, 6, 5, 5);
				
				
//				ScrollBar sc = new ScrollBar();
//		        sc.setMin(0);
//		        sc.setOrientation(Orientation.HORIZONTAL);
//		        sc.setPrefWidth(620);
//		        sc.setMax(360);
//		        group.getChildren().add(sc);
		        
//				Rectangle rect = new Rectangle(200, 200, 100, 100);
//				rect.setStroke(Color.BLACK);
//				rect.setFill(Color.WHITE);
//				rect.setStrokeWidth(3);
//				group.getChildren().add(rect);

				listaSeq.createUI(group);
				
				
				Scene scene = new Scene(menu, 640, 480);
				stage.setScene(scene);
				stage.show();

//				sc.valueProperty().addListener(new ChangeListener<Number>() {
//		            public void changed(ObservableValue<? extends Number> ov,
//		                Number old_val, Number new_val) {
//		                    menu.setLayoutX(-new_val.doubleValue());
//		            }
//		        });
				
				insereButton.setOnMouseClicked((new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent event) {
						listaSeq.insere((Integer.parseInt(inserePosicaoTextField.getText())), (Integer.parseInt(insereElementoTextField.getText())));
						tamanhoMostraLabel.setText(listaSeq.tamanho() + "");
					}
				}));
				removeButton.setOnMouseClicked((new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent event) {
						
						listaSeq.remove(Integer.parseInt(removeElementoTextField.getText()));
						tamanhoMostraLabel.setText(listaSeq.tamanho() + "");
					}
				}));
				
				

				buscaPosicaoButton.setOnMouseClicked((new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent event) {
						respostaLabel.setText( listaSeq.posicao( Integer.parseInt(buscaTextField.getText())) + "" );
					}
				}));
				buscaElementoButton.setOnMouseClicked((new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent event) {
						respostaLabel.setText( listaSeq.elemento( Integer.parseInt(buscaTextField.getText()) ) + "" );
					}
				}));
			}
		}));
		
		// Lista Encadeada
		LSEButton.setOnMouseClicked((new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				LSE lista = new LSE();
				Stage stage = new Stage();

				GridPane menu = new GridPane();
				menu.setHgap(8);
				menu.setVgap(5);
				menu.setPadding(new Insets(6));
				
				menu.add(insereLabel, 0, 0);
				menu.add(inserePosicaoTextField, 1, 0);
				menu.add(insereElementoTextField, 2, 0);
				menu.add(insereButton, 3, 0);
				
				menu.add(removeLabel, 0, 1);
				menu.add(removeButton, 2, 1);
				menu.add(removeElementoTextField, 1, 1);
				
				menu.add(buscaLabel, 0, 2);
				menu.add(buscaTextField, 1, 2);
				menu.add(buscaPosicaoButton, 2, 2);
				menu.add(buscaElementoButton, 3, 2);
				menu.add(respostaLabel, 4, 2);
				
				menu.add(tamanhoLabel, 0, 3);
				
				Group group = new Group();							
				menu.add(group, 0, 6, 5, 5);
				
				Scene scene = new Scene(menu, 640, 480);
				stage.setScene(scene);
				stage.show();
				
				insereButton.setOnMouseClicked((new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent event) {
						lista.insere((Integer.parseInt(inserePosicaoTextField.getText())), (Integer.parseInt(insereElementoTextField.getText())));
						lista.createUI(group, (Integer.parseInt(inserePosicaoTextField.getText())));
						tamanhoMostraLabel.setText(lista.tamanho() + "");
						
					}
				}));
				removeButton.setOnMouseClicked((new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent event) {

						lista.removeUI(group, Integer.parseInt(removeElementoTextField.getText()));
						lista.remove(Integer.parseInt(removeElementoTextField.getText()));
						tamanhoMostraLabel.setText(lista.tamanho() + "");
						
					}
				}));
				buscaPosicaoButton.setOnMouseClicked((new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent event) {
						respostaLabel.setText( lista.posicao( Integer.parseInt(buscaTextField.getText())) + "" );
						
					}
				}));
				buscaElementoButton.setOnMouseClicked((new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent event) {
						respostaLabel.setText( lista.elemento( Integer.parseInt(buscaTextField.getText()) ) + "" );
					}
				}));
			}
		}));
		
		// Pilha Sequencial
		pilhaSeqButton.setOnMouseClicked((new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				PilhaSeq pilhaSeq = new PilhaSeq();
				
				Stage stage = new Stage();
				
				GridPane menu = new GridPane();
				menu.setHgap(8);
				menu.setVgap(5);
				menu.setPadding(new Insets(6));
				
				menu.add(insereLabel, 0, 0);
				menu.add(insereElementoTextField, 1, 0);
				menu.add(insereButton, 2, 0);
				
				menu.add(removeLabel, 0, 1);
				menu.add(removeButton, 1, 1);
				
				
				menu.add(tamanhoLabel, 0, 3);
				menu.add(tamanhoMostraLabel, 1, 3);
				
				menu.add(topoLabel, 2, 3);
				menu.add(topoMostraLabel, 3, 3);
				
				Group group = new Group();							
				menu.add(group, 0, 6, 5, 5);
				
				pilhaSeq.createUI(group);
				
				Scene scene = new Scene(menu, 640, 480);
				stage.setScene(scene);
				stage.show();
				
				insereButton.setOnMouseClicked((new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent event) {
						pilhaSeq.push((Integer.parseInt(insereElementoTextField.getText())));
						topoMostraLabel.setText(pilhaSeq.top() + "");
						tamanhoMostraLabel.setText(pilhaSeq.tamanho() + "");
					}
				}));
				removeButton.setOnMouseClicked((new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent event) {
						
						pilhaSeq.pop();
						topoMostraLabel.setText(pilhaSeq.top() + "");
						tamanhoMostraLabel.setText(pilhaSeq.tamanho() + "");
					}
				}));

			}
		}));
		
		

		// Fila Sequencial
		
		filaSeqButton.setOnMouseClicked((new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				FilaSeq filaSeq = new FilaSeq();
				Stage stage = new Stage();
				
				

				GridPane menu = new GridPane();
				menu.setHgap(8);
				menu.setVgap(5);
				menu.setPadding(new Insets(6));
				
				menu.add(insereLabel, 0, 0);
				menu.add(insereElementoTextField, 1, 0);
				menu.add(insereButton, 2, 0);
				
				menu.add(removeLabel, 0, 1);
				menu.add(removeButton, 2, 1);
								
				menu.add(tamanhoLabel, 0, 2);
				menu.add(tamanhoMostraLabel, 1, 2);
				
				menu.add(primeiroLabel, 0, 3);
				menu.add(primeiroMostraLabel, 1, 3);
				
				
				Group group = new Group();							
				menu.add(group, 0, 6, 5, 5);
				
				filaSeq.createUI(group);
				
				Scene scene = new Scene(menu, 640, 480);
				stage.setScene(scene);
				stage.show();
				
				
				
				insereButton.setOnMouseClicked((new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent event) {
						filaSeq.insere((Integer.parseInt(insereElementoTextField.getText())));
						primeiroMostraLabel.setText(filaSeq.primeiro() + "");
						tamanhoMostraLabel.setText(filaSeq.tamanho() + "");
					}
				}));
				removeButton.setOnMouseClicked((new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent event) {
						
						filaSeq.remove();
						primeiroMostraLabel.setText(filaSeq.primeiro() + "");
						tamanhoMostraLabel.setText(filaSeq.tamanho() + "");
					}
				}));
			}
		}));
		ABPButton.setOnMouseClicked((new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				ABP abp = new ABP();
				Stage stage = new Stage();
				
				

				GridPane menu = new GridPane();
				menu.setHgap(8);
				menu.setVgap(5);
				menu.setPadding(new Insets(6));
				
				menu.add(insereLabel, 0, 0);
				menu.add(insereElementoTextField, 1, 0);
				menu.add(insereButton, 2, 0);
				
				menu.add(exibeABP, 0, 2);
				
				Group group = new Group();							
				menu.add(group, 0, 6, 5, 5);
				
				Scene scene = new Scene(menu, 640, 480);
				stage.setScene(scene);
				stage.show();
				
				
				
				insereButton.setOnMouseClicked((new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent event) {
						abp.insere((Integer.parseInt(insereElementoTextField.getText())));
						exibeABP.setText(abp.exibe());
					}
				}));
			}
		}));
		
		
		Scene scene = new Scene(root);
		stage.setTitle("Projeto de Estrutura de Dados");
		stage.setScene(scene);
		stage.show();
		
		
	}
}
