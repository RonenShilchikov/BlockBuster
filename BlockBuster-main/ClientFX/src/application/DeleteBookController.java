package application;

import java.awt.Button;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;

import com.google.gson.Gson;

import application.Model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class DeleteBookController implements Initializable {
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	@FXML
	public TextField x;
	
	
	public void switchToMenu(ActionEvent e) throws IOException {
		root = FXMLLoader.load(getClass().getResource("menu.fxml"));
		stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void switchToBooks(ActionEvent e) throws IOException {
		root = FXMLLoader.load(getClass().getResource("books.fxml"));
		stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	public void deleteBook(ActionEvent event) {
		try {
			String id = x.getText();
			Model.deleteBook(id);
			
			switchToBooks(event);
			
			
		} catch (Exception err) {
			err.printStackTrace();
		}
		
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	}
	
}
