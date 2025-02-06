package ej1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Contacto contacto = new Contacto("Laura", "62386537");
        TelefonoMovil telefonomovil = new TelefonoMovil("936439865");
        Contacto contacto2=null;

        boolean acabarPrograma = false;
        while (!acabarPrograma) {
            System.out.println("0. Salir");
            System.out.println("1. Imprimir contactos");
            System.out.println("2. Crear nuevo contacto");
            System.out.println("3. Actualizar contacto existente");
            System.out.println("4. Eliminar contacto de la lista");
            System.out.println("5. Buscar/encontrar contacto por nombre");
            Scanner scanner=new Scanner(System.in);
            System.out.println("Introduce un número del 0 al 6:");
            int opcion=scanner.nextInt();
            switch (opcion) {
                case 0:
                    System.out.println("Salir del programa");
                    acabarPrograma = true;
                    break;
                case 1:
                    telefonomovil.printContacts();
                    break;
                case 2:
                    System.out.println("Introduce el nombre del usuario a crear:");
                    scanner.nextLine();
                    String nombre = scanner.nextLine();
                    System.out.println("Introduce el número de teléfono de la persona:");
                    String telf = scanner.nextLine();
                    contacto2 = new Contacto(nombre, telf);
                    if ((telefonomovil.findsContact(contacto2)) < 0) {
                        System.out.println("El contacto no existe, se ha creado con éxito");
                        telefonomovil.addNewContact(contacto2);
                    } else {
                        System.out.println("El contacto ya existe, no se puede crear");
                    }
                    break;
                case 3:
                    System.out.println("¿Qué contacto desea actualiazar?");
                    scanner.nextLine();
                    String persona=scanner.nextLine();

                    int numContacto = telefonomovil.queryContact(persona);
                    if (numContacto == -1) {
                        System.out.println("El contacto no existe, no se puede actualizar");
                    } else {
                        System.out.println("El contacto existe, se puede actualizar");
                        System.out.println("Introduce el nuevo nombre a cambiar");
                        String nuevaPersona=scanner.nextLine();
                        System.out.println("Introduce el nuevo número de teléfono");
                        String telf2=scanner.nextLine();

                        telefonomovil.updateContact(numContacto, new Contacto(nuevaPersona, telf2));
                    }

                    break;
                case 4:
                    scanner.nextLine();
                    System.out.println("Introduce un nombre que esté en la lista que desee eliminar");
                    String nombreEliminar= scanner.nextLine();
                    int posicionContacto = telefonomovil.queryContact(nombreEliminar);
                    if (posicionContacto >= 0){
                       telefonomovil.removeContact(telefonomovil.myContacts.get(posicionContacto));
                    }else{
                        System.out.println("No se puede eliminar ya que no existe");
                    }

                case 5:
                    scanner.nextLine();
                    System.out.println("Introduce el nombre a buscar");
                    String nombreBuscar=scanner.nextLine();
                    int posicionContacto2=telefonomovil.queryContact(nombreBuscar);
                    if(posicionContacto2>=0){
                        System.out.println("El teléfono existe");
                        System.out.println("- " + contacto.getName() + " --> " + contacto.getPhoneNumber());
                    }else{
                        System.out.println("El teléfono no existe por lo que no podemos buscarlo.");
                    }
                    
            }
        }

    }

}