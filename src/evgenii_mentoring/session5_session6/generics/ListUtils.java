package evgenii_mentoring.session5_session6.generics;

import java.util.List;

//Task 3
//Objective: Implement a method getFirstElement in a class called ListUtils. This method
//should accept a List of any type that extends Comparable and returns the first element
//of the list. Test this method with a List<String> and a List<Integer>.

public class ListUtils {
    public static <T extends Comparable<T>> T getFirstElement(List<T> l) {
        if (l.isEmpty()) {
            System.out.println("Empty list");
            return null;
        }
        return l.get(0);
    }
}
