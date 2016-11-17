import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class GameForm extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		
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
	         ColumnConstraints row1 = new ColumnConstraints(130);
	         grid.getColumnConstraints().add(row1);
	         ColumnConstraints row2 = new ColumnConstraints(400);
	         grid.getColumnConstraints().add(row2);
	         ColumnConstraints row3 = new ColumnConstraints(300);
	         grid.getColumnConstraints().add(row3);
	      
	 
		grid.setPadding(new Insets(10, 10, 10, 10));
		grid.setVgap(5);
		grid.setHgap(5);
		
		//Create the gameTitle text field
		final TextField gameTitle = new TextField();
		Label gameTitleLabel = new Label("Game Title:");
		gameTitleLabel.setFont(Font.font("Times New Roman", FontWeight.BOLD, 16));
		gameTitleLabel.setTextFill(Color.LIGHTSLATEGRAY);
		GridPane.setConstraints(gameTitleLabel, 0, 0);
		grid.getChildren().add(gameTitleLabel);
		gameTitle.setPromptText("Enter the game title.");
		gameTitle.setPrefColumnCount(10);
		gameTitle.getText();
		GridPane.setConstraints(gameTitle, 1, 0);
		grid.getChildren().add(gameTitle);
		
		//Create the gameRating text field
		final TextField gameRating = new TextField();
		Label gameRatingLabel = new Label("Game Rating:");
		gameRatingLabel.setFont(Font.font("Times New Roman", FontWeight.BOLD, 16));
		gameRatingLabel.setTextFill(Color.LIGHTSLATEGRAY);
		GridPane.setConstraints(gameRatingLabel, 0, 1);
		grid.getChildren().add(gameRatingLabel);
		gameRating.setPromptText("Enter the game rating.");
		GridPane.setConstraints(gameRating, 1, 1);
		grid.getChildren().add(gameRating);
		
		//Create the hoursPlayed text field
		final TextField hoursPlayed = new TextField();
		Label hoursPlayedLabel = new Label("Hours Played:");
		hoursPlayedLabel.setFont(Font.font("Times New Roman", FontWeight.BOLD, 16));
		hoursPlayedLabel.setTextFill(Color.LIGHTSLATEGRAY);
		GridPane.setConstraints(hoursPlayedLabel, 0, 2);
		grid.getChildren().add(hoursPlayedLabel);
		hoursPlayed.setPromptText("Enter the amount of hours played.");
		GridPane.setConstraints(hoursPlayed, 1, 2);
		grid.getChildren().add(hoursPlayed);
		
		//Create the gameDesc text area
		final TextField gameDesc = new TextField();
		Label gameDescLabel = new Label("Game Description:");
		//gameDesc.setPrefHeight(20);
		gameDescLabel.setFont(Font.font("Times New Roman", FontWeight.BOLD, 16));
		gameDescLabel.setTextFill(Color.LIGHTSLATEGRAY);
		GridPane.setConstraints(gameDescLabel, 0, 3);
		grid.getChildren().add(gameDescLabel);
		gameDesc.setPromptText("Enter a description of the game:");
		GridPane.setConstraints(gameDesc, 1, 3);
		grid.getChildren().add(gameDesc);
		
		//Create the CheckBox buttons for types of games to be checked off
		VBox vbox = new VBox();
		CheckBox box1, box2, box3;
		box1 = new CheckBox("Video Games");
		box2 = new CheckBox("Card Games");
		box3 = new CheckBox("Board Games");
		Label type = new Label("Select the types of games");
		type.setFont(Font.font("Times New Roman", FontWeight.BOLD, 16));
		type.setTextFill(Color.LIGHTSLATEGRAY);
		GridPane.setConstraints(type, 2, 0);
		type.setPadding(new Insets(0, 0, 0, 20));
		grid.getChildren().add(type);
		vbox.getChildren().addAll(box1, box2, box3);
		vbox.setPadding(new Insets(0, 0, 0, 50));
		box1.setPadding(new Insets(10, 0, 0, 0));
		box2.setPadding(new Insets(10, 0, 0, 0));
		box3.setPadding(new Insets(10, 0, 0, 0));
		
		grid.getChildren().addAll(vbox);
		GridPane.setConstraints(type, 2, 0);
		GridPane.setConstraints(vbox, 2, 2);
		//GridPane.setConstraints(box1, 2, 1);
		//GridPane.setConstraints(box2, 2, 2);
		//GridPane.setConstraints(box3, 2, 3);
		
		border.setLeft(grid);
		Scene scene = new Scene(border, 900, 500);
		primaryStage.setTitle("Game Managenent");
		primaryStage.setScene(scene);
		primaryStage.show();
	
	}
	
	
	public static void main(String[] args) {
		Application.launch(args);
	}

	
}
