package evgenii_mentoring.session2;

import java.lang.FunctionalInterface;
import java.util.List;

@FunctionalInterface
public interface ListProductTransformer {
    Product apply(List<Product> listOfProducts);
}
