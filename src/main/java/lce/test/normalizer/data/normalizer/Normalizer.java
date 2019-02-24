package lce.test.normalizer.data.normalizer;

import java.util.*;

/**
 * Класс нормализующий данные в файле
 */
public class Normalizer implements Normalize {

    /**
     * Функцияя нормализует данные в файле
     * @param dataStr Данные в файле
     * @return Нормализованные данные
     */
    @Override
    public String normalize(String dataStr) {
        StringBuilder sortLine = new StringBuilder();
        for (String str : dataStr.split("\\s")){
            if (!str.equals("")) {
                ArrayList<String> symbolInLines = new ArrayList<>();
                Set<String> setSymbols = new TreeSet<>();
                for(String symbol : str.split(",")) {
                    if(!symbol.equals("") & !setSymbols.contains(symbol)) {
                        setSymbols.add(symbol);
                        symbolInLines.add(symbol);
                    }
                }
                Collections.sort(symbolInLines);
                sortLine.append(splitChars(symbolInLines) + "\n");
            }
        }
        return sortLine.toString();
    }

    /**
     * Разделяет нормализованные символы символом ','
     * @param line Одна строка в файле
     * @return Возвращает строку разделенную символом ','
     */
    private String splitChars(ArrayList<String> line){
        StringBuilder splitBuilder = new StringBuilder();
        for(String symbol : line ){
            splitBuilder.append(symbol + ",");
        }
        return splitBuilder.toString();
    }

}
