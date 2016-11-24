
import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.util.Duration;

public class GameForm extends Application{

	@Override
	public void start(Stage stage) throws Exception {
		//Create border pane for the whole form
		BorderPane border = new BorderPane();
		
		/**
		 * @author Blaze 
		 * Created a GridPane for some of the form
		 * Created buttons for the types of games to be checked off
		 */
		
		//Creating a GridPane container
		GridPane grid = new GridPane();
		for (int i = 0; i < 4; i++) {
	         RowConstraints row = new RowConstraints(35);
	         grid.getRowConstraints().add(row);
	     }
	         ColumnConstraints row1 = new ColumnConstraints(120);
	         grid.getColumnConstraints().add(row1);
	         ColumnConstraints row2 = new ColumnConstraints(300);
	         grid.getColumnConstraints().add(row2);
	         ColumnConstraints row3 = new ColumnConstraints(300);
	         grid.getColumnConstraints().add(row3);
	         //Creating a GridPane container
			grid.setPadding(new Insets(10, 10, 10, 10));
			grid.setVgap(5);
			grid.setHgap(5);
				
				//Create the gameTitle text field
				final TextField name = new TextField();
				Label nameLabel = new Label("Game Title:");
				GridPane.setConstraints(nameLabel, 0, 0);
				grid.getChildren().add(nameLabel);
				name.setPromptText("Enter the game's title.");
				name.setPrefColumnCount(10);
				name.getText();
				GridPane.setConstraints(name, 1, 0);
				grid.getChildren().add(name);
				
				//Create the hrsPlayed text field
				final TextField hours = new TextField();
				Label hoursLabel = new Label("Hours Played:");
				GridPane.setConstraints(hoursLabel, 0, 2);
				grid.getChildren().add(hoursLabel);
				hours.setPromptText("Enter total hours played.");
				GridPane.setConstraints(hours, 1, 2);
				grid.getChildren().add(hours);
				
				//Create the rating text field
				final TextField rating = new TextField();
				Label ratingLabel = new Label("Rating:");
				GridPane.setConstraints(ratingLabel, 0, 1);
				grid.getChildren().add(ratingLabel);
				rating.setPromptText("Rate game out of 10.");
				GridPane.setConstraints(rating, 1, 1);
				grid.getChildren().add(rating);
				
				//Create the gameDesc text area
				final TextArea gameDesc = new TextArea();
				Label gameDescLabel = new Label("Game Description:");
				//gameDesc.setPrefHeight(20);
				GridPane.setConstraints(gameDescLabel, 0, 3);
				grid.getChildren().add(gameDescLabel);
				gameDesc.setPromptText("Enter a description of the game:");
				GridPane.setConstraints(gameDesc, 1, 4);
				grid.getChildren().add(gameDesc);
				
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

		//Create the CheckBox buttons for types of games to be checked off
				VBox vbox = new VBox();
				CheckBox box1, box2, box3;
				box1 = new CheckBox("Video Games");
				box2 = new CheckBox("Card Games");
				box3 = new CheckBox("Board Games");
				Label type = new Label("Select the types of games:");
				GridPane.setConstraints(type, 2, 0);
				type.setPadding(new Insets(0, 0, 0, 20));
				grid.getChildren().add(type);
				vbox.getChildren().addAll(box1, box2, box3);
				GridPane.setConstraints(vbox, 2, 2);
				vbox.setPadding(new Insets(0, 0, 40, 20));
				box1.setPadding(new Insets(10, 0, 0, 0));
				box2.setPadding(new Insets(10, 0, 0, 0));
				box3.setPadding(new Insets(10, 0, 0, 0));
				grid.getChildren().add(vbox);

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
				gameDesc.clear();
				box1.setSelected(false);
				box2.setSelected(false);
				box3.setSelected(false);
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

		bottom.getChildren().addAll(clear, next);
		bottom.setAlignment(Pos.CENTER);
		
		//create grid pane for the central content of the app
		//GridPane grid = new GridPane();

		//grid.setStyle("-fx-background-color: #FFFF00;");
		//add the hboxes and grid pane to the border pane

		grid.setStyle("-fx-background-color: #3BB258;");

		border.setTop(top);
		border.setCenter(grid);
		border.setBottom(bottom);
		//set the scene with the border pane
		Scene scene = new Scene(border, 800, 800);
		stage.setTitle("Game Management");
		stage.setScene(scene);
		stage.show();

		
		//create second scene to view records
		BorderPane seeRecords = new BorderPane();
		Text secondaryTitle = new Text("View Records");
		//sets the BorderPane to center alignment
		seeRecords.setAlignment(secondaryTitle, Pos.CENTER);
		//sets padding to the BorderPane
		seeRecords.setPadding(new Insets(10,10,10,10));
		//creates Text area to view game records 
		TextArea records = new TextArea();
		//sets the width to the text field
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