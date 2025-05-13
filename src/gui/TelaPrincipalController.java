package gui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;

public class TelaPrincipalController implements Initializable {
	
	@FXML
	private MenuItem menuItemNovoProduto;
	
	@FXML
	public void onMenuItemNovoProduto() {
		System.out.println("Novo produto");
	}
	
	@FXML
	private MenuItem menuItemNovoItem;
	
	@FXML
	public void onMenuItemNovoItem() {
		System.out.println("Novo item");
	}
	
	@FXML
	private MenuItem menuItemNovoFornecedor;
	
	@FXML
	public void onMenuItemNovoFornecedor() {
		System.out.println("Novo fornecedor");
	}
	
	@FXML
	private MenuItem menuItemNovoMarca;
	
	@FXML
	public void onMenuItemNovoMarca() {
		System.out.println("Nova marca");
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		// TODO Auto-generated method stub
		
	}

}
