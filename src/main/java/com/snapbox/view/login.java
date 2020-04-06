package com.snapbox.view;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.snapbox.MainApp;
import com.snapbox.bean.admin;
import com.snapbox.model.service.AdminService;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import net.rgielen.fxweaver.core.FxmlView;
@Component
@FxmlView("login.fxml")
public class login {
	@FXML
    private TextField login;

    @FXML
    private PasswordField password;

    @FXML
    private Label error;
    @FXML
    private ImageView imageV;
    
    private AdminService adminService;
    @Autowired
    public login(AdminService adminService) {
		this.adminService = adminService;
	}
    
       @FXML
       public void initialize() {
    	   FileInputStream input;
		try {
			input = new FileInputStream("C:\\Users\\Toshiba\\git\\repository\\snapbox\\src\\main\\java\\com\\snapbox\\view\\CuteLogo.PNG");
	         Image image = new Image(input); 
	         this.imageV.setImage(image);
   
		} catch (FileNotFoundException e) {
         System.out.println("error fi image");
		}
		
		
      }
	@FXML
    void goBack(ActionEvent event) {
     MainApp.stage.setScene(MainApp.getMoviesChoiceScene());
    }

    @FXML
    void logIn(ActionEvent event) {
    	error.setText(null);
    	String lg = login.getText();
    	admin foundedAdmin = this.adminService.findByLogin(lg);
    	if(foundedAdmin==null) {
        	error.setText("ther's no admin with this login");
           
    	}else if(!foundedAdmin.getPassword().equals(password.getText())) {
        	error.setText("password is incorrect");
    	
    	}else {
         MainApp.stage.setScene(MainApp.getFirstPageForAdmin());
    	}
    	

    }
}
