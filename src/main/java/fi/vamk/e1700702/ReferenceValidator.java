package fi.vamk.e1700702;

import java.util.ArrayList;

public class ReferenceValidator {
  public static String calculateRef(String invoice_num) {
    
    StringBuilder result = new StringBuilder("");
    ArrayList<Integer> nums = new ArrayList<>();
    int sum = 0;
    int checkNum;

    if (invoice_num.length() < 4 || invoice_num.length() > 19)
    {
      result.append("Invalid invoice number");
      return result.toString();
    }

    // split String into String array
    String[] numbers = invoice_num.split("");
    
    // convert String into int
    for (String str : numbers) {
      nums.add(Integer.parseInt(str));
    }

    // Calculate sum
    // (length - currentIndex) % 3
    // 0 => 1, 1 => 7, 2 => 3
    for (int i = 0; i < nums.size(); i++) {
      if ((nums.size() - i) % 3 == 0) {
        sum += nums.get(i) * 1;
      } else if ((nums.size() - i) % 3 == 1) {
        sum += nums.get(i) * 7;
      } else {    // (nums.size() - i) % 3 == 2
        sum += nums.get(i) * 3;
      }
    }

    // Calculate check number
    checkNum = sum % 10 == 0 ? 0 : 10 - sum % 10;

    // Add checkNum to the invoice number
    result.append(invoice_num + checkNum);

    // Check if the invoice number length is larger than 5. If it is, then 
    // add space from right to left every 5 characters
    if (result.length() > 5) {
      int idx = result.length() - 5;
      while(idx > 0) {
        result.insert(idx, " ");
        idx = idx - 5;
      }
    }

    return result.toString();

  }
}