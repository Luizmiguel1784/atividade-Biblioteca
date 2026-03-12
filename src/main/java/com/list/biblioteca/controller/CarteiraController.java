package com.list.biblioteca.controller;

import com.list.biblioteca.dto.CarteiraRequest;
import com.list.biblioteca.dto.CarteiraResponse;
import com.list.biblioteca.service.CarteiraService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("carteira")
public class CarteiraController {

    private final CarteiraService carteiraService;

    public CarteiraController(CarteiraService carteiraService) {
        this.carteiraService = carteiraService;
    }

    @PostMapping("usuarios/{id}/carteira")
    public CarteiraResponse criarCarteira(Long  carteira, CarteiraRequest carteirarequest)
    {
         return carteiraService.criarCarteira(carteira, carteirarequest);
    }


}
