package appresuablefeatures;

import java.awt.AWTException;
import java.io.IOException;
import appPages.CreateNeighborInNeed;
import appPages.HomePage;
import appPages.Login;
import reusable.BaseClass;

public class Resuables extends BaseClass {

	Login login = new Login();
	HomePage HP = new HomePage();
	CreateNeighborInNeed create = new CreateNeighborInNeed();

	public void Login() throws InterruptedException, IOException, AWTException {
		
		
		if (login.LoginToYourAccount()) {

			login.WaitUsername();

			login.UserName();

			login.WaitPassword();

			login.Password();

			login.WaitLoginButton();

			login.LoginButton();
			
            HP.WaitApptitle();
			
			Thread.sleep(5000);
		}
		else
		{
			
		}

	}
	
public void CreateStory() throws InterruptedException, IOException, AWTException {
	String testname = "TS_AOC_003";
	
		if (create.Apptitle()) {

			create.WaitFormtitle();
			create.Apptitle();
			create.Category();
			
			String[] inputfieldarray = {"Title","Nameoftheperson","Description","TargetAmount","ThankYouMessage" };
			
			create.getvaluefromfield(testname, inputfieldarray);
			
			create.SaveButton();
			create.WaitConfirmationPopup();
			create.ConfirmationPopupOkBtn();
			create.WaitAddedformOnTheGrid();
					
	}
		else
		{
			driver.navigate().to("https://svdpappdev.wpengine.com/gift-dashboard/?type=Individual");  
			create.AddNewStoryButton();
			create.WaitFormtitle();
			create.Apptitle();
			create.Category();
			
			String[] inputfieldarray = {"Title","Nameoftheperson","Description","TargetAmount","ThankYouMessage" };
			
			create.getvaluefromfield(testname, inputfieldarray);
			
			create.SaveButton();
			create.WaitConfirmationPopup();
			create.ConfirmationPopupOkBtn();
			create.WaitAddedformOnTheGrid();
		}
}
}
