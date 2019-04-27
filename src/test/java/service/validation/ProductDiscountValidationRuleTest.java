package service.validation;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.service.validation.ProductDiscountValidationRule;
import com.javaguru.shoppinglist.service.validation.ProductValidationException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.math.BigDecimal;


public class ProductDiscountValidationRuleTest {

    @Rule
    public final ExpectedException expectedException = ExpectedException.none();

    private ProductDiscountValidationRule victim = new ProductDiscountValidationRule();

    private Product input;

    @Test
    public void shouldThrowProductValidationException() {
        input = productDiscount(new BigDecimal(105));

        expectedException.expect(ProductValidationException.class);
        expectedException.expectMessage("Discount should be less than 100%");
        victim.validate(input);
}
    @Test
    public void shouldValidateSuccess() {
        input = productDiscount(new BigDecimal(50));

        victim.validate(input);
    }

    private Product productDiscount(BigDecimal discount) {
        Product product= new Product();
        product.setDiscount(discount);
        return product;
    }
}