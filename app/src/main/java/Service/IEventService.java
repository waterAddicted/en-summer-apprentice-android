package Service;

import java.util.List;

import Models.DTOs.EventsDtO;
import retrofit2.Call;
import retrofit2.http.GET;

public interface IEventService {
    @GET("/api/Event/Events")
    Call<List<EventsDtO>> fetchAllEvents();
}
