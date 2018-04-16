package org.micap.common;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.micap.common.utilies.AppProperties.readAllProperties;
import static org.micap.common.utilies.AppProperties.readProperties;

public class CommonApplicationTests {


	@Test
	public void  readAllPropertiesFile(){
		Map test=readAllProperties();

		assertEquals(test.size(),6);
		assertEquals(test.get("DuplicateIdException"),"1001 -- DUPLICATE_ID_EXCEPTION -- \"Entity store need a diferent id with %s%s\"");
		assertNotEquals(test.get("DuplicateIdException"),"1002 -- DUPLICATE_ID_EXCEPTION -- \"Entity store need a diferent id with %s%s\"");
	}
	@Test
	public void  readPropertiesFile(){
		Map test=
				readProperties(new String[]{
						"DuplicateIdException",
						"AuthorizationException"
				});

		assertEquals(test.size(),2);
		assertEquals(test.get("DuplicateIdException"),"1001 -- DUPLICATE_ID_EXCEPTION -- \"Entity store need a diferent id with %s%s\"");
		assertNotEquals(test.get("DuplicateIdException"),"1002 -- DUPLICATE_ID_EXCEPTION -- \"Entity store need a diferent id with %s%s\"");
	}
	@Test
	public void  readPropertiesFile2(){
		String test=
				readProperties("DuplicateIdException");

		assertEquals(test,"1001 -- DUPLICATE_ID_EXCEPTION -- \"Entity store need a diferent id with %s%s\"");

	}


}
