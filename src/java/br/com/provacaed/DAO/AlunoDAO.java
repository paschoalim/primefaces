/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.provacaed.DAO;

import br.com.provacaed.Util.HibernateUtil;
import br.com.provacaed.entity.Aluno;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author crist
 */

public class AlunoDAO {
       public void salvar(Aluno aluno){
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        sessao.beginTransaction();
        
        sessao.persist(aluno);
        
        sessao.getTransaction().commit();
        sessao.close();
    }
    public List<Aluno> listar(){
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        List<Aluno> lista = sessao.getNamedQuery("Aluno.findAll").list();
        sessao.close();
        return lista;
    }
     public void alterar(Aluno aluno){
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        sessao.beginTransaction();
        
        sessao.merge(aluno);
        sessao.getTransaction().commit();
        sessao.close();
    } 
        public void deletar(Integer id){
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        sessao.beginTransaction();
       
        sessao.delete(sessao.get(Aluno.class, id));
        
        sessao.getTransaction().commit();
        sessao.close();
    } 
}
