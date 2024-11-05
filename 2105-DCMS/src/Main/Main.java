package Main;

public class Main 
{
    public static void main(String[] args) 
    {
    userRegistrationPage newUser = new userRegistrationPage();
	LogInPage userLogIn = new LogInPage(newUser.userLoginInfo());
    }
}
