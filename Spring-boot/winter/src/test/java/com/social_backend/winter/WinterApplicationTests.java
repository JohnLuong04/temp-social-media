package com.social_backend.winter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import com.social_backend.Model.*;

@SpringBootTest
class WinterApplicationTests {

	@Test
	public void account_test(){
		Account test_account = new Account("test", "password");
		assertEquals("test", test_account.get_username());
		assertEquals("password", test_account.get_password());
	}	

	@Test
	public void null_catch(){
		NullPointerException test_exception = assertThrows(NullPointerException.class, () -> {
			new Account(null, "password");
		});
		assertEquals("Username cannot be null", test_exception.getMessage());

		test_exception = assertThrows(NullPointerException.class, () -> {
			new Account("one", null);
		});
		assertEquals("Password cannot be null", test_exception.getMessage());
	}

	


}
