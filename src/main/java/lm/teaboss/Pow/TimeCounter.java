package lm.teaboss.Pow;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class TimeCounter
{
  private static String TimeMacth_Default = "yyyy-MM-dd HH:mm:ss.SSS";
  
  private static String TimeMacth_Date = "yyyy-MM-dd";
  
  private static String TimeMacth_DateTime = "yyyy-MM-dd HH:mm:ss";
  
  private static String TimeMacth_DateTimeSSS = "yyyy-MM-dd HH:mm:ss.SSS";
  
  public static String getTimeMacth(String input) {
    String timemacth = TimeMacth_Default;
    if (input.length() == 19) {
      timemacth = TimeMacth_DateTime;
    } else if (input.length() == 10) {
      timemacth = TimeMacth_Date;
    } else {
      timemacth = TimeMacth_DateTimeSSS;
    } 
    return timemacth;
  }
  
  public Date getNow() {
    Calendar ca = Calendar.getInstance();
    ca.setTime(new Date());
    SimpleDateFormat simpledate = new SimpleDateFormat(TimeMacth_Default);
    return getDate(simpledate.format(ca.getTime()));
  }







  
  public int compare(Date startDate) {
    return compare(startDate, new Date());
  }









  
  public int compare(Date startDate, Date endDate) {
    return startDate.compareTo(endDate);
  }
  
  public int compare(String inputStart) {
    return compare(inputStart, (String)null);
  }
  
  public int compare(String inputStart, String inputEnd) {
    DateFormat df = new SimpleDateFormat(getTimeMacth(inputStart));
    Date startDate = null;
    Date endDate = null;
    try {
      startDate = df.parse(inputStart);
      if (inputEnd == null || "".equals(inputEnd))
      { endDate = new Date(); }
      else
      { endDate = df.parse(inputEnd); } 
    } catch (ParseException e) {
      e.printStackTrace();
    } 
    return startDate.compareTo(endDate);
  }
  
  public int compareDay(String inputStart, String inputEnd) {
    if (inputStart.length() > 0) {
      inputStart = inputStart.substring(0, 10);
    }
    if (inputEnd.length() > 0) {
      inputEnd = inputEnd.substring(0, 10);
    }
    DateFormat df = new SimpleDateFormat(TimeMacth_Date);
    Date startDate = null;
    Date endDate = null;
    try {
      startDate = df.parse(inputStart);
      if (inputEnd == null || "".equals(inputEnd))
      { endDate = new Date(); }
      else
      { endDate = df.parse(inputEnd); } 
    } catch (ParseException e) {
      e.printStackTrace();
    } 
    return startDate.compareTo(endDate);
  }







  
  public String getString(Date date) {
    DateFormat df = new SimpleDateFormat(TimeMacth_Default);
    return df.format(date);
  }
  
  public String getStrDatetime(Date date) {
    DateFormat df = new SimpleDateFormat(TimeMacth_DateTime);
    return df.format(date);
  }







  
  public Date getDate(String input) {
    DateFormat df = new SimpleDateFormat(getTimeMacth(input));
    try {
      return df.parse(input);
    } catch (ParseException e) {
      e.printStackTrace();
      return null;
    } 
  }











  
  public Date offset(Date date, int field, int amount) {
    GregorianCalendar grecal = new GregorianCalendar();
    grecal.setTime(date);
    grecal.add(field, amount);
    return grecal.getTime();
  }

  
  public Date offsetYear(Date date, int amount) {
    return offset(date, 1, amount);
  }

  
  public Date offsetMonth(Date date, int amount) {
    return offset(date, 2, amount);
  }

  
  public Date offsetDate(Date date, int amount) {
    return offset(date, 5, amount);
  }

  
  public Date offsetHour(Date date, int amount) {
    return offset(date, 10, amount);
  }

  
  public Date offsetMin(Date date, int amount) {
    return offset(date, 12, amount);
  }

  
  public Date offsetSec(Date date, int amount) {
    return offset(date, 13, amount);
  }

  
  public long getRemainDay(Date start, Date end) {
                return getRemainHour(start, end) / 24L;
  }

  
  public long getRemainHour(Date start, Date end) {
                return getRemainMin(start, end) / 60L;
  }

  
  public long getRemainMin(Date start, Date end) {
                return getRemainSec(start, end) / 60L;
  }

  
  public long getRemainSec(Date start, Date end) {
                return getRemainMs(start, end) / 1000L;
  }

  
  public long getRemainMs(Date start, Date end) {
    return end.getTime() - start.getTime();
  }






  
  public String getToJson(String input) {
    return getToJson(getDate(input));
  }
  
  public String getToJson(Date date) {
    return getToJson(new Date(), date);
  }
  
  public String getToJson(Date start, Date end) {
    GregorianCalendar grecal = new GregorianCalendar();
    String json = "{re:'" + getRemainMs(start, end) + "'," + "y:'" + grecal.get(1) + "'," + "M:'" + (grecal.get(2) + 1) + "'," + "d:'" + grecal.get(5) + "'," + "h:'" + grecal.get(11) + "'," + "m:'" + grecal.get(12) + "'," + "s:'" + grecal.get(13) + "'," + "S:'" + grecal.get(14) + "'," + "W:'" + (grecal.get(7) - 1) + "'" + "}";
    
    return json;
  }



































  
  public static void main(String[] args) {
    System.out.println((new TimeCounter()).getDate("2020-10-02"));
  }
}
