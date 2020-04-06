package com.snapbox.view;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.snapbox.MainApp;
import com.snapbox.bean.Movie;
import com.snapbox.bean.MovieProjectTheater;
import com.snapbox.bean.Theatre;
import com.snapbox.model.service.MovieProjectTheaterService;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import net.rgielen.fxweaver.core.FxmlView;

@Component
@FxmlView("MoviesChoice.fxml")
public class MoviesChoice {
   @FXML
   private VBox movie1;
   @FXML
   private VBox movie2;
   @FXML
   private VBox movie3;
   
   private List<MovieProjectTheater> movies;

   private MovieProjectTheaterService movieProjectTheaterService;
   @Autowired
   public MoviesChoice(MovieProjectTheaterService movieProjectTheaterService) {
   this.movieProjectTheaterService = movieProjectTheaterService;
   }
@FXML
   public void initialize() {
	   this.movies = movieProjectTheaterService.getProjectionOfTheNight();
	   setBackgrounds(movie1,0);
	   setBackgrounds(movie2,1);
	   setBackgrounds(movie3,2);

 

}
 private void setBackgrounds(VBox movie,int i) {
	 try {
			FileInputStream input = new FileInputStream(movies.get(i).getMovie().getPoster());
	        Image image = new Image(input); 
	        BackgroundSize size =  new BackgroundSize(movie.getWidth(), movie.getHeight(), false, false, true, false);
	          BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.CENTER,size);
	          Background background = new Background(backgroundImage); 
	           movie.setBackground(background);

		} catch (FileNotFoundException e) {
			System.out.println("error in images of "+movies.get(i).getMovie().getName());
		} 
	 
	 
	 
 }

public void openMovie(ActionEvent actionEvent) {
      Object src = actionEvent.getSource();
      Button btn = (Button)src;

      if(btn.getParent() == movie1) {
    	  goNext(0);
      }
      if(btn.getParent() == movie2) {
     	 goNext(1);
      }
      if(btn.getParent() == movie3) {
         goNext(2);
      }
}
public void login(ActionEvent actionEvent) {
    MainApp.stage.setScene(MainApp.getLoginScene());
}
private void goNext(int i) {
	MainApp.chosenMovieProjectTheater=this.movies.get(i);
   // JavaFxApplication.stage.setScene(JavaFxApplication.playWalkScene(JavaFxApplication.getMovieDetail()));
	MainApp.stage.setScene(MainApp.getMovieDetail());

}
   
   
   
}
