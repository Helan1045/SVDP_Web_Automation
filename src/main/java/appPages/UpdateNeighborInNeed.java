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

public class UpdateNeighborInNeed extends BaseClass {

			SeleniumActions Actions = new SeleniumActions();
			BaseClass Base = new BaseClass();
			public String EnteredTitle = "";
			
			
			
			public void EditIcon() throws InterruptedException, IOException, AWTException
			{
				Base.LocatorDataRead();

				HashMap<String, String> Locator = LocatorDataRead();

				Actions.ActionClass(Locator.get("EditIcon"), "click");
			}
			
			public void WaitCategoryfield() throws InterruptedException, IOException, AWTException {
				
				Base.LocatorDataRead();

				HashMap<String, String> Locator = LocatorDataRead();
				
				Thread.sleep(5000);
				
				Actions.ExplicitWait(20, Locator.get("Categoryfield"), "visibilityOfElementLocated");
			}

			public boolean Categoryfield() throws InterruptedException, IOException, AWTException {

				Base.LocatorDataRead();

				HashMap<String, String> Locator = LocatorDataRead();

				boolean exist = Actions.IsExists(Locator.get("Categoryfield"));

				return exist;
			}

		public void Category() throws InterruptedException, IOException, AWTException {

		Base.LocatorDataRead();

		HashMap<String, String> Locator = LocatorDataRead();

		String Category = Locator.get("Category");
		
		WebElement categoryElement = driver.findElement(By.xpath(Category));
		
		Select dropdown= new Select(categoryElement);
		dropdown.selectByIndex(1);

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
				
				 String FieldXpathValue = Locator.get(fieldname);
					
				 driver.findElement(By.xpath(FieldXpathValue)).clear();
				
				Actions.SendKeys(Locator.get(fieldname), Data.get(R).get(fieldname));
				if(fieldname.equals("Title"))
				  { 
					 EnteredTitle = Data.get(R).get(fieldname);
				  System.out.println(EnteredTitle);
				  
				  }
			}
			
			}
		
		public void UpdateButton() throws InterruptedException, IOException, AWTException
		{
			Base.LocatorDataRead();

			HashMap<String, String> Locator = LocatorDataRead();

			Actions.ActionClass(Locator.get("UpdateButton"), "click");
		}
		
		public void WaitUpdateConfirmationPopup() throws InterruptedException, IOException, AWTException {
						
			Thread.sleep(7000);
		}
		
		public void UpdateConfirmationPopupOkBtn() throws InterruptedException, IOException, AWTException
		{
			Base.LocatorDataRead();

			HashMap<String, String> Locator = LocatorDataRead();

			Actions.ActionClass(Locator.get("UpdateConfirmationPopupOkBtn"), "click");
		}
		
public void WaitUpdatedformOnTheGrid() throws InterruptedException, IOException, AWTException {
			
	 Base.LocatorDataRead();
	  
	  HashMap<String, String> Locator = LocatorDataRead();
	  
	  Actions.ExplicitWait(20, Locator.get("UpdatedTitleontheGrid"),
	  "visibilityOfElementLocated");	
			
}	
			
			public String UpdatedtitleontheGrid() throws InterruptedException, IOException, AWTException {

				Base.LocatorDataRead();

				HashMap<String, String> Locator = LocatorDataRead();
				
              String TitleXpath = Locator.get("UpdatedTitleontheGrid");
			
			String DisplayedTitle = driver.findElement(By.xpath(TitleXpath)).getText();
			
			return DisplayedTitle;
			
}
}
		
