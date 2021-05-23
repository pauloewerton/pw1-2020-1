package br.edu.ifpb;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/SelectIntensity")
public class SelectIntensity extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws IOException, ServletException {
           this.doGet(request, response); 
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws IOException, ServletException {
            String intensity = request.getParameter("intensity");
            HttpSession session = request.getSession();
            session.setAttribute("intensity", intensity);

            response.setContentType("text/html");
            Stream<String> lines;
            String selectColorForm = "";

            try {
                lines = Files.lines(Paths.get(ClassLoader.getSystemResource("/coffeewiz/color-form.html").toURI()));
                selectColorForm = lines.collect(Collectors.joining("\n"));
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }

            PrintWriter out = response.getWriter();
            out.println(selectColorForm);
    }
}