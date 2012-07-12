import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Calendar;

import urbanairship.*;



public class UANotification {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		doSomething();
		
	}
	

	
	public static void doSomething()
	{
		
		UrbanAirshipClient client = new UrbanAirshipClient("LKjOfcWPT_GbyYXieoH0bA", "RcZiB0xRTG2tPzf2oNz3Bg");
		
		/*Device device = new Device();
		
		device.setiOSDeviceToken("58dbb6334b65ef03a07fddf00969ba7ddd77d45492eb4746eff7f2909c40ed90");
		
		device.setAlias("kannans01");
		
		device.addTag("oregon_resident");
		device.addTag("pacific_time_zone");
		device.addTag("rebecca_black_fan");
		
		
		client.register(device);
		*/
		
		Push p = new Push();
		
		p.addDeviceToken("58dbb6334b65ef03a07fddf00969ba7ddd77d45492eb4746eff7f2909c40ed90");
		
		p.setMessage("Kannan Testing again but From UA");
		
		/*
		Calendar scheduleFor = Calendar.getInstance();
		scheduleFor.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
		scheduleFor.set(Calendar.HOUR_OF_DAY, 8);
		
		p.addScheduleFor(scheduleFor);
		*/
		
		client.sendPushNotifications(p);
		
		
		System.out.println("Notification send successfully");
		
	}

	
	
	private void sendN(){
		
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);

		String urlString = "https://go.urbanairship.com/api/device_tokens/58dbb6334b65ef03a07fddf00969ba7ddd77d45492eb4746eff7f2909c40ed90/";

		String userPassword = "LKjOfcWPT_GbyYXieoH0bA" + ":"
				+ "RcZiB0xRTG2tPzf2oNz3Bg";

		String encoding = new sun.misc.BASE64Encoder().encode(userPassword
				.getBytes());

		try {
			URL url = new URL(urlString);
			URLConnection uc = url.openConnection();

			uc.setRequestProperty("Authorization", "Basic " + encoding);
			
			InputStream content = (InputStream) uc.getInputStream();
			BufferedReader in = new BufferedReader(new InputStreamReader(
					content));
			String line;
			while ((line = in.readLine()) != null) {
				pw.println(line);
			}

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
	

}
