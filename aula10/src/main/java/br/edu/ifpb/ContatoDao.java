package br.edu.ifpb;

import java.util.List;

public interface ContatoDao {

    public List<Contato> findAll();
    public Contato findById(Long id);
    public void save(Contato contato);
    public void update(Contato contato);
    public void delete(Contato contato);
}
