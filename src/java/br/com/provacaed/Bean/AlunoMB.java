/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.provacaed.Bean;

import br.com.provacaed.relatorio.RelatorioAluno;
import br.com.provacaed.DAO.AlunoDAO;
import br.com.provacaed.entity.Aluno;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;


/**
 *
 * @author crist
 */

@ManagedBean(name = "alunoMB")
@ViewScoped
public class AlunoMB {
      
    private Aluno aluno;
    private List<Aluno> lista = new ArrayList<Aluno>();
    AlunoDAO dao;
    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public List<Aluno> getLista() {
        return lista;
    }

    public void setLista(List<Aluno> lista) {
        this.lista = lista;
    }
    public void limpar(){
        aluno = new Aluno();
    }
    public void salvar(){
        dao = new AlunoDAO();
        if (aluno.getId() == null){
            dao.salvar(aluno);
        }else{
            dao.alterar(aluno);
        }

        inicializar();
    }
    public void deletar(Aluno item){
        dao = new AlunoDAO();
        dao.deletar(item.getId());
        inicializar();
    }
    public void carregarAluno(Aluno item){
        aluno = item;
    }
    public void gerarRelatorio(){
        RelatorioAluno relatorio = new RelatorioAluno();

        relatorio.getRelatorio(lista);
    }   
    @PostConstruct
    public void inicializar(){
        AlunoDAO dao = new AlunoDAO();
        lista = dao.listar();
        limpar();
    }
}
