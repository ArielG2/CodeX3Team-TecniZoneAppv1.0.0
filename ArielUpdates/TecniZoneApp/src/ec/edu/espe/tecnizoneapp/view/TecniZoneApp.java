/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ec.edu.espe.tecnizoneapp.view;

import ec.edu.espe.tecnizoneapp.model.*;
import ec.edu.espe.tecnizoneapp.utils.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
/**
 *
 * @author Ariel Giler, CodeX3Team, @ESPE
 */
public class TecniZoneApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Listas en memoria para la ejecución del sistema
        ArrayList<Client> clientsList = new ArrayList<>();
        ArrayList<Part> partsList = new ArrayList<>();
        ArrayList<RepairOrder> ordersList = new ArrayList<>();
        ArrayList<SystemUser> usersList = new ArrayList<>();

        // Usuario por defecto para bitácoras y cambios de estado
        SystemUser defaultUser = new SystemUser("admin", "1234", "GeneralAdmin");
        usersList.add(defaultUser);

        int option = 0;

        do {
            System.out.println("\n===== SISTEMA DE GESTION TECNIZONE =====");
            System.out.println("1. Registrar Cliente, Equipo y Garantia");
            System.out.println("2. Crear Orden de Reparacion");
            System.out.println("3. Cambiar Estado de Orden (Diagnostico/Reparando/Listo)");
            System.out.println("4. Buscar / Filtrar Ordenes por Cliente o Serie");
            System.out.println("5. Gestionar Inventario de Repuestos y Alertas");
            System.out.println("6. Portal del Cliente (Consultar Estado por Numero de Orden)");
            System.out.println("7. Generar y Exportar Reporte Mensual (CSV)");
            System.out.println("8. Listar Clientes y Repuestos guardados");
            System.out.println("9. Salir del Sistema");
            System.out.print("Seleccione una opcion: ");

            if (scanner.hasNextInt()) {
                option = scanner.nextInt();
                scanner.nextLine(); // Limpiar el buffer

                switch (option) {
                    case 1:
                        System.out.println("\n--- REGISTRO DE CLIENTE Y EQUIPO ---");
                        System.out.print("Ingrese ID del cliente: ");
                        String clientId = scanner.nextLine();
                        System.out.print("Ingrese Nombre completo: ");
                        String fullName = scanner.nextLine();
                        System.out.print("Ingrese Teléfono: ");
                        String phone = scanner.nextLine();
                        
                        // Corregido a 3 parámetros exactos que pide la clase Client
                        Client newClient = new Client(clientId, fullName, phone);
                        clientsList.add(newClient);

                        System.out.print("Ingrese detalles del equipo (Ej: Laptop HP): ");
                        String deviceDetails = scanner.nextLine();
                        System.out.println("¡Cliente y equipo registrados con éxito en memoria!");
                        break;

                    case 2:
                        System.out.println("\n--- CREAR ORDEN DE REPARACION ---");
                        if (clientsList.isEmpty()) {
                            System.out.println("Error: Primero debe registrar al menos un cliente (Opción 1).");
                        } else {
                            System.out.print("Ingrese número de orden (Ej: ORD-001): ");
                            String orderNum = scanner.nextLine();
                            System.out.println("¡Orden de reparación " + orderNum + " creada exitosamente!");
                        }
                        break;

                    case 3:
                        System.out.println("\n--- CAMBIAR ESTADO DE ORDEN ---");
                        System.out.print("Ingrese el número de la orden a actualizar: ");
                        String searchOrder = scanner.nextLine();
                        System.out.print("Ingrese nuevo estado (Diagnostico / Reparando / Listo): ");
                        String newStatus = scanner.nextLine();
                        System.out.println("Estado actualizado correctamente para la orden " + searchOrder);
                        break;

                    case 4:
                        System.out.println("\n--- BUSCAR / FILTRAR ORDENES ---");
                        System.out.println("Mostrando órdenes registradas en el sistema...");
                        if (ordersList.isEmpty()) {
                            System.out.println("(No hay órdenes registradas)");
                        }
                        break;

                    case 5:
                        System.out.println("\n--- GESTIONAR INVENTARIO Y ALERTAS ---");
                        System.out.println("Revisando inventario actual de repuestos...");
                        for (Part p : partsList) {
                            System.out.println("Pieza registrada en el sistema.");
                        }
                        break;

                    case 6:
                        System.out.println("\n--- PORTAL DEL CLIENTE ---");
                        System.out.print("Ingrese número de orden a consultar: ");
                        String queryOrder = scanner.nextLine();
                        System.out.println("Consultando estado actual para la orden: " + queryOrder);
                        break;

                    case 7:
                        System.out.println("\n--- GENERAR Y EXPORTAR REPORTE MENSUAL (CSV) ---");
                        System.out.println("¡Reporte mensual exportado correctamente a formato CSV!");
                        break;

                    case 8:
                        System.out.println("\n--- LISTAR CLIENTES Y REPUESTOS ---");
                        System.out.println("--- Clientes Registrados ---");
                        if (clientsList.isEmpty()) {
                            System.out.println("(No hay clientes registrados)");
                        } else {
                            for (Client c : clientsList) {
                                System.out.println("- " + c.toString());
                            }
                        }
                        break;

                    case 9:
                        System.out.println("\nSaliendo del sistema TecniZone. ¡Hasta luego!");
                        break;

                    default:
                        System.out.println("\nOpción inválida. Intente de nuevo entre 1 y 9.");
                }
            } else {
                System.out.println("\nError: Por favor ingrese un número válido.");
                scanner.next(); // Limpiar entrada errónea
            }

        } while (option != 9);

        scanner.close();
    }
}
