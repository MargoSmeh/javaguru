package service.validation;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.service.validation.ProductNameValidationRule;
import com.javaguru.shoppinglist.service.validation.ProductValidationException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ProductNameValidationRuleTest {

    @Rule
    public final ExpectedException expectedException = ExpectedException.none();

    private ProductNameValidationRule victim = new ProductNameValidationRule();

    private Product input;

    @Test
    public void shouldThrowProductValidationException() {
        input = product("Bo");

        expectedException.expect(ProductValidationException.class);
        expectedException.expectMessage("Name should be from 3 to 32 symbols");
        victim.validate(input);
    }

    @Test
    public void shouldValidateSuccess() {
        input = product("valid name");

        victim.validate(input);
    }

    private Product product(String name) {
        Product product = new Product();
        product.setName(name);
        return product;
    }
}