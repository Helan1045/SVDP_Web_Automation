package appPages;


import java.awt.AWTException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import reusable.BaseClass;
import utilities.SeleniumActions;

public class CreateNeighborInNeed extends BaseClass {

			SeleniumActions Actions = new SeleniumActions();
			BaseClass Base = new BaseClass();
			public String EnteredTitle = "";
			
			public void AddNewStoryButton() throws InterruptedException, IOException, AWTException
			{
				Base.LocatorDataRead();

				HashMap<String, String> Locator = LocatorDataRead();

				Actions.ActionClass(Locator.get("AddNewStoryButton"), "click");
			}
			
			public void WaitFormtitle() throws InterruptedException, IOException, AWTException {
				
				Base.LocatorDataRead();

				HashMap<String, String> Locator = LocatorDataRead();
				
				Actions.ExplicitWait(20, Locator.get("AddNewStoryTitle"), "visibilityOfElementLocated");
			}

			public boolean Apptitle() throws InterruptedException, IOException, AWTException {

				Base.LocatorDataRead();

				HashMap<String, String> Locator = LocatorDataRead();

				boolean exist = Actions.IsExists(Locator.get("AddNewStoryTitle"));

				return exist;
			}

		public void Category() throws InterruptedException, IOException, AWTException {

		Base.LocatorDataRead();

		HashMap<String, String> Locator = LocatorDataRead();

		String Category = Locator.get("Category");
		
		WebElement categoryElement = driver.findElement(By.xpath(Category));
		
		Select dropdown= new Select(categoryElement);
		dropdown.selectByIndex(2);

		}
		
		
		public void getvaluefromfield(String testname,String[] fieldnamearray) throws InterruptedException, IOException, AWTException {
			

			Base.LocatorDataRead();

			HashMap<String, String> Locator = LocatorDataRead();

			Base.TestDataRead();

			Map<String, Map<String, String>> Data = TestDataRead();

			int RI = RowIndexTestData(testname);

			String R = String.valueOf(RI);
			

			for(String fieldname : fieldnamearray)
			{
				
				Actions.SendKeys(Locator.get(fieldname), Data.get(R).get(fieldname));
				if(fieldname.equals("Title"))
				  { 
					 EnteredTitle = Data.get(R).get(fieldname);
				  System.out.println(EnteredTitle);
				  
				  }
			}
			
			}
		
		public void SaveButton() throws InterruptedException, IOException, AWTException
		{
			Base.LocatorDataRead();

			HashMap<String, String> Locator = LocatorDataRead();

			Actions.ActionClass(Locator.get("SaveButton"), "click");
		}
		
		public void WaitConfirmationPopup() throws InterruptedException, IOException, AWTException {
			
			Thread.sleep(7000);
		}
		
		public void ConfirmationPopupOkBtn() throws InterruptedException, IOException, AWTException
		{
			Base.LocatorDataRead();

			HashMap<String, String> Locator = LocatorDataRead();

			Actions.ActionClass(Locator.get("ConfirmationPopupOkBtn"), "click");
		}
		
public void WaitAddedformOnTheGrid() throws InterruptedException, IOException, AWTException {
			
	
	  Base.LocatorDataRead();
	  
	  HashMap<String, String> Locator = LocatorDataRead();
	  
	  Actions.ExplicitWait(20, Locator.get("AddedTitleontheGrid"),
	  "visibilityOfElementLocated");
	 	
			
}	
			
			public String FormtitleontheGrid() throws InterruptedException, IOException, AWTException {

				Base.LocatorDataRead();

				HashMap<String, String> Locator = LocatorDataRead();
				
              String TitleXpath = Locator.get("AddedTitleontheGrid");
			
			String DisplayedTitle = driver.findElement(By.xpath(TitleXpath)).getText();
			
			return DisplayedTitle;
			
}
}
		

	


