package ec.edu.espe.tecnizoneapp.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

public class CsvManager<T extends CsvSerializable> {

    private final String fileName;

    public CsvManager(String fileName) {
        this.fileName = fileName;
    }

    public void save(T item) {
        if (item == null) return;
        File file = new File(fileName);
        boolean writeHeader = !file.exists() || file.length() == 0;

        try (PrintWriter writer = new PrintWriter(new FileWriter(file, true))) {
            if (writeHeader) {
                writer.println(item.getCsvHeader());
            }
            writer.println(item.toCsvRow());
            System.out.println(">> Registro guardado en " + fileName);
        } catch (Exception e) {
            System.out.println(">> Error al guardar en " + fileName + ": " + e.getMessage());
        }
    }
}