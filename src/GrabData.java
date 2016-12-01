import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class GrabData implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			PreparedStatement	preparedStatement =
					GameForm.connection.prepareStatement("SELECT * from GameDataBase");
			
			ResultSet rset = preparedStatement.executeQuery();
			GameForm.records.clear();
			while(rset.next()){
			GameForm.records.appendText("Game Title:"+ " " + rset.getString("gameTitle") +"\n" + "Rating:" + " " + rset.getString("rating") + "\n" +"Hours Played:" + " " + rset.getString("hours") + "\n" + "Game description:" + rset.getString("description") + "\n");
			
				if (rset.getInt("video") == 1){
					GameForm.records.appendText("Video Game: Yes\n");
				} else {
					GameForm.records.appendText("Video Game: No\n");
				}
				if (rset.getInt("card") == 1){
					GameForm.records.appendText("Card Game: Yes\n");
				} else {
					GameForm.records.appendText("Card Game: No\n");
				}
				if (rset.getInt("board") == 1){
					GameForm.records.appendText("Board Game: Yes\n\n");
				} else {
					GameForm.records.appendText("Board Game: No\n\n");
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
