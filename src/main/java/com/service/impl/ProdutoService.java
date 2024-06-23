package com.service.impl;

import com.model.Produto;

/**
 * Interface que define o padrão <b>Strategy</b> no domínio de cliente. Com
 * isso, se necessário, podemos ter multiplas implementações dessa mesma
 * interface.
 * 
 * @author falvojr
 */
public interface ProdutoService {

	Iterable<Produto> buscarTodos();

	Produto buscarPorId(Long id);

	void adicionaProduto(String produto, int qtd, double preco);

	void atualizaQtd(Long id, int qtd);

    void atualizaPreco(Long id, double preco);

	void deletar(Long id);

}