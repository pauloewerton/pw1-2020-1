package br.edu.ifpb.command;

import br.edu.ifpb.dao.Contato;
import br.edu.ifpb.dao.ContatoDaoImpl;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.RequestAware;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

public class ListCommand extends ActionSupport implements RequestAware {
    private Map<String, Object> attributes;
    private List<Contato> contatos;

    public String execute() {
        Connection connection = (Connection) this.getAttributes().get("connection");
        this.contatos = new ContatoDaoImpl(connection).findAll();

        return SUCCESS;
    }

    @Override
    public void setRequest(Map<String, Object> attributes) {
        this.attributes = attributes;
    }

    public Map<String, Object> getAttributes() {
        return attributes;
    }

    public List<Contato> getContatos() {
        return contatos;
    }
}
