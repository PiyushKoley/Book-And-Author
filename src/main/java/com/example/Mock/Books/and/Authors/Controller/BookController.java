package com.example.Mock.Books.and.Authors.Controller;

import com.example.Mock.Books.and.Authors.Dto.BookEntryDtoWithAuthorId;
import com.example.Mock.Books.and.Authors.Dto.BookResponseDtoWithAuthor;
import com.example.Mock.Books.and.Authors.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookService bookService;

    @PutMapping("/add_book_with_authorId")
    public ResponseEntity addBook(@RequestBody() BookEntryDtoWithAuthorId bookEntryDto) {
        BookResponseDtoWithAuthor book = bookService.addBookWithAuthorId(bookEntryDto);
        if(book == null){
            return new ResponseEntity("Author Id not present", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(book,HttpStatus.ACCEPTED);
    }

    @PostMapping("/add_book_by_name/{name}")
    public ResponseEntity addBookByName(@PathVariable("name") String bookName) {


        return new ResponseEntity(bookService.addBookByName(bookName) , HttpStatus.CREATED);
    }
}
