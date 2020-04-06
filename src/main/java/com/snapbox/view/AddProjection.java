package com.snapbox.view;

import java.time.Instant;
import java.time.ZoneId;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.snapbox.MainApp;
import com.snapbox.bean.Movie;
import com.snapbox.bean.MovieProjectTheater;
import com.snapbox.bean.Theatre;
import com.snapbox.model.service.MovieProjectTheaterService;

import net.rgielen.fxweaver.core.FxmlView;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

@Component
@FxmlView("AddProjection.fxml")
public class AddProjection {
	   @FXML
	    private TextField refInput;

	    
	    @FXML
	    private TextField movieInput;

	    @FXML
	    private TextField theaterInput;

	    @FXML
	    private DatePicker dateProjectionInput;

	    @FXML
	    private TextField orderInput;

	    @FXML
	    private Slider placesInput;

	    @FXML
	    private TableView<MovieProjectTheater> projectionsTable;

	    @FXML
	    private TableColumn<MovieProjectTheater, String> ref;

	    @FXML
	    private TableColumn<MovieProjectTheater, String> movie;

	    @FXML
	    private TableColumn<MovieProjectTheater, String> theater;

	    @FXML
	    private TableColumn<MovieProjectTheater, Date> date;

	    @FXML
	    private TableColumn<MovieProjectTheater, Integer> order;
	    
	    private MovieProjectTheaterService movieProjectTheaterService;

	    @FXML
	    public void initialize() {
	    	 ref.setCellValueFactory(new  PropertyValueFactory<MovieProjectTheater, String>("ref"));
	    	    movie.setCellValueFactory( cellData -> new SimpleStringProperty(cellData.getValue().getMovie().getName()));
	    	    theater.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTheater().getName()));
	    	    date.setCellValueFactory(new  PropertyValueFactory<MovieProjectTheater, Date>("showDate"));
	    	    order.setCellValueFactory(new  PropertyValueFactory<MovieProjectTheater, Integer>("tartib"));
	    	   
		    	  this.projectionsTable.getItems().setAll(this.movieProjectTheaterService.findAll());


	 }
	    @FXML
	    void addProjectionToList(ActionEvent event) {
	    	Instant instant = Instant.from(dateProjectionInput.getValue().atStartOfDay(ZoneId.systemDefault()));
	    	Date d = Date.from(instant);
	    	System.out.println(d);
	    	int n = Integer.parseInt(orderInput.getText());
	    	Movie m = new Movie();
	    	m.setName(movieInput.getText());
	    	Theatre t = new Theatre();
	    	t.setName(theaterInput.getText());
        MovieProjectTheater mvp =  new MovieProjectTheater(null, refInput.getText(),d ,n,m,t,0);
      if( movieProjectTheaterService.save(mvp)>0) {
          this.projectionsTable.getItems().add(movieProjectTheaterService.findByRef(mvp.getRef()));

      }
  	
	    }
        @Autowired
		public AddProjection(MovieProjectTheaterService movieProjectTheaterService) {
			this.movieProjectTheaterService = movieProjectTheaterService;
		}
        
        @FXML
        void goback(ActionEvent event) {
           MainApp.stage.setScene(MainApp.getFirstPageForAdmin());
        }


}
