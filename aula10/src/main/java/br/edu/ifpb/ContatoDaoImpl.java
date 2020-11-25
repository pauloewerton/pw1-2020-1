package br.edu.ifpb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContatoDaoImpl implements ContatoDao {

    private Connection connection;

    public ContatoDaoImpl() {
        this.connection = new ConnectionFactory().getConnection();
    }
    
    @Override
    public List<Contato> findAll() {
        String sql = "select * from contatos";
        List<Contato> contatos = new ArrayList<>();

        try {
            PreparedStatement stm = this.connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();

            while(rs.next()) {
                contatos.add(new Contato(rs.getLong("id"), rs.getString("nome"),
                 rs.getString("telefone")));
            }

            rs.close();
            stm.close();
        } catch (SQLException e) {
            throw new RuntimeException();
        } 

        return contatos;
    }
    
    @Override
    public Contato findById(Long id) {
        String sql = "select * from contatos where id=?";
        Contato contato = null;

        try {
            PreparedStatement stm = this.connection.prepareStatement(sql);
            stm.setLong(1, id);

            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                contato = new Contato(rs.getLong("id"), rs.getString("nome"), rs.getString("telefone"));
            }

            rs.close();
            stm.close();
        } catch (SQLException e) {
            throw new RuntimeException();
        } 

        return contato;
    }

    @Override
    public void save(Contato contato) {
        String sql = "insert into contatos (nome, telefone) values (?,?)";

        try {
            PreparedStatement stm = this.connection.prepareStatement(sql);
            stm.setString(1, contato.getNome());
            stm.setString(2, contato.getTelefone());
            stm.execute();

            System.out.println("Contato salvo.");
            stm.close();
        } catch (SQLException e) {
            throw new RuntimeException();
        } 
    }

    @Override
    public void update(Contato contato) {
        String sql = "update contatos set nome=?, telefone=? where id=?";

        try {
            PreparedStatement stm = this.connection.prepareStatement(sql);
            stm.setString(1, contato.getNome());
            stm.setString(2, contato.getTelefone());
            stm.setLong(3, contato.getId());
            stm.execute();

            System.out.println("Contato atualizado.");
            stm.close();
        } catch (SQLException e) {
            throw new RuntimeException();
        } 
    }

    @Override
    public void delete(Contato contato) {
        String sql = "delete from contatos where id=?";

        try {
            PreparedStatement stm = this.connection.prepareStatement(sql);
            stm.setLong(1, contato.getId());
            stm.execute();

            System.out.println("Contato apagado.");
            stm.close();
        } catch (SQLException e) {
            throw new RuntimeException();
        } 
    }
}
