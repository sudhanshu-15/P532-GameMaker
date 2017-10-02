package game.create;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimerTask;



/*
 * @author: Pulkit Mathur 
 */

public class GameClock extends TimerTask{

	private String time;

	public GameClock() {
		time = "00:00";
	}
	
	
	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public void reset() {
		this.setTime("00:00");
	}

	public void execute() 
	{
		Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        this.time =  sdf.format(cal.getTime());
	}


	@Override
	public void run() {
		execute();
		System.out.println(this.getTime());
	}
}
