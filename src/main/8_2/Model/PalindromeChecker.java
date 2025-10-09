package Model;

public class PalindromeChecker {
    public static boolean isPalindrome(String str) {
        String cleanedStr = str.replaceAll(",", "").toLowerCase();
        String finalStr = cleanedStr.replaceAll(" ", "");
        String[] arr = finalStr.split("");
        String reversed = "";
        for (int i = arr.length - 1; i >= 0; i--) {
            reversed += arr[i];
    }
        return finalStr.equals(reversed);
    }
}
