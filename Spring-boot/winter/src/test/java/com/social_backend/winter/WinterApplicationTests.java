package com.social_backend.winter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Null;
import org.springframework.boot.test.context.SpringBootTest;
import com.social_backend.Model.*;

/*Author: Jason Ha */

@SpringBootTest
class WinterApplicationTests {

	/* Account Test */

	@Test
	public void account_test(){
		Account test_account = new Account("test", "password");
		assertEquals("test", test_account.get_username());
		assertEquals("password", test_account.get_password());
	}	

	@Test
	public void account_null_catch(){
		NullPointerException test_exception = assertThrows(NullPointerException.class, () -> {
			new Account(null, "password");
		});
		assertEquals("Username cannot be null", test_exception.getMessage());

		test_exception = assertThrows(NullPointerException.class, () -> {
			new Account("one", null);
		});
		assertEquals("Password cannot be null", test_exception.getMessage());
	}

	/* Profile Test */

	@Test
	public void profile_test(){
		Profile test_profile = new Profile("Something", "Something2");
		assertEquals("Something", test_profile.get_nickname());
		assertEquals("Something2", test_profile.get_description());
	}

	@Test
	public void profile_null_catch(){

		NullPointerException test_exception = assertThrows(NullPointerException.class, () -> {
			new Profile(null, "Something2");
		});
		assertEquals("nickname cannot be null", test_exception.getMessage());

		test_exception = assertThrows(NullPointerException.class, () -> {
			new Profile("something1", null);
		});
		assertEquals("description cannot be null", test_exception.getMessage());
	}

	/* Database aka Persistence */
	


}
