package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Consumer;

import application.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;
import model.services.ProdutoService;

public class TelaPrincipalController implements Initializable {
	
	@FXML
	private MenuItem menuItemNovoProduto;
	
	@FXML
	public void onMenuItemNovoProduto() {
		carregarTela("/gui/TelaCadastroProduto.fxml", x ->{});
	}

	
	@FXML
	private MenuItem menuItemNovoItem;
	
	@FXML
	public void onMenuItemNovoItem() {
		carregarTela("/gui/TelaCadastroItem.fxml", x ->{});
	}
	
	
	@FXML
	private MenuItem menuItemNovoFornecedor;
	
	@FXML
	public void onMenuItemNovoFornecedor() {
		carregarTela("/gui/TelaCadastroFornecedor.fxml", x ->{});
	}
	
	
	@FXML
	private MenuItem menuItemNovoMarca;
	
	@FXML
	public void onMenuItemNovoMarca() {
		carregarTela("/gui/TelaCadastroMarca.fxml", x ->{});
	}
	
	
	@FXML
	private MenuItem menuItemEditarProduto;
	
	@FXML
	public void onMenuItemEditarProduto() {
		carregarTela("/gui/TelaEditarProduto.fxml", x ->{});
	}
	
	
	@FXML
	private MenuItem menuItemEditarItem;
	
	@FXML
	public void onMenuItemEditarItem() {
		carregarTela("/gui/TelaEditarItem.fxml", x ->{});
	}
	
	
	@FXML
	private MenuItem menuItemEditarFornecedor;
	
	@FXML
	public void onMenuItemEditarFornecedor() {
		carregarTela("/gui/TelaEditarFornecedor.fxml", x ->{});
	}
	
	
	@FXML
	private MenuItem menuItemConsultarProduto;
	
	@FXML
	public void onMenuItemConsultarProduto() {
		carregarTela("/gui/TelaConsultarProduto.fxml", (ProdutoListController controller) -> {
			controller.setProdutoService(new ProdutoService());
			controller.updateTableView();
		});
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		// TODO Auto-generated method stub
		
	}
	
	private synchronized <T> void carregarTela(String absoluteName, Consumer<T> initializingAction) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
			VBox newVBox = loader.load();
			
			Scene mainScene = Main.getMainScene();
			VBox mainVBox = (VBox) mainScene.getRoot();
			
			Node mainMenu = mainVBox.getChildren().get(0);
			mainVBox.getChildren().clear();
			mainVBox.getChildren().add(mainMenu);
			mainVBox.getChildren().addAll(newVBox.getChildren());
			
			T controller = loader.getController();
			initializingAction.accept(controller);
		}
		catch(IOException e) {
			e.getMessage();
		}
				
	}

}
