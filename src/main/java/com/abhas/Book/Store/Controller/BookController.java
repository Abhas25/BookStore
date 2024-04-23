package com.abhas.Book.Store.Controller;

import com.abhas.Book.Store.Entity.Book;
import com.abhas.Book.Store.Entity.MyBookList;
import com.abhas.Book.Store.service.BookService;
import com.abhas.Book.Store.service.MyBookListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;
    @Autowired
    private MyBookListService myBookListService;
    @GetMapping("/")
    public String home(){
        return "home";
    }

    @GetMapping("/book_register")
    public String book_register(){
        return "book_register";
    }

    @GetMapping("/available_books")
    public ModelAndView available_books(){
        List<Book> list = bookService.getAllBooks();
        return new ModelAndView("available_books", "book", list);
    }

    @PostMapping("/save")
    public String addBook(@ModelAttribute Book b){
        bookService.save(b);
        return "redirect:/available_books";
    }

    @GetMapping("/myBooks")
    public String getMyBooks(Model model){
        List<MyBookList> list = myBookListService.getAllMyBooks();
        model.addAttribute("book",list);
        return "myBooks";
    }

    @RequestMapping("/mylist/{id}")
    public String myList(@PathVariable int id){
        Book b = bookService.getBookById(id);
        MyBookList l = new MyBookList(b.getId(), b.getName(), b.getAuthor(), b.getPrice());
        myBookListService.saveMyBooks(l);

        return "redirect:/myBooks";
    }

    @RequestMapping("/bookEdit/{id}")
    public String editBook(@PathVariable int id, Model model){
        Book b = bookService.getBookById(id);
        model.addAttribute("book", b);
        return "bookEdit";
    }

    @RequestMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable int id){
        bookService.deleteById(id);
        return "redirect:/available_books";
    }



}
