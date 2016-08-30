package au.com.reece;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
 * AddressBook which can save any number of contacts. 
 * If thread safety is a must, we can make the methods setContacts, addContact and removeContact as synchronized
 * We are using HashSet only because we can leverage Java 8 Streams to print the sorted set
 * We can also make contact class comparable if we are using lower versions of Java 
 */
public class AddressBook {

	private static final Logger LOGGER = LoggerFactory.getLogger(AddressBook.class);

	private Set<Contact> contacts;

	/*
	 * Default constructor instantiates with empty HashSet of Contact objects
	 */
	public AddressBook() {
		contacts = new HashSet<Contact>();
	}

	/*
	 * @return Returning Unmodifiable Set of Contacts so that the object doesnt get modified
	 */
	public Set<Contact> getContacts() {
		return Collections.unmodifiableSet(this.contacts);
	}

	public void setContacts(Set<Contact> contacts) {
		this.contacts = contacts;
	} 

	/*
	 * Add contact to the address book
	 */
	public void addContact(Contact contact) {
		contacts.add(contact);
	}

	/*
	 * Remove contact from the address book
	 */
	public boolean removeContact(Contact contact) {
		return contacts.remove(contact);
	}

	/*
	 * Prints unique contacts from this addressbook and the one passed as argument
	 * Returns the unique set of contacts object
	 */
	public Set<Contact> printUniqueContacts(AddressBook addressBook) {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Printing Unique Contacts");
		}
		Set<Contact> uniqueContacts = new HashSet<Contact>();
		uniqueContacts.addAll(getContacts());
		uniqueContacts.addAll(addressBook.getContacts());
		Comparator<Contact> byName = (c1,c2) -> c1.getContactName().compareToIgnoreCase(c2.getContactName());
		uniqueContacts.stream().sorted(byName).forEach(contact -> {
			LOGGER.info("{}", contact.toString());
		});
		return uniqueContacts;
	}

	/*
	 * Prints the address book in the sorted order of name
	 * Uses Java 8 Stream to do this, we can go with comparable interface implementation if using lower versions
	 */
	public void printAddressBookOrderByName() {
		if (getContacts().size() <= 0) {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("Empty Address Book");
			}
			return;
		}
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Printing Address Book Sorted by Name Order");
		}
		Comparator<Contact> byName = (c1,c2) -> c1.getContactName().compareToIgnoreCase(c2.getContactName());
		getContacts().stream().sorted(byName).forEach(contact -> {
			LOGGER.info("{}", contact.toString());
		});
	}

	/*
	 * Prints the address book in the sorted order of Number
	 * Uses Java 8 Stream to do this, we can go with comparable interface implementation if using lower versions
	 */
	public void printAddressBookOrderByNumber() {
		if (getContacts().size() <= 0) {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("Empty Address Book");
			}
			return;
		}
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Printing Address Book Sorted by Number Order");
		}
		Comparator<Contact> byNumber = (c1,c2) -> c1.getContactNumber().compareToIgnoreCase(c2.getContactNumber());
		getContacts().stream().sorted(byNumber).forEach(contact -> {
			LOGGER.info("{}", contact.toString());
		});
	}

}
