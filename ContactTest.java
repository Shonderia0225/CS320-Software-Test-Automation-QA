package contactservice;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContactTest {

    private Contact testContact;

    @BeforeEach
    void setUp() {

        testContact = new Contact(
                "123",
                "John",
                "Smith",
                "1234567890",
                "123 Main Street"
        );
    }

    @Test
    void testValidContact() {

        assertEquals("123", testContact.getContactId());
        assertEquals("John", testContact.getFirstName());
        assertEquals("Smith", testContact.getLastName());
        assertEquals("1234567890", testContact.getPhone());
        assertEquals("123 Main Street", testContact.getAddress());
    }

    @Test
    void testInvalidContactId() {

        assertThrows(IllegalArgumentException.class, () -> {

            new Contact(
                    "1234567891011",
                    "John",
                    "Smith",
                    "1234567890",
                    "123 Main Street"
            );
        });
    }

    @Test
    void testInvalidFirstName() {

        assertThrows(IllegalArgumentException.class, () -> {

            new Contact(
                    "123",
                    "VeryLongFirstName",
                    "Smith",
                    "1234567890",
                    "123 Main Street"
            );
        });
    }

    @Test
    void testInvalidLastName() {

        assertThrows(IllegalArgumentException.class, () -> {

            new Contact(
                    "123",
                    "John",
                    "VeryLongLastName",
                    "1234567890",
                    "123 Main Street"
            );
        });
    }

    @Test
    void testInvalidPhone() {

        assertThrows(IllegalArgumentException.class, () -> {

            new Contact(
                    "123",
                    "John",
                    "Smith",
                    "123",
                    "123 Main Street"
            );
        });
    }

    @Test
    void testInvalidAddress() {

        assertThrows(IllegalArgumentException.class, () -> {

            new Contact(
                    "123",
                    "John",
                    "Smith",
                    "1234567890",
                    "12345678901234567890123456789012345"
            );
        });
    }

    @Test
    void testSetFirstName() {

        testContact.setFirstName("Mike");

        assertEquals("Mike", testContact.getFirstName());
    }
}
