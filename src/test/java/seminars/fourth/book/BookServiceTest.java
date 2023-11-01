package seminars.fourth.book;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

class BookServiceTest {
    @Test
    void findByIdTest() {
        Book someBook = new Book("1", "title", "author");
        BookRepository bookRepository = mock(BookRepository.class);
        BookService bookService = new BookService(bookRepository);
        when(bookRepository.findById(anyString())).thenReturn(someBook);
        Book result = bookService.findBookById("1");

        verify(bookRepository, times(1)).findById("1");
        assertThat(result).isEqualTo(someBook);
    }

    @Test
    void findAllBooksTest() {
        List<Book> books = new ArrayList<>();
        books.add(new Book("1", "Book1", "Author1"));
        books.add(new Book("2", "Book2", "Author2"));

        BookRepository bookRepository = mock(BookRepository.class);
        BookService bookService = new BookService(bookRepository);
        when(bookRepository.findAll()).thenReturn(books);
        List<Book> result = bookService.findAllBooks();

        verify(bookRepository, times(1)).findAll();
        assertThat(result).isEqualTo(books);
    }

}