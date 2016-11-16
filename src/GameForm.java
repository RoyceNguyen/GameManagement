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
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
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
		grid.setPadding(new Insets(10, 10, 10, 10));
		grid.setVgap(5);
		grid.setHgap(5);
		
		//Create the gameTitle text field
		final TextField gameTitle = new TextField();
		Label gameTitleLabel = new Label("Game Title:");
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
		GridPane.setConstraints(gameRatingLabel, 0, 1);
		grid.getChildren().add(gameRatingLabel);
		gameRating.setPromptText("Enter the game rating.");
		GridPane.setConstraints(gameRating, 1, 1);
		grid.getChildren().add(gameRating);
		
		//Create the hoursPlayed text field
		final TextField hoursPlayed = new TextField();
		Label hoursPlayedLabel = new Label("Hours Played:");
		GridPane.setConstraints(hoursPlayedLabel, 0, 2);
		grid.getChildren().add(hoursPlayedLabel);
		hoursPlayed.setPromptText("Enter the amount of hours played.");
		GridPane.setConstraints(hoursPlayed, 1, 2);
		grid.getChildren().add(hoursPlayed);
		
		//Create the gameDesc text area
		final TextArea gameDesc = new TextArea();
		Label gameDescLabel = new Label("Game Description:");
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
		GridPane.setConstraints(vbox, 2, 1);
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
