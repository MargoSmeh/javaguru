 package service;

 import com.javaguru.shoppinglist.domain.Product;
 import com.javaguru.shoppinglist.repository.ProductInMemoryRepository;
 import com.javaguru.shoppinglist.service.ProductService;
 import com.javaguru.shoppinglist.service.validation.ProductValidationService;
 import org.junit.Test;
 import org.junit.runner.RunWith;
 import org.mockito.ArgumentCaptor;
 import org.mockito.Captor;
 import org.mockito.InjectMocks;
 import org.mockito.Mock;
 import org.mockito.junit.MockitoJUnitRunner;

 import java.math.BigDecimal;

 import static org.junit.Assert.assertEquals;
 import static org.mockito.Mockito.verify;
 import static org.mockito.Mockito.when;

 @RunWith(MockitoJUnitRunner.class)
 public class ProductServiceTest {
     @Mock
     private ProductInMemoryRepository repository;

     @Mock
     private ProductValidationService validationService;

     @InjectMocks
     private ProductService victim;

     @Captor
     private ArgumentCaptor<Product> productCaptor;

     @Test
     public void shouldCreateProductSuccessfully() {
         Product product = product();
         when(repository.addProduct(product)).thenReturn(product);

         Long result = victim.createProduct(product);

         verify(validationService).validate(productCaptor.capture());
         Product captorResult = productCaptor.getValue();

         assertEquals(captorResult, product);
         assertEquals(product.getId(), result);
     }

     private Product product() {
         Product product = new Product();
         product.setName("TEST_NAME");
         product.setCategory("TEST_CATEGORY");
         product.setPrice(new BigDecimal(200));
         product.setDescription("TEST_DESCRIPTION");
         product.setDiscount(new BigDecimal(50));
         product.setId(1001L);
         return product;
     }
 }