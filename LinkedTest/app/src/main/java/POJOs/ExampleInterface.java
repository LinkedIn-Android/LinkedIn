package POJOs;

import retrofit.http.GET;

/**
 * Created by xiaotingli on 4/1/15.
 */
public interface ExampleInterface {
    @GET("/api/getProfile")
    public void getProfile();
}
