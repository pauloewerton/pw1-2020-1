package br.edu.ifpb;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.servlet.annotation.WebServlet;
 
@WebServlet("/ReadCookies")
public class ReadCookies extends HttpServlet {
 
   public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
      Cookie[] cookies = request.getCookies();

      response.setContentType("text/html");

      PrintWriter out = response.getWriter();
      String title = "Leitura de cookies";
      String docType = "<!doctype html>\n";
         
      out.println(docType +
         "<html>\n" +
         "<head><title>" + title + "</title></head>\n" +
         "<body>\n" );

      if( cookies != null ) {
         out.println("<h2>Cookies encontrados</h2>");

         for (Cookie cookie : cookies) {
            out.print("Nome : " + cookie.getName() + ",  ");
            out.print("Valor: " + cookie.getValue() + " <br/>");
         }
      } else {
         out.println("<h2>Nenhum cookie encontrado</h2>");
      }
      out.println("</body>");
      out.println("</html>");
   }
}