package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Conexao.ConexaoBD;
import PessoaPack.Professor;

public class DAO_Professor {

    public void cadastrarProfessor(Professor professor){

        String sql = "INSERT INTO PROFESSOR (NOME, SOBRENOME, CPF, FONE, ENDERECO, CEP) VALUES(?, ?, ?, ?, ?, ?)";

        PreparedStatement ps = null;
        
            try {
                ps = ConexaoBD.getConexao().prepareStatement(sql);
                ps.setString(1, professor.getNome());
                ps.setString(2, professor.getSobrenome());
                ps.setString(3, professor.getCPF());
                ps.setString(4, professor.getfone());
                ps.setString(5, professor.getendereço());
                ps.setLong(6, professor.getcep());

                ps.execute();
                ps.close();
                
            } catch (SQLException e) {
                
                e.printStackTrace();
        }

    }
    public List<Professor> listar() {
        List<Professor> listaProfessor = new ArrayList<Professor>();
        try {
            Connection connection = ConexaoBD.getConexao(); // Obtém a conexão corretamente

            String sql = "SELECT * FROM PROFESSOR";

            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Professor professor = new Professor(0, sql, sql, sql, sql, sql, 0); // Certifique-se de atualizar os argumentos com os tipos corretos
                professor.setId(rs.getInt("ID"));
                professor.setNome(rs.getString("Nome"));
                professor.setSobrenome(rs.getString("Sobrenome"));
                professor.setCPF(rs.getString("CPF"));
                professor.setFone(rs.getString("Fone"));
                professor.setEndereço(rs.getString("Endereco"));
                professor.setCep(rs.getInt("CEP"));

                listaProfessor.add(professor);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return listaProfessor;
    }

    public void atualizar(Professor professor){
        try {
            Connection conn = ConexaoBD.getConexao(); 
    
            String sql = "UPDATE PROFESSOR SET NOME = ?, SOBRENOME = ?, FONE = ?, ENDERECO = ?, CPF = ?, CEP = ? WHERE ID = ?";
    
            PreparedStatement ps = conn.prepareStatement(sql);
    
            ps.setString(1, professor.getNome());
            ps.setString(2, professor.getSobrenome());
            ps.setString(3, professor.getfone());
            ps.setString(4, professor.getendereço());
            ps.setString(5, professor.getCPF());
            ps.setInt(6, professor.getcep());
            ps.setInt(7, professor.getId());
    
            ps.execute();
            ps.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void remover(int professorId) {
        try {
            Connection conn = ConexaoBD.getConexao();
    
            // Excluir turmas associadas ao professor
            String sqlDeleteTurmas = "DELETE FROM TURMAS WHERE PROFESSOR = ?";
            PreparedStatement psDeleteTurmas = conn.prepareStatement(sqlDeleteTurmas);

            psDeleteTurmas.setInt(1, professorId);

            psDeleteTurmas.execute();
            psDeleteTurmas.close();
    
            // Excluir o professor da tabela "professor"
            String sqlDeleteProfessor = "DELETE FROM PROFESSOR WHERE ID = ?";
            PreparedStatement psDeleteProfessor = conn.prepareStatement(sqlDeleteProfessor);

            psDeleteProfessor.setInt(1, professorId);
            
            psDeleteProfessor.execute();
            psDeleteProfessor.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}