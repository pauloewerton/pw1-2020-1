package br.edu.ifpb;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CadastrarContato")
public class ContatoController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ContatoBean contato = new ContatoBean();
        contato.setNome(req.getParameter("nome"));
        contato.setEndereco(req.getParameter("endereco"));

        Map<String, String> mapBean = new HashMap<>();
        mapBean.put("mapNome", "maria da silva");
        mapBean.put("mapEndereco", "rua tal");

        List<ContatoBean> contatoList = new ArrayList<>();
        contatoList.add(contato);
        contatoList.add(new ContatoBean("jose ferreira", "rua fulano"));

        req.setAttribute("contato", contato); 
        req.setAttribute("contatoMap", mapBean);
        req.setAttribute("contatoList", contatoList);

        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/contato-view.jsp");
        dispatcher.forward(req, resp);
    }
    
}
