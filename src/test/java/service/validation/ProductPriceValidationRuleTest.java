package service.validation;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.service.validation.ProductPriceValidationRule;
import com.javaguru.shoppinglist.service.validation.ProductValidationException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.math.BigDecimal;

public class ProductPriceValidationRuleTest {
    @Rule
    public final ExpectedException expectedException = ExpectedException.none();

    private ProductPriceValidationRule victim = new ProductPriceValidationRule();

    private Product input;

    @Test
    public void shouldThrowProductValidationException() {
        input = productPrice(new BigDecimal(-5));

        expectedException.expect(ProductValidationException.class);
        expectedException.expectMessage("Price cannot be 0 or less");
        victim.validate(input);
    }
    @Test
    public void shouldValidateSuccess() {
        input = productPrice(new BigDecimal(250));

        victim.validate(input);
    }

    private Product productPrice(BigDecimal price) {
        Product product= new Product();
        product.setPrice(price);
        return product;
    }

}