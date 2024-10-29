package com.booksStore.bookStore;



import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.booksStore.bookStore.models.Author;
import com.booksStore.bookStore.models.Book;
import com.booksStore.bookStore.models.Category;
import com.booksStore.bookStore.models.Publisher;
import com.booksStore.bookStore.service.BookService;

@SpringBootApplication
public class BookStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookStoreApplication.class, args);
	}

	@Bean 
	public CommandLineRunner initialCreate(BookService bookService)
	{
		return(args)->{
			Book book1=new Book("13: 9780747591054","Harry Potter and the Deathly Hallows","https://drive.google.com/file/d/1yQw_poYiSRBezRMKGzzjVskq5wpCYcWa/view?usp=sharing","Harry Potter and the Deathly Hallows follows Harry, Ron, and Hermione as they embark on a perilous journey to defeat Lord Voldemort by destroying his Horcruxes. Facing danger at every turn, they uncover powerful secrets about the Deathly Hallows, ancient magical objects that could change the outcome of the wizarding war. This final installment is a story of courage, sacrifice, and the power of friendship, bringing the Harry Potter series to an epic and emotional conclusion.");
			Author author1=new Author("JK Rowling","J.K. Rowling, British author of the Harry Potter series, redefined young adult fantasy with themes of courage, friendship, and resilience. Her books have captivated millions, leading her to become one of the most influential authors worldwide.");
			Category category1=new Category("Fanatsy");
			Publisher publisher1=new Publisher("Bloomsbury Publishing");
			book1.addAuthor(author1);
			book1.addCategory(category1);
			book1.addPublisher(publisher1);
			bookService.saveBook(book1);

			/*Book book2=new Book("ISBN2","Fantastic beast","Book for Aurors");
			Author author2=new Author("KJ Rowling","Best author for magical books");
			Category category2=new Category("Magical Realism");
			Publisher publisher2=new Publisher("Fox Publisher");
			book2.addAuthor(author2);
			book2.addCategory(category2);
			book2.addPublisher(publisher2);
			bookService.saveBook(book2);*/
		};
	}
}


