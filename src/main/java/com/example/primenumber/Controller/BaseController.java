package com.example.primenumber.Controller;

import com.example.primenumber.Service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseController {

    @Autowired
    protected RequestService requestService;
}
