package lce.test.normalizer;

import lce.test.normalizer.data.fileswork.DataWriter;
import lce.test.normalizer.data.normalizer.Normalize;
import lce.test.normalizer.data.fileswork.DataReader;
import lce.test.normalizer.filedialogchoose.ChooseFile;
import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class RunNormalizer extends JFrame{

    @Autowired
    private ChooseFile chooseFile;

    @Autowired
    private DataReader dataReader;

    @Autowired
    private Normalize normalize;

    @Autowired
    private DataWriter dataWriter;

    public void start(){
        try {
            File file = chooseFile.fileChoose();
            System.out.println("Открыли файл: " + file.getPath());
            String readData = dataReader.read(file);
            System.out.println("Изначальные данные:\n" + readData);
            String normalizeStr = normalize.normalize(readData);
            System.out.println("Нормализованные данные:\n" + normalizeStr);
            String oldFilePath = file.getPath();
            String newFilePath = oldFilePath.substring(0, oldFilePath.lastIndexOf("\\")) + "\\normalizeDate.txt";
            dataWriter.write(normalizeStr, newFilePath);
            System.out.println("Сохранили нормализованные данные в новый файл: " + newFilePath);
        }
        catch (IOException ex){
            System.out.println(ex.getMessage());
        }
        System.exit(0);
    }
}
