package ec.edu.espe.tecnizoneapp.utils;

import ec.edu.espe.tecnizoneapp.model.DirectSale;
import org.json.JSONObject;
import java.io.FileWriter;

/**
 *
 * @author Lesly Muzo, CodeX3Team, @ESPE
 */
public class DirectSaleJsonManager {

    public static void save(DirectSale directSale) {

        JSONObject json = new JSONObject(directSale);

        try (FileWriter file = new FileWriter("directSales.json", true)) {
            file.write(json.toString() + "\n");
            System.out.println(">> Venta directa guardada en directSales.json");
        } catch (Exception e) {
            System.out.println(">> Error al guardar: " + e.getMessage());
        }
    }
}
