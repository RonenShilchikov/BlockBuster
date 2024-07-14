package application;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.net.Socket;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import application.Model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class VideosController implements Initializable {
	private Stage stage;
	private Scene scene;
	private Parent root;

	@FXML
	ListView<String> booksList;

	public void switchToMenu(ActionEvent e) throws IOException {
		root = FXMLLoader.load(getClass().getResource("menu.fxml"));
		stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	public void displayBooks() {

//		String json = "[{'id':'6','name':'6','author':'author6','description':'desc6','pages':69,'releaseDay':6,'releaseMonth':6,'releaseYear':2066},{'id':'7','name':'777','author':'777','description':'7777','pages':7,'releaseDay':7,'releaseMonth':7,'releaseYear':1977}]";
//
//		Type listType = new TypeToken<ArrayList<Book>>() {
//		}.getType();
//		ArrayList<Book> db = new Gson().fromJson(json, listType);
//
//		for (Book book : db) {
//			booksList.getItems().add(book.toString());
//		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		// get json
		String json = getJson();
		System.out.println(json);
		// parse json
		Type listType = new TypeToken<ArrayList<Video>>() {
		}.getType();
		ArrayList<Video> db = new Gson().fromJson(json, listType);

		// display books / videos
		for (Video v : db) {
			booksList.getItems().add(v.toString());
		}

	}

	String getJson() {
		return Model.getAllVideos();
	}
}
