package model.services;

import java.util.ArrayList;
import java.util.List;

import model.entities.Produto;

public class ProdutoService {

	public List<Produto> findAll() {
		List<Produto> list = new ArrayList<>();
		list.add(new Produto(1, "Luva", "Ativo", 1));
		return list;
	}

}
