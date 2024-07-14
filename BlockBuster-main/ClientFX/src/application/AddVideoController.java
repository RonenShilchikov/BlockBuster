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

public class AddVideoController {
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	@FXML
	public TextField id;
	@FXML
	public TextField name;
	@FXML
	public TextField director;
	@FXML
	public TextField description;
	
	@FXML
	public TextField minutes;
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
	
	public void switchToVideos(ActionEvent e) throws IOException {
		root = FXMLLoader.load(getClass().getResource("videos.fxml"));
		stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	public void addVideo(ActionEvent event) {
		try {
			Gson gson = new Gson();
						
			Model.addVideo(id.getText() , name.getText() , director.getText() ,description.getText() , Integer.parseInt(minutes.getText()) ,Integer.parseInt(day.getText()),Integer.parseInt(month.getText()),Integer.parseInt(year.getText()));
			
			switchToVideos(event);
			
		} catch (Exception err) {
			err.printStackTrace();
		}
		
	}
}
