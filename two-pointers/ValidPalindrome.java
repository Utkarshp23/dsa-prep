public class ValidPalindrome {

    // Given a string s, return true if it is a palindrome, otherwise return false.

    // A palindrome is a string that reads the same forward and backward. It is also
    // case-insensitive and ignores all non-alphanumeric characters.

    // Note: Alphanumeric characters consist of letters (A-Z, a-z) and numbers
    // (0-9).

    // Example 1:

    // Input: s = "Was it a car or a cat I saw?"

    // Output: true
    // Explanation: After considering only alphanumerical characters we have
    // "wasitacaroracatisaw", which is a palindrome.

    // Example 2:

    // Input: s = "tab a cat"

    // Output: false
    // Explanation: "tabacat" is not a palindrome.

    // Constraints:

    // 1 <= s.length <= 1000
    // s is made up of only printable ASCII characters.

    public boolean isPalindrome(String s) {
        int n = s.length();
        int i = 0;
        int j = n - 1;

        while (i < j) {
            while (i < j && !Character.isLetterOrDigit(s.charAt(i)))
                i++;
            while (i < j && !Character.isLetterOrDigit(s.charAt(j)))
                j--;

            if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j)))
                return false;
            i++;
            j--;
        }

        return true;

    }

    public static void main(String[] args) {
        ValidPalindrome vp = new ValidPalindrome();
        String[] tests = {
                "Was it a car or a cat I saw?",
                "tab a cat",
                "A man, a plan, a canal: Panama",
                "No lemon, no melon"
        };

        for (String test : tests) {
            System.out.println("\"" + test + "\" -> " + vp.isPalindrome(test));
        }
    }

}