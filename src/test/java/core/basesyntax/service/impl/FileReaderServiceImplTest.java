package core.basesyntax.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import core.basesyntax.service.FileReaderService;
import org.junit.BeforeClass;
import org.junit.Test;

public class FileReaderServiceImplTest {
    public static final String PATH = "src/test/resources/dataFrom.csv";
    private static FileReaderService fileReaderService;

    @BeforeClass
    public static void setUp() {
        fileReaderService = new FileReaderServiceImpl();
    }

    @Test
    public void readFile_Ok() {
        String actual = fileReaderService.readFile(PATH);
        String expected = "Text for ReadFromFileImpl class tests";
        assertEquals(expected, actual);
    }

    @Test
    public void readFile_InvalidPath_NotOk() {
        assertThrows(RuntimeException.class, () -> fileReaderService.readFile(""));
    }

    @Test
    public void readFile_NullPath_NotOk() {
        assertThrows(RuntimeException.class, () -> fileReaderService.readFile(null));
    }
}
