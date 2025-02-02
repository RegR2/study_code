package leetcode;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        String longestPalindrome = longestPalindrome("xaaaabbbbbbbbbbccccccccccddddddddddeeeeeeeeeeffffffffffgggggggggghhhhhhhhhhiiiiiiiiiijjjjjjjjjjkkkkkkkkkkllllllllllmmmmmmmmmmnnnnnnnnnnooooooooooppppppppppqqqqqqqqqqrrrrrrrrrrssssssssssttttttttttuuuuuuuuuuvvvvvvvvvvwwwwwwwwwwxxxxxxxxxxyyyyyyyyyyzzzzzzzzzzyyyyyyyyyyxxxxxxxxxxwwwwwwwwwwvvvvvvvvvvuuuuuuuuuuttttttttttssssssssssrrrrrrrrrrqqqqqqqqqqppppppppppoooooooooonnnnnnnnnnmmmmmmmmmmllllllllllkkkkkkkkkkjjjjjjjjjjiiiiiiiiiihhhhhhhhhhggggggggggffffffffffeeeeeeeeeeddddddddddccccccccccbbbbbbbbbbaaaaaaaabbbbbbbbbbccccccccccddddddddddeeeeeeeeeeffffffffffgggggggggghhhhhhhhhhiiiiiiiiiijjjjjjjjjjkkkkkkkkkkllllllllllmmmmmmmmmmnnnnnnnnnnooooooooooppppppppppqqqqqqqqqqrrrrrrrrrrssssssssssttttttttttuuuuuuuuuuvvvvvvvvvvwwwwwwwwwwxxxxxxxxxxyyyyyyyyyyzzzzzzzzzzyyyyyyyyyyxxxxxxxxxxwwwwwwwwwwvvvvvvvvvvuuuuuuuuuuttttttttttssssssssssrrrrrrrrrrqqqqqqqqqqppppppppppoooooooooonnnnnnnnnnmmmmmmmmmmllllllllllkkkkkkkkkkjjjjjjjjjjiiiiiiiiiihhhhhhhhhhggggggggggffffffffffeeeeeeeeeeddddddddddccccccccccbbbbbbbbbbaaaa");
        System.out.println(longestPalindrome);
    }

    public static String longestPalindrome(String s) {
        int startIndex = 1;
        int endIndex = 1;

        String longestString = "" + s.charAt(0);
        String currentString = "" + s.charAt(0);

        while (endIndex <= s.length() - 1) {
            currentString += s.charAt(endIndex);

            boolean isPalindrome = isPalindrome(currentString);

            if (isPalindrome && longestString.length() < currentString.length()) {
                longestString = currentString;
            }
            endIndex++;

            if (endIndex == s.length()) {
                currentString = "" + s.charAt(startIndex);
                endIndex = startIndex + 1;
                startIndex++;
            }
        }
        return longestString;
    }

    private static boolean isPalindrome(String s) {
        int startIndex = 0;
        int endIndex = s.length() - 1;

        while (endIndex > startIndex) {
            if (s.charAt(startIndex) != s.charAt(endIndex)) {
                return false;
            }

            startIndex++;
            endIndex--;
        }
        return true;
    }
}
