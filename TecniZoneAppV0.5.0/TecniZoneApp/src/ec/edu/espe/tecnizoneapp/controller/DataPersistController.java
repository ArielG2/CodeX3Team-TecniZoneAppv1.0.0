package ec.edu.espe.tecnizoneapp.controller;

import ec.edu.espe.tecnizoneapp.model.*;
import org.json.JSONObject;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Stalyn Guerrero, CodeX3Team, @ESPE
 */
public class DataPersistController {

    public void loadClients(ArrayList<Client> clients) {
        File file = new File("clients.json");
        if (!file.exists()) return;

        try (Scanner reader = new Scanner(file)) {
            while (reader.hasNextLine()) {
                String line = reader.nextLine().trim();
                if (!line.isEmpty()) {
                    JSONObject json = new JSONObject(line);
                    clients.add(new Client(
                        json.optString("ClientId", "N/A"),
                        json.optString("fullName", "N/A"),
                        json.optString("phoneNumber", "N/A")
                    ));
                }
            }
        } catch (Exception e) {
            System.out.println(">> Nota: No se cargaron clientes previos.");
        }
    }

    public void loadParts(ArrayList<Part> parts) {
        File file = new File("parts.json");
        if (!file.exists()) return;

        try (Scanner reader = new Scanner(file)) {
            while (reader.hasNextLine()) {
                String line = reader.nextLine().trim();
                if (!line.isEmpty()) {
                    JSONObject json = new JSONObject(line);
                    parts.add(new Part(
                        json.optString("partCode", "P00"),
                        json.optString("partName", "Sin Nombre"),
                        json.optInt("stockQuantity", 0),
                        json.optInt("minStockThreshold", 0),
                        json.optDouble("unitPrice", 0.0)
                    ));
                }
            }
        } catch (Exception e) {
            System.out.println(">> Nota: No se cargaron repuestos previos.");
        }
    }

    public void clearFileContent(String filename) {
        try {
            File file = new File(filename);
            if (file.exists()) {
                new PrintWriter(filename).close();
            }
        } catch (Exception e) {
            System.out.println(">> Error al limpiar " + filename + ": " + e.getMessage());
        }
    }

    public void displayRawFileContent(String filename) {
        File file = new File(filename);
        System.out.println("\n===== CONTENIDO DEL ARCHIVO: " + filename + " =====");
        if (!file.exists() || file.length() == 0) {
            System.out.println("(El archivo no existe o está vacío)");
            return;
        }

        try (Scanner reader = new Scanner(file)) {
            int lineNum = 1;
            while (reader.hasNextLine()) {
                System.out.println("[" + lineNum++ + "] " + reader.nextLine());
            }
        } catch (Exception e) {
            System.out.println(">> Error al leer el archivo " + filename + ": " + e.getMessage());
        }
    }
}