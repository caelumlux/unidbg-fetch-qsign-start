package lm.teaboss.Pow;

import lm.teaboss.Pow.TimeCounter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Log
{
  private static SimpleDateFormat formatter;
  public static String CODEFILE = "log/code.txt";
  public static String FileName = "";
  
  public static SimpleDateFormat getInstance() {
    if (formatter == null) {
      formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    }
    return formatter;
  }
  
  public static String OPLOGFILE = "\\log\\oplog.txt";

  
  public static void createOneDay() {
    try {
      SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
      String filename = formatter.format(new Date());
      String filepath = "\\log\\";
      
      File file = new File(filepath);
      if (!file.exists()) {
        file.mkdirs();
      }
      
      OPLOGFILE = String.valueOf(filepath) + filename + ".txt";

      
      delete(3);
    } catch (Exception e) {
      e.printStackTrace();
    } 
  }





  
  public static void delete(int days) {
    String filepath = "\\log\\";
    File file = new File(filepath);
    File[] fileList = file.listFiles();
    
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    TimeCounter tc = new TimeCounter();
    for (int i = 0; i < fileList.length; i++) {
      try {
        if (fileList[i].isFile()) {
          File onefile = fileList[i];
          if (onefile.getName().startsWith("20")) {
            
            if (onefile.getName().endsWith(".txt")) {
              String fileName = onefile.getName().split("\\.")[0];
              Date fdate = formatter.parse(fileName);
              long delay = tc.getRemainDay(fdate, new Date());
              if (delay > days) {
                onefile.delete();
              }
            }
          
          } else {
            
            onefile.delete();
          } 
        } 
      } catch (Exception e) {
        e.printStackTrace();
      } 
    } 
  }





  
  public static void saveLogFile(Object msg) {
    writeLog(msg.toString(), true, OPLOGFILE);
  }
  
  public static void println(Object msg) {
    if (Const.LogLevel >= 1) {
      msg = String.valueOf(getInstance().format(new Date())) + " : " + msg.toString();
      System.out.println(msg);
    } 
  }
  
  public static void debug(Object msg) {
    if (Const.LogLevel >= 2) {
      msg = String.valueOf(getInstance().format(new Date())) + " : " + msg.toString();
      System.err.println(msg);
    } 
  }








  
  public static void writeLog(String conent, boolean isNextWriter, String fileName) {
    try {
      File file = new File(fileName);
      if (!file.getParentFile().exists()) {
        file.getParentFile().mkdirs();
      }
      if (!file.exists()) {
        file.createNewFile();
      }
      
      OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(file, isNextWriter), "UTF8");
      PrintWriter pw = new PrintWriter(osw);
      pw.write("\r\n");
      pw.write(conent);
      pw.flush();
      pw.close();
      osw.close();
    } catch (Exception e) {
      e.printStackTrace();
    } 
  }
}
