package es.palmademallorca.imi.proyecto3.service;



import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import es.palmademallorca.imi.proyecto3.model.Product;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=SpringTestConfig.class)
public class ProductServiceTest {

	@Autowired
	private ProductService productService;
	
	
	/**
	 * Consulta de producta por ID
	 */
	@Test
	public void getProductTest(){
		int old = productService.getProducts().size();
		productService.saveProduct(new Product("Artículo 3",103.,true));
		Assert.assertTrue(
				old < productService.getProducts().size()
		);
	}
	
	/**
	 * Guardado de producta con el mismo ID
	 */
	@Test
	public void saveProductTest(){
		int size = productService.getProducts().size();
		productService.saveProduct(new Product("Artículo 3",103.,true));
		Assert.assertTrue(
				productService.getProducts().size()
				== size+1 );
	}
	
	@Test
	public void removeProductTest(){
		int size = productService.getProducts().size();
		productService.saveProduct(new Product("Artículo 2",101.,true));
		productService.removeProduct(3l);
		Assert.assertTrue(
				productService.getProducts().size()
				== size
		);
	}
	
	
	
}
