package com.example.primenumber.Service;

import com.example.primenumber.Entity.Requests;
import com.example.primenumber.Repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RequestService {

    @Autowired
    RequestRepository requestRepository;

    public Requests save(Requests requests){
        return requestRepository.save(requests);
    }
}
