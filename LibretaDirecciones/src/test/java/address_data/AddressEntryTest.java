package address_data;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Clase de prueba para la clase AddressEntry.
 */
public class AddressEntryTest {

    private AddressEntry addressEntry;

    /**
     * Configura el objeto AddressEntry antes de cada prueba.
     */
    @BeforeEach
    public void setUp() {
        addressEntry = new AddressEntry("John", "Doe", "123 Main St", "Anytown", "CA", "12345", "555-123-4567", "john.doe@example.com");
    }

    /**
     * Prueba para obtener el primer nombre.
     */
    @Test
    public void testFirstName() {
        String firstName = addressEntry.getFirstName();
        assertEquals("John", firstName);
    }

    /**
     * Prueba para obtener el apellido.
     */
    @Test
    public void testLastName() {
        String lastName = addressEntry.getLastName();
        assertEquals("Doe", lastName);
    }

    /**
     * Prueba para obtener la calle.
     */
    @Test
    public void testStreet() {
        String street = addressEntry.getStreet();
        assertEquals("123 Main St", street);
    }

    /**
     * Prueba para obtener la ciudad.
     */
    @Test
    public void testCity() {
        String city = addressEntry.getCity();
        assertEquals("Anytown", city);
    }

    /**
     * Prueba para obtener el estado.
     */
    @Test
    public void testState() {
        String state = addressEntry.getState();
        assertEquals("CA", state);
    }

    /**
     * Prueba para obtener el código postal.
     */
    @Test
    public void testZipCode() {
        String zipCode = addressEntry.getZipCode();
        assertEquals("12345", zipCode);
    }

    /**
     * Prueba para obtener el número de teléfono.
     */
    @Test
    public void testPhoneNumber() {
        String phoneNumber = addressEntry.getPhoneNumber();
        assertEquals("555-123-4567", phoneNumber);
    }

    /**
     * Prueba para obtener el correo electrónico.
     */
    @Test
    public void testEmail() {
        String email = addressEntry.getEmail();
        assertEquals("john.doe@example.com", email);
    }
}
