package au.com.reece;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AddressUtils {

	private static final Logger LOGGER = LoggerFactory.getLogger(AddressUtils.class);
	/*
	 * static method : Uses Class Files static methods to read from the file
	 * Takes input as comma separate name and number
	 * Returns the updated Address Book with all the contacts
	 * If any line is invalid, it will print the error to the console
	 */
	public static AddressBook getAddrBookFromFile(String path) throws IOException {
		AddressBook addressBook = new AddressBook();
		List<String> sheet = Files.readAllLines(Paths.get(path));
		int lineCount = 0;
		for (String strLine : sheet) {
			lineCount++;
			String[] contact = strLine.split(",");
			if (contact.length != 2 || !isValidPhoneNumber(contact[1])) {
				if (LOGGER.isErrorEnabled()) {
					LOGGER.error("For Sheet {} : Invalid Contact found at line {} ", path, lineCount);
				}
				continue;
			}
			addressBook.addContact(new Contact(contact[0], contact[1]));
		}
		return addressBook;
	}

	/*
	 * Any number starting with + or numbers and length between 3 and 15
	 * Doesn't accept alphabets
	 */
	public static boolean isValidPhoneNumber(String contactNum) {
		String regex = "^\\+?[0-9. ()-]{3,15}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(contactNum);
        if (matcher.matches()) {
        	return true;
        } else {
        	if (LOGGER.isErrorEnabled()) {
				LOGGER.error("Invalid Contact Number given {}. Skipping Entry to Address Book ", contactNum);
			}
        }
		return false;
	}
}
