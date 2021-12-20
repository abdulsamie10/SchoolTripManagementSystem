package application;

import java.io.IOException;
import java.util.Vector;

import Multi_Threads.School_SetUp;
import Multi_Threads.TravelAgency;
import Multi_Threads.threadRemove;
import Multi_Threads.threadStatus;
import database.TripAdd;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
public class MainController {

	
    @FXML
    private Button aLogin;

    @FXML
    private TextField aName;

    @FXML
    private TextField aPass;

    @FXML
    private Button aSign;

    @FXML
    private Button btn1;

    @FXML
    private Button btn2;
    
    @FXML
    private Button btn3;
    
    @FXML
    private TextField aPhone;
    
    @FXML
    private Button newSign;
    
    @FXML
    private Button sLogin;

    @FXML
    private TextField sName;

    @FXML
    private TextField sPass;

    @FXML
    private Button sSign;
    
    @FXML
    private Button sNewSign;

    @FXML
    private TextField smAddress;

    @FXML
    private TextField smEmail;

    @FXML
    private TextField smName;

    @FXML
    private TextField smPass;

    @FXML
    private TextField smPhone;
    
    @FXML
    void homescreen(ActionEvent event) throws IOException {
    	AnchorPane root;
		root = (AnchorPane)FXMLLoader.load(getClass().getResource("Main.fxml"));
		Scene scene = new Scene(root,750,400);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
		primaryStage.setScene(scene);
		primaryStage.show();
    }
    
    @FXML
    void TravelAgency(ActionEvent event) throws IOException {
    	AnchorPane root;
		root = (AnchorPane)FXMLLoader.load(getClass().getResource("TravelAgency.fxml"));
		Scene scene = new Scene(root,750,400);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
		primaryStage.setScene(scene);
		primaryStage.show();
    }
    
    @FXML
    void School(ActionEvent event) throws IOException {
    	AnchorPane root;
		root = (AnchorPane)FXMLLoader.load(getClass().getResource("SchoolMain.fxml"));
		Scene scene = new Scene(root,750,400);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
		primaryStage.setScene(scene);
		primaryStage.show();
    }
    
//    void shifting() {
//    	try {
//    		AnchorPane root;
//    		root = (AnchorPane)FXMLLoader.load(getClass().getResource("SchoolTripMain.fxml"));
//    		Scene scene = new Scene(root,750,400);
//    		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
//    		Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
//    		primaryStage.setScene(scene);
//    		primaryStage.show();
//		} catch(Exception e) {
//			e.printStackTrace();
//		}
//    }
//    
    @FXML
    void mLogin(ActionEvent event) throws IOException {
    	String lName = null, lPass = null;
    	lName = sName.getText();
    	lPass = sPass.getText();
    	School_SetUp sch = new School_SetUp();
    	sch.logIn(lName, lPass);
    	//System.out.println(check);
    	//launch(String [] args);
    	AnchorPane root;
		root = (AnchorPane)FXMLLoader.load(getClass().getResource("SchoolAdmin.fxml"));
		Scene scene = new Scene(root,750,400);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
		primaryStage.setScene(scene);
		primaryStage.show();
    	
    }

    @FXML
    void mSignup(ActionEvent event) throws IOException {
    	AnchorPane root;
		root = (AnchorPane)FXMLLoader.load(getClass().getResource("SchoolSignUp.fxml"));
		Scene scene = new Scene(root,750,400);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
		primaryStage.setScene(scene);
		primaryStage.show();
    }
    
    @FXML
    void mSignUp(ActionEvent event) throws IOException {
    	String sname = smName.getText(), spass = smPass.getText(), saddress = smAddress.getText(), semail = smEmail.getText();
    	int sphone = Integer.valueOf(smPhone.getText());
    	School_SetUp sch = new School_SetUp();
    	sch.signUp(sname, spass, sphone, saddress, semail);
    	Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Information Dialog");
		alert.setHeaderText(null);
		alert.setContentText("A new user has been added!");
		alert.showAndWait();
    	AnchorPane root;
		root = (AnchorPane)FXMLLoader.load(getClass().getResource("SchoolAdmin.fxml"));
		Scene scene = new Scene(root,750,400);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
		primaryStage.setScene(scene);
		primaryStage.show();
//-------------------------------------------Code After Hibernating
    }
    @FXML
    private Button addTrip;
    
