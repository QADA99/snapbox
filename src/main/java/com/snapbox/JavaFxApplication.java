package com.snapbox;

import java.io.File;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import com.snapbox.bean.Movie;
import com.snapbox.bean.MovieProjectTheater;
import com.snapbox.view.MoviesChoice;
import com.snapbox.view.ReservationController;
import com.snapbox.view.MovieDetail;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import net.rgielen.fxweaver.core.FxWeaver;

public class JavaFxApplication extends Application {

	 private ConfigurableApplicationContext applicationContext;
	 public static Stage stage;
	 private static ConfigurableApplicationContext applicationContextStatic;
	 
	 
     public static MovieProjectTheater chosenMovieProjectTheater;
     
     
     
     
	    @Override
	    public void init() {
	        String[] args = getParameters().getRaw().toArray(new String[0]);
	        JavaFxApplication.applicationContextStatic = new SpringApplicationBuilder()
	                .sources(SnapboxApplication.class)
	                .run(args);
	    }
	    
	    
	@Override
	public void start(Stage stage) throws Exception {
		JavaFxApplication.stage = stage;
		JavaFxApplication.stage.initStyle(StageStyle.UNDECORATED);
		JavaFxApplication.stage.setScene(playSnapeScene(getMoviesChoiceScene()));
		//JavaFxApplication.stage.setScene(JavaFxApplication.getMoviesChoiceScene());

		JavaFxApplication.stage.show();
		 
	}
	public static Scene getMoviesChoiceScene() {
		FxWeaver fxWeaver = applicationContextStatic.getBean(FxWeaver.class);
	    Parent root2 = fxWeaver.loadView(MoviesChoice.class);
	    return  new Scene(root2);
	}
	
	public static Scene getMovieDetail() {
		FxWeaver fxWeaver = applicationContextStatic.getBean(FxWeaver.class);
	    Parent root2 = fxWeaver.loadView(MovieDetail.class);
	    return  new Scene(root2);
	}
	public static Scene getReservationScene() {
		FxWeaver fxWeaver = applicationContextStatic.getBean(FxWeaver.class);
	    Parent root2 = fxWeaver.loadView(ReservationController.class);
	    return  new Scene(root2);
	}
	public static Scene playSnapeScene(Scene playWhenEnds) {
		File file=new File("snap.mp4");
		 Media media = new Media(file.toURI().toString());  
		 MediaPlayer snap = new MediaPlayer(media);
        snap.setAutoPlay(true);  
		 MediaView mediaView = new MediaView (snap);
		 Group root = new Group();  
		 root.getChildren().add(mediaView);
		 snap.setOnEndOfMedia(() -> {
			 JavaFxApplication.stage.setScene(playWhenEnds);
			}); 
		return new Scene(root,1000,600);
	}
	
	public static Scene playWalkScene(Scene playWhenEnds) {
		File file=new File("walk_with_background.mp4");
		 Media media = new Media(file.toURI().toString());  
		 MediaPlayer walk = new MediaPlayer(media);
        walk.setAutoPlay(true); 
		 MediaView mediaView = new MediaView (walk);
		 Group root = new Group();  
		 root.getChildren().add(mediaView);
		 walk.setOnEndOfMedia(() -> {
			 JavaFxApplication.stage.setScene(playWhenEnds);
			}); 
		return new Scene(root,1000,600);
	}
	public static Scene goBack(Scene playWhenEnds) {
		File file=new File("time.mp4");
		 Media media = new Media(file.toURI().toString());  
		 MediaPlayer walk = new MediaPlayer(media);
        walk.setAutoPlay(true); 
		 MediaView mediaView = new MediaView (walk);
		 Group root = new Group();  
		 root.getChildren().add(mediaView);
		 walk.setOnEndOfMedia(() -> {
			 JavaFxApplication.stage.setScene(playWhenEnds);
			}); 
		return new Scene(root,1000,600);
	}
	public static Scene playDeadpoolHey(Scene playWhenEnds) {
		File file=new File("deadpool.mkv");
		 Media media = new Media(file.toURI().toString());  
		 MediaPlayer walk = new MediaPlayer(media);
        walk.setAutoPlay(true); 
		 MediaView mediaView = new MediaView (walk);
		 Group root = new Group();  
		 root.getChildren().add(mediaView);
		 walk.setOnEndOfMedia(() -> {
			 JavaFxApplication.stage.setScene(playWhenEnds);
			}); 
		return new Scene(root,1000,600);
	}
	@Override
	public void stop() {
		applicationContextStatic.close();
	    Platform.exit();
	}

}
