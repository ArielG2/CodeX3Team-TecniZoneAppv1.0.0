package ec.edu.espe.tecnizoneapp.utils;

import org.json.JSONObject;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

public class JsonManager<T extends JsonSerializable> {

    private final String fileName;
    private final Function<JSONObject, T> parser;

    public JsonManager(String fileName) {
        this(fileName, null);
    }

    public JsonManager(String fileName, Function<JSONObject, T> parser) {
        this.fileName = fileName;
        this.parser = parser;
    }

    public void save(T item) {
        if (item == null) return;
        File fileObj = new File(fileName);

        try (FileWriter file = new FileWriter(fileObj, true)) {
            file.write(item.toJson().toString() + "\n");
            file.flush();
            System.out.println(">> Registro guardado en: " + fileObj.getAbsolutePath());
        } catch (Exception e) {
            System.out.println(">> Error al guardar en " + fileName + ": " + e.getMessage());
        }
    }

    public void saveAll(List<T> items) {
        File fileObj = new File(fileName);
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileObj, false))) {
            for (T item : items) {
                writer.println(item.toJson().toString());
            }
        } catch (Exception e) {
            System.out.println(">> Error al sobrescribir " + fileName + ": " + e.getMessage());
        }
    }

    public List<T> loadAll() {
        List<T> results = new ArrayList<>();
        if (parser == null) return results;

        File file = new File(fileName);
        if (!file.exists() || file.length() == 0) return results;

        try (Scanner reader = new Scanner(file)) {
            while (reader.hasNextLine()) {
                String line = reader.nextLine().trim();
                if (!line.isEmpty()) {
                    JSONObject json = new JSONObject(line);
                    T obj = parser.apply(json);
                    if (obj != null) {
                        results.add(obj);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(">> Nota: No se pudieron cargar datos previos de " + fileName);
        }
        return results;
    }
}