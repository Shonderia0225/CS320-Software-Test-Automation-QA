package contactservice;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContactServiceTest {

    private ContactService service;
    private Contact testContact;

    @BeforeEach
    void setUp() {

        service = new ContactService();

        testContact = new Contact(
                "1",
                "John",
                "Smith",
                "1234567890",
                "123 Main Street"
        );
    }

    @Test
    void testAddContact() {

        service.addContact(testContact);

        assertEquals(testContact, service.getContact("1"));
    }

    @Test
    void testDuplicateContactId() {

        service.addContact(testContact);

        assertThrows(IllegalArgumentException.class, () -> {

            service.addContact(testContact);
        });
    }

    @Test
    void testDeleteContact() {

        service.addContact(testContact);

        service.deleteContact("1");

        assertEquals(null, service.getContact("1"));
    }

    @Test
    void testUpdateFirstName() {

        service.addContact(testContact);

        service.updateFirstName("1", "Mike");

        assertEquals("Mike",
                service.getContact("1").getFirstName());
    }

    @Test
    void testUpdateLastName() {

        service.addContact(testContact);

        service.updateLastName("1", "Brown");

        assertEquals("Brown",
                service.getContact("1").getLastName());
    }

    @Test
    void testUpdatePhone() {

        service.addContact(testContact);

        service.updatePhone("1", "0987654321");

        assertEquals("0987654321",
                service.getContact("1").getPhone());
    }

    @Test
    void testUpdateAddress() {

        service.addContact(testContact);

        service.updateAddress("1", "456 Oak Street");

        assertEquals("456 Oak Street",
                service.getContact("1").getAddress());
    }

    @Test
    void testTimeout() {

        assertTimeout(Duration.ofSeconds(1), () -> {

            service.addContact(testContact);
        });
    }
}

