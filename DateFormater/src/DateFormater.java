
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class DateFormater {
public static void main(String[] args){
	Date birth = null;
	String birthDate =  "30/MAR/2012";
	DateFormat formatter = null;
	//formatter = DateFormat.getDateInstance(DateFormat.MEDIUM);
	formatter = new SimpleDateFormat("dd/MMM/yyyy");
     try {
		birth = formatter.parse(birthDate);
		
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}  
	if (birth == null) {
        System.out.println("Birth object is still null.");
    } else {
        System.out.println("Default date format " + birth);
     System.out.println("Our SimpleDateFormat " + formatter.format(birth));
       System.out.println("Our SimpleDateFormat with all uppercase " + formatter.format(birth).toUpperCase());
    }
}
}
