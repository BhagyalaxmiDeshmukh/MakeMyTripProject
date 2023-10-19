package pagepackage;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectData 
{
	WebDriver driver;
	
	@FindBy(xpath="(//*[@class='tabsCircle appendRight5'])[2]")
	private WebElement roundtrip;
	
	@FindBy(xpath="//*[@id='fromCity']")
	private WebElement fromcity;

	@FindBy(xpath="//*[@id='toCity'] ")
	 private WebElement  tocity;
	
	@FindBy(xpath="//*[@class='react-autosuggest__suggestions-list']//li")
	private List<WebElement> fromcityinput;
	
	@FindBy(xpath="//*[@id='react-autowhatever-1']//li")
	private List<WebElement> tocityinput;
		
	@FindBy(xpath="(//*[@class='lbl_input appendBottom10'])[3]")
	private WebElement departure;
	
	@FindBy(xpath="//*[@aria-label='Fri Oct 20 2023']")
	private WebElement departuredate;
	

	@FindBy(xpath="//*[@aria-label='Fri Nov 24 2023']")
	private WebElement returndate;
	
	@FindBy(xpath="//*[@class='lbl_input appendBottom5']")
	private WebElement travellersandclass;
	
	@FindBy(xpath="(//*[text()='Save on bookings with more than 9 travellers'])[2]")
	private WebElement validationmsg;
	
	@FindBy(xpath="//*[@class='guestCounter font12 darkText gbCounter']//li")
	private List<WebElement> adults;
	
	@FindBy(xpath="//*[@data-cy='children-3']")
	private WebElement children;
	
	@FindBy(xpath="//*[@class='commonModal__close']")
	private WebElement signuppopup;
	JavascriptExecutor js=(JavascriptExecutor)driver;
	
	public SelectData(WebDriver driver)
	{
	this.driver=	driver;
	
	PageFactory.initElements(driver,this);
	driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
	}
	public void clickPopUp()
	{
		signuppopup.click();
	}
	public void clickRoundTrip()
	{
		
		roundtrip.click();
	}
		
	
	public void fromCity() throws InterruptedException
	{
		try
		{
		Thread.sleep(2000);
		fromcity.click();
		Thread.sleep(2000);
	
		for(WebElement fromcitydata:fromcityinput)
		{
		String data=	fromcitydata.getText();
		
		if(data.contains("New Delhi, India"))
		{
			Thread.sleep(2000);
			fromcitydata.click();
		}
		}
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
				
	}
	public void toCity() throws InterruptedException
	{
		try
		{
		Thread.sleep(3000);
		 tocity.click();
		 Thread.sleep(3000);
		for(WebElement tocitydata:tocityinput)
		{
		String data=	tocitydata.getText();
		
		if(data.contains("Mumbai, India"))
		{
			Thread.sleep(3000);
			tocitydata.click();
		}
		}
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
 public void selectDeparAndRetDate() throws InterruptedException
	{
	 Thread.sleep(2000);
		departure.click();
		Thread.sleep(2000);
		departuredate.click();
		Thread.sleep(2000);
		
		returndate.click();
		
		
					
	}
	
	public String travellerAndClass() throws InterruptedException
	{
		String msg="";
		String adu="";
		Thread.sleep(2000);
	 travellersandclass.click();
		for(int i=0;i<adults.size();i++)
		{
			adu=adults.get(9).getText();
			
				//WebElement aa=adults.get(i);
				//	aa.click();
			if(adults.get(i).equals(">9"))
			{
				adults.get(i).click();
				break;
			}
			else
			{
				msg=validationmsg.getText();
				System.out.println(msg);
				
			}
			
		
		}
		System.out.println(adu);
			
		children.click();
		return msg;
		
	}
	
	
}
