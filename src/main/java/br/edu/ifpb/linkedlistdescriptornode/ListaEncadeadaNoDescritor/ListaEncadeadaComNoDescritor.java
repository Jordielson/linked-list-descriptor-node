package br.edu.ifpb.linkedlistdescriptornode.ListaEncadeadaNoDescritor;

public class ListaEncadeadaComNoDescritor implements TListaMiniProjeto {
	private TNo inicio;
	private TNo fim;
	private TNo maior;
	private int qtd;
	
	public void add(String s) throws Exception {
		if(qtd == 0) {
			inicio = fim = maior = new TNo(s);
		} else {
			TNo aux = inicio;
			while(aux != null) {
				if(aux.dado.equals(s)) {
					throw new Exception("Valor ja inserido na lista");
				}
				aux = aux.proximo;
			}
			fim.proximo = new TNo(s);
			fim = fim.proximo;
			if(maior.dado.compareToIgnoreCase(s) < 0) {
				maior = fim;
			}
		}
		qtd++;
	}

	public String removeIndex(int i) throws Exception {
		TNo anterior = encontrarAnterior(i);
		return remover(anterior).dado;
	}

	public void removeElem(String s) throws Exception {
		TNo anterior = encontrarAnterior(s);
		remover(anterior);
	}

	public String previous(String s) throws Exception {
		TNo anterior = encontrarAnterior(s);
		if(inicio.dado.equals(s)) {
			throw new Exception("Elemento nao possui antecessor");
		}
		return anterior.dado;
	}

	public int index(String s) throws Exception {
		int i = 0;
		TNo aux = inicio;
		while(aux != null) {
			if(aux.dado.equals(s)) {
				return i;
			}
			i++;
			aux = aux.proximo;
		}
		throw new Exception("Elemento nao encontrado");
	}

	public String elemen(int i) throws Exception {
		return encontrarAnterior(i).proximo.dado;
	}

	public int size() {
		return qtd;
	}

	public String first() {
		if(inicio == null) {
			return null;
		}
		return inicio.dado;
	}

	public String last() {
		return fim != null ? fim.dado : null;
	}

	public void print() {
		System.out.print("LISTA -> ");
		TNo aux = inicio;
		while(aux != null) {
			System.out.print(aux.dado + " -> ");
			aux = aux.proximo;
		}
		System.out.println("NULL");
	}
	
	private void atualizarMaior() {
		maior = inicio;
		TNo aux = inicio;
		while(aux != null) {
			if(aux.dado.compareToIgnoreCase(maior.dado) > 0) {
				maior = aux;
			}
			aux = aux.proximo;
		}
	}
	
	private TNo remover(TNo anterior) {
		TNo aux = anterior.proximo;
		if(aux == inicio) {
			inicio = inicio.proximo;
		} else {
			anterior.proximo = aux.proximo;
		}
		if(fim == aux) {
			fim = anterior;
		}
		if(maior == aux) {
			atualizarMaior();
		}
		aux.proximo = null;
		qtd--;
		return aux;
	}
	
	private TNo encontrarAnterior(String s) throws Exception {
		if(maior.dado.compareToIgnoreCase(s) >= 0) {
			TNo anterior = new TNo(null);
			anterior.proximo = inicio;
			while(anterior.proximo != null) {
				if(anterior.proximo.dado.equals(s)) {
					return anterior;
				}
				anterior = anterior.proximo;
			}
		}
		throw new Exception("Elemento nao encontrado");
	}
	
	private TNo encontrarAnterior(int i) throws Exception {
		if(i < 0 || i >qtd-1) {
			throw new Exception("Indice invalido");
		}
		TNo anterior = new TNo(null);
		anterior.proximo = inicio;
		int index = 0;
		while(index < i) {
			anterior = anterior.proximo;
			index++;
		}
		return anterior;
	}

}
