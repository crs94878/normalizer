package lce.test.normalizer.data.fileswork;

import java.io.File;
import java.io.IOException;

public interface DataReader {
    String read(File file) throws IOException;
}
