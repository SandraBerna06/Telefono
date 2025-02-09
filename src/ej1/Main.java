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
                    scanner.nextLine();
                    System.out.println("Introduce el nombre del usuario a crear:");
                    String nombre = scanner.nextLine();
                    if (telefonomovil.queryContact(nombre) != null) {
                        System.out.println("No se puede crear porque el nombre ya existe");
                    } else {
                        System.out.println("Introduce el número de teléfono de la persona:");
                        String telf = scanner.nextLine();
                        Contacto contactoNuevo = Contacto.createContact(nombre, telf);
                        telefonomovil.addNewContact(contactoNuevo);
                    }
                    break;
                case 3:
                    scanner.nextLine();
                    System.out.println("¿Qué contacto desea actualizar?");
                    String persona = scanner.nextLine();
                    Contacto c = telefonomovil.queryContact(persona);
                    if (c == null) {
                        System.out.println("El contacto no existe, no se puede actualizar");
                    } else {
                        System.out.println("Introduce el nuevo nombre a cambiar:");
                        String nuevaPersona = scanner.nextLine();
                        if (telefonomovil.queryContact(nuevaPersona) == null) {
                            System.out.println("Introduce el nuevo número de teléfono:");
                            String telf2 = scanner.nextLine();
                            Contacto nuevoContacto = new Contacto(nuevaPersona, telf2);
                            telefonomovil.updateContact(c, nuevoContacto);
                        } else {
                            System.out.println("No se puede actualizar porque el nombre ya existe");
                        }
                    }
                    break;
                case 4:
                    scanner.nextLine();
                    System.out.println("Introduce un nombre que esté en la lista que desees eliminar:");
                    String nombreEliminar = scanner.nextLine();
                    if (telefonomovil.queryContact(nombreEliminar) != null) {
                        telefonomovil.removeContact(telefonomovil.queryContact(nombreEliminar));
                        System.out.println("Contacto eliminado");
                    } else {
                        System.out.println("No se puede eliminar ya que no existe");
                    }
                    break;
                case 5:
                    scanner.nextLine();
                    System.out.println("Introduce el nombre a buscar:");
                    String nombreBuscar = scanner.nextLine();
                    Contacto contactoBuscado = telefonomovil.queryContact(nombreBuscar);
                    if (contactoBuscado != null) {
                        System.out.println("El teléfono existe");
                        System.out.println("- " + contactoBuscado.getName() + " --> " + contactoBuscado.getPhoneNumber());
                    } else {
                        System.out.println("El teléfono no existe, por lo que no podemos buscarlo.");
                    }
                    break;
                    
            }
        }

    }

}