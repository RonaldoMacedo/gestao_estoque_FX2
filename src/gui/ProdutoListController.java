package gui;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.entities.Produto;
import model.services.ProdutoService;

public class ProdutoListController implements Initializable {
	
	private ProdutoService service;
	
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
	
	private ObservableList<Produto> obsList;
	
	public void setProdutoService(ProdutoService service) { //injeção de dependência
		this.service = service;
	}

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
	
	public void updateTableView() { //metodo que acessa o servico, carrega os produtos e joga-los na observable list
		if(service == null) {
			throw new IllegalStateException("Service was null");
		}
		List<Produto> list = service.findAll();
		obsList = FXCollections.observableArrayList(list);
		listaProduto.setItems(obsList);
	}

}
