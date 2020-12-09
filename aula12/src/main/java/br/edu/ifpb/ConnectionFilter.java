package br.edu.ifpb;

import br.edu.ifpb.dao.ConnectionFactory;

import javax.servlet.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionFilter implements Filter {
    private FilterConfig config;
    private ServletContext context;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.config = filterConfig;
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
