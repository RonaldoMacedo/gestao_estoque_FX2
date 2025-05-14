package gui;

import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.entities.Produto;

public class ProdutoListController implements Initializable {
	
	@FXML
	private TableView<Produto> listaProduto;
	
	@FXML
	private TableColumn<Produto, Integer> tableColumnCodigo;
	
	@FXML
	private TableColumn<Produto, String> tableColumnDescricaoInterna;
	
	@FXML
	private TableColumn<Produto, String> tableColumnSituacao;
	
	@FXML
	private TableColumn<Produto, Integer> tableColumnSaldo;

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		initializeNodes();
	}

	private void initializeNodes() {
		tableColumnCodigo.setCellValueFactory(new PropertyValueFactory<>("id_produto"));
		tableColumnDescricaoInterna.setCellValueFactory(new PropertyValueFactory<>("descricao_interna"));
		tableColumnSituacao.setCellValueFactory(new PropertyValueFactory<>("situacao"));
		tableColumnSaldo.setCellValueFactory(new PropertyValueFactory<>("saldo"));
		
		Stage stage = (Stage) Main.getMainScene().getWindow();
		listaProduto.prefHeightProperty().bind(stage.heightProperty());
	}

}
