
public class Validate {
	private int day = 1;
	private String month = "none";
	private int year = 1900;
	
	public boolean checkDate(){
		if((day == 31) && (month == "Februari" || month == "April" || month == "Juni" || month == "September" || month == "November")){
			return false;
		}else if(month == "Februari" && day == 29 && (year % 4 != 0 || year % 400 != 0)){
			return false;
		}else if(month == "Februari" && (day == 30 || day == 31)){
		return false;
		}
		return true;
	}
	
	public void setDay(int d){
		day = d;
	}
	public int getDay(){
		return day;
	}
	public void setMonth(String m){
		month = m;
	}
	public String getMonth(){
		return month;
	}
	public void setYear(int y){
		year = y;
	}
	public int getYear(){
		return year;
	}
}
