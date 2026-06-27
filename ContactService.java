package contactservice;

import java.util.HashMap;
import java.util.Map;

public class ContactService {

    private final Map<String, Contact> contacts = new HashMap<>();

    // Adds a contact if the ID does not already exist
    public void addContact(Contact contact) {

        if (contacts.containsKey(contact.getContactId())) {
            throw new IllegalArgumentException("Duplicate ID");
        }

        contacts.put(contact.getContactId(), contact);
    }

    // Deletes a contact using the contact ID
    public void deleteContact(String contactId) {

        contacts.remove(contactId);
    }

    // Updates first name
    public void updateFirstName(String contactId, String firstName) {

        Contact contact = contacts.get(contactId);

        if (contact != null) {
            contact.setFirstName(firstName);
        }
    }

    // Updates last name
    public void updateLastName(String contactId, String lastName) {

        Contact contact = contacts.get(contactId);

        if (contact != null) {
            contact.setLastName(lastName);
        }
    }

    // Updates phone number
    public void updatePhone(String contactId, String phone) {

        Contact contact = contacts.get(contactId);

        if (contact != null) {
            contact.setPhone(phone);
        }
    }

    // Updates address
    public void updateAddress(String contactId, String address) {

        Contact contact = contacts.get(contactId);

        if (contact != null) {
            contact.setAddress(address);
        }
    }

    // Helper method for testing
    public Contact getContact(String contactId) {
        return contacts.get(contactId);
    }
}
