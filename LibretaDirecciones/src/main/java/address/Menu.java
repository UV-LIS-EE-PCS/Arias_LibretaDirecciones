package address;

import address_data.AddressBook;
import address_data.AddressEntry;

import java.util.Scanner;

/**
 * Clase que representa el menú de una aplicación de libreta de direcciones.
 */
public class Menu {

    private static final String RESET = "\033[0m";
    private static final String YELLOW = "\033[0;33m";
    private static final String GREEN = "\033[0;32m";
    private static final String RED = "\033[0;31m";
    
    private AddressBook addressBook;
    private Scanner scanner;

    /**
     * Constructor de la clase Menu.
     *
     * @param addressBook La libreta de direcciones asociada al menú.
     */
    public Menu(AddressBook addressBook) {
        this.addressBook = addressBook;
        this.scanner = new Scanner(System.in);
    }

    /**
     * Método para iniciar el menú.
     */
    public void start() {
        while (true) {
            printMenu();
            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println(RED + "Por favor, ingrese un numero valido." + RESET);
                continue;
            }

            switch (choice) {
                case 1:
                    addEntry();
                    break;
                case 2:
                    deleteEntry();
                    break;
                case 3:
                    searchEntry();
                    break;
                case 4:
                    listAllEntries();
                    break;
                case 5:
                    readFromFile();
                    break;
                case 6:
                    System.out.println("Saliendo... " + GREEN + "Hecho." + RESET);
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("ingrese un valor.");
            }
        }
    }

    /**
     * Método para imprimir el menú.
     */
    private void printMenu() {
        // Imprime el banner del menú
        System.out.println(YELLOW + "<banner del menú>" + RESET);
        
        // Imprime las opciones del menú
        System.out.println(YELLOW + """
                                   _____ ______   ______ _______ _______ _______      ______  _______
                            |        |   |_____] |_____/ |______    |    |_____|      |     \\ |______
                            |_____ __|__ |_____] |    \\_ |______    |    |     |      |_____/ |______
                           ______  _____  ______ _______ _______ _______ _____  _____  __   _ _______ _______
                            |     \\   |   |_____/ |______ |       |         |   |     | | \\  | |______ |______
                            |_____/ __|__ |    \\_ |______ |_____  |_____  __|__ |_____| |  \\_| |______ ______|""" + RESET + "\n\n");
        System.out.println("-==================================-");
        System.out.println(YELLOW + "1) " + RESET + "Nuevo contacto");
        System.out.println(YELLOW + "2) " + RESET + "Borrar contacto");
        System.out.println(YELLOW + "3) " + RESET + "Buscar por apellido");
        System.out.println(YELLOW + "4) " + RESET + "Mostrar todos mis contactos");
        System.out.println(YELLOW + "5) " + RESET + "Cargar de un archivo");
        System.out.println(YELLOW + "6) " + RESET + "Salir");
        System.out.println("-==================================-");
        System.out.print( YELLOW + "Por favor seleccione una opcion: " + RESET);
    }

    /**
     * Método para agregar una nueva entrada en la libreta de direcciones.
     */
    private void addEntry() {
        // Solicita al usuario que ingrese los datos del nuevo contacto
        System.out.print("Nombre: ");
        String firstName = scanner.nextLine();
        System.out.print("Apellido: ");
        String lastName = scanner.nextLine();
        System.out.print("Direccion: ");
        String street = scanner.nextLine();
        System.out.print("Ciudad: ");
        String city = scanner.nextLine();
        System.out.print("Estado: ");
        String state = scanner.nextLine();
        System.out.print("Codigo Postal: ");
        String zipCode = scanner.nextLine();
        System.out.print("Numero Telefonico: ");
        String phoneNumber = scanner.nextLine();
        System.out.print("Correo Electronico: ");
        String email = scanner.nextLine();

        // Crea una nueva entrada en la libreta de direcciones y la agrega
        AddressEntry entry = new AddressEntry(firstName, lastName, street, city, state, zipCode, phoneNumber, email);
        addressBook.add(entry);
        System.out.println("-==================================-");
        System.out.println(GREEN + "Contacto agendado exitosamente." + RESET);
    }

    /**
     * Método para eliminar una entrada de la libreta de direcciones.
     */
    private void deleteEntry() {
        // Solicita al usuario que ingrese el apellido del contacto a eliminar
        System.out.print(YELLOW + "Ingrese el apellido del contacto que deseas eliminar: " + RESET);
        String lastName = scanner.nextLine();
        // Elimina el contacto de la libreta de direcciones
        addressBook.delete(lastName);
        System.out.println("-==================================-");
        System.out.println(GREEN + "Contacto eliminado exitosamente." + RESET);
    }

    /**
     * Método para buscar entradas en la libreta de direcciones por apellido.
     */
    private void searchEntry() {
        // Solicita al usuario que ingrese un apellido para la búsqueda
        System.out.print("Ingrese un apellido para empezar la busqueda: ");
        String lastName = scanner.nextLine();
        // Realiza la búsqueda y muestra los resultados
        System.out.println(GREEN + "Resultados de busqueda:" + RESET);
        addressBook.search(lastName);
        System.out.println("Fin de los resultados.");
    }

    /**
     * Método para mostrar todas las entradas de la libreta de direcciones.
     */
    private void listAllEntries() {
        // Muestra todas las entradas de la libreta de direcciones
        addressBook.list();
    }

    /**
     * Método para leer entradas de la libreta de direcciones desde un archivo.
     */
    private void readFromFile() {
        // Solicita al usuario que ingrese la ruta del archivo
        System.out.print("Escriba la ruta del archivo para importar contactos: ");
        String filename = scanner.nextLine();
        // Lee las entradas desde el archivo y las agrega a la libreta de direcciones
        addressBook.readFromFile(filename);
    }
}

