package seminars.fourth.database;


import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

class DataProcessorTest {
    @Test
    void databaseTest() {
        Database database = mock(Database.class);
        DataProcessor dataProcessor = new DataProcessor(database);
        when(database.query(anyString())).thenReturn(Arrays.asList("123", "qwe", "ASD"));

        List<String> result = dataProcessor.processData("???");

        verify(database, times(1)).query("???");
        assertThat(result).isNotEmpty().isEqualTo(Arrays.asList("123", "qwe", "ASD"));
    }
}