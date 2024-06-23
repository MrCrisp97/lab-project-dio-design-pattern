package br.com.controller;

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

import br.com.model.Produto;
import br.com.service.impl.ProdutoService;;

@RestController
@RequestMapping("produtos")
public class ProdutoRestController {

    @Autowired(required = false)
    private ProdutoService ProdutoService;

    @PostMapping
    public ResponseEntity<Produto> adicionaProduto(@RequestBody Produto produto) {
        ProdutoService.adicionaProduto(produto.getNome(), produto.getQtd(), produto.getPreco());
        return ResponseEntity.ok(produto);
    }

    @PutMapping("/{id}")
	public ResponseEntity<Produto> atualizaQtd(@PathVariable Long id, @RequestParam int qtd) {
		ProdutoService.atualizaQtd(id, qtd);
		return ResponseEntity.ok().build();
    }

   
    @DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
		ProdutoService.deletar(id);
		return ResponseEntity.ok().build();
	}
    
    @GetMapping("/{id}")
	public ResponseEntity<Produto> buscarPorId(@PathVariable Long id) {
		Produto produto = ProdutoService.buscarPorId(id);
        if (produto != null) {
            return ResponseEntity.ok(ProdutoService.buscarPorId(id));
        } else {
            return ResponseEntity.notFound().build();
        }
	}

    @GetMapping
	public ResponseEntity<Iterable<Produto>> buscarTodos() {
		return ResponseEntity.ok(ProdutoService.buscarTodos());
	}

}