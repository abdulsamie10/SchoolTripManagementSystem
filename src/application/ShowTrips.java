package application;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Vector;

import database.SaveTripVector;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ShowTrips {
	//static String getBg = "111111";
    //String getBg = "111111";
	@FXML
    private Button selectID;
	
	@FXML
    private Button yesCon;
	
	@FXML
	private Button noCon;
	
	@FXML
    private Button yesRec;
	
	@FXML
    private Button noRec;
	
    @FXML
    private TextField IDgetter;
    
	@FXML
    private Button home;

    @FXML
    private Button records;

    @FXML
    private Button search;

    @FXML
    private TableColumn<SearchResult, String> tripAct;

    @FXML
    private TableColumn<SearchResult, String> tripBudget;

    @FXML
    private TableColumn<SearchResult, String> tripChks;

    @FXML
    private TableColumn<SearchResult, String> tripDate;

    @FXML
    private TableColumn<SearchResult, String> tripDestination;

    @FXML
    private TableColumn<SearchResult, String> tripID;

    @FXML
    private TableColumn<SearchResult, String> tripOrigin;

    @FXML
    private TableView<SearchResult> tripResults;

    @FXML
    private TableColumn<SearchResult, String> tripStatus;

    @FXML
    void SearchTrip(ActionEvent event) {

    }

    @FXML
    void SeeRecords(ActionEvent event) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Information Dialog");
		alert.setHeaderText(null);
		alert.setContentText("The Receipt has been printed!");
		alert.showAndWait();
    }
	
    @FXML
    void homescreen(ActionEvent event) throws IOException {
    	AnchorPane root;
		root = (AnchorPane)FXMLLoader.load(getClass().getResource("SchoolAdmin.fxml"));
		Scene scene = new Scene(root,750,400);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
		primaryStage.setScene(scene);
		primaryStage.show();
    }
    
	@FXML
    void initialize() throws Exception{
    	if(tripID == null) {
    		//System.out.println("Problemmmm");
    		return;
    	}
    	tripID.setCellValueFactory(cellData->	new SimpleStringProperty(cellData.getValue().getTripID()));
    	tripOrigin.setCellValueFactory(cellData->	new SimpleStringProperty(cellData.getValue().getTripOrigin()));
    	tripDestination.setCellValueFactory(cellData->	new SimpleStringProperty(cellData.getValue().getTripDestination()));
    	tripDate.setCellValueFactory(cellData->	new SimpleStringProperty(cellData.getValue().getTripDate()));
    	tripAct.setCellValueFactory(cellData->	new SimpleStringProperty(cellData.getValue().getTripAct()));
    	tripBudget.setCellValueFactory(cellData->	new SimpleStringProperty(cellData.getValue().getTripBudget()));
    	tripChks.setCellValueFactory(cellData->	new SimpleStringProperty(cellData.getValue().getTripChks()));
    	tripStatus.setCellValueFactory(cellData->	new SimpleStringProperty(cellData.getValue().getTripStatus()));
    	tripResults.setItems(obsList());
    }
    
    private ObservableList<SearchResult> obsList() throws SQLException {
    	System.out.println("Yesss");
    	//String tmp = getBg;
    	//int budgt = Integer.valueOf(tmp);
    	Vector<String> main = new Vector<String>();
    	SaveTripVector s = new SaveTripVector();
    	s.byBudget(main);
    	System.out.println(main.size());
    	ObservableList<SearchResult> bugt= FXCollections.observableArrayList();
    	
    	for(int i=0;i<main.size();) {
    		SearchResult nam1 = new SearchResult();
    		nam1.setTripID(main.get(i));
    		nam1.setTripOrigin(main.get(i+1));
    		nam1.setTripDestination(main.get(i+2));
    		nam1.setTripDate(main.get(i+3));
    		nam1.setTripAct(main.get(i+4));
    		nam1.setTripBudget(main.get(i+5));
    		nam1.setTripChks(main.get(i+6));
    		nam1.setTripStatus(main.get(i+7));
    		i += 8;
    		bugt.add(nam1);
    	}
    	
    	return bugt;
    	}
    //String tmp1;
    @FXML
    void onIDselection(ActionEvent event) throws IOException {
    //	String tmp =  IDgetter.getText();
    //	tmp1 = tmp;
    //	Vector<String> main = new Vector<String>();
    //	SaveTripVector s = new SaveTripVector();
    //	s.byBudget(main);
    //	boolean temp = false;
    //	for(int i = 0;i<main.size();) {
    //		if(tmp.equals(main.get(i))) {
    //			temp = true;
    //		}
    //		i = i+8;
    //	}
   // 	if(temp == true) {
    		AnchorPane root;
    		root = (AnchorPane)FXMLLoader.load(getClass().getResource("IDConfirmation.fxml"));
    		Scene scene = new Scene(root,750,400);
    		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
    		Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
    		primaryStage.setScene(scene);
    		primaryStage.show();
    //	}else {
    	//	Alert alert = new Alert(AlertType.INFORMATION);
    //		alert.setTitle("Information Dialog");
    //		alert.setHeaderText(null);
    //		alert.setContentText("You entered a wrong ID!");
    //		alert.showAndWait();
    //	}
    }
    
    @FXML
    void negCon(ActionEvent event) throws IOException {
    	AnchorPane root;
		root = (AnchorPane)FXMLLoader.load(getClass().getResource("budgetReesults.fxml"));
		Scene scene = new Scene(root,750,400);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
		primaryStage.setScene(scene);
		primaryStage.show();
    }
    
    
    @FXML
    void posCon(ActionEvent event) throws SQLException, IOException {
    	String tmp = IDgetter.getText();
    	Vector<String> main = new Vector<String>();
    	SaveTripVector s = new SaveTripVector();
    	s.byBudget(main);
    	Vector<String> smain = new Vector<String>();
    	for(int i = 0;i<main.size();) {
    		if(tmp.equals(main.get(i))) {
    			//temp = true;
    			smain.add(0, main.get(i));
    			smain.add(1, main.get(i+1));
    			smain.add(2, main.get(i+2));
    			smain.add(3, main.get(i+3));
    			smain.add(4, main.get(i+4));
    			smain.add(5, main.get(i+5));
    			smain.add(6, main.get(i+6));
    			smain.add(7, main.get(i+7));
    		}
    		i = i+8;
    	}
    	UpdateTripStatus u = new UpdateTripStatus(smain);
    	u.updating();
    	FileHandling h = new FileHandling(null);
    	h.savingTemp(smain);
    	
    	AnchorPane root;
		root = (AnchorPane)FXMLLoader.load(getClass().getResource("PrintReciept.fxml"));
		Scene scene = new Scene(root,750,400);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
		primaryStage.setScene(scene);
		primaryStage.show();
    }
    
    @FXML
    void negRec(ActionEvent event) throws IOException {
    	AnchorPane root;
		root = (AnchorPane)FXMLLoader.load(getClass().getResource("Main.fxml"));
		Scene scene = new Scene(root,750,400);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
		primaryStage.setScene(scene);
		primaryStage.show();
    }

    @FXML
    void posRec(ActionEvent event) throws IOException {
    	AnchorPane root;
		root = (AnchorPane)FXMLLoader.load(getClass().getResource("SchoolConfirmation.fxml"));
		Scene scene = new Scene(root,750,400);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
		primaryStage.setScene(scene);
		primaryStage.show();
//    			Alert alert = new Alert(AlertType.INFORMATION);
//        		alert.setTitle("Information Dialog");
//        		alert.setHeaderText(null);
//        		alert.setContentText("The Receipt has been printed!");
//        		alert.showAndWait();
    }
    
    @FXML
    private TextField schName;
    
    @FXML
    private Button okRec;
    
    @FXML
    void printRec(ActionEvent event) throws IOException, FileHandling {
    	String temp1 = ".txt";
    	String temp2 = schName.getText();
    	String temp = temp2.concat(temp1);
    	FileHandling h = new FileHandling(null);
    	h.updateRecords(temp);
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Information Dialog");
		alert.setHeaderText(null);
		alert.setContentText("File saved with the name of temp.txt for reciept!");
		alert.showAndWait();
		AnchorPane root;
		root = (AnchorPane)FXMLLoader.load(getClass().getResource("Main.fxml"));
		Scene scene = new Scene(root,750,400);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
		primaryStage.setScene(scene);
		primaryStage.show();
    }
    
}
