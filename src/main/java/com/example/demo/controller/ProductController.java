package com.example.demo.controller;


import com.example.demo.repository.ProductRepository;
import com.example.demo.domain.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductRepository productRepository;
    
    
    @GetMapping("/create")
    public ResponseEntity<String> init(){
    	
        Arrays.asList(new Products("Addidas_Hoddie",1000,"This is Sample Toy"),
        		new Products("Baby_Diaperjpg",1200,"This is smaple Toy data"),
        		new Products("Ben10_watch",1200,"This is smaple Toy data"),
        		new Products("BossPrintedShirt",1200,"This is smaple Toy data"),
        		new Products("Brown_TeddyBear",1200,"This is smaple Toy data"),
        		new Products("Culturelle_baby_grow",1200,"This is smaple Toy data"),
        		new Products("duck",1200,"This is smaple Toy data"),
        		new Products("Ear_and_forehead_thermometer",1200,"This is smaple Toy data"),
        		new Products("Floral_printed_boluse",1200,"This is smaple Toy data"),
        		new Products("Healthcare_and_Grooming_Kit",1200,"This is smaple Toy data"),
        		new Products("Infant_car_seat",1200,"This is smaple Toy data"),
        		new Products("Long_sleeve_shirt",1200,"This is smaple Toy data"),
        		new Products("mermaid",1200,"This is smaple Toy data"),
        		new Products("MickeyMouse",1200,"This is smaple Toy data"),
        		new Products("Moutiain_Falls_Baby_Lotion",1200,"This is smaple Toy data"),
        		new Products("OrbitPrintedCroptop",1200,"This is smaple Toy data"),
        		new Products("Polo_Sport_Shirt",1200,"This is smaple Toy data"),
        		new Products("Princess_Dress",1200,"This is smaple Toy data"),
        		new Products("prinkTrouser",1200,"This is smaple Toy data"),
        		new Products("SportShirt",1200,"This is smaple Toy data"),
        		new Products("sully",1200,"This is smaple Toy data"),
        		new Products("TeddyBear",1200,"This is smaple Toy data"),
        		new Products("toy5",1200,"This is smaple Toy data"),
        		new Products("Transformer",1200,"This is smaple Toy data"),
        		new Products("wazowski",1200,"This is smaple Toy data"),
        		new Products("Wet_Tissue",1200,"This is smaple Toy data"),
        		new Products("White_cotton_dress",1200,"This is smaple Toy data"))
        .forEach(productRepository::save);
        
        return new ResponseEntity<String>("Successfully Created",HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping(value = "/products", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Products> findAllProducts() {
        return productRepository.findAll();
    }

    @CrossOrigin
    @GetMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public Products findProductsById(@PathVariable("id") int id) {
       return productRepository.getOne(id);

    }
}