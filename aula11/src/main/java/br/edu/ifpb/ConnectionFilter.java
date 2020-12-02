package br.edu.ifpb;

import br.edu.ifpb.dao.ConnectionFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

// @WebFilter("/*")
// @WebFilter(filterName = "MeuFiltro", ulrPatterns = {"/oi", "/ola"})
// @WebFilter(filterName = "MeuFiltro", servletNames = {"meuServlet", "outroServlet"})
@WebFilter(urlPatterns = "/*", initParams = {
        @WebInitParam(name = "url", value = "jdbc:postgresql://localhost:5432/agenda"),
        @WebInitParam(name = "username", value = "pauloewerton"),
        @WebInitParam(name = "password", value = "")
})
public class ConnectionFilter implements Filter {
    private FilterConfig config;
    private ServletContext context;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.config = filterConfig;
        this.context = config.getServletContext();
        this.context.log("Servlet name" + context.getServletContextName());
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        String url = this.config.getInitParameter("url");
        String username = this.config.getInitParameter("username");
        String password = this.config.getInitParameter("password");
        Connection connection = new ConnectionFactory().getConnection(url, username, password);

        request.setAttribute("connection", connection);
        chain.doFilter(request, response);

        try {
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void destroy() { }
}
