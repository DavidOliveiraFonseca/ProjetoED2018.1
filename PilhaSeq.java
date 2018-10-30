import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class PilhaSeq {
	private int xInicial = 70;
	private int yInicial = 470;
	
	
	
	private int dados[]; // Vetor que contém os dados da lista 
	private int topo; 
	private int tamMax;
		
	NoSeq noSeq[];
		
		public void createUI (Group group) {
			for (int i = 0; i < tamMax; i++) {
				this.noSeq[i] = new NoSeq();
				this.noSeq[i].setLayoutY(yInicial - (xInicial * i));
				group.getChildren().addAll(this.noSeq[i]);
			}		
		}
		
	    public PilhaSeq(){
	    		tamMax = 5;
	    		dados = new int[tamMax];
	    		noSeq = new NoSeq[tamMax];
	    		topo = -1;
	    	}
	    
	    public PilhaSeq(int n){
	    		tamMax = n;
	    		dados = new int[tamMax];
	    		noSeq = new NoSeq[tamMax];
	    		topo = -1;
	    }

	    /** Verifica se a Pilha está vazia */
	    public boolean vazia(){
	    		if (topo == -1)
	    			return true;
	    	   else 
	    	      return false;
		}
		
	    /**Verifica se a Pilha está cheia */
	    public boolean cheia(){
	        if (topo == (tamMax-1))
	  		  return true;
	      else
	  		  return false;
		}
		
	    /**Obtém o tamanho da Pilha*/
	    public int tamanho(){
			return topo+1;
		}
	    
	    /** Consulta o elemento do topo da Pilha.
			Retorna -1 se a pilha estiver vazia, 
			caso contrário retorna o valor que está no topo da pilha. */
	 	public int top () {
	      if (vazia()) 
	         return -1; // pilha vazia
	 	  
	      return dados[topo];
	 	}
	     
		 /** Insere um elemento no topo da pilha.
		  Retorna false se a pilha estiver cheia. 
		  Caso contrário retorna true */
	 	public boolean push (int valor) {
	 		if (cheia()) 
	 			return false;  // err: pilha cheia 
	 		
	 		topo++;
	 		dados[topo] = valor; 
	 		noSeq[topo].valorText.setText(valor+"");
	 		return true;
		 }   

		 /** Retira o elemento do topo da pilha.
		  Retorna -1 se a pilha estiver vazia. */
	 	public int pop() {          
	 		if (vazia()) 
	 			return -1; // Pilha vazia
	 		
	 		int valor = dados[topo]; 
	 		noSeq[topo].valorText.setText("");
	 		topo--; 
	 		return valor;
	 	}
	}


