package com.konoha.sushi.controller;

import com.konoha.sushi.services.abstraction.IVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/venta")
public class VentaController {
    @Autowired
    private IVentaService ventaService;


}
