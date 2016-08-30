package au.com.reece.test;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.Set;

import org.junit.Test;

import au.com.reece.AddressBook;
import au.com.reece.AddressUtils;
import au.com.reece.Contact;

/*
 * These can be individual test that can run with changes to the CSV Files placed at src/test/resources.
 */
public class AddressBookIntTest {

	@Test
	public void testAddContacts() throws IOException {
		AddressBook addrBook = AddressUtils.getAddrBookFromFile(".\\src\\test\\resources\\ContactSheetCSV1.txt");
		assertEquals(addrBook.getContacts().size(), 7);
		addrBook.printAddressBookOrderByName();
		addrBook.printAddressBookOrderByNumber();
	}

	@Test
	public void testRemoveContacts() throws IOException {
		AddressBook addrBook = AddressUtils.getAddrBookFromFile(".\\src\\test\\resources\\ContactSheetCSV1.txt");
		Contact emergency = new Contact("Madhukar", "213");
		addrBook.removeContact(emergency);
		assertEquals(addrBook.getContacts().size(), 6);
		addrBook.printAddressBookOrderByName();
	}
	
	@Test
	public void testUniqueContacts() throws IOException {
		AddressBook firstAddrBook = AddressUtils.getAddrBookFromFile(".\\src\\test\\resources\\ContactSheetCSV1.txt");
		AddressBook secondAddrBook = AddressUtils.getAddrBookFromFile(".\\src\\test\\resources\\ContactSheetCSV2.txt");
		Set<Contact> contacts = firstAddrBook.printUniqueContacts(secondAddrBook);
		assertEquals(contacts.size(), 11);
	}
}
