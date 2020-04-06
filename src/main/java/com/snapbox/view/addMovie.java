package com.snapbox.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.snapbox.MainApp;
import com.snapbox.bean.Movie;
import com.snapbox.model.service.MovieService;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import net.rgielen.fxweaver.core.FxmlView;

@Component
@FxmlView("addMovie.fxml")
public class addMovie {
	@FXML
    private TableColumn<Movie, String> movieName;
	@FXML
    private TableView<Movie> moviesTables;

    @FXML
    private TableColumn<Movie, String> movieGenre;
    @FXML
    private TableColumn<Movie, Double> moviePrice;
    @FXML
    private TextField director;

    @FXML
    private TextField cast;

    @FXML
    private TextField price;

    @FXML
    private TextField genre;

    @FXML
    private TextField poster;
    @FXML
    private TextField name;

    @FXML
    private TextField trailler;
 
    private MovieService movieService;
    @Autowired
    public addMovie(MovieService m) {
    	this.movieService= m;
	}
	@FXML
    public void initialize() {
 	    movieName.setCellValueFactory(new  PropertyValueFactory<Movie, String>("name"));
 	    movieGenre.setCellValueFactory(new  PropertyValueFactory<Movie, String>("categorie"));
 	    moviePrice.setCellValueFactory(new  PropertyValueFactory<Movie, Double>("price"));
 	    moviesTables.getItems().setAll(movieService.findAll());
 }
    @FXML
    void addMovieToList(ActionEvent event) {
    	double p = Double.parseDouble(price.getText());
    	
       Movie m = new Movie(null, this.name.getText(), cast.getText(),director.getText(), poster.getText(), trailler.getText(), genre.getText(),p , "");
      if(this.movieService.save(m)>0){
          this.moviesTables.getItems().add(m);
    	   this.name.setText(null);
    	   cast.setText(null);
    	   director.setText(null);
    	   poster.setText(null);
    	   trailler.setText(null);
    	   genre.setText(null);
    	   price.setText(null);
      }
       
    }

    @FXML
    void goback(ActionEvent event) {
      MainApp.stage.setScene(MainApp.getFirstPageForAdmin());
    }
}