    @FXML
    private Button tHome;
    
    @FXML
    void ftnHome(ActionEvent event) throws IOException {
    	AnchorPane root;
		root = (AnchorPane)FXMLLoader.load(getClass().getResource("TravelHome.fxml"));
		Scene scene = new Scene(root,750,400);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
		primaryStage.setScene(scene);
		primaryStage.show();
    }
    
    @FXML
    void ftnAdd(ActionEvent event) throws IOException {
    	AnchorPane root;
		root = (AnchorPane)FXMLLoader.load(getClass().getResource("TripSettings.fxml"));
		Scene scene = new Scene(root,750,400);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
		primaryStage.setScene(scene);
		primaryStage.show();
    }
    
    @FXML
    void tLogin(ActionEvent event) throws IOException {
    	String lName = null, lPass = null;
    	lName = aName.getText();
    	lPass = aPass.getText();
    	System.out.println(lName + " " + lPass);
    	TravelAgency s = new TravelAgency();
    	boolean check = true;
    	s.login(lName, lPass,check);
    	if(check == true) {
    		AnchorPane root;
    		root = (AnchorPane)FXMLLoader.load(getClass().getResource("TravelHome.fxml"));
    		Scene scene = new Scene(root,750,400);
    		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
    		Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
    		primaryStage.setScene(scene);
    		primaryStage.show();
    	}
    }

    @FXML
    void tSignup(ActionEvent event) throws IOException {
    	AnchorPane root;
		root = (AnchorPane)FXMLLoader.load(getClass().getResource("TravelSignUp.fxml"));
		Scene scene = new Scene(root,750,400);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
		primaryStage.setScene(scene);
		primaryStage.show();
    }
    
    @FXML
    void aSignUp(ActionEvent event) throws IOException {
    	int sPhone = 0;
    	String sName = null, sPass = null;
    	sName = aName.getText();
    	sPass = aPass.getText();
    	String tmp = aPhone.getText();
    	sPhone = Integer.valueOf(tmp);
    	TravelAgency s = new TravelAgency();
    	//boolean check = true;
    	s.signup(sName, sPass, sPhone);
    	AnchorPane root;
		root = (AnchorPane)FXMLLoader.load(getClass().getResource("TravelHome.fxml"));
		Scene scene = new Scene(root,750,400);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
		primaryStage.setScene(scene);
		primaryStage.show();
    }
    //------------------------------------------------------------------------------------------Select Trip Screen
    
    @FXML
    private Button sHome;

    @FXML
    private Button records;

    @FXML
    private Button search;
    
    @FXML
    private Button date;

    @FXML
    private Button destination;

    @FXML
    private Button budget;

    @FXML
    private Button origin;
    
    @FXML
    private TextField getBudget;
    
    @FXML
    private Button seachbybudget;

    @FXML
    void SearchTrip(ActionEvent event) throws IOException {
    	AnchorPane root;
		root = (AnchorPane)FXMLLoader.load(getClass().getResource("budgetReesults.fxml"));
		Scene scene = new Scene(root,750,400);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
		primaryStage.setScene(scene);
		primaryStage.show();
    }

    @FXML
    void SeeRecords(ActionEvent event) {
    	Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Information Dialog");
		alert.setHeaderText(null);
		alert.setContentText("Saved with the (your school name).txt. You can see there.");
		alert.showAndWait();
    }

    @FXML 
    void sHomescreen(ActionEvent event) throws IOException {
    	AnchorPane root;
		root = (AnchorPane)FXMLLoader.load(getClass().getResource("SchoolTripMain.fxml"));
		Scene scene = new Scene(root,750,400);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
		primaryStage.setScene(scene);
		primaryStage.show();
    } 
    //-----------------------------------------------------------------------------------Trip Add(Trip Agency)
    @FXML
    private Button fAdd;

    @FXML
    private TextField factivities;

    @FXML
    private TextField fbudget;

    @FXML
    private TextField fcheck;

    @FXML
    private TextField fdate;

    @FXML
    private TextField fdestination;

    @FXML
    private TextField fid;

