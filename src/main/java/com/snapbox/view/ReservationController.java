package com.snapbox.view;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.snapbox.MainApp;
import com.snapbox.bean.MovieProjectTheater;
import com.snapbox.bean.Reservation;
import com.snapbox.model.service.ReservationService;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import net.rgielen.fxweaver.core.FxmlView;

@Component
@FxmlView("ReservationView.fxml")
public class ReservationController {
	@FXML
    private AnchorPane mainView;
    public static Stage thankyou;
    @FXML
    private VBox form;

    @FXML
    private Label title1;

    @FXML
    private Label date1;

    @FXML
    private Label time1;

    @FXML
    private TextField name1;

    @FXML
    private TextField seat1;

    @FXML
    private ToggleGroup type;

    @FXML
    private Label price1;

    @FXML
    private HBox ticket;

    @FXML
    private VBox poster;

    @FXML
    private Label title2;

    @FXML
    private Label genre;

    @FXML
    private Label seat2;

    @FXML
    private Label time2;
   @FXML
   private RadioButton normal;
   @FXML
   private RadioButton vip;
    @FXML
    private Label type2;

    @FXML
    private Label price2;

    @FXML
    private Label name2;

    @FXML
    private Label title3;
    private double price ;
    private MovieProjectTheater mv;
    ReservationService rs;
    @Autowired
    public ReservationController(ReservationService rs) {
       this.rs = rs;
    }
	@FXML
	public void initialize() {
		 try {
     		this.mv = MainApp.chosenMovieProjectTheater;
     		this.price = mv.getMovie().getPrice();
     		title1.setText(mv.getMovie().getName());
     		this.title2.setText(mv.getMovie().getName());
     		this.title3.setText(mv.getMovie().getName());
			 name2.textProperty().bind(name1.textProperty());
			 seat2.textProperty().bind(seat1.textProperty());
			 price1.setText(price+" DH");	
			 price2.setText(price+" DH");
			 // TODO time o date 
			type.selectedToggleProperty().addListener(new ChangeListener<Toggle>()  
	        { 
	            public void changed(ObservableValue<? extends Toggle> ob,  
	                                                    Toggle o, Toggle n) 
	            { 
	  
	                RadioButton rb = (RadioButton)type.getSelectedToggle(); 
	  
	                if (rb != null) { 
	                	if(rb==vip)
	                	{
	                		price = mv.getMovie().getPrice()+mv.getMovie().getPrice()*0.2;
	                		 price1.setText(price+" DH");	
	            			 price2.setText(price+" DH");
	                	}
	                	if(rb==normal) {
	                		price = mv.getMovie().getPrice();
	                		 price1.setText(price+" DH");	
	            			 price2.setText(price+" DH");
	                	}
	                }
	            } 
	        }); 
			 
			 
			 type2.setText(normal.getText());
			 DropShadow dropShadow = new DropShadow();
			 dropShadow.setRadius(5.0);
			 dropShadow.setOffsetX(2.0);
			 dropShadow.setOffsetY(2.0);
			 ticket.setEffect(dropShadow);
		          FileInputStream input1 = new FileInputStream(mv.getMovie().getPoster());
			        Image image1 = new Image(input1); 
			        BackgroundSize size1 =  new BackgroundSize(this.poster.getWidth(), this.poster.getHeight(), false, false, false, true);
			          BackgroundImage backgroundImage1 = new BackgroundImage(image1, BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.CENTER,size1);
			          Background background1 = new Background(backgroundImage1); 
			           this.poster.setBackground(background1);

			} catch (FileNotFoundException e) {
				System.out.println("error in image of logo");
			} 
	}
	  @FXML
	    void goBack(ActionEvent event) {
           MainApp.stage.setScene(MainApp.getMovieDetail());
	    }

	    @FXML
	    void pay(ActionEvent event) {
            RadioButton rb = (RadioButton)type.getSelectedToggle(); 
	    	Reservation r = new Reservation(null, MainApp.chosenMovieProjectTheater,this.name2.getText(),rb.getText(), this.price);
           System.out.println(this.rs.save(r));
            thankyou=new Stage();
            thankyou.initStyle(StageStyle.UNDECORATED);
            thankyou.setScene(MainApp.getThankYouScene());
            thankyou.show();
	    }

}
