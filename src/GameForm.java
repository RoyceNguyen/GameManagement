import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
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

	public static TextField name;
	public static TextField hours;
	public static TextField rating;
	public static TextArea gameDesc;
	public static TextArea records;
	public static CheckBox box1, box2, box3;
	public static Connection connection;
	InitializeDB db = new InitializeDB();
	GrabData gd = new GrabData();
	InsertData insert = new InsertData();
	Thread thread;
	
	@Override
	public void start(Stage stage) throws Exception {
		//Create border pane for the whole form
		BorderPane border = new BorderPane();
		thread = new Thread(db);
		thread.start();
		
		/**
		 * @author Blaze 
		 * Created a GridPane for some of the form
		 * Created buttons for the types of games to be checked off
		 * Created external stylesheet for css throughout the application
		 */
		
		GridPane grid = new GridPane();
		for (int i = 0; i < 4; i++) {
	         RowConstraints row = new RowConstraints(35);
	         grid.getRowConstraints().add(row);
	     }
	         ColumnConstraints row1 = new ColumnConstraints(130);
	         grid.getColumnConstraints().add(row1);
	         ColumnConstraints row2 = new ColumnConstraints(300);
	         grid.getColumnConstraints().add(row2);
	         ColumnConstraints row3 = new ColumnConstraints(300);
	         grid.getColumnConstraints().add(row3);
	        grid.setPadding(new Insets(10, 10, 10, 10));
			grid.setVgap(5);
			grid.setHgap(5);
			/**
			 * @author Jared 
			 * Created a TextField to enter the name of the title
			 * of the game played.
			 */
				name = new TextField();
				Label nameLabel = new Label("Game Title:");
				GridPane.setConstraints(nameLabel, 0, 0);
				grid.getChildren().add(nameLabel);
				name.setPromptText("Enter the game's title.");
				name.setPrefColumnCount(10);
				name.getText();
				nameLabel.getStyleClass().add("labels");
				GridPane.setConstraints(name, 1, 0);
				grid.getChildren().add(name);
				/**
				 * @author Jared 
				 *Created a TextField for the amount of hours played
				 */
				hours = new TextField();
				Label hoursLabel = new Label("Hours Played:");
				GridPane.setConstraints(hoursLabel, 0, 2);
				grid.getChildren().add(hoursLabel);
				hoursLabel.getStyleClass().add("labels");
				hours.setPromptText("Enter total hours played.");
				GridPane.setConstraints(hours, 1, 2);
				grid.getChildren().add(hours);
				/**
				 * @author Jared 
				 * Created a TextField for the Rating TextField
				 */
				rating = new TextField();
				Label ratingLabel = new Label("Rating:");
				GridPane.setConstraints(ratingLabel, 0, 1);
				ratingLabel.getStyleClass().add("labels");
				grid.getChildren().add(ratingLabel);
				rating.setPromptText("Rate game out of 10.");
				GridPane.setConstraints(rating, 1, 1);
				grid.getChildren().add(rating);
				/**
				 * @author Jared 
				 * Created a TextArea for the description of the game that 
				 * the user may edit
				 */
				gameDesc = new TextArea();
				Label gameDescLabel = new Label("Game Description:");
				gameDescLabel.getStyleClass().add("labels");
				GridPane.setConstraints(gameDescLabel, 0, 3);
				grid.getChildren().add(gameDescLabel);
				gameDesc.setPromptText("Enter a description of the game:");
				GridPane.setConstraints(gameDesc, 1, 4);
				grid.getChildren().add(gameDesc);
				
				/**
				 * @author Jared 
				 * Added an image and put it in an ImageView
				 */
				Image img = new Image("checkers.jpg");
				ImageView imgVw = new ImageView();
				imgVw.setImage(img);
				/**
				 * @author Jared 
				 * Sets the height and width of the image
				 */
				imgVw.setFitWidth(500);
				imgVw.setFitHeight(100);
				/**
				 * @author Jared 
				 * Created an animation to the image that will fade it
				 */
				FadeTransition ft = new FadeTransition(Duration.millis(4000), imgVw);
				ft.setFromValue(0.1);
				ft.setToValue(1.0);
				ft.setCycleCount(1);
				ft.setAutoReverse(false);
				ft.play();
		
				/**
				 * @author Jared 
				 * Created an HBox to place the image title in and sets
				 * a background color the the HBox
				 */
		HBox top = new HBox();
		//top.setPadding(new Insets(10,10,10,10));
		top.setSpacing(10);
		top.setStyle("-fx-background-color: #333333;");
		/**
		 * @author Jared 
		 * Adds the Image View to the HBox and sets the alignment to Center
		 */
		top.getChildren().add(imgVw);
		top.setAlignment(Pos.CENTER);
		
		/**
		 * @author Jared 
		 * Created an HBox to add the Clear and Next buttons
		 * Sets Padding and spacing to the Hbox
		 * Sets a background color to the Hbox
		 */
		HBox bottom = new HBox();
		bottom.setPadding(new Insets(10,10,10,10));
		bottom.setSpacing(10);
		bottom.setStyle("-fx-background-color: #333333;");

		//label for listview
		//Label gameGenre = new Label("Select the type(s) of games you have played:");
		//list view that lists board game genres 
		//ListView<String> genre = new ListView<String>();
		//g1enre.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		//ObservableList<String> genres = FXCollections.observableArrayList(
		//"Board Games","Video Games","Card Games");
		//genre.setPrefHeight(100);
		//genre.setItems(genres);
		//VBox intro = new VBox();
		//intro.getChildren().addAll(grid,gameGenre,genre);
		
		
		/**
		 * @author Blaze 
		 * Created a VBox to add the checkboxes to
		 * Sets padding to the Label
		 * Sets padding to each button
		 */

				VBox vbox = new VBox();
				
				box1 = new CheckBox("Video Games");
				box2 = new CheckBox("Card Games");
				box3 = new CheckBox("Board Games");
				box1.getStyleClass().add("labels");
				box2.getStyleClass().add("labels");
				box3.getStyleClass().add("labels");
				Label type = new Label("What type of game is it:");
				type.getStyleClass().add("labels");
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
		Button clear = new Button("CLEAR");
		clear.setPrefSize(100, 20);
		clear.setOnMouseClicked(new EventHandler<Event>(){
			@Override
			public void handle(Event event) {
				// TODO Auto-generated method stub
				clearForm();
			}
		}
		);
		
		/**
		 * @author Blaze 
		 * Creates "Next" Button
		 */
		//Brings you to the second scene
		Button next = new Button("NEXT");
		next.setPrefSize(100, 20);
		//add buttons to the hbox
		next.setOnMouseClicked(new EventHandler<Event>(){
			@Override
			public void handle(Event event) {
				//stage.setScene(/*NEW SCENE HERE*/);
			}
		});
		
		/**
		 * @author Jared 
		 * Creates "Submit" Button
		 */
		//Brings you to the second scene
		Button submit = new Button("SUBMIT");
		submit.setPrefSize(100, 20);
		//add buttons to the hbox
		submit.setOnMouseClicked(new EventHandler<Event>(){
			@Override
			public void handle(Event event) {
				thread = new Thread(insert);
				thread.start();

			}
		});
		
		bottom.getChildren().addAll(clear, submit, next);
		bottom.setAlignment(Pos.CENTER);
		
		//create grid pane for the central content of the app
		border.setTop(top);
		border.setCenter(grid);
		border.setBottom(bottom);
		/**
		 * @author Jared 
		 * Creates scene with BorderPane along with width and height of Pane
		 */
		Scene scene = new Scene(border, 800, 500);
		stage.setTitle("Game Management");
		stage.setScene(scene);
		stage.show();

		
		/**
		 * @author Tyler 
		 * Creates a second BorderPane for the records submitted
		 */
		BorderPane seeRecords = new BorderPane();
		Text secondaryTitle = new Text("View Records");
		/**
		 * @author Tyler 
		 * Sets alignment of the Pane to center
		 */
		seeRecords.setAlignment(secondaryTitle, Pos.CENTER);
		/**
		 * @author Tyler 
		 * Sets padding to the BorderPane
		 */
		//seeRecords.setPadding(new Insets(10,10,10,10));
		/**
		 * @author Tyler 
		 * Creates a non-editable TextArea to show records
		 */ 
		//sets padding to the BorderPane
		//seeRecords.setPadding(new Insets(0,0,0,0));
		
		//add image view for second scene with title image
		ImageView imgVw2 = new ImageView();
		imgVw2.setImage(img);
		//set the size of the title image view
		imgVw2.setFitWidth(550);
		imgVw2.setFitHeight(100);
		//create animation for image
		FadeTransition ft2 = new FadeTransition(Duration.millis(4000), imgVw2);
		ft2.setFromValue(0.1);
		ft2.setToValue(1.0);
		ft2.setCycleCount(1);
		ft2.setAutoReverse(false);
		ft2.play();

		//create top hbox for the title image to sit in
		HBox top2 = new HBox();
		top2.setSpacing(10);
		top2.setStyle("-fx-background-color: #333333;");
		//add image view to the hbox
		top2.getChildren().add(imgVw2);
		top2.setAlignment(Pos.CENTER);
		
		//creates Text area to view game records 
		records = new TextArea();
		records.setMaxWidth(600);
		records.setEditable(false);
		seeRecords.setTop(top2);
		seeRecords.setCenter(records);
		seeRecords.setStyle("-fx-background-color: #3BB258;");
		HBox secondaryButtonBox = new HBox();
		Button back = new Button("Back to Form");
		back.setOnAction(e->{
			stage.setScene(scene);
			ft.play();
		});
		secondaryButtonBox.getChildren().add(back);
		
		seeRecords.setBottom(secondaryButtonBox);
		BorderPane.setAlignment(secondaryButtonBox, Pos.CENTER);
		secondaryButtonBox.setAlignment(Pos.CENTER);
		
		secondaryButtonBox.setPadding(new Insets(10,10,10,10));
		secondaryButtonBox.setSpacing(10);
		secondaryButtonBox.setStyle("-fx-background-color: #333333;");
		Scene viewScene = new Scene(seeRecords, 800, 500);

		next.setOnAction(e->{
		/*	Platform.runLater(() -> {
		        try {	
		        	PreparedStatement	preparedStatement =
							GameForm.connection.prepareStatement("SELECT * from GameDataBase");
					
					ResultSet rset = preparedStatement.executeQuery();
					GameForm.records.clear();
					GameForm.records.appendText("Game Title:"+ " " + "Rating" + " " + "Hours Played" + " " + "Game description" + "  " + "Type of game");
					while(rset.next()){
						GameForm.records.appendText(rset.getString("name") + " " + rset.getString("rating") + "\t|\t " + rset.getString("hours") + rset.getString("gameDesc") + "\n");
					}
		        } catch (Exception x) {
		        	x.printStackTrace();
		        }
		    });*/
        	stage.setScene(viewScene);

			thread = new Thread(gd);
			thread.start();
		
			ft2.play();
		});	
		viewScene.getStylesheets().add("main.css");
		scene.getStylesheets().add("main.css");
}
	public static void  clearForm(){
		name.clear();
		hours.clear();
		rating.clear();
		gameDesc.clear();
		box1.setSelected(false);
		box2.setSelected(false);
		box3.setSelected(false);
	}
	public static boolean formEmpty(){
		boolean fieldEmpty = false;
		if(name.getText().trim().isEmpty()){
			 shake(name);
			 fieldEmpty = true;
		}
		if(hours.getText().trim().isEmpty()){
			shake(hours);
			fieldEmpty = true;
		}
		if(rating.getText().trim().isEmpty()){
			shake(rating);
			fieldEmpty = true;
		}
		if(gameDesc.getText().trim().isEmpty()){
			shake(gameDesc);
			fieldEmpty = true;
		}
		if((!box1.isSelected())&&(!box2.isSelected())&&(!box3.isSelected())){
			shake(box1);
			shake(box2);
			shake(box3);
			fieldEmpty = true;
		}
		return fieldEmpty;
	}
	public static void shake(Node textfield){
		TranslateTransition shake = new TranslateTransition(Duration.millis(20), textfield);
		shake.setByX(22);
		shake.setCycleCount(2);
		shake.setAutoReverse(true);
		shake.play();
	}
public static void main(String[] args) {
	// TODO Auto-generated method stub
	Application.launch(args);
}

}