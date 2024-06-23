package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.model.Produto;
import com.service.impl.ProdutoService;;

@RestController
@RequestMapping("produtos")
public class ProdutoRestController {

    @Autowired
    private ProdutoService ProdutoService;

    @PostMapping
    public ResponseEntity<String> adicionaProduto(@RequestBody Produto produto) {
        ProdutoService.adicionaProduto(produto.getNome(), produto.getQtd(), produto.getPreco());
        return ResponseEntity.ok("Produto adicionado");
    }

    @PutMapping("/{id}")
	public ResponseEntity<String> atualizaQtd(@PathVariable Long id, @RequestParam int qtd) {
		ProdutoService.atualizaQtd(id, qtd);
		return ResponseEntity.ok("Quantidade do Produto Atualizada");
    }

    @PutMapping("/{id}")
	public ResponseEntity<String> atualizaPreco(@PathVariable Long id, @RequestParam double preco) {
		ProdutoService.atualizaPreco(id, preco);
		return ResponseEntity.ok("Preço do Produto Atualizado");
    }

    @DeleteMapping("/{id}")
	public ResponseEntity<String> deletar(@PathVariable Long id) {
		ProdutoService.deletar(id);
		return ResponseEntity.ok("Produto Removido");
	}
    
    @GetMapping("/{id}")
	public ResponseEntity<Produto> buscarPorId(@PathVariable Long id) {
		Produto produto = ProdutoService.buscarPorId(id);
        if (produto != null) {
            return ResponseEntity.ok(produto);
        } else {
            return ResponseEntity.notFound().build();
        }
	}

    @GetMapping
	public ResponseEntity<Iterable<Produto>> buscarTodos() {
		return ResponseEntity.ok(ProdutoService.buscarTodos());
	}

}