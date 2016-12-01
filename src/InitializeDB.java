import java.sql.DriverManager;

public class InitializeDB implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.jdbc.Driver");
            GameForm.connection = DriverManager.getConnection("jdbc:mysql://php.scweb.ca/hnguyendb?useSSL=false", database.USERNAME, database.PASSWORD);
            System.out.println("Connection succsessful");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Connection successful");
		}
	}
}
