package model.services;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.ProdutoDao;
import model.entities.Produto;

public class ProdutoService {
	
	private ProdutoDao dao = DaoFactory.createProdutoDao();

	public List<Produto> findAll() {
		return dao.findAll();
	}

}
