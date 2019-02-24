package lce.test.normalizer.filedialogchoose;

import javax.swing.*;
import java.io.File;

/**
 * Класс вызывает всплывающее окно для выбора файла
 */
public class FileChoose extends JFrame implements ChooseFile{

    private JFileChooser fileChooser;

    public FileChoose(JFileChooser fileChooser){
        this.fileChooser = fileChooser;
        fileChooser.showOpenDialog(this);
    }

    /**
     * Функция выбора необходимого файла для нормализации
     * @return Выбранный файл
     */
    public File fileChoose(){
        File file = fileChooser.getSelectedFile();
        return file;

    }
}
