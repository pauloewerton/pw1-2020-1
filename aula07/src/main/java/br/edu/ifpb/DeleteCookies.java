package br.edu.ifpb;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.servlet.annotation.WebServlet;
 
@WebServlet("/DeleteCookies")
public class DeleteCookies extends HttpServlet {
 
   public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
      Cookie[] cookies = request.getCookies();
      response.setContentType("text/html");
 
      PrintWriter out = response.getWriter();
      String title = "Remocao de Cookies";
      String docType = "<!doctype html>\n";
         
      out.println(docType +
         "<html>\n" +
         "<head><title>" + title + "</title></head>\n" +
         "<body>\n");
         
      if( cookies != null ) {
         out.println("<h2>Lista de cookies</h2>");

         for (Cookie cookie : cookies) {
            if((cookie.getName()).equals("first_name")) {
               cookie.setMaxAge(0);
               response.addCookie(cookie);
               out.print("Cookie removido : " + cookie.getName() + "<br/>");
            }
            out.print("Nome : " + cookie.getName() + ",  ");
            out.print("Valor: " + cookie.getValue()+ " <br>");
         }
      } else {
         out.println("<h2>Nenhum cookie encontrado</h2>");
      }

      out.println("</body></html>");
   }
}