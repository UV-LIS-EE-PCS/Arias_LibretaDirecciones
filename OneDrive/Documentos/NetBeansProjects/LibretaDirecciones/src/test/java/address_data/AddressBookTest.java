package address_data;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Clase de prueba para la clase AddressBook.
 */
public class AddressBookTest {
    
    private AddressBook addressBook;
    private AddressEntry contact1;
    private AddressEntry contact2;
    private AddressEntry contact3;

    /**
     * Configura el objeto AddressBook y los contactos antes de cada prueba.
     */
    @BeforeEach
    public void setUp() {
        addressBook = new AddressBook();
        contact1 = new AddressEntry("John", "Doe", "123 Main St", "Anytown", "CA", "12345", "555-555-5555", "john@example.com");
        contact2 = new AddressEntry("Jane", "Smith", "456 Oak St", "Othertown", "NY", "67890", "666-666-6666", "jane@example.com");
    }
    
    /**
     * Prueba para el método add de la clase AddressBook.
     */
    @Test
    public void testAdd() {
        addressBook.add(contact1);
        addressBook.add(contact2);

        assertEquals(2, addressBook.contactDirectory.size());
        assertTrue(addressBook.contactDirectory.contains(contact1));
        assertTrue(addressBook.contactDirectory.contains(contact2));
    }
    
    /**
     * Prueba para el método list de la clase AddressBook.
     */
    @Test
    public void testList() {
        addressBook.add(contact1);
        addressBook.add(contact2);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        addressBook.list();

        System.setOut(originalOut);

        String listOutput = outputStream.toString().trim();

        assertTrue(listOutput.contains(contact1.toString()));
        assertTrue(listOutput.contains(contact2.toString()));
    }

    /**
     * Prueba para el método delete de la clase AddressBook.
     */
    @Test
    public void testDelete() {
        addressBook.add(contact1);
        addressBook.add(contact2);

        addressBook.delete("Doe");
        
        assertEquals(1, addressBook.contactDirectory.size());
        assertFalse(addressBook.contactDirectory.contains(contact1));
        assertTrue(addressBook.contactDirectory.contains(contact2));
    }

    /**
     * Prueba para el método search de la clase AddressBook.
     */
    @Test
    public void testSearch() {
        addressBook.add(contact1);
        addressBook.add(contact2);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        addressBook.search("Doe");

        System.setOut(originalOut);

        String searchOutput = outputStream.toString().trim();

        assertTrue(searchOutput.contains(contact1.toString()));
        assertFalse(searchOutput.contains(contact2.toString()));
    }

    /**
     * Prueba para el método readFromFile de la clase AddressBook.
     */
    @Test
    public void testReadFromFile() {
        AddressBook addressBook = new AddressBook();
        String filePath = "C:\\contactos.txt";
        addressBook.readFromFile(filePath);

        assertEquals(10, addressBook.contactDirectory.size());
        assertTrue(addressBook.search("Doe").size() > 0);
        assertTrue(addressBook.search("Smith").size() > 0);
    }

}
