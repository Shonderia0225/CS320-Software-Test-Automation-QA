package contactservice;

public class Contact {

    private final String contactId;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;

    public Contact(String contactId, String firstName,
                   String lastName, String phone,
                   String address) {

        // Validate contact ID
        if (contactId == null || contactId.length() > 10) {
            throw new IllegalArgumentException("Contact ID is invalid");
        }

        // Validate first name
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("First name is invalid");
        }

        // Validate last name
        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("Last name is invalid");
        }

        // Validate phone number
        if (phone == null || !phone.matches("\\d{10}")) {
            throw new IllegalArgumentException("Phone number is invalid");
        }

        // Validate address
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("Address is invalid");
        }

        this.contactId = contactId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
    }

    // Getters

    public String getContactId() {
        return contactId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    // Setters

    public void setFirstName(String firstName) {

        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("First name is invalid");
        }

        this.firstName = firstName;
    }

    public void setLastName(String lastName) {

        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("Last name is invalid");
        }

        this.lastName = lastName;
    }

    public void setPhone(String phone) {

        if (phone == null || !phone.matches("\\d{10}")) {
            throw new IllegalArgumentException("Phone number is invalid");
        }

        this.phone = phone;
    }

    public void setAddress(String address) {

        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("Address is invalid");
        }

        this.address = address;
    }
}



