package com.somi.springbootdemo.controller;

import com.somi.springbootdemo.model.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Slf4j
@RestController
public class FrontFace {

    RestTemplate restTemplate = new RestTemplate();


    @GetMapping("/resttemplate")
    public List<Employee> getEmployees(){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        String uri = "http://localhost:8087/api/v1/employees";
        List<Employee> res = restTemplate.exchange(
                uri, HttpMethod.GET, entity, List.class).getBody();

       System.out.println("my res ---" + res);
       log.debug(res.toString() + "-- response");

       return res;
    }

    /**
     * {
     *   "age": 0,
     *   "email": "string",
     *   "id": 0,
     *   "name": "string"
     * }
     * @return
     */
    @PostMapping("/resttemplate")
    public HttpEntity<HttpStatus> createEmp(@RequestBody Employee employee){
        String uri = "http://localhost:8087/api/v1/employees";
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Employee> entity = new HttpEntity<>(employee,headers);
        String res = restTemplate.exchange(uri,HttpMethod.POST,entity,String.class).getBody();
        System.out.println("res:::" + res);

        return new HttpEntity<>(HttpStatus.OK);
    }
}
