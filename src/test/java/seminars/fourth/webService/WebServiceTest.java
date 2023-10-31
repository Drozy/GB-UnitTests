package seminars.fourth.webService;

import org.junit.jupiter.api.Test;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

class WebServiceTest {
    @Test
    void httpGetTest() {
        HttpClient httpClient = mock(HttpClient.class);
        WebService webService = new WebService(httpClient);
        when(httpClient.get(anyString())).thenReturn("data");
        String site = "www.inter.net";

        webService.getHTTP(site);

        verify(httpClient, times(1)).get(anyString());

    }

}