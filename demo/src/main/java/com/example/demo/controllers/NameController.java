package com.example.demo.controllers;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import com.example.demo.models.Name;
import com.example.demo.models.Namedata;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "name")
public class NameController {

    @GetMapping(value = "/{sort}")
    public Name[] GetNames(@PathVariable(value = "sort") String sort)
            throws JsonParseException, JsonMappingException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        InputStream file = getClass().getClassLoader().getResourceAsStream("names.json");
        Namedata  nameobject = mapper.readValue(file, Namedata.class);

        List<Name> names = nameobject.names;
        //testing//
        //System.out.println ("list " + names.get(0).GetName());
        Name[] array = new Name[names.size()];
        names.toArray(array);
        switch (sort)
        {
            case "name":
                Arrays.sort(array,Comparator.comparing(Name::GetName));
                break;
            case "amount":
                Arrays.sort(array,Comparator.comparing(Name::GetAmount).reversed());
                break;
            default:
                break;
        }
        return array;
    }
}