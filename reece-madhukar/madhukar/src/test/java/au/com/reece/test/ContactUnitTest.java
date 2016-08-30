package au.com.reece.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import au.com.reece.Contact;

public class ContactUnitTest {
	
	private Contact contact;
	
	@Test
	public void testEmptyOnNullObject() {
		contact = new Contact(null, null);
		assertEquals(contact.getContactName(), "");
		assertEquals(contact.getContactNumber(), "");
	}
	
	@Test
	public void testNameAndNumberOnValidObect() {
		contact = new Contact("A", "1");
		assertEquals(contact.getContactName(), "A");
		assertEquals(contact.getContactNumber(), "1");
	}
	
	@Test
	public void testHashCodeSameObects() {
		contact = new Contact("Madhukar", "0123123");
		Contact secondContact = new Contact("Madhukar", "0123123");
		assertEquals(contact.hashCode(), secondContact.hashCode());
	}
	
	@Test
	public void testHashCodeDiffObects() {
		contact = new Contact("Madhukar", "0123123");
		Contact secondContact = new Contact("Reece", "0123123");
		assertNotSame(contact.hashCode(), secondContact.hashCode());
	}
	
	@Test
	public void testEqualsSameObects() {
		contact = new Contact("Madhukar", "0123123");
		Contact secondContact = new Contact("Madhukar", "0123123");
		Contact thirdContact = new Contact("M", "0123123");
		assertTrue(contact.equals(secondContact));
		assertEquals(contact , secondContact);
		assertNotSame(contact , thirdContact);
		assertEquals(contact , contact);
		assertNotSame(contact , null);
		assertNotSame(contact , "SomeOtherClassType");
	}
}
