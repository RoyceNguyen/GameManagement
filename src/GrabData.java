import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class GrabData implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			PreparedStatement	preparedStatement =
					GameForm.connection.prepareStatement("SELECT * from GuestBook");
			
			ResultSet rset = preparedStatement.executeQuery();
			GameForm.records.clear();
			GameForm.records.appendText("Name"+ "\t\t|\t" + "Location\n");
			while(rset.next()){
				GameForm.records.appendText(rset.getString("fname") + " " + rset.getString("lname") + "\t|\t " + rset.getString("location") + "\n");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
