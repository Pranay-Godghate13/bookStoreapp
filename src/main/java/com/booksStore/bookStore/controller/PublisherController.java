package com.booksStore.bookStore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.booksStore.bookStore.models.Publisher;
import com.booksStore.bookStore.service.PublisherService;
import org.springframework.web.bind.annotation.RequestBody;





@Controller
public class PublisherController {
    
    @Autowired
    PublisherService publisherService;

    @GetMapping("/publishers")
    public String findAllPublishers(Model model) {
        List<Publisher> publishers=publisherService.findAllPublishers();
        model.addAttribute("publishers", publishers);
        return "publishers";
    }

    @GetMapping("/remove-publisher/{id}")
    public String removePublisherById(@PathVariable Long id) {
        publisherService.deletePublisher(id);
        return "redirect:/publishers";
    }

    @GetMapping("/update-publisher/{id}")
    public String updatePublisherById(@PathVariable Long id,Model model) {
        Publisher publisher=publisherService.findPublisherById(id);
        model.addAttribute("publisher", publisher);
        return "update-publisher";
    }

    @PostMapping("/save-update-publisher/{id}")
    public String saveUpdatePublisherById(@PathVariable Long id,Publisher publisher,BindingResult result,Model model)
    {
        if(result.hasErrors())
        {
            return "update-publisher";
        }
        publisherService.updatPublisher(id,publisher);
        return "redirect:/publishers";
        
    }

    @GetMapping("/add-publisher")
    public String addPublisher(Publisher publisher) {
        return "add-publisher";
    }

    @PostMapping("/save-add-publisher")
    public String saveAddPublisher(Publisher publisher,BindingResult result,Model model) {
        if(result.hasErrors())
        {
            return "add-publisher";
        }
        publisherService.savePublisher(publisher);
        return "redirect:/publishers";
    }
    
    
    

    
}
