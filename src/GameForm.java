import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.util.Duration;

public class GameForm extends Application{

	@Override
	public void start(Stage stage) throws Exception {
		//Create border pane for the whole form
		BorderPane border = new BorderPane();
		
		//Creating a GridPane container
				GridPane grid = new GridPane();
				grid.setPadding(new Insets(10, 10, 10, 10));
				grid.setVgap(5);
				grid.setHgap(5);
				
				//Create the firstName text field
				final TextField name = new TextField();
				Label nameLabel = new Label("Game Title:");
				GridPane.setConstraints(nameLabel, 0, 0);
				grid.getChildren().add(nameLabel);
				name.setPromptText("Enter the game's title.");
				name.setPrefColumnCount(10);
				name.getText();
				GridPane.setConstraints(name, 1, 0);
				grid.getChildren().add(name);
				
				//Create the lastName text field
				final TextField hours = new TextField();
				Label hoursLabel = new Label("Hours Played:");
				GridPane.setConstraints(hoursLabel, 2, 0);
				grid.getChildren().add(hoursLabel);
				hours.setPromptText("Enter total hours played.");
				GridPane.setConstraints(hours, 3, 0);
				grid.getChildren().add(hours);
				
				//Create the rating text field
				final TextField rating = new TextField();
				Label ratingLabel = new Label("Rating:");
				GridPane.setConstraints(ratingLabel, 0, 1);
				grid.getChildren().add(ratingLabel);
				rating.setPromptText("Rate game out of 10.");
				GridPane.setConstraints(rating, 1, 1);
				grid.getChildren().add(rating);
				
				//add title image and put it in an image view
				Image img = new Image("checkers.jpg");
				ImageView imgVw = new ImageView();
				imgVw.setImage(img);
				//set the size of the title image view
				imgVw.setFitWidth(500);
				imgVw.setFitHeight(100);
				//create animation for image
				FadeTransition ft = new FadeTransition(Duration.millis(4000), imgVw);
				ft.setFromValue(0.1);
				ft.setToValue(1.0);
				ft.setCycleCount(1);
				ft.setAutoReverse(false);
				ft.play();
		
		//create top hbox for the title image to sit in
		HBox top = new HBox();
		//top.setPadding(new Insets(10,10,10,10));
		top.setSpacing(10);
		top.setStyle("-fx-background-color: #333333;");
		//add image view to the hbox
		top.getChildren().add(imgVw);
		top.setAlignment(Pos.CENTER);
		
		//create bottom hbox for the continue and clear buttons to sit in
		HBox bottom = new HBox();
		bottom.setPadding(new Insets(10,10,10,10));
		bottom.setSpacing(10);
		bottom.setStyle("-fx-background-color: #333333;");

		//label for listview
		Label gameGenre = new Label("Select the type(s) of games you have played:");
		//list view that lists board game genres 
		ListView<String> genre = new ListView<String>();
		genre.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		ObservableList<String> genres = FXCollections.observableArrayList(
		"Board Games","Video Games","Card Games");
		genre.setPrefHeight(100);
		genre.setItems(genres);
		VBox intro = new VBox();
		intro.getChildren().addAll(grid,gameGenre,genre);
		

		Button submit = new Button("Submit");
		submit.setPrefSize(100, 20);
		submit.setOnMouseClicked(new EventHandler<Event>(){

			@Override
			public void handle(Event event) {
				// TODO Auto-generated method stub
				try (BufferedWriter bw = new BufferedWriter(new FileWriter("info.txt", true))) {
					//bw.write("Member name : " + name.getText() + " " + lastName.getText() + ". Gender: " + ((Labeled) group.getSelectedToggle()).getText() +". To contact the member email them at " + hours.getText() + ".");
					bw.newLine();
					bw.write("The member's introduction: Their favorite board game genre is " + genre.getSelectionModel().getSelectedItem());
					bw.newLine();
			    } catch (IOException e) {
			        e.printStackTrace();
			    }
			}
		});

		Button clear = new Button("Clear");
		clear.setPrefSize(100, 20);
		//add buttons to the hbox
		clear.setOnMouseClicked(new EventHandler<Event>(){
			@Override
			public void handle(Event event) {
				// TODO Auto-generated method stub
				name.clear();
				hours.clear();
				rating.clear();
				genre.getSelectionModel().clearSelection();
			}
		}
		);
		
		
		
		//Brings you to the second scene
		Button next = new Button("Next");
		next.setPrefSize(100, 20);
		//add buttons to the hbox
		next.setOnMouseClicked(new EventHandler<Event>(){
			@Override
			public void handle(Event event) {
				//stage.setScene(/*NEW SCENE HERE*/);
			}
		}
		);

		bottom.getChildren().addAll(submit, clear, next);
		bottom.setAlignment(Pos.CENTER);
		
		//create grid pane for the central content of the app
		//GridPane grid = new GridPane();

		//grid.setStyle("-fx-background-color: #FFFF00;");
		//add the hboxes and grid pane to the border pane

		intro.setStyle("-fx-background-color: #3BB258;");

		border.setTop(top);
		border.setCenter(intro);
		border.setBottom(bottom);
		//set the scene with the border pane
		Scene scene = new Scene(border, 540, 500);
		stage.setTitle("Game Management");
		stage.setScene(scene);
		stage.show();
		
		//create second scene to view records
		BorderPane seeRecords = new BorderPane();
		//text view to insert record into
		Text secondaryTitle = new Text("View Records");
		//sets the BorderPane to center alignment
		seeRecords.setAlignment(secondaryTitle, Pos.CENTER);
		//sets padding to the BorderPane
		seeRecords.setPadding(new Insets(10,10,10,10));
		TextArea records = new TextArea();
		records.setMaxWidth(400);
		records.setEditable(false);
		seeRecords.setTop(secondaryTitle);
		seeRecords.setCenter(records);
		HBox secondaryButtonBox = new HBox();
		Button back = new Button("Back to Form");
		back.setOnAction(e->{
			stage.setScene(scene);
		});
		secondaryButtonBox.getChildren().add(back);
		seeRecords.setBottom(secondaryButtonBox);
		BorderPane.setAlignment(secondaryButtonBox, Pos.CENTER);
		secondaryButtonBox.setAlignment(Pos.CENTER);
		Scene viewScene = new Scene(seeRecords, 400, 400);
		next.setOnAction(e->{
			stage.setScene(viewScene);
			
		});	
		
		}

public static void main(String[] args) {
	// TODO Auto-generated method stub
	Application.launch(args);
}
	
}