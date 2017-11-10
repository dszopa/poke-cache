package factory;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClients;

public class HttpClientFactory {

    public HttpClient getHttpClient() {
        return HttpClients.createDefault();
    }
}
