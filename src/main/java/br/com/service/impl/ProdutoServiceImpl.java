package br.com.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.model.Produto;
import br.com.model.ProdutoRepository;
import br.com.service.ProdutoService;

@Service
public class ProdutoServiceImpl implements ProdutoService{

    @Autowired
	private ProdutoRepository produtoRepository;

    @Override
	public Iterable<Produto> buscarTodos() {
		// Buscar todos os Clientes.
		return produtoRepository.findAll();
	}

	@Override
	public Produto buscarPorId(Long id) {
		// Buscar Cliente por ID.
		Optional<Produto> produto = produtoRepository.findById(id);
		return produto.get();
	}

	@Override
	public void adicionaProduto(Produto produto, String nome, int qtd, double preco) {
		produto.setNome(nome);
        produto.setQtd(qtd);
        produto.setPreco(preco);
        produtoRepository.save(produto);
	}

	@Override
	public void atualizaQtd(Produto produto, Long id, int qtd) {
		// Buscar Cliente por ID, caso exista:
		Optional<Produto> produtoBd = produtoRepository.findById(id);
		if (produtoBd.isPresent()) {
			produto.setQtd(qtd);
		}
        produtoRepository.save(produto);
	}

	@Override
	public void deletar(Long id) {
		// Deletar Cliente por ID.
		produtoRepository.deleteById(id);
	}

    @Override
    public Double calculaTotal(){
        Iterable<Produto> produtos = produtoRepository.findAll();
        double total = 0;
        for (Produto produto : produtos){
            total += produto.getQtd() * produto.getPreco();
        }
        return total;
    }
}
