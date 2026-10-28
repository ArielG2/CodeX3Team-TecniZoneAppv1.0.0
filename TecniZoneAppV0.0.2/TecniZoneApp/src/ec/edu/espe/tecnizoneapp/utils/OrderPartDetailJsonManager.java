package ec.edu.espe.tecnizoneapp.utils;

import ec.edu.espe.tecnizoneapp.model.OrderPartDetail;
import org.json.JSONObject;
import java.io.FileWriter;

/**
 *
 * @author Stalyn Guerrero, CodeX3Team, @ESPE
 */
public class OrderPartDetailJsonManager {

    public static void save(OrderPartDetail orderPartDetail) {

        JSONObject json = new JSONObject(orderPartDetail);

        try (FileWriter file = new FileWriter("orderPartDetails.json", true)) {
            file.write(json.toString() + "\n");
            System.out.println(">> Detalle de repuesto guardado en orderPartDetails.json");
        } catch (Exception e) {
            System.out.println(">> Error al guardar: " + e.getMessage());
        }
    }
}
