package com.example.springbootexample.controller;

import org.springframework.web.bind.annotation.RequestMethod;
// import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
// import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

// import org.apache.commons.io.IOUtils;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.CacheControl;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
// import sun.misc.Request;
import org.springframework.core.io.Resource;

@RestController
@RequestMapping("/alpha-vantage")
public class AlphaVantageController {
	
    @RequestMapping(method = RequestMethod.GET, value = "/")
    public ResponseEntity<String> index() {
    	
        return ResponseEntity.ok()
        		.body("Alpha Vantage Cer is dsfdsfdfworking!!");
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/resume", produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<Resource> getResume() throws IOException {
    		
    	

        File file = new File("src/main/resources/static/Resume.pdf");
        Path path = Paths.get(file.getAbsolutePath());
        ByteArrayResource resource = new ByteArrayResource(Files.readAllBytes(path));
       
       
        return ResponseEntity.ok()
                .cacheControl(CacheControl.maxAge(60, TimeUnit.SECONDS).cachePrivate())
                .contentLength(file.length())
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(resource);
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/test-html", produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<Resource> getHtml() throws IOException {
    		
    	

        File file = new File("src/main/resources/static/test.html");
        Path path = Paths.get(file.getAbsolutePath());
        ByteArrayResource resource = new ByteArrayResource(Files.readAllBytes(path));
//        counter++;
        
        return ResponseEntity.ok()
                .contentLength(file.length())
                .contentType(MediaType.TEXT_HTML)
                .body(resource);
    }

//    @RequestMapping(method = RequestMethod.GET, value = "`")

}