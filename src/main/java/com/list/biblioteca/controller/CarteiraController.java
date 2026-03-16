package com.list.biblioteca.controller;

import com.list.biblioteca.dto.CarteiraRequest;
import com.list.biblioteca.dto.CarteiraResponse;
import com.list.biblioteca.service.CarteiraService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class CarteiraController {

    private final CarteiraService carteiraService;

    public CarteiraController(CarteiraService carteiraService) {
        this.carteiraService = carteiraService;
    }

    @PostMapping("/{id}/carteira")
    public CarteiraResponse criarCarteira(@PathVariable Long  id, @RequestBody CarteiraRequest carteirarequest)
    {
         return carteiraService.criarCarteira(id, carteirarequest);
    }


}
