package lm.teaboss.Pow;

import java.util.Random;


public class CharacterUtils
{
  public static final String RString1 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
  public static final String RString2 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890-_";
  public static final String RString_00A8 = "aebhURMP";
  public static final String RString_00A8_Lower = "aebh";
  public static final String[] Base64String = new String[] {
      
      "YmJiYmJiYmJiYmJiYmJiYmJiYmJiYmJiYmJiYmJiYmI=", 
      
      "aGhoaGhoaGhoaGhoaGhoaGhoaGhoaGhoaGhoaGhoaGg=", 
      
      "VVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVU=", 
      
      "WFhYWFhYWFhYWFhYWFhYWFhYWFhYWFhYWFhYWFhYWFg=", 
      
      "Z2dnZ2dnZ2dnZ2dnZ2dnZ2dnZ2dnZ2dnZ2dnZ2dnZ2c=", 
      
      "UlJSUlJSUlJSUlJSUlJSUlJSUlJSUlJSUlJSUlJSZWU=", 
      
      "YWFhTU1NTU1NTU1NTU1NTU1NTU1NTU1NTU1NTU1NTU0=", 
      
      "ZWVlZWVlZWVlZWVlZWVlZWVlZWVlZWVlZWVlZWVlZWU=", 
      
      "UFBQUFBQUFBQUFBQUFBQUFBQUFBQUFBQUFBQUFBQUFA=", 
      
      "WVlZWVlZWVlZWVlZWVlZWVlZWVlZWVlZWVlZWVlZWVk=",
      
      "V1dXV1dXV1dXV1dXV1dXV1dXV1dXV1dXV1dXV1dXV1c="
    };
  public static int Index = 0;
  
  public static void main(String[] args) {
    for (int i = 0; i < 20; i++) {
      System.out.println(get00A8Base64String());
    }
  }
  
  public static String reverse(String str) {
    if (str == null) {
      return null;
    }
    char[] chars = str.toCharArray();
    int n = chars.length - 1;
            for (int i = 0; i < chars.length / 2; i++) {
      char temp = chars[i];
      chars[i] = chars[n - i];
      chars[n - i] = temp;
    } 
    return new String(chars);
  }

  
  public static String get00A8Base64String() {
    Index++;
    return Base64String[Index % Base64String.length];
  }

  
  public static String get00A8String() {
    Random random = new Random();
    int number = random.nextInt("aebhURMP".length());
    StringBuffer sb = new StringBuffer();
    char letter = "aebhURMP".charAt(number);
    boolean isUppisUpperCase = Character.isUpperCase(letter);
    for (int i = 0; i < 32; i++) {
      sb.append(letter);
    }

    
    if (isUppisUpperCase) {
      int leftRight = random.nextInt(2);
      
      leftRight = 1;
      if (leftRight == 1) {
        int left = random.nextInt(2);
        int count = random.nextInt(2) + 2;
        number = random.nextInt("aebh".length());
        char letter_lower = "aebh".charAt(number);
        for (int j = 0; j < count; j++) {
          sb = sb.replace(j, j + 1, String.valueOf(letter_lower));
        }
        if (left == 0) {
          return sb.toString();
        }
        return sb.reverse().toString();
      } 
    } 
    
    return sb.toString();
  }








  
  public static String RandomStringRange(int length, String value) {
    Random random = new Random();
    StringBuffer sb = new StringBuffer();
    
    for (int i = 0; i < length; i++) {
      
      int number = random.nextInt(value.length());
      
      sb.append(value.charAt(number));
    } 
    
    return sb.toString();
  }

  
  public static String getRandstr(int length) {
    Random random = new Random();
    StringBuffer sb = new StringBuffer();
    
    for (int i = 0; i < length; i++) {
      
      int number = random.nextInt("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890".length());
      
      sb.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890".charAt(number));
    } 
    
    return sb.toString();
  }

  
  public static String getRandstr() {
    Random random = new Random();
    StringBuffer sb = new StringBuffer();
    
    for (int i = 0; i < 3; i++) {
      
      int number = random.nextInt("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890".length());
      
      sb.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890".charAt(number));
    } 
    
    return "@" + sb.toString();
  }

  
  public static String getTicket() {
    Random random = new Random();
    StringBuffer sb = new StringBuffer();
    
    for (int i = 0; i < 118; i++) {
      
      int number = random.nextInt("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890-_".length());
      
      sb.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890-_".charAt(number));
    } 
    
    return "t02" + sb.toString() + "**";
  }
  
  public static String getCode() {
    return String.valueOf(getRandstr()) + "----" + getTicket();
  }
}

