import java.util.Calendar;


public class Calculator {
	private long beginms;
	private long endms;
	private long currentTime;
	private long gbInMs;
	public long differenceMiliseconds(int beginDay, int beginMonth, int beginYear, int endDay, int endMonth, int endYear){
		Calendar cal = Calendar.getInstance();
		cal.set(beginYear,beginMonth-1,beginDay,0 ,0 ,0);
		beginms = cal.getTimeInMillis();
		Calendar cal1 = Calendar.getInstance();
		cal1.set(endYear,endMonth-1,endDay, 0, 0, 0);
		endms = cal1.getTimeInMillis();
		return endms - beginms;
	}
	public long differenceSeconds(int beginDay, int beginMonth, int beginYear, int endDay, int endMonth, int endYear){
		long verschilms = differenceMiliseconds(beginDay, beginMonth, beginYear, endDay, endMonth, endYear);
		return verschilms / 1000;
	}
	public long differenceHours(int beginDay, int beginMonth, int beginYear, int endDay, int endMonth, int endYear){
		long verschilSeconds = differenceSeconds(beginDay, beginMonth, beginYear, endDay, endMonth, endYear);
		return verschilSeconds / 3600;
	}
	public long differenceDays(int beginDay, int beginMonth, int beginYear, int endDay, int endMonth, int endYear){
		long verschilHours = differenceHours(beginDay, beginMonth, beginYear, endDay, endMonth, endYear);
		return verschilHours / 24;
	}
	public long differenceYears(int beginYear, int endYear){
		return endYear - beginYear;
	}

	public int convertMonth(String month) {
		int monthNumber;
		switch (month){
		case "Januari":
			monthNumber = 1;
			break;
		case "Februari":
			monthNumber = 2;
			break;
		case "Maart":
			monthNumber = 3;
			break;
		case "April":
			monthNumber = 4;
			break;
		case "Mei":
			monthNumber = 5;
			break;
		case "Juni":
			monthNumber = 6;
			break;
		case "Juli":
			monthNumber = 7;
			break;
		case "Augustus":
			monthNumber = 8;
			break;
		case "September":
			monthNumber = 9;
			break;
		case "Oktober":
			monthNumber = 10;
			break;
		case "November":
			monthNumber = 11;
			break;
		case "December":
			monthNumber = 12;
		default:
			monthNumber = 1;
		}
		return monthNumber;
	}
	public long aantalMs(int gbDag, int gbMaand, int gbJaar) {
		currentTime = System.currentTimeMillis();
		Calendar calendar = Calendar.getInstance();
		calendar.set(gbJaar, gbMaand - 1, gbDag,0 ,0 ,0);
		gbInMs = calendar.getTimeInMillis();
		return currentTime - gbInMs;
	}
	public long aantalSec(int gbDag, int gbMaand, int gbJaar) {
		long aantalMilis = aantalMs(gbDag, gbMaand, gbJaar);
		return aantalMilis / 1000;
	}
	public long aantalHours(int gbDag, int gbMaand, int gbJaar) {
		long aantalSeconds = aantalSec(gbDag, gbMaand, gbJaar);
		return aantalSeconds / 3600;
	}
	public long aantalDays(int gbDag, int gbMaand, int gbJaar) {
		long aantalUren = aantalHours(gbDag, gbMaand, gbJaar);
		return aantalUren / 24;
	}
	public long aantalYears(int gbDag, int gbMaand, int gbJaar) {
		long aantalDagen = aantalDays(gbDag, gbMaand, gbJaar);
		return aantalDagen / 365;
	}
}
