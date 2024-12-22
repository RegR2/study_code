package leetcode;

import java.util.ArrayList;
import java.util.List;

public class IpAddresses {
    public static void main(String[] args) {
        List<String> validIpAddresses = restoreIpAddresses("25525511135");
        System.out.println(validIpAddresses);
    }

    public static List<String> restoreIpAddresses(String s) {
        List<String> returnArray = new ArrayList<>();

        recursive("", returnArray, s, 0, 0);

        return returnArray;
    }

    private static void recursive(String currentString, List<String> returnArray, String s, int index, int initialIndex) {
        String[] splitString = currentString.split("\\.");

        String subString = splitString[splitString.length - 1];
        if (subString.length() == 3 && Integer.parseInt(subString) > 255) {
            subString = subString.substring(0, subString.length() - 1);

            currentString = "";
            for (int i = 0; i <= splitString.length - 2; i++) {
                currentString += splitString[i] + ".";
            }

            currentString += subString + ".";
            index--;
        } else if ((subString.length() == 3 && Integer.parseInt(subString) <= 255) || subString.equals("0")) {
            currentString += ".";
        }

        for (int i = index; i <= s.length() - 1; i++) {
            currentString = currentString + s.charAt(i);
            recursive(currentString, returnArray, s, i +1, initialIndex);
            if (isIpValid(currentString)) {
                returnArray.add(currentString);
            }

            currentString = s.substring(0, initialIndex +1) + ".";
            i = initialIndex;
            initialIndex++;
        }
    }

    private static boolean isIpValid(String ip) {
        String[] splitip = ip.split("\\.");

        if (splitip.length == 4) {
            for (String ipString : splitip) {
                if (Integer.parseInt(ipString) > 255) {
                    return false;
                }

                if (ipString.length() > 1 && ipString.charAt(0) == '0') {
                    return false;
                }
            }

            return true;
        } else {
            return false;
        }

    }
}
