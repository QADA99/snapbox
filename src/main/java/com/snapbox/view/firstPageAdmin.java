package com.snapbox.view;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.snapbox.MainApp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.VBox;
import net.rgielen.fxweaver.core.FxmlView;
@Component
@FxmlView("firstPageAdmin.fxml")
public class firstPageAdmin {
	 @FXML
	    private VBox addMovie;

	    @FXML
	    private VBox addProjection;

	    @FXML
	    private VBox showReservation;

	    @FXML
	    void addMovie(ActionEvent event) {
        MainApp.stage.setScene(MainApp.getAddMovieScene());
	    }

	    @FXML
	    void addProjection(ActionEvent event) {
         MainApp.stage.setScene(MainApp.getAddProjectionScene());
	    }

	    @FXML
	    void showReservation(ActionEvent event) {
           MainApp.stage.setScene(MainApp.getReservationsScene());
	    }
        @Autowired
		public firstPageAdmin() {
        	
		}
        @FXML
        void logout(ActionEvent event) {
          MainApp.stage.setScene(MainApp.getLoginScene());
        }
        @FXML
        public void initialize() {
     	   setBackgrounds(addMovie,"C:\\Users\\Toshiba\\git\\repository\\snapbox\\images\\addMovie.jpg");
    	   setBackgrounds(addProjection,"C:\\Users\\Toshiba\\git\\repository\\snapbox\\images\\addProjection.jpg");
    	   setBackgrounds(showReservation,"C:\\Users\\Toshiba\\git\\repository\\snapbox\\images\\reseravation.jpg");
     }
        
        private void setBackgrounds(VBox vb,String img) {
       	 try {
       			FileInputStream input = new FileInputStream(img);
       	        Image image = new Image(input); 
       	        BackgroundSize size =  new BackgroundSize(vb.getWidth(), vb.getHeight(), false, false, false, true);
       	          BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.CENTER,size);
       	          Background background = new Background(backgroundImage); 
       	           vb.setBackground(background);

       		} catch (FileNotFoundException e) {
       			System.out.println("error in images of "+img);
       		} 
       	 
       	 
       	 
        }

}
