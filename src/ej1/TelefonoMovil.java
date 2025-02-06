package ej1;

import java.util.ArrayList;

public class TelefonoMovil {
    String myNumber;
    ArrayList<Contacto> myContacts;

    public TelefonoMovil(String myNumber) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<>();
    }
    public void addNewContact(Contacto c){
        myContacts.add(c);
    }

    public void updateContact(int posicionContactoAntiguo, Contacto nuevoContacto){
        myContacts.set(posicionContactoAntiguo, nuevoContacto);
    }

    public boolean removeContact(Contacto c){
        if(myContacts.contains(c)){
            myContacts.remove(c);
            return true;
        }else{
            return false;
        }
    }

    public int findContact(String c){
        if(myContacts.contains(c)){
            myContacts.indexOf(c);
            return myContacts.indexOf(c);
        }else{
            return -1;
        }
    }
    public int findsContact(Contacto c){
        if (myContacts.indexOf(c) >= 0){
            return myContacts.indexOf(c);
        } else {
            return -1;
        }
    }

    public int queryContact(String s){
        for (int i = 0; i < myContacts.size(); i++){
            if (myContacts.get(i).name.equals(s)){
                return i;
            }
        }
        return -1;
    }

    public void printContacts(){
        System.out.println("Lista de contactos:");
        for (Contacto contacto : myContacts){
            System.out.println("- " + contacto.getName() + " --> " + contacto.getPhoneNumber());
        }
    }
}
