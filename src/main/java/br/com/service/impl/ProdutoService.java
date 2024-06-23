package br.com.service.impl;



import br.com.model.Produto;


public interface ProdutoService {

	Iterable<Produto> buscarTodos();

	Produto buscarPorId(Long id);

	void adicionaProduto(String produto, int qtd, double preco);

	void atualizaQtd(Long id, int qtd);

    void atualizaPreco(Long id, double preco);

	void deletar(Long id);

}