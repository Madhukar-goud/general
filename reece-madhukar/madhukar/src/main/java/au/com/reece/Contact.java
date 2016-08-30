package au.com.reece;

/*
 * The Contact class. Assumption is made that if any of contact name or number is null,
 *  it will save it as empty string similar to any phone book 
 *  We can make Contact implement Comparable if we are using lower versions of Java.
 *  Because we are using Streams in this applications, it wont be required
 */
public class Contact {

	private String contactName;
	private String contactNumber;
	
	/*
	 * No Default constructor, every contact needs to be instantiated with a name and number
	 * If any of them is not provided, it will save as empty string similar to any phone book
	 */
	public Contact(String contactName, String contactNumber) {
		if (contactName == null) {
			contactName = "";
		}
		if (contactNumber == null) {
			contactNumber = "";
		}
		this.contactName = contactName;
		this.contactNumber = contactNumber;
	}
	
	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((contactName == null) ? 0 : contactName.hashCode());
		result = prime * result
				+ ((contactNumber == null) ? 0 : contactNumber.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contact other = (Contact) obj;
		if (!contactName.equals(other.contactName))
			return false;
		if (!contactNumber.equals(other.contactNumber))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Contact [contactName=" + contactName + ", contactNumber="
				+ contactNumber + "]";
	}
	
}
