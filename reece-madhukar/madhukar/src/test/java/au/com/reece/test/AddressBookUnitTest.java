package au.com.reece.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import au.com.reece.AddressBook;
import au.com.reece.Contact;

public class AddressBookUnitTest {

	private AddressBook addressBook = new AddressBook();
	private Set<Contact> contacts = new HashSet<Contact>();
	
	@Before
	public void setup() {
		contacts.add(new Contact("A","1"));
		contacts.add(new Contact("B","2"));
	}
	
	@Test
	public void testEmptyOnCreation() {
		assertTrue(addressBook.getContacts().isEmpty());
	}

	@Test
	public void testAddNewContact() {
		addressBook.addContact(new Contact("A", "1"));
		addressBook.addContact(new Contact("B", "2"));
        assertEquals(addressBook.getContacts().size(), 2);
        assertEquals(addressBook.getContacts(), contacts);
	}
	
	@Test
	public void testAddNullContact() {
		addressBook.addContact(new Contact("", ""));
		addressBook.addContact(new Contact(null, null));
		addressBook.addContact(new Contact(null, ""));
		addressBook.addContact(new Contact("", null));
        assertEquals(addressBook.getContacts().size(), 1);
	}
	
	@Test
	public void testRemoveContact() {
		addressBook.addContact(new Contact("A", "1"));
		addressBook.addContact(new Contact("B", "2"));
		addressBook.removeContact(new Contact("A", "1"));
		addressBook.removeContact(new Contact("C", "3"));
        assertEquals(addressBook.getContacts().size(), 1);
	}
	
	@Test
	public void testRemoveContactOnEmptyAddressBook() {
		addressBook.removeContact(new Contact("A", "1"));
		addressBook.removeContact(new Contact("C", "3"));
        assertEquals(addressBook.getContacts().size(), 0);
	}
	
	@Test
	public void testUniqueContacts() {
		addressBook.addContact(new Contact("A", "1"));
		addressBook.addContact(new Contact("B", "2"));
		AddressBook secondAddrBook = new AddressBook();
		secondAddrBook.addContact(new Contact("A", "1"));
		secondAddrBook.addContact(new Contact("B", "2"));
		secondAddrBook.addContact(new Contact("C", "3"));
		Set<Contact> uniqueContacts = addressBook.printUniqueContacts(secondAddrBook);
        assertEquals(uniqueContacts.size(), 3);
        assertEquals(uniqueContacts, secondAddrBook.getContacts());
	}
	
	@Test
	public void testUniqueContactsOnEmptyAddressBook() {
		AddressBook secondAddrBook = new AddressBook();
		addressBook.printAddressBookOrderByName();
		addressBook.printAddressBookOrderByNumber();
		Set<Contact> uniqueContacts = addressBook.printUniqueContacts(secondAddrBook);
        assertEquals(uniqueContacts.size(), 0);
        assertEquals(uniqueContacts, secondAddrBook.getContacts());
	}
}
