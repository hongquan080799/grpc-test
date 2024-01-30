package com.abc.Client;

import com.abc.Client.dto.PostDTO;
import com.abc.Client.monitor.Monitor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Component
public class RestClient {
    private RestTemplate restTemplate = new RestTemplate();

    @Monitor(name = "insert_post", type = "http")
    public void sendTest() {
        PostDTO dto = new PostDTO();
        dto.setPerson(UUID.randomUUID().toString());
        dto.setBody(UUID.randomUUID().toString());
        dto.setTitle(UUID.randomUUID().toString());
        dto.setField1(UUID.randomUUID().toString());
        dto.setField2(UUID.randomUUID().toString());
        dto.setField3(UUID.randomUUID().toString());
        dto.setField4(UUID.randomUUID().toString());
        dto.setField5(UUID.randomUUID().toString());
        dto.setField6(UUID.randomUUID().toString());
        dto.setField7(UUID.randomUUID().toString());
        dto.setField8(UUID.randomUUID().toString());
        dto.setField9(UUID.randomUUID().toString());
        dto.setField10(UUID.randomUUID().toString());
        dto.setField11(UUID.randomUUID().toString());
        dto.setField12(UUID.randomUUID().toString());
        dto.setField13(UUID.randomUUID().toString());
        dto.setField14(UUID.randomUUID().toString());
        dto.setField15(UUID.randomUUID().toString());
        dto.setField16(UUID.randomUUID().toString());
        dto.setField17(UUID.randomUUID().toString());
        dto.setField18(UUID.randomUUID().toString());
        dto.setField19(UUID.randomUUID().toString());
        dto.setField20(UUID.randomUUID().toString());
        String url = "http://localhost:8081/post";
        String response = restTemplate.postForObject(url, dto, String.class);
        System.out.println(response);
    }
}
