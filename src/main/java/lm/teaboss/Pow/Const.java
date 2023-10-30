package lm.teaboss.Pow;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;


public class Const
{
  
  public static final String UTF8 = "UTF8";
  
  public static int LogLevel = 1;
  
  public static TimeCounter TC = new TimeCounter();






  
  public static String printUrlAndParam(HttpServletRequest request) {
    String uri = request.getRequestURI();
    
    Log.println(getIP4(request));
    Log.println(uri);
    Map<String, String[]> map = request.getParameterMap();
    for (Map.Entry<String, String[]> entry : map.entrySet()) {
      System.out.print(String.valueOf(entry.getKey()) + "=" + ((String[])entry.getValue())[0] + "&");
    }
    System.out.println();
    return uri;
  }






  
  public static String getIP4(HttpServletRequest request) {
    String ip = request.getHeader("x-forwarded-for");
    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
      ip = request.getHeader("Proxy-Client-IP");
    }
    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
      ip = request.getHeader("WL-Proxy-Client-IP");
    }
    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
      ip = request.getRemoteAddr();
    }
    return ip;
  }
}
