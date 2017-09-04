package es.palmademallorca.factu.utils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

public class ModelUtils {
  public static final String DEFAULTENTITAT="JUDI";
  public static final String E_RANG_DATES_KEY="error.rangdates.invalid";
  
  
  public static final int DIES_DESDE_DEFECTE=-8000;
  
  public static boolean beforeThat(Date date1, Date date2) {
	  return date1==null||date2==null?true:date2.before(date1);
  }
  
  public static boolean afterThat(Date date1, Date date2) {
	  return date1==null||date2==null?false:date1.after(date2);
  }
  
  public static boolean equalsThat(Date date1, Date date2) {
	  return date1==null||date2==null?false:date1.equals(date2);
  }
  
  
  
}
