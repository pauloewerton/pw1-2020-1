package br.edu.ifpb.command;

import br.edu.ifpb.dao.Contato;
import br.edu.ifpb.dao.ContatoDaoImpl;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.RequestAware;

import java.sql.Connection;
import java.util.Map;

public class SearchCommand extends ActionSupport implements RequestAware {
    private Map<String, Object> attributes;
    private Contato contato;
    private Long id;

    @Override
    public String execute() {
        Connection connection = (Connection) this.attributes.get("connection");
        this.contato = new ContatoDaoImpl(connection).findById(this.id);

        return SUCCESS;
    }

    @Override
    public void validate() {
        if (this.id == null) {
            this.addFieldError("id", "O ID é obrigatório.");
        }
    }

    @Override
    public void setRequest(Map<String, Object> attributes) {
        this.attributes = attributes;
    }

    public Contato getContato() {
        return contato;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
