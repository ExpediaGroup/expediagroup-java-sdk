package com.expediagroup.sdk.exemplar.playground;

import com.expediagroup.sdk.exemplar.client.ExemplarClient;
import com.expediagroup.sdk.exemplar.operation.SearchHotelOperation;
import com.expediagroup.sdk.exemplar.operation.SearchHotelOperationParams;
import com.expediagroup.sdk.okhttp.OkHttpClientConfiguration;
import com.expediagroup.sdk.okhttp.OkHttpTransport;

public class ConfiguredOkHttpTransport {

    public static void main(String[] args) {
        OkHttpClientConfiguration configuration = OkHttpClientConfiguration.builder()
            .callTimeout(100000)
            .connectTimeout(100000)
            .readTimeout(100000)
            .build();

        OkHttpTransport transport = new OkHttpTransport(configuration);

        ExemplarClient exemplarClient = new ExemplarClient(transport);

        SearchHotelOperationParams params = SearchHotelOperationParams.builder().build();
        SearchHotelOperation operation = new SearchHotelOperation(params);

        exemplarClient.execute(operation);
    }
}
