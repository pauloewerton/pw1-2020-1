package br.edu.ifpb;

import java.sql.Connection;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception {
        ContatoDaoImpl dao = new ContatoDaoImpl();
        Contato contato = dao.findById(new Long(6));
        //System.out.println(contato);
        //Contato novoContato = new Contato("Joao", "445544878");
        //dao.save(novoContato);
        List<Contato> contatos = dao.findAll();
        System.out.println(contatos);
        contato.setNome("Joao Silva");
        dao.update(contato);
        System.out.println(dao.findById(new Long(7)));
        dao.delete(contato);
        System.out.println(dao.findAll());
    }
}
