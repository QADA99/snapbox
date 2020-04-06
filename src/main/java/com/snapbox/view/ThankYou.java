package com.snapbox.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import net.rgielen.fxweaver.core.FxmlView;
@Component
@FxmlView("ThankYou.fxml")
public class ThankYou {
	
	@Autowired
	 public ThankYou() {		
	}

	@FXML
	    void hideStage(ActionEvent event) {
		ReservationController.thankyou.hide();
	    }
}
