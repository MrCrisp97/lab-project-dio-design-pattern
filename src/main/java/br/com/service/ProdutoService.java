package br.com.service;



import br.com.model.Produto;


public interface ProdutoService {

	Iterable<Produto> buscarTodos();

	Produto buscarPorId(Long id);

	void adicionaProduto(Produto produto, String nome, int qtd, double preco);

	void atualizaQtd(Produto produto, Long id, int qtd);

    //void atualizaPreco(Long id, double preco);

	Double calculaTotal();

	void deletar(Long id);

}