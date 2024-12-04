package az.turing.util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtil<T> {

    public final String fileName;

    public FileUtil(String fileName) {
        this.fileName = fileName;
    }

    public void WriteToFile(List<T> t) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
            outputStream.writeObject(t);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<T> ReadToFile() {
        List<T> entityList = new ArrayList<>();
        File file = new File(fileName);
        if (!file.exists()) {
            return entityList;
        } else {
            try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fileName))) {
                List<T> flightlist = (List<T>) objectInputStream.readObject();
                entityList.addAll(flightlist);
            } catch (IOException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            return entityList;
        }
    }
}
