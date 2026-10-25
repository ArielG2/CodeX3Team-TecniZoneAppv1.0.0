package ec.edu.espe.tecnizoneapp.controller;

import ec.edu.espe.tecnizoneapp.model.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Lesly Muzo, CodeX3Team, @ESPE
 */
public class DataManager {

    private static final String CLIENTS_CSV = "clients.csv";
    private static final String PARTS_JSON = "parts.json";
    private static final String REPORT_TXT = "monthly_report.txt";

    public static void saveClientsCSV(List<Client> clients) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(CLIENTS_CSV))) {
            writer.write("clientId,fullName,phoneNumber,companyName\n");
            for (Client c : clients) {
                writer.write(c.getClientId() + "," + c.getFullName() + "," + c.getPhoneNumber() + "," + c.getCompanyName() + "\n");
            }
            System.out.println("-> Clientes guardados exitosamente en " + CLIENTS_CSV);
        } catch (IOException e) {
            System.out.println("Error al guardar clientes en CSV: " + e.getMessage());
        }
    }

    public static List<Client> loadClientsCSV() {
        List<Client> clients = new ArrayList<>();
        File file = new File(CLIENTS_CSV);
        if (!file.exists()) return clients;

        try (BufferedReader reader = new BufferedReader(new FileReader(CLIENTS_CSV))) {
            String line = reader.readLine(); // Cabecera
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length >= 4) {
                    clients.add(new Client(data[0], data[1], data[2], data[3]));
                }
            }
        } catch (IOException e) {
            System.out.println("Error al cargar clientes desde CSV: " + e.getMessage());
        }
        return clients;
    }

    public static void savePartsJSON(List<Part> parts) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(PARTS_JSON))) {
            writer.write("[\n");
            for (int i = 0; i < parts.size(); i++) {
                Part p = parts.get(i);
                writer.write("  {\n");
                writer.write("    \"partId\": \"" + p.getPartId() + "\",\n");
                writer.write("    \"partName\": \"" + p.getPartName() + "\",\n");
                writer.write("    \"stockQuantity\": " + p.getStockQuantity() + ",\n");
                writer.write("    \"minimumStock\": " + p.getMinimumStock() + ",\n");
                writer.write("    \"unitPrice\": " + p.getUnitPrice() + "\n");
                writer.write("  }" + (i < parts.size() - 1 ? "," : "") + "\n");
            }
            writer.write("]\n");
            System.out.println("-> Piezas guardadas exitosamente en " + PARTS_JSON);
        } catch (IOException e) {
            System.out.println("Error al guardar piezas en JSON: " + e.getMessage());
        }
    }

    public static List<Part> loadPartsJSON() {
        List<Part> parts = new ArrayList<>();
        File file = new File(PARTS_JSON);
        if (!file.exists()) return parts;

        try (BufferedReader reader = new BufferedReader(new FileReader(PARTS_JSON))) {
            StringBuilder jsonBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                jsonBuilder.append(line.trim());
            }
            String json = jsonBuilder.toString();
            if (json.startsWith("[") && json.endsWith("]")) {
                json = json.substring(1, json.length() - 1);
                String[] items = json.split("\\},\\s*\\{");
                for (String item : items) {
                    item = item.replace("{", "").replace("}", "").replace("\"", "");
                    String[] fields = item.split(",");
                    String id = "", name = "";
                    int stock = 0, minStock = 0;
                    double price = 0.0;
                    for (String field : fields) {
                        String[] pair = field.split(":");
                        if (pair.length == 2) {
                            String key = pair[0].trim();
                            String val = pair[1].trim();
                            switch (key) {
                                case "partId": id = val; break;
                                case "partName": name = val; break;
                                case "stockQuantity": stock = Integer.parseInt(val); break;
                                case "minimumStock": minStock = Integer.parseInt(val); break;
                                case "unitPrice": price = Double.parseDouble(val); break;
                            }
                        }
                    }
                    if (!id.isEmpty()) {
                        parts.add(new Part(id, name, stock, minStock, price));
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Error al cargar piezas desde JSON: " + e.getMessage());
        }
        return parts;
    }

    public static void exportReportTXT(MonthlyReport report) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(REPORT_TXT))) {
            writer.write(report.exportToText());
            System.out.println("-> Reporte mensual exportado exitosamente en " + REPORT_TXT);
        } catch (IOException e) {
            System.out.println("Error al exportar reporte: " + e.getMessage());
        }
    }
}
