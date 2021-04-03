package fi.vamk.e1700702;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App {

  private static String refNumber = "1 23453";
  static Scanner input = new Scanner(System.in);

  public static void main(String[] args) {
    System.out.println("Give an invoice number (3 < length < 20): ");

    String invoiceNumber = input.nextLine();
    String invoiceReferenceNum = ReferenceValidator.calculateRef(invoiceNumber);
    System.out.println("Invoice reference number: \n" + invoiceReferenceNum);

  }

  public static int lengthIsCorrect() {
    return refNumber.length();
  }

  public static boolean groupByFive() {

    if (refNumber.length() < 6) {
      return true;
    } else {
      int idx = refNumber.length() - 6;
      while (idx > 0) {
        if (refNumber.charAt(idx) != ' ')
          return false;
        idx -= 5;
      }
    }

    return true;
  }

  public static boolean numbersAndSpaces() {

    for (char c : refNumber.toCharArray()) {
      // ASCII
      if (((int) c < 48 || (int) c > 57) && (int) c != 32)
        return false;
    }

    return true;
  }

  public static boolean checkNumberIsCorrect() {

    ArrayList<Integer> nums = new ArrayList<>();
    int sum = 0, checkNum;

    // remove all spaces
    refNumber = refNumber.replaceAll("\\s+", "");

    // split String into String array
    String[] numbers = refNumber.split("");

    // convert String into int
    for (String str : numbers) {
        nums.add(Integer.parseInt(str));
    }

    // calculate the sum of multiplier and refNumber EXCEPT the last digit
    for (int i = 0; i < nums.size() - 1; i++) {
      if ((nums.size() - i) % 3 == 0) {
        sum += nums.get(i) * 1;
      } else if ((nums.size() - i) % 3 == 1) {
        sum += nums.get(i) * 7;
      } else { // (nums.size() - i) % 3 == 2
        sum += nums.get(i) * 3;
      }
    }

    // Calculate check number
    checkNum = sum % 10 == 0 ? 0 : 10 - sum % 10;

    // Check if the checkNum is equal to the last digit in refNumber
    return checkNum == nums.get(nums.size() - 1) ? true : false;

  }
}
