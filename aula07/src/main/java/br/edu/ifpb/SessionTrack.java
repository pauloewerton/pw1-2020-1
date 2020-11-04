package br.edu.ifpb;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.servlet.annotation.WebServlet;
 
@WebServlet("/SessionTrack")
public class SessionTrack extends HttpServlet {
 
   public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
         
      HttpSession session = request.getSession();
         
      Date createTime = new Date(session.getCreationTime());
         
      Date lastAccessTime = new Date(session.getLastAccessedTime());

      // use para invalidar um sessão
      // session.invalidate();
      // use para configurar um tempo de expiração automático (em segundos)
      session.setMaxInactiveInterval(60*60);

      String title = "Bem-vindo/a de volta ao meu site!";
      Integer visitCount = new Integer(0);
      String visitCountKey = new String("visitCount");
      String userIDKey = new String("userID");
      String userID = new String("ABCD");

      if (session.isNew()) {
         title = "Bem-vindo/a ao meu site!";
         session.setAttribute(userIDKey, userID);
      } else {
         visitCount = (Integer) session.getAttribute(visitCountKey);
         visitCount = visitCount + 1;
         userID = (String) session.getAttribute(userIDKey);
      }

      session.setAttribute(visitCountKey,  visitCount);

      response.setContentType("text/html");
      PrintWriter out = response.getWriter();

      String docType =
         "<!doctype html>\n";

      out.println(docType +
         "<html>\n" +
            "<head><title>" + title + "</title></head>\n" +
            
            "<body>\n" +
               "<h1 align = \"center\">" + title + "</h1>\n" +
               "<h2 align = \"center\">Rastreamento da Sessao</h2>\n" +
               "<table border = \"1\" align = \"center\">\n" +
                  
                  "<tr bgcolor = \"#949494\">\n" +
                     "  <th>Dados de sessao</th><th>value</th></tr>\n" +
                     
                  "<tr>\n" +
                     "  <td>ID (JSESSIONID cookie)</td>\n" +
                     "  <td>" + session.getId() + "</td></tr>\n" +
                  
                  "<tr>\n" +
                     "  <td>Data de criacao</td>\n" +
                     "  <td>" + createTime + "  </td> </tr>\n" +
                  
                  "<tr>\n" +
                     "  <td>Data do ultimo acesso</td>\n" +
                     "  <td>" + lastAccessTime + "  </td> </tr>\n" +
                  
                  "<tr>\n" +
                     "  <td>ID do usuario</td>\n" +
                     "  <td>" + userID + "  </td> </tr>\n" +
                  
                  "<tr>\n" +
                     "  <td>Numero de visitas</td>\n" +
                     "  <td>" + visitCount + "</td> </tr>\n" +
               "</table>\n" + "</body> </html>"
      );
   }
}