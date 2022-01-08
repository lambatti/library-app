package com.software.architecture.libraryapp.service;

import com.software.architecture.libraryapp.model.Book;
import com.software.architecture.libraryapp.model.dto.BookDto;
import com.software.architecture.libraryapp.repository.BookRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookService {
    private final BookRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    private BookDto convertEntityToDto(Book book) {
        return modelMapper.map(book, BookDto.class);
    }

    public List<BookDto> getListBookDto(List<Book> bookList) {
        return bookList
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    public Optional<BookDto> findById(Integer id) {
        Optional<Book> bookModel = repository.findById(id);
        return bookModel.map(this::convertEntityToDto);
    }

    public List<BookDto> readAll() {
        return getListBookDto(repository.findAll());
    }

    public List<BookDto> readAvailableBooks(boolean available) {
        return getListBookDto(repository.findByIsAvailable(available));
    }

    public List<BookDto> readFilteredBooks(
            String inputTitle, String inputAuthor, String inputGenre) {
        return getListBookDto(repository.findAllByFilters(inputTitle, inputAuthor, inputGenre));
    }

}
