package testcasepackage;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSelectData  extends BaseTest
{
	@Test(priority=0)
	public void handlePopUp()
	{
		sd.clickPopUp();
	}
	@Test(priority=1)
	public void verifyRoundTrip()
	{
		sd.clickRoundTrip();
	}
	@Test(priority=2)
	public void verifytFromCity() throws InterruptedException
	{
		sd.fromCity();
	}
	
	@Test(priority=3)
	public void verifytToCity() throws InterruptedException
	{
		sd.toCity();
	}
	@Test(priority=6)
	public void verifyDeparture() throws InterruptedException
	{
		sd.selectDeparAndRetDate();
	}

	@Test(priority=7)
	public void verifyTravelAndClass() throws InterruptedException
	{
		sd.travellerAndClass();
		
		Assert.assertEquals(sd.travellerAndClass(),"Save on bookings with more than 9 travellers");
		
	}
}
