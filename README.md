**
SQLQuery to create the database table 
create table GameDatabase (
  game_id INT NOT NULL AUTO_INCREMENT,
  gameTitle VARCHAR(128) NOT NULL,
  rating VARCHAR(20) NOT NULL,
  hours VARCHAR(20) NOT NULL,
  description VARCHAR(1024) NOT NULL,
  video bit NOT NULL,
  card bit NOT NULL,
  board bit NOT NULL,
  PRIMARY KEY(game_id)
  );	
**





**
Local MySQL Database 
NOTE : php.scweb.ca cant be accessed at home , you can however download MySQL server on your home computer and test it there 
Create a class named Const.java or download the zip folder from Cai and edit 

Put in your phpmyadmin username and password

	public class Const {

	public static final String USERNAME = "username";
	
	public static final String PASSWORD = "password";
	}
 
 switch to the form and add in 
 
 	protected void initializeDB(){
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://php.scweb.ca/<YOURUSERNAME>db?useSSL=false", Const.USERNAME, Const.PASSWORD);
            statement = connection.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
 
change <Yourusername> to your phpmyadmin username 

go to phpmyadmin , goto yourusernamedb , go so SQL and run 

create table GuestBook (
  guest_id INT NOT NULL AUTO_INCREMENT,
  fname VARCHAR(64) NOT NULL,
  lname VARCHAR(64) NOT NULL,
  location VARCHAR(64) NOT NULL,
  visit_date TIMESTAMP NOT NULL DEFAULT now(),
  PRIMARY KEY(guest_id)
  );	
  
 test and run the program

**
Group project for Java class.

Git Config Instructions

Set name: git config --global user.name <<<YOUR NAME HERE>>>

Set email: git config --global user.email <<<YOUR EMAIL HERE>>>

Commiting Instructions

First, we'll make sure we're up to date with the staging branch using the following command: git pull staging

We will then change branch to staging. To change from our current branch to staging, we execute the following: git checkout staging

Create your feature branch, the feature branch name should be descriptive of the feature you are adding to the project. To do this, run: git checkout -b <<<YOUR BRANCH NAME>>>

Next, you will push the branch to the git repository. git push origin <<<YOUR BRANCH NAME>>>

Make the changes to the application, making commits as necessary (git commit -m <<<COMMIT MESSAGE>>>). Make sure you write JavaDoc comments as necessary. I will not merge your branches if you do not have this. When complete the feature, merge the staging branch into your branch. You will probably end up with a merge conflict. Resolve the conflict. Ensure the application compiles. Make a commit after you resolve the merge conflict.

Finially, create a pull request for your branch to the staging branch. Make sure you watch the pull request page for my feedback.

Tips For Avoiding Waiting

Create and document your feature and how to interact with it from another class. Make sure your code functions. If the functionality your class requires to work in the application does not yet exist, create a test class to ensure it works. Document how to use/interact with the class properly. cough JavaDoc couch
