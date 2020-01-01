package game;

import java.io.IOException;

public interface Observer {
    void update(fileio.FileSystem fs, String message) throws IOException;
}
