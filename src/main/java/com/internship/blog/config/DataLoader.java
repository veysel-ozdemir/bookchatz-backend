package com.internship.blog.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.internship.blog.service.BookService;
import com.internship.blog.service.JsonFileService;
import com.internship.blog.service.PostService;
import com.internship.blog.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class DataLoader implements CommandLineRunner {

    private final BookService bookService;
    private final UserService userService;
    private final PostService postService;

    @Override
    public void run(String... args) throws Exception {
        // create 2 users
        String userJsonList = """
                     [
                        { "fullname": "Sevgi Nur Kara", "password": "12345", "email": "sevgi-nur-kara@internship.com", "photoUrl": "https://t3.ftcdn.net/jpg/02/81/81/42/240_F_281814220_xSqihBCVEluoKEjWLH8iq9sYPs1A3ojr.jpg" },
                        { "fullname": "Veysel Özdemir", "password": "667788", "email": "veysel-ozdemir@internship.com", "photoUrl": "https://t3.ftcdn.net/jpg/02/95/46/68/240_F_295466808_npU0rjNVfQ6X3DFnVijP4YCs78gft1jX.jpg" }
                     ]
                """;

        // create 3 posts
        String postJsonList = """
                     [
                        {
                           "bookTitle": "The Life Of Prophet Muhammed(s.a.v)",
                           "bookReview": "Acclaimed worldwide as the definitive biography of the Prophet in the English language. Martin Lings life of Muhammad is unlike any other. Based on Arabic sources of the eighth and ninth centuries, of which some important passages are translated here for the first time, it owes the freshness and directness of its approach to the words of men and women who heard Muhammad speak and witnessed the events of his life. Martin Lings has an unusual gift for narrative. He has adopted a style which is at once extremely readable and reflects both the simplicity and grandeur of the story. The result is a book which will be read with equal enjoyment by those already familiar with Muhammad s life and those coming to it for the first time. This book was given an award by the government of Pakistan, and selected as the best biography of the Prophet in English at the National Seerat Conference in Islamabad in 1983. In 1990, after the book had attracted the attention of Azhar University, the author received a decoration from president Mubarak.Martin Lings, formerly Keeper of Oriental Manuscript in the British Museum and the British Library, is the author of three works on Islamic mysticism, A Sufi Saint of the Twentieth Century, What is Sufism? and The Book of Certainty, all published by The Islamic Texts Society.",
                           "bookType": "RELIGION",
                           "authorName": "Martin LINGS",
                           "bookPhotoUrl": "https://m.media-amazon.com/images/I/71YY6rsN-rL._AC_UY218_.jpg",
                           "userId": 1
                        },
                        {
                           "bookTitle": "The Surgeon",
                           "bookReview": "He slips into homes at night and walks silently into bedrooms where women lie sleeping, about to awaken to a living nightmare. The precision of his methods suggests that he is a deranged man of medicine, prompting the Boston newspapers to dub him “The Surgeon.” Led by Detectives Thomas Moore and Jane Rizzoli, the cops must consult the victim of a nearly identical crime: Two years ago, Dr. Catherine Cordell fought back and filled an attacker before he could complete his assault. Now this new killer is re-creating, with chilling accuracy, the details of Cordell’s ordeal. With every new murder he seems to be taunting her, cutting ever closer, from her hospital to her home. And neither Moore nor Rizzoli can protect Cordell from a ruthless hunter who somehow understands—and savors—the secret fears of every woman he kills.",
                           "bookType": "THRILLER",
                           "authorName": "Tess GERRITSEN",
                           "bookPhotoUrl": "https://m.media-amazon.com/images/I/81X2W7kBNjL._SX342_.jpg",
                           "userId": 2
                        },
                        {
                           "bookTitle": "The Bloodstream",
                           "bookReview": "Tess Gerritsen again weaves frighteningly realistic medical detail into heart-stopping suspense, as a small-town doctor races to unravel the roots of a violent epidemic - before it destroys everything she loves. Lapped by the gentle waters of Locust Lake, the small resort town of Tranquility, Maine, seems like the perfect spot for Dr. Claire Elliot to shelter her adolescent son, Noah, from the distractions of the big city, and the lingering memory of his father's death. She's also hopeful that she can earn the trust of the town as she builds a new practice. But all her plans unravel with the news of a shocking incident: a teenage boy under her care has committed an appalling act of violence. Claire has stopped prescribing a controversial drug to the troubled boy, a decision that some in town now second-guess. But before she can defend herself, a rash of new teenage violence erupts in Tranquility, forcing Claire to perform increasingly risky emergency procedures. And when one of her patients dies, the town's panic turns to fury. Shaken by accusations, and fearful that Noah is now at risk, Claire desperately searches for a medical cause behind the murderous epidemic. She begins to suspect that the placid waters of Locust lake conceal a disturbing history - and an insidiously lethal danger. But while Claire races to save the town - and her son - from harm, she discovers an even greater threat: a shocking conspiracy to manipulate nature, and turn innocents to slaughter.",
                           "bookType": "HORROR",
                           "authorName": "Tess GERRITSEN",
                           "bookPhotoUrl": "https://m.media-amazon.com/images/I/81IoUHDbGOL._AC_UY218_.jpg",
                           "userId": 1
                        }
                     ]
                """;

        // create 10 books
        String bookJsonList = """
                     [
                        { "title": "To Kill a Mockingbird", "authorName": "Harper Lee", "bookType": "HISTORY", "photoUrl": "https://m.media-amazon.com/images/I/51g3u0pKK4L._SY445_SX342_.jpg" },
                        { "title": "1984", "authorName": "George Orwell", "bookType": "ADVENTURE", "photoUrl": "https://avatars.dzeninfra.ru/get-zen_doc/1706621/pub_61a0e1c2e90f1c2241dbfefb_61a0ef8835cb395eb604a57e/scale_1200" },
                        { "title": "Pride and Prejudice", "authorName": "Jane Austen", "bookType": "ROMANCE", "photoUrl": "https://m.media-amazon.com/images/I/81NLDvyAHrL._AC_UY218_.jpg" },
                        { "title": "The Great Gatsby", "authorName": "F. Scott Fitzgerald", "bookType": "CLASSIC", "photoUrl": "https://m.media-amazon.com/images/I/91pySFftptL._AC_UY218_.jpg" },
                        { "title": "One Hundred Years of Solitude", "authorName": "Gabriel García Márquez", "bookType": "HISTORY", "photoUrl": "https://m.media-amazon.com/images/I/714ZLzX852L._AC_UY218_.jpg" },
                        { "title": "The Catcher in the Rye", "authorName": "J.D. Salinger", "bookType": "CLASSIC", "photoUrl": "https://m.media-amazon.com/images/I/71c-1s150eL._AC_UY218_.jpg" },
                        { "title": "The Hobbit", "authorName": "J.R.R. Tolkien", "bookType": "ADVENTURE", "photoUrl": "https://m.media-amazon.com/images/I/51HJMYGOdBL._SY445_SX342_.jpg" },
                        { "title": "The Hunger Games", "authorName": "Suzanne Collins", "bookType": "ADVENTURE", "photoUrl": "https://m.media-amazon.com/images/I/81gExM+-XtL._AC_UY218_.jpg" },
                        { "title": "The Da Vinci Code", "authorName": "Dan Brown", "bookType": "THRILLER", "photoUrl": "https://m.media-amazon.com/images/I/81gPg90cAML._AC_UY218_.jpg" },
                        { "title": "The Alchemist", "authorName": "Paulo Coelho", "bookType": "CLASSIC", "photoUrl": "https://m.media-amazon.com/images/I/81FPzmB5fgL._AC_UY218_.jpg" }
                    ]
                """;

        JsonFileService jsonFileService = new JsonFileService(new ObjectMapper(), bookService, userService, postService);
        try {
            jsonFileService.processUserJsonList(userJsonList);
            jsonFileService.processPostJsonList(postJsonList);
            jsonFileService.processBookJsonList(bookJsonList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("\n\nInitialized data from DataLoader.\n\n");
    }
}
