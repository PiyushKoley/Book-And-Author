package com.example.Mock.Books.and.Authors.Controller;

import com.example.Mock.Books.and.Authors.Dto.AuthorEntryDto;
import com.example.Mock.Books.and.Authors.Service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/author")
public class AuthorController {
    @Autowired
    AuthorService authorService;

    @PostMapping("/add")
    public ResponseEntity addAuthor(@RequestBody() AuthorEntryDto authorEntryDto){
        return new ResponseEntity(authorService.addAuthorByName(authorEntryDto), HttpStatus.CREATED) ;
    }


    @PostMapping("/add_name/{name}")
    public ResponseEntity addByAuthorByName(@PathVariable("name") String authorName) {

        return  new ResponseEntity(authorService.addAuthor(authorName), HttpStatus.CREATED);
    }
}
