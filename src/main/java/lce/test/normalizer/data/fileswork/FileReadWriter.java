package lce.test.normalizer.data.fileswork;

import java.io.*;

/**
 * Класс чтения и записи в файл
 */
public class FileReadWriter implements DataReader, DataWriter {

    @Override
    public String read(File file) throws IOException {
        StringBuilder dataInFile = new StringBuilder();
        try(InputStreamReader fileReader = new InputStreamReader(new FileInputStream(file), "UTF-8")) {
            int symbol;
            while ((symbol = fileReader.read()) != -1) {
                dataInFile.append((char) symbol);
            }
        }
        return dataInFile.toString();
    }

    @Override
    public void write(String data, String path) throws IOException {
        File file = new File(path);
        try(FileWriter fileWriter = new FileWriter(file)) {
            fileWriter.write(data);
        }
    }
}
