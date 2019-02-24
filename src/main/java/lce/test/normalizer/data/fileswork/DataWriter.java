package lce.test.normalizer.data.fileswork;

import java.io.IOException;

public interface DataWriter {

    void write(String data, String path) throws IOException;
}
