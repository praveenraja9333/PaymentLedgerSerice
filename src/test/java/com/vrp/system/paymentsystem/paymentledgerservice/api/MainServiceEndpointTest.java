package com.vrp.system.paymentsystem.paymentledgerservice.api;

import com.vrp.system.paymentsystem.paymentledgerservice.PaymentledgerserviceApplication;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Headers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.*;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest(classes = PaymentledgerserviceApplication.class  , webEnvironment= WebEnvironment.DEFINED_PORT)
class MainServiceEndpointTest {

    static final String PROTOCOL="http://";
    static final String HOSTNAME="localhost:8080";
    static final String jsonPaylaod="{\n" +
            "  \"checkoutid\": \"c8be15de-4488-4490-9dc6-fab3f91435c6\",\n" +
            "  \"buyerinfo\":\"Praveen\",\n" +
            "  \"currencycode\":\"INR\",\n" +
            "  \"paymentOrderList\":[\n" +
            "    {\n" +
            "      \"sellername\":\"abc\",\n" +
            "      \"amount\":\"3241.83\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"sellername\":\"abc1\",\n" +
            "      \"amount\":\"4441.83\"\n" +
            "    }\n" +
            "  ]\n" +
            "}";

    enum Endpoints{
        PAYMENT_ENDPOINT("/api/v1/postOrder");
        final String endpoint;
        Endpoints(String endpoint){
            this.endpoint=endpoint;
        }
        public String getUrl(){
            return PROTOCOL+HOSTNAME+endpoint;
        }
    }


        @Test
        public void postOrder(){
            RestTemplate restTemplate=new RestTemplate();
            HttpHeaders headers=new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
            HttpEntity<String> requestEntity=new RequestEntity<>(jsonPaylaod,headers,HttpMethod.POST,null);
            ResponseEntity<String> response =restTemplate.exchange(URI.create(Endpoints.PAYMENT_ENDPOINT.getUrl()), HttpMethod.POST,requestEntity, String.class);
            assertEquals("0",response.getBody());
        }

}