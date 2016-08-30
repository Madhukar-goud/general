package au.com.reece;


import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
 * The Main class with the static void main method. 
 * This class demonstrates all the functionality that was expected out of this test
 * Add Contact to Address Book, Remove Contacts, Print Contacts in Sorted Order, Print unique contacts   
 */
public class MainApp {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MainApp.class);

	/*
	 * Creating 2 Address Books from 2 Different files
	 * Add Contact
	 * Remove Contact
	 * Print Address in Sorted Order by Name
	 * Print Unique Contacts
	 * Print Address in Sorted Order by Number
	 * throws Exception
	 */
	public static void main(String[] args) throws Exception {
		try {
			AddressBook firstAddrBook = AddressUtils.getAddrBookFromFile(".\\src\\main\\resources\\ContactSheetCSV1.txt");
			AddressBook secondAddrBook = AddressUtils.getAddrBookFromFile(".\\src\\main\\resources\\ContactSheetCSV2.txt");
			Contact armida = new Contact("Armida","012312312");
			Contact reece = new Contact("Reece","89123812");
			firstAddrBook.addContact(reece);
			firstAddrBook.addContact(armida);
			firstAddrBook.removeContact(armida);
			firstAddrBook.printAddressBookOrderByName();
			secondAddrBook.printAddressBookOrderByName();
			firstAddrBook.printUniqueContacts(secondAddrBook);
			firstAddrBook.printAddressBookOrderByNumber();
		} catch (IOException e) {
			if (LOGGER.isErrorEnabled()) {
				LOGGER.error("IO Exception in main method {} ", e);
			}
			throw new Exception(e);
		}
	}
}
