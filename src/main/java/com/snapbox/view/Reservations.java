package com.snapbox.view;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.snapbox.MainApp;
import com.snapbox.bean.Movie;
import com.snapbox.bean.MovieProjectTheater;
import com.snapbox.bean.Reservation;
import com.snapbox.model.service.MovieService;
import com.snapbox.model.service.ReservationService;

import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import net.rgielen.fxweaver.core.FxmlView;

@Component
@FxmlView("Rerervations.fxml")
public class Reservations {
	@FXML
    private TextField searchedInput;
	@FXML
	  private BarChart<String,Double> charts;
    @FXML
    private ChoiceBox<String> choice;

    @FXML
    private TableView<Reservation> ticketsTable;

    @FXML
    private TableColumn<Reservation, String> name;

    @FXML
    private TableColumn<Reservation, String> projection;

    @FXML
    private TableColumn<Reservation, String> movie;

    @FXML
    private TableColumn<Reservation, String> type;

    @FXML
    private TableColumn<Reservation, Double> price;

   private  ReservationService reservationService;
   private MovieService movieService;
    
   
   @Autowired
    public Reservations(ReservationService reservationService,MovieService movieService) {
	this.reservationService = reservationService;
	this.movieService = movieService;
}
	@FXML
    public void initialize() {
		 choice.getItems().removeAll(choice.getItems());
		 choice.getItems().addAll("name", "projection", "movie","type");
		 choice.getSelectionModel().select("name");
    	 name.setCellValueFactory(new  PropertyValueFactory<Reservation, String>("name"));
    	    movie.setCellValueFactory( cellData -> new SimpleStringProperty(cellData.getValue().getProjection().getMovie().getName()));
    	    projection.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getProjection().getRef()));
    	    price.setCellValueFactory(new  PropertyValueFactory<Reservation, Double>("price"));
    	    type.setCellValueFactory(new  PropertyValueFactory<Reservation, String>("type"));
             
    	 
    	   charts.getXAxis().setLabel("Movies");
    	   charts.getYAxis().setLabel("Money");
    	   XYChart.Series dataSeries1 = new XYChart.Series();
           dataSeries1.setName("2020");
           for(Movie m : movieService.findAll()) {
        	   dataSeries1.getData().add(new XYChart.Data(m.getName(), reservationService.sales(m.getName())));
           }
           
           charts.getData().add(dataSeries1);
           charts.lookupAll(".default-color0.chart-bar").forEach(n -> n.setStyle("-fx-bar-fill: #d30000;"));
	    	  this.ticketsTable.getItems().setAll(this.reservationService.findAll());
        
	    	  

 }
    @FXML
    void shearch(ActionEvent event) {
        if(this.searchedInput.getText().length()==0)
	    	  this.ticketsTable.getItems().setAll(this.reservationService.findAll());
        else if(choice.getValue()=="name") {
    		this.ticketsTable.getItems().setAll(this.reservationService.findByName(this.searchedInput.getText()));
    	}
        else if(choice.getValue()=="movie")
    		this.ticketsTable.getItems().setAll(this.reservationService.findByMovie(this.searchedInput.getText()));
        else if(choice.getValue()=="projection")
    		this.ticketsTable.getItems().setAll(this.reservationService.findByShowRef(this.searchedInput.getText()));

    }
    
    @FXML
    void goBack(ActionEvent event) {
      MainApp.stage.setScene(MainApp.getFirstPageForAdmin());
    }
}
