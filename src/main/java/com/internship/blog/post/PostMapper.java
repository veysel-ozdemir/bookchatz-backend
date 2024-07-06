package com.internship.blog.post;

import com.internship.blog.book.Book;
import com.internship.blog.book.BookService;
import com.internship.blog.user.User;
import com.internship.blog.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PostMapper {

    private final UserService userService;
    private final BookService bookService;

    public Post toPost(PostDto postDto) {
        // create the post
        Post post = new Post();

        // configure the user
        User user = userService.getUserById(postDto.userId());
        user.getPosts().add(post);

        // configure the book
        Book book = bookService.getBookByTitleAndAuthorName(
                postDto.bookTitle(),
                postDto.authorName()
        );
        if(book == null) {
            book = new Book();
            book.setTitle(postDto.bookTitle());
            book.setAuthorName(postDto.authorName());
            book.setBookType(postDto.bookType());
            book.setPhotoUrl(postDto.bookPhotoUrl());
        }
        book.getPosts().add(post);

        // set the fields of post
        post.setReview(postDto.bookReview());
        post.setUser(user);
        post.setBook(book);

        return post;
    }
}
