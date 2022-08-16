package appPages;

import java.awt.AWTException;
import java.io.IOException;
import java.util.HashMap;

import org.openqa.selenium.By;
import reusable.BaseClass;
import utilities.SeleniumActions;

public class DeleteNeighborInNeed extends BaseClass {

			SeleniumActions Actions = new SeleniumActions();
			BaseClass Base = new BaseClass();
			
			public String GetStoryID() throws InterruptedException, IOException, AWTException
			{
				Base.LocatorDataRead();

				HashMap<String, String> Locator = LocatorDataRead();

			String StoryIDXpath = Locator.get("StoryID");
			
			String StoryID = driver.findElement(By.xpath(StoryIDXpath)).getText();
			
			return StoryID;
			
			}
			
	
			public void DeleteIcon() throws InterruptedException, IOException, AWTException
			{
				Base.LocatorDataRead();

				HashMap<String, String> Locator = LocatorDataRead();

				Actions.ActionClass(Locator.get("DeleteIcon"), "click");
			}
			
			public void WaitDeletionPopup() throws InterruptedException, IOException, AWTException {
				
				
				  Base.LocatorDataRead();
				  
				  HashMap<String, String> Locator = LocatorDataRead();
				  
				  Actions.ExplicitWait(20, Locator.get("DeletionPopup"),
				  "visibilityOfElementLocated");
			}
			
			public void DeletionPopupConfirmBtn() throws InterruptedException, IOException, AWTException
			{
				Base.LocatorDataRead();

				HashMap<String, String> Locator = LocatorDataRead();

				Actions.ActionClass(Locator.get("DeletionPopupConfirmBtn"), "click");
				
				Thread.sleep(2000);
			}
			
			public boolean DeletedStoryIDCheck(String StoryID) throws InterruptedException, IOException, AWTException
			{
								
			boolean StoryElement = driver.findElement(By.xpath("(//a[text()='"+StoryID+"'])[1]")).isDisplayed();
			
			return StoryElement;
			
			
			
			}
		
					
						
			}	
			