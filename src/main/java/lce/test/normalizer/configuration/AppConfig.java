package lce.test.normalizer.configuration;

import lce.test.normalizer.RunNormalizer;
import lce.test.normalizer.data.fileswork.FileReadWriter;
import lce.test.normalizer.data.normalizer.Normalizer;
import lce.test.normalizer.filedialogchoose.FileChoose;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import javax.swing.*;

@Configuration
public class AppConfig {

    @Bean
    public Normalizer normalizer(){
        return new Normalizer();
    }

    @Bean
    @Lazy
    public JFileChooser getFileChooser(){
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        fileChooser.setDialogTitle("Выберите файл для нормализации данных");
        fileChooser.setApproveButtonText("Выбрать");
        fileChooser.setDialogType(JFileChooser.OPEN_DIALOG);
        fileChooser.setVisible(true);
        return fileChooser;
    }

    @Bean
    public FileChoose fileChoose(JFileChooser fileChooser){
        return new FileChoose(fileChooser);
    }

    @Bean(name = "runNormalizer")
    public RunNormalizer getRunNormalizer(){
        return new RunNormalizer();
    }

    @Bean
    public FileReadWriter getFileReadWriter(){
        return new FileReadWriter();
    }

}
