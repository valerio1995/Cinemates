package mvp;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class jUnitTesting {
	@Test
	public void testCheckFields() {
		AuthenticationView authenticationView = new AuthenticationView();
		assertTrue(authenticationView.checkFields("admin@gmail.com","admin"));
	}
	
	@Test
	public void test() {
		SendMailPresenter sendMailPresenter = new SendMailPresenter();
		assertTrue(sendMailPresenter.isNotEmptyField("ss", "dd"));
	}
}
