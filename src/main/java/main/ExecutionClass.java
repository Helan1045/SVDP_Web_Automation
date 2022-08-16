package main;

import java.util.Arrays;
import java.util.List;

import org.testng.annotations.Test;

import appPages.CreateNeighborInNeed;
import appPages.DeleteNeighborInNeed;
import appPages.HomePage;
import appPages.Login;
import appPages.UpdateNeighborInNeed;
import appresuablefeatures.Resuables;
import reusable.BaseClass;
import utilities.ExtentReport;

public class ExecutionClass extends BaseClass {

	ExtentReport ER = new ExtentReport();
	BaseClass BS = new BaseClass();
	Login login = new Login();
	HomePage HP = new HomePage();
	CreateNeighborInNeed create = new CreateNeighborInNeed();
	UpdateNeighborInNeed update = new UpdateNeighborInNeed();
	DeleteNeighborInNeed delete = new DeleteNeighborInNeed();
	Resuables reuse = new Resuables();
	
	//Verify whether login page is displayed when punch in the URL in the browser
	
	  @Test public void TS_AOC_001() throws Exception {
	  
	  String testname = "TS_AOC_001"; try {
	  
	  login.AppLoginURL();
	  
	  login.WaitLoginToYourAccount();
	  
	  boolean exist = login.LoginToYourAccount();
	  
	  if (exist)
	  { ER.ERSS(testname, "Pass", "Login page displayed"); 
	  } else 
	  {
	  ER.ERSS(testname, "Fail", "Login page not displayed");
	  }
	  log.info(testname + " Executed Sucessfully"); } catch (Exception e) { ER.ERSS(testname,
	  "Exception", e.getMessage()); log.error(testname + " Execution Failed" +
	  e.getMessage()); } }
	 
	

	
	//Verify whether user logged in to the application when provide valid credentials
    @Test
	public void TS_AOC_002() throws Exception {

		String testname = "TS_AOC_002";
		try {

			 login.AppLoginURL();
			 
			login.WaitUsername();

			login.UserName();

			login.WaitPassword();

			login.Password();

			login.WaitLoginButton();

			login.LoginButton();

			HP.WaitApptitle();
			
			Thread.sleep(5000);

			boolean exist = HP.Apptitle();

			if (exist) {
				ER.ERFSS(testname, "Pass", "Login Sucessfull");
			} else {
				ER.ERFSS(testname, "Fail", "Login failed");
			}
			log.info(testname + " Executed Sucessfully");
		} catch (Exception e) {
			ER.ERFSS(testname, "Exception", e.getMessage());

			log.error(testname + " Execution Failed" + e.getMessage());
		}
    }

		//Verify whether the admin can add a new story in neighbor in need 
	    @Test
		public void TS_AOC_003() throws Exception {

			String testname = "TS_AOC_003";
			try {
			
				//reuse.Login();
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
				String DisplayedTitle = create.FormtitleontheGrid();
				
				
				if(create.EnteredTitle.equals(DisplayedTitle))
				{
					ER.ERFSS(testname, "Pass", "Form is submitted successfully & Title is reflected properly");
				}
				
				else
				{
					ER.ERFSS(testname, "Fail", "Form is not submitted");
				}
				log.info(testname + " Executed Sucessfully");
				
				        						
			}
			catch (Exception e) {
				ER.ERFSS(testname, "Exception", e.getMessage());

				log.error(testname + " Execution Failed" + e.getMessage());
			}
	
}

	  //Verify whether the admin can update a created story in neighbor in need 
	    @Test (groups= {"SmokeTest"})  
		public void TS_AOC_004() throws Exception {

			String testname = "TS_AOC_004";
			try {
				
				/*
				 * login.AppLoginURL(); reuse.Login(); reuse.CreateStory();
				 */
				update.EditIcon();
				update.WaitCategoryfield();
				update.Categoryfield();
				update.Category();
				
				String[] inputfieldarray = {"Title","Nameoftheperson","Description","TargetAmount","ThankYouMessage" };
				
				update.getvaluefromfield(testname, inputfieldarray);
				
				update.UpdateButton();
				update.WaitUpdateConfirmationPopup();
				update.UpdateConfirmationPopupOkBtn();
				update.WaitUpdatedformOnTheGrid();
				String DisplayedTitle = update.UpdatedtitleontheGrid();
				
				
				if(update.EnteredTitle.equals(DisplayedTitle))
				{
					ER.ERFSS(testname, "Pass", "Form is updated successfully & Title is reflected properly");
				}
				
				else
				{
					ER.ERFSS(testname, "Fail", "Form is not updated");
				}
				log.info(testname + " Executed Sucessfully");
				
				        						
			}
			catch (Exception e) {
				ER.ERFSS(testname, "Exception", e.getMessage());

				log.error(testname + " Execution Failed" + e.getMessage());
			}
	
}
	    //Verify whether the admin can delete a created story in neighbor in need 
	    @Test
		public void TS_AOC_005() throws Exception {

			String testname = "TS_AOC_005";
			
			try {

				/*
				 * login.AppLoginURL(); reuse.Login(); reuse.CreateStory();
				 */
				String StoryID = delete.GetStoryID();
				delete.DeleteIcon();
				delete.WaitDeletionPopup();
				delete.DeletionPopupConfirmBtn();
						
				if(delete.DeletedStoryIDCheck(StoryID))
				{
					ER.ERFSS(testname, "Pass", "Story is deleted successfully");
				}
				
				else
				{
					ER.ERFSS(testname, "Fail", "Story is not deleted");
				}
				log.info(testname + " Executed Sucessfully");			        						
			}
				
			
			catch (Exception e) {
				ER.ERFSS(testname, "Exception", e.getMessage());

				log.error(testname + " Execution Failed" + e.getMessage());
			}
	    
}
}
