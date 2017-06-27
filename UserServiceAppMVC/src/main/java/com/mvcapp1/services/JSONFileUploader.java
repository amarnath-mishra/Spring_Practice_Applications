package com.mvcapp1.services;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Controller;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mvcapp1.controllerpackage.UserData;


@Controller
public class JSONFileUploader implements FileUploadInterface{

	private ObjectMapper mapper = new ObjectMapper();

    public Boolean isFileExists(File file) {
        return (file.exists() && !file.isDirectory() && (file.getName().endsWith(".json")));
    }

   
    public List<UserData> readContent(File file) throws Exception {
//        if(!isFileExists(file))
//            throw new Exception("File not found!");
        
        List<UserData> users = mapper.readValue(file, new TypeReference<List<UserData>>(){});
        return users;
    }
}
