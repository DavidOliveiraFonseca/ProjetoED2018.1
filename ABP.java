
public class ABP {
	public class No {
		private int conteudo;
		private No esq;
		private No dir;
		
//		NoArvore noArvore;
		
		public No(){
			esq = null;
			dir = null;
//			noArvore = new NoArvore("");
		}
		public No(int valor){
			esq = null;
			dir = null;
//			noArvore = new NoArvore("" + valor);
		}
		
		public int getConteudo() {
			return conteudo;
		}
		public void setConteudo(int conteudo) {
			this.conteudo = conteudo;
		}
		
		public No getEsq() {
			return esq;
		}
		public void setEsq(No esq) {
			this.esq = esq;
		}
		
		public No getDir() {
			return dir;
		}
		
		public void setDir(No dir) {
			this.dir = dir;
		}
	}

	
	private No raiz;
	
	public ABP(){
		raiz = null;
	}
	
	/** Verifica se a �rvore est� vazia */
	public boolean vazia (){
		return (raiz == null);
	}

	/**Buscar recursivamente a partir da raiz.
	    Retorna o endere�o se o elemento for
	    encontrado, caso contr�rio retorna NULL*/
	private No busca(No T, int valor) {
		if (T == null)
			return null;  // Arvore Vazia

		if(T.getConteudo() == valor)
			return T; 	// Elem. encontrado na raiz
		
		if (valor < T.getConteudo())
			return busca(T.getEsq(), valor);
	    else
			return busca(T.getDir(), valor);
	}
	
	/**Buscar um elemento na ABP
    		Retorna o endere�o se o elemento for
    		encontrado, caso contr�rio retorna NULL*/
	public No busca(int valor) {          
		if (raiz != null) 
			return busca(raiz, valor);
		
		return null;
	}
	

	/**Exibe o conte�do de uma �rvore no formato in-ordem
	    (preserva a ordena��o)*/
	private String exibe (No T){
		String exibe = "";
		if (T != null) {
			exibe = exibe + " " + exibe(T.getEsq());
			exibe = exibe + " " + T.getConteudo();
			exibe = exibe + " " + exibe(T.getDir());
		}
		return exibe;
	}

	public String exibe() {
		String exibe = "";
		if (raiz == null) {
			exibe = "Arvore vazia";
			return exibe;
		}
		else {
			exibe = exibe(raiz);
			return exibe;
		}
	}
	
	/**Insere um n� em uma �rvore ABP
	    Retorna 1 se a inser��o for com sucesso.
	    Caso contr�rio retorna 0*/
	public boolean insere(int valor){

		No novoNo = new No();
		novoNo.setConteudo(valor);
		novoNo.setEsq(null);
		novoNo.setDir(null);

		if (raiz == null){ // Arvore vazia
	 		raiz = novoNo;
			return true;
		}

	    // Procura a posicao correta pra inserir o novo no
	    No aux = raiz;
	    	No p = null;
	    while (aux != null) {
	    		p = aux;
			if (valor < aux.getConteudo())
				aux = aux.getEsq();
			else
				aux = aux.getDir();
		}

		// Encontrou um n� folha para inserir
		if (valor < p.getConteudo())
			p.setEsq(novoNo);
		else
			p.setDir(novoNo);
		return true;
	}
}
