package address_data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Clase que representa una libreta de direcciones.
 */
public class AddressBook {
    List<AddressEntry> contactDirectory = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    private static final String RESET = "\033[0m";
    private static final String YELLOW = "\033[0;33m";
    private static final String GREEN = "\033[0;32m";
    private static final String RED = "\033[0;31m";

    /**
     * Muestra todos los contactos en la libreta de direcciones.
     */
    public void list() {
        if (contactDirectory.isEmpty()) {
            System.out.println(
                    "-==================================-\n\n" +
                            RED +
                            "La libreta de contactos está vacía.\n\n" +
                            RESET +
                            "-==================================-\n\n");
        } else {
            for (int i = 0; i < contactDirectory.size(); i++) {
                AddressEntry contact = contactDirectory.get(i);
                System.out.println(
                        GREEN + "Contacto " + (i + 1) + ":" + RESET + "\n" +
                                contact.toString() + "\n");
            }
        }
    }

    /**
     * Agrega un nuevo contacto a la libreta de direcciones.
     *
     * @param contact El contacto a agregar.
     */
    public void add(AddressEntry contact) {
        contactDirectory.add(contact);
    }

    /**
     * Elimina un contacto de la libreta de direcciones basado en el apellido.
     *
     * @param lastName El apellido del contacto a eliminar.
     */
    public void delete(String lastName) {
        System.out.println("Resultados de búsqueda: ");
        System.out.println("-==================================-\n");
        List<AddressEntry> results = search(lastName);
        if (results.isEmpty()) {
            System.out.println(RED + "No se encontraron contactos con el apellido: " + lastName + RESET);
        } else if (results.size() == 1) {
            AddressEntry contact = results.get(0);
            contactDirectory.remove(contact);
            System.out.println(GREEN + "Contacto eliminado: " + contact.getFirstName() + " " + contact.getLastName() + RESET);
        } else {
            System.out.print(YELLOW + "Seleccione el número del contacto a eliminar: " + RESET);
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice > 0 && choice <= results.size()) {
                AddressEntry contact = results.get(choice - 1);
                contactDirectory.remove(contact);
                System.out.println(GREEN + "Contacto eliminado: " + contact.getFirstName() + " " + contact.getLastName() + RESET);
            } else {
                System.out.println(RED + "Selección inválida, cancelando." + RESET);
            }
        }
    }

    /**
     * Busca contactos en la libreta de direcciones basado en el apellido.
     *
     * @param lastName El apellido a buscar.
     * @return Una lista de contactos con el apellido especificado.
     */
    public List<AddressEntry> search(String lastName) {
        List<AddressEntry> result = new ArrayList<>();
        int contactFound = 0;
        for (AddressEntry contact : contactDirectory) {
            if (contact.getLastName().equalsIgnoreCase(lastName)) {
                result.add(contact);
                System.out.println(GREEN + "Contacto " + (++contactFound) + ": \n" + RESET + contact.toString() + "\n\n");
            }
        }
        return result;
    }

    /**
     * Lee contactos desde un archivo y los agrega a la libreta de direcciones.
     *
     * @param filename El nombre del archivo desde el cual leer los contactos.
     */
    public void readFromFile(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(",");
                if (fields.length == 8) {
                    AddressEntry contact = new AddressEntry(
                            fields[0], // firstName
                            fields[1], // lastName
                            fields[2], // street
                            fields[3], // city
                            fields[4], // state
                            fields[5], // zipCode
                            fields[6], // phoneNumber
                            fields[7]  // email
                    );
                    add(contact);
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}

