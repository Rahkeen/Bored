package com.rikin.bored.com.rikin.bored.model.repository;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface TwitchService {

    @GET("streams")
    Single<StreamsResponse> getStreams(@Query(value = "game_id") String gameId);
}