    @FXML
    private TextField forigin;

    @FXML
    private TextField fstatus;
    @FXML
    void tripAdd(ActionEvent event) throws IOException {
    	Vector<String> vec  = new Vector<String>();
    	vec.add(0, fid.getText());
    	vec.add(1,forigin.getText());
    	vec.add(2,fdestination.getText());
    	vec.add(3, fdate.getText());
    	vec.add(4, factivities.getText());
    	vec.add(5, fbudget.getText());
    	vec.add(6, fcheck.getText());
    	vec.add(7, fstatus.getText());
    	TripAdd t = new TripAdd();
    	t.AddTrip(vec);
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Information Dialog");
		alert.setHeaderText(null);
		alert.setContentText("Trip Added!");
		alert.showAndWait();
		AnchorPane root;
		root = (AnchorPane)FXMLLoader.load(getClass().getResource("Main.fxml"));
		Scene scene = new Scene(root,750,400);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
		primaryStage.setScene(scene);
		primaryStage.show();
    }
    //-------------------------------------------------------------------------Admin Panel Control
    
    @FXML
    private Button adBut;
    
    @FXML
    private Button adminLogin;

    @FXML
    private TextField adminPassword;

    @FXML
    private TextField adminUsername;
    
    @FXML
    private Button statusAgency;
    
    @FXML
    private Button agencyRemove;
    
    @FXML
    private TextField getAgencyID;

    @FXML
    private Button removing;
    
    @FXML
    private Button changeStat;

    @FXML
    private TextField statusAgencyID;
    
    @FXML
    void clickAdmin(ActionEvent event) throws IOException {
    	AnchorPane root;
		root = (AnchorPane)FXMLLoader.load(getClass().getResource("adminLogin.fxml"));
		Scene scene = new Scene(root,750,400);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
		primaryStage.setScene(scene);
		primaryStage.show();
    }
    
    @FXML
    void clickLogin(ActionEvent event) throws IOException {
    	String userN = "samie", userP = "samie";
    	if(userN.equals(adminUsername.getText()) && userP.equals(adminPassword.getText())) {
    		AnchorPane root;
    		root = (AnchorPane)FXMLLoader.load(getClass().getResource("adminControl.fxml"));
    		Scene scene = new Scene(root,750,400);
    		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
    		Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
    		primaryStage.setScene(scene);
    		primaryStage.show();
    	}else {
    		Alert alert = new Alert(AlertType.INFORMATION);
    		alert.setTitle("Information Dialog");
    		alert.setHeaderText(null);
    		alert.setContentText("Incorrect Username or password!");
    		alert.showAndWait();
    	}
    }
    
    @FXML
    void clickRemove(ActionEvent event) throws IOException {
    	AnchorPane root;
		root = (AnchorPane)FXMLLoader.load(getClass().getResource("RemoveAgency.fxml"));
		Scene scene = new Scene(root,750,400);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
		primaryStage.setScene(scene);
		primaryStage.show();
    }
    
    @FXML
    void clickRemoving(ActionEvent event) throws IOException {
    	String agencyID = getAgencyID.getText();
    	threadRemove r = new threadRemove();
    	r.remove(agencyID);
    	Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Information Dialog");
		alert.setHeaderText(null);
		alert.setContentText("Agency has been removed!");
		alert.showAndWait();
		AnchorPane root;
		root = (AnchorPane)FXMLLoader.load(getClass().getResource("Main.fxml"));
		Scene scene = new Scene(root,750,400);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
		primaryStage.setScene(scene);
		primaryStage.show();
    }
    
    @FXML
    void changeStatus(ActionEvent event) throws IOException {
    	AnchorPane root;
		root = (AnchorPane)FXMLLoader.load(getClass().getResource("ChangeStatusPanel.fxml"));
		Scene scene = new Scene(root,750,400);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
		primaryStage.setScene(scene);
		primaryStage.show();
    }
    
    @FXML
    void clickChange(ActionEvent event) throws IOException {
    	String AgencyID = statusAgencyID.getText();
    	threadStatus s = new threadStatus();
    	s.changeStatus(AgencyID);
    	Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Information Dialog");
		alert.setHeaderText(null);
		alert.setContentText("Agency Status has been changed!");
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
