package br.edu.ifpb.linkedlistdescriptornode.ListaEncadeadaNoDescritor;

public interface TListaMiniProjeto {

	/**
	 * esse método insere a entrada na lista. No caso de listas ordenadas, a inserção
	 * acontece na posição adequada. No caso de listas desordenadas, a inserção acontece 
	 * no final da lista.
	 * @param s valor a ser guardado na lista
	 * @throws Exception não deve ser possível inserir valores repetidos dentro da lista
	 */
	public void add(String s) throws Exception;
	
	/**
	 * o método remove o elemento que está guardado no índice passado por parâmetro (começando de 0)
	 * @param i índice do qual o elemento será removido
	 * @return retorna o elemento que foi removido da lista
	 * @throws Exception o método lança uma exceção caso o índice passado não exista na lista atualmente
	 */
	public String removeIndex(int i) throws Exception;
	
	/**
	 * o método remove da lista o elemento que foi passado por parâmetro
	 * @param s elemento a ser removido da lista
	 * @throws Exception o método lança uma exceção caso o elemento não faça parte da lista
	 */
	public void removeElem(String s) throws Exception;
	
	/**
	 * retorna o antecessor de um elemento na lista
	 * @param s elemento que se deseja consultar o antecessor
	 * @return o método retorna o antecessor do elemento passado por parâmetro
	 * @throws Exception o método lança uma exceção caso o elemento recebido por parâmetro 
	 * não faça parte da lista ou não possua antecessor (seja o primeiro)
	 */
	public String previous(String s) throws Exception;
	
	/**
	 * o método retorna o índice do elemento recebido por parâmetro dentro da lista (começando de 0)
	 * @param s elemento que se deseja consultar o índice
	 * @return retorna o índice do elemento recebido por parâmetro
	 * @throws Exception lança uma exceção caso o elemento recebido não faça parte da lista
	 */
	public int index(String s) throws Exception;
	
	/**
	 * o método retorna o elemento da lista que está posicionado no índice recebido por parâmetro (começando 
	 * de 0)
	 * @param i índice cujo elemento se deseja consultar
	 * @return reteorna o elemento da lista que está posicionado no índice recebido
	 * @throws Exception lança uma xceção caso a lista não possua esse índice
	 */
	public String elemen(int i) throws Exception;

	/**
	 * @return retorna o tamanho atual da lista
	 */
	public int size();
	
	/**
	 * @return retorna o primeiro elemento da lista (null caso a lista esteja vazia)
	 */
	public String first();

	/**
	 * @return retorna o último elemento da lista (null caso a lista esteja vazia)
	 */
	public String last();

	/**
	 * imprimi no console a lista dos elementos, seguindo o seguinte padrão:
	 * (lista com elementos) LISTA -> "ABC" -> "BCA" -> NULL
	 * (lista vazia) LISTA -> NULL
	 */
	public void print();
}
