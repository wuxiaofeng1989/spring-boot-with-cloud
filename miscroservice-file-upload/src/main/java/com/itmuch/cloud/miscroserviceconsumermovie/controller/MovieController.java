package com.itmuch.cloud.miscroserviceconsumermovie.controller;

import com.itmuch.cloud.miscroserviceconsumermovie.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Stack;

@RestController
public class MovieController {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/simple/{id}")
    public User findById(@PathVariable Long id ){
       User user = new User();
       user.setId(id);
       return user;
    }

    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    public @ResponseBody String handleFileUpload(@RequestParam(value = "file",required = true)MultipartFile file) throws IOException{
        byte [] bytes = file.getBytes();
        File fileToSave = new File(file.getOriginalFilename());
        FileCopyUtils.copy(bytes,fileToSave);

        return fileToSave.getAbsolutePath();
    }
}
