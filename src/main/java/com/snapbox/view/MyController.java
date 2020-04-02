package com.snapbox.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.snapbox.model.service.MovieService;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import net.rgielen.fxweaver.core.FxmlView;

@Component
@FxmlView("test.fxml")
public class MyController {
 
	private MovieService movieService;
	@Autowired
	public MyController(MovieService movieService ) {
		this.movieService = movieService;
	}


	@FXML
	private Label weatherLabel;
	

  public void loadWeatherForecast(ActionEvent actionEvent) {
   }
	
}
