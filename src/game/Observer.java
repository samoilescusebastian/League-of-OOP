package game;

import java.io.IOException;

public interface Observer {
    void update(final fileio.FileSystem fs, final String message) throws IOException;
}
