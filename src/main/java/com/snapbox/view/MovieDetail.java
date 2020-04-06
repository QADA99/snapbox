package com.snapbox.view;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.springframework.stereotype.Component;

import com.snapbox.MainApp;
import com.snapbox.bean.MovieProjectTheater;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import net.rgielen.fxweaver.core.FxmlView;

@Component
@FxmlView("MovieDetail.fxml")
public class MovieDetail {
	
	@FXML 
	private WebView trailler;
	
	@FXML
    private Label director;

    @FXML
    private Label cast;

    @FXML
    private Label name;

    @FXML
    private Text story;

	private MovieProjectTheater mvp;
	private String[] sessions= {"14:30h-16:30h","17:00h-19:00h","19:30h-21:30h"};
	  @FXML
	    private Label price;

	    @FXML
	    private Label vip;

	    @FXML
	    private Label salle;
	    @FXML
	    private Label genre;
	    @FXML
	    private ProgressBar attendance;
	    @FXML
	    private Label indecateurPr;
	    @FXML
	    private Label heure;

	@FXML
	public void initialize() {
		MainApp.playMusic();

			mvp = MainApp.chosenMovieProjectTheater;
			this.director.setText(mvp.getMovie().getDirector());
			this.cast.setText(mvp.getMovie().getCast());
			this.genre.setText(mvp.getMovie().getCategorie());
            this.story.setText(mvp.getMovie().getStory());
            this.price.setText(mvp.getMovie().getPrice()+"DH");
            double vipPrice = mvp.getMovie().getPrice()+mvp.getMovie().getPrice()*0.2;
            this.price.setText(vipPrice+"DH");
            this.salle.setText(mvp.getTheater().getName());
            this.name.setText(mvp.getMovie().getName());
            double p = (double)(mvp.getAvailablePlaces())/(mvp.getTheater().getCapacite());
            this.attendance.setProgress(p);
            this.attendance.setStyle("-fx-accent:  #d10404f0; ");
            this.indecateurPr.setText("  "+mvp.getAvailablePlaces()+"\\"+mvp.getTheater().getCapacite());
            this.heure.setText(sessions[mvp.getTartib()-1]);
			WebEngine wbg = trailler.getEngine(); 		   
		    wbg.loadContent(mvp.getMovie().getTrailer());
      
		
	 
	}
	
	public void goBack(ActionEvent actionEvent) {
		MainApp.stage.setScene(MainApp.getMoviesChoiceScene());
		
	}
	public void goNext(ActionEvent actionEvent) {
		MainApp.stage.setScene(MainApp.getReservationScene());

	}
    
    
}
