package br.edu.ifpb;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CoffeeSelect extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws IOException, ServletException {
            
            String intensity = request.getParameter("intensity");
            response.sendRedirect("https://duckduckgo.com/?q=" + intensity);
     //       CoffeeExpert expert = new CoffeeExpert();
     //       List<String> result = expert.getBrands(intensity);

     //       request.setAttribute("styles", result);
     //       RequestDispatcher view = request.getRequestDispatcher("result.jsp");
     //       view.forward(request, response);
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws IOException, ServletException {
            
            response.setContentType("application/zip");
            InputStream is = getServletContext().getResourceAsStream("/teste.zip");

            int read = 0;
            byte[] bytes = new byte[1024];
            OutputStream out = response.getOutputStream();

            while ((read = is.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }

            out.flush();
            out.close();
    }
}