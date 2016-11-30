import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertData implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		if(!GameForm.formEmpty()){
			try {			
				PreparedStatement	preparedStatement =
						GameForm.connection.prepareStatement("insert into GameDatabase (gameTitle, rating, hours, description, video, card, board) values (?, ?,?,?,?,?,?);");
				preparedStatement.setString(1, GameForm.name.getText());
				preparedStatement.setString(2, GameForm.hours.getText());
				preparedStatement.setString(3, GameForm.rating.getText());
				preparedStatement.setString(4, GameForm.gameDesc.getText());
				preparedStatement.setInt(5, (GameForm.box1.isSelected()) ? 1 : 0);
				preparedStatement.setInt(6, (GameForm.box2.isSelected()) ? 1 : 0);
				preparedStatement.setInt(7, (GameForm.box3.isSelected()) ? 1 : 0);
				preparedStatement.executeUpdate();
				GameForm.clearForm();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
}
	
