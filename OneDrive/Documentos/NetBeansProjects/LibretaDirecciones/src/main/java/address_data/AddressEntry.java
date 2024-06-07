package address_data;

/**
 * Clase que representa una entrada en una libreta de direcciones.
 */
public class AddressEntry {

    private String firstName;
    private String lastName;
    private String street;
    private String city;
    private String state;
    private String zipCode;
    private String phoneNumber;
    private String email;

    /**
     * Constructor para crear una nueva entrada en la libreta de direcciones.
     *
     * @param firstName   El nombre del contacto.
     * @param lastName    El apellido del contacto.
     * @param street      La calle de la dirección del contacto.
     * @param city        La ciudad de la dirección del contacto.
     * @param state       El estado de la dirección del contacto.
     * @param zipCode     El código postal de la dirección del contacto.
     * @param phoneNumber El número de teléfono del contacto.
     * @param email       El correo electrónico del contacto.
     */
    public AddressEntry(String firstName, String lastName, String street, String city, String state, String zipCode, String phoneNumber, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
    
    /**
     * Devuelve una representación en cadena de la entrada de la libreta de direcciones.
     *
     * @return Una representación en cadena de la entrada de la libreta de direcciones.
     */
    @Override
    public String toString() {
        return String.format("Nombre: %s %s%nCalle: %s%nCiudad: %s%nEstado: %s%nCodigo Postal: %s%nTelefono: %s%nCorreo Electronico: %s", 
                              firstName, lastName, street, city, state, zipCode, phoneNumber, email);
    }

    // Métodos de acceso para los atributos de la entrada de la libreta de direcciones

    // Métodos getter y setter para cada atributo...

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
}
