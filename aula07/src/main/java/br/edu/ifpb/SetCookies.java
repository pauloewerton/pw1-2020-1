package br.edu.ifpb;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.servlet.annotation.WebServlet;
 
@WebServlet("/SetCookies")
public class SetCookies extends HttpServlet {
 
   public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
      Cookie firstName = new Cookie("first_name", request.getParameter("first_name"));
      Cookie lastName = new Cookie("last_name", request.getParameter("last_name"));

      firstName.setMaxAge(60*60*24);
      lastName.setMaxAge(60*60*24);

      response.addCookie(firstName);
      response.addCookie(lastName);

      response.setContentType("text/html");

      PrintWriter out = response.getWriter();
      String title = "Configurando Cookies";
      String docType = "<!doctype html>\n";

      out.println(docType +
         "<html>\n" + "<head> <title>" + title + "</title> </head>\n" +
            
            "<body>\n" +
               "<h1 align = \"center\">" + title + "</h1>\n" +
               "<ul>\n" +
                  "  <li><b>Nome</b>: "
                  + request.getParameter("first_name") + "\n" +
                  "  <li><b>Sobrenome</b>: "
                  + request.getParameter("last_name") + "\n" +
               "</ul>\n" + "</body> </html>"
      );
   }
}