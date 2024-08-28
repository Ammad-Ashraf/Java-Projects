package src.main.java.servelets;

import java.io.*;
import java.util.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Bookservlet extends HttpServlet
{


	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        
        response.setContentType("text/html");
        
        PrintWriter out = response.getWriter();

        List<Book> books = new ArrayList<>();
        books.add(new Book("Zain", "AliKhan", "drama", 10.99));
        books.add(new Book("Ammad", "Ashraf", "action", 7.99));

        
        out.println("<html><body>");
        if(books.isEmpty())
        {
        	out.println("<h3>No book available</h3>");
        	
        }else
        {
        	out.println("<h1>List of Books</h1>");
            out.println("<ul>");
            for (Book book : books) {
                out.println("<li>" + book.getTitle() + " by " + book.getAuthor() + " (" + book.getGenre() + ") - $" + book.getPrice() + "</li>");
            }
            out.println("</ul>");
            
        }
        out.println("</body></html>");
        out.close();
    }

    
}

