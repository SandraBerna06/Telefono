package ej1;

import java.util.ArrayList;

public class TelefonoMovil {
    String myNumber;
    ArrayList<Contacto> myContacts;

    public TelefonoMovil(String myNumber) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<>();
    }

    public void addNewContact(Contacto c) {
        for (Contacto contact : myContacts) {
            if (contact.getName().equals(c.getName())) {
                System.out.println("No se puede añadir el contacto porque ya existe.");
                return;
            }
        }
        myContacts.add(c);
        System.out.println("Contacto añadido: " + c.getName());
    }


    public boolean updateContact(Contacto c, Contacto nuevoContacto) {
        int i = findContact(c.getName());
        if (i >= 0) {
            this.myContacts.set(i, nuevoContacto);
            return true;
        } else {
            return false;
        }
    }

    public boolean removeContact(Contacto c){
        int index = findContact(c.getName());
        if (index >= 0) {
            myContacts.remove(index);
            return true;
        } else {
            return false;
        }
    }

    public int findContact(String c){
        for (int i = 0; i < myContacts.size(); i++) {
            if (myContacts.get(i).getName().equals(c)) {
                return i;
            }
        }
        return -1;
    }
    public int findsContact(Contacto c){
        if (myContacts.indexOf(c) >= 0){
            return myContacts.indexOf(c);
        } else {
            return -1;
        }
    }

    public Contacto queryContact(String s){
        int index = findContact(s);
        if (index >= 0) {
            return myContacts.get(index);
        } else {
            return null;
        }
    }

    public void printContacts(){
        System.out.println("Lista de contactos:");
        for (Contacto contacto : myContacts){
            System.out.println("- " + contacto.getName() + " --> " + contacto.getPhoneNumber());
        }
    }
}
