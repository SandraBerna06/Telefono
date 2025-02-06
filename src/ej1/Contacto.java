package ej1;

public class Contacto {
    String name;
    String phoneNumber;

    public Contacto(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
    public static Contacto createContact(String nombre, String phoneNumber){
        Contacto contacto=new Contacto(nombre,phoneNumber);
        return contacto;
    }
}
