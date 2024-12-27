package evgenii_mentoring.session2;

import java.lang.FunctionalInterface;

@FunctionalInterface
public interface ProductTransformer {
    Product apply(Product product);
}
