package application;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import com.google.gson.Gson;

import application.Model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddBookController {
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	@FXML
	public TextField id;
	@FXML
	public TextField name;
	@FXML
	public TextField author;
	@FXML
	public TextField description;
	
	@FXML
	public TextField pages;
	@FXML
	public TextField day;
	@FXML
	public TextField month;
	@FXML
	public TextField year;
	
	
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

	public void addBook(ActionEvent event) {
		try {
			
			Model.addBook(
					id.getText() ,
					name.getText() , author.getText() ,
					description.getText() , 
					Integer.parseInt(pages.getText()) ,
					Integer.parseInt(day.getText()),
					Integer.parseInt(month.getText()),
					Integer.parseInt(year.getText())
					);
			
			switchToBooks(event);
			
		} catch (Exception err) {
			err.printStackTrace();
		}
		
	}
}
