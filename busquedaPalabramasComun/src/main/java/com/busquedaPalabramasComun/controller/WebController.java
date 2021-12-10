package com.busquedaPalabramasComun.controller;

import com.busquedaPalabramasComun.model.Web;
import com.busquedaPalabramasComun.service.WebService;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", methods={RequestMethod.GET,RequestMethod.POST})
public class WebController {

   // @Autowired
    private WebService webService= new WebService();

    @GetMapping("/{url}")
    public String webSearch(@PathVariable("url") String url){
        return webService.getWeb2(url);
    }
    @PostMapping("/search")
    @ResponseStatus(HttpStatus.OK)
    public String SearchWord(@RequestBody Web url){
        return webService.getWeb(url);
    }

}
