package POJOs;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;

/**
 * Created by xiaotingli on 4/1/15.
 */
public class ExampleRestClient {
    private static final String BASE_URL = "https://api.linkedin.com/";
    private ExampleInterface exampleInterface;

    public ExampleRestClient()
    {
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy'-'MM'-'dd'T'HH':'mm':'ss'.'SSS'Z'")
                .create();

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setEndpoint(BASE_URL)
                .setConverter(new GsonConverter(gson))
                .build();

        exampleInterface = restAdapter.create(ExampleInterface.class);
    }

    public ExampleInterface getApiService()
    {
        return exampleInterface;
    }
}
