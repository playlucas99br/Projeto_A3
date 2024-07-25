package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Conexao.ConexaoBD;
import EduPack.Cursos;


public class DAO_Cursos {

    public void cadastrarCursos(Cursos cursos){

        String sql = "INSERT INTO CURSOS (NOME, CARGAHORARIA, DESCRICAOSOBRE) VALUES(?, ?, ?)";

        PreparedStatement ps = null;
        
            try {
                ps = ConexaoBD.getConexao().prepareStatement(sql);
                ps.setString(1, cursos.getNome());
                ps.setLong(2, cursos.getCargaHoraria());
                ps.setString(3, cursos.getDescriçãoSobre());

                ps.execute();
                ps.close();
                
            } catch (SQLException e) {
                
                e.printStackTrace();
        }

    }
    public List<Cursos> listar() {
        List<Cursos> listaCursos = new ArrayList<Cursos>();
        try {
            Connection connection = ConexaoBD.getConexao(); // Obtém a conexão corretamente

            String sql = "SELECT * FROM CURSOS";

            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Cursos cursos = new Cursos(0, sql, 0, sql); // Certifique-se de atualizar os argumentos com os tipos corretos
                cursos.setId(rs.getInt("ID"));
                cursos.setNome(rs.getString("Nome"));
                cursos.setCargaHoraria(rs.getInt("CargaHoraria"));
                cursos.setDescriçãoSobre(rs.getString("DescricaoSobre"));


                listaCursos.add(cursos);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return listaCursos;
    }

    public void atualizar(Cursos cursos){
        try {
            Connection conn = ConexaoBD.getConexao(); 
    
            String sql = "UPDATE CURSOS SET NOME = ?, CARGAHORARIA = ?, DESCRICAOSOBRE = ? WHERE ID = ?";
    
            PreparedStatement ps = conn.prepareStatement(sql);
    
            ps.setString(1, cursos.getNome());
            ps.setInt(2, cursos.getCargaHoraria());
            ps.setString(3, cursos.getDescriçãoSobre());
            ps.setInt(4, cursos.getId());

    
            ps.execute();
            ps.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void remover(int cursoId) {
        try {
            Connection conn = ConexaoBD.getConexao();
    
            // Excluir registros na tabela "aluno" relacionados ao curso
            String sqlDeleteAluno = "DELETE FROM aluno WHERE Curso = ?";
            PreparedStatement psDeleteAluno = conn.prepareStatement(sqlDeleteAluno);
            psDeleteAluno.setInt(1, cursoId);
            psDeleteAluno.execute();
            psDeleteAluno.close();
    
            // Excluir o curso da tabela "cursos"
            String sqlDeleteCurso = "DELETE FROM cursos WHERE ID = ?";
            PreparedStatement psDeleteCurso = conn.prepareStatement(sqlDeleteCurso);
            psDeleteCurso.setInt(1, cursoId);
            psDeleteCurso.execute();
            psDeleteCurso.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}