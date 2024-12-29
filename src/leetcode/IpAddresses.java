package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IpAddresses {
    public static void main(String[] args) {
        List<String> validIpAddresses = restoreIpAddresses("101023");
        System.out.println(validIpAddresses);
    }

    public static List<String> restoreIpAddresses(String s) {
        if (s.length() > 12 || s.length() < 4) {
            return new ArrayList<>();
        }

        List<String> initialSubstringArray = new ArrayList<>();
         for (int i=0; i <= 3; i++) {
             String substring = s.substring(0, i);
             if (isIpSubstringValid(substring)) {
                 initialSubstringArray.add(substring);
             }
         }

        return recursive(initialSubstringArray, s , 3);
    }

    private static List<String> recursive(List<String> returnArray, String s, int numberOfDotsRemaining) {
        if (numberOfDotsRemaining == 0) {
            return returnArray;
        }

        Set<String> newReturnArray = new HashSet<>();

        for (String subString : returnArray) {
            int startingIndex = Math.max(subString.length() - (3 - numberOfDotsRemaining), 0);
            int endIndex = startingIndex + 3;
            int numberToCheck = 0;

            for (int i=startingIndex; i <= endIndex - 1; i++) {
                String substring;

                if (numberOfDotsRemaining == 1) {
                   substring = s.substring(startingIndex);
                } else {
                    substring = s.substring(startingIndex, Math.min(startingIndex + numberToCheck + 1, s.length()));
                }

                if (isIpSubstringValid(substring)) {
                    newReturnArray.add(subString + "." + substring);
                    numberToCheck++;
                }
            }
        }

        return recursive(newReturnArray.stream().toList(), s,  --numberOfDotsRemaining);
    }

    private static boolean isIpSubstringValid(String ip) {
        if (ip.isEmpty()) {
            return false;
        } else if (ip.startsWith("0") && ip.length() == 1) {
            return true;
        } else if (ip.startsWith("0") && ip.length() > 1) {
            return false;
        } else if (Integer.parseInt(ip) > 255) {
            return false;
        } else {
            return true;
        }
    }
}
