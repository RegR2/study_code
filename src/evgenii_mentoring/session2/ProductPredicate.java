package evgenii_mentoring.session2;

import java.lang.FunctionalInterface;

@FunctionalInterface
public interface ProductPredicate {
    boolean test(Product product);
}
