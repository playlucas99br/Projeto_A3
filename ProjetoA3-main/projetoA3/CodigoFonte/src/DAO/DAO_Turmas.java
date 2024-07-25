package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Conexao.ConexaoBD;
import EduPack.Turmas;

public class DAO_Turmas {

    public void cadastrarTurmas(Turmas turmas) {
        String sql = "INSERT INTO TURMAS (SEMESTRE, ANO, CURSO, PROFESSOR, SALA, HORA) VALUES (?, ?, ?, ?, ?, ?)";
    
        PreparedStatement ps = null;
        ResultSet generatedKeys = null;
    
        try {
            ps = ConexaoBD.getConexao().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setLong(1, turmas.getSemestre());
            ps.setLong(2, turmas.getAno());
            ps.setLong(3, turmas.getCurso());
            ps.setLong(4, turmas.getProfessor());
            ps.setLong(5, turmas.getSala());
            ps.setString(6, turmas.getHora());
    
            ps.execute();
    
            // Obter as chaves geradas
            generatedKeys = ps.getGeneratedKeys();
            if (generatedKeys.next()) {
                int turmaId = generatedKeys.getInt(1);
    
                // Percorrer a lista de IDs dos alunos associados à turma
                for (Integer alunoId : turmas.getAlunos()) {
                    String sqlInsertTurmaAluno = "INSERT INTO MATRICULA (TURMA, ALUNOS) VALUES (?, ?)";
                    PreparedStatement psTurmaAluno = ConexaoBD.getConexao().prepareStatement(sqlInsertTurmaAluno);
                    psTurmaAluno.setInt(1, turmaId);
                    psTurmaAluno.setInt(2, alunoId);

                    psTurmaAluno.execute();
                    psTurmaAluno.close();
                }
            }
    
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Fechar os recursos (PreparedStatement e ResultSet)
            try {
                if (generatedKeys != null) {
                    generatedKeys.close();
                }
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public List<Turmas> listar() {
        List<Turmas> listaTurmas = new ArrayList<Turmas>();
        try {
            Connection connection = ConexaoBD.getConexao();
    
            String sql = "SELECT t.ID, t.SEMESTRE, t.ANO, t.CURSO, t.PROFESSOR, t.SALA, t.HORA, GROUP_CONCAT(m.ALUNOS SEPARATOR ', ') AS ALUNOS " +
                         "FROM TURMAS t " +
                         "LEFT JOIN MATRICULA m ON t.ID = m.TURMA " +
                         "GROUP BY t.ID";
    
            PreparedStatement statement = connection.prepareStatement(sql);
    
            ResultSet rs = statement.executeQuery();
    
            while (rs.next()) {
                Turmas turmas = new Turmas(0, 0, 0, 0, 0, 0, sql, null, sql); 
                turmas.setId(rs.getInt("ID"));
                turmas.setSemestre(rs.getInt("SEMESTRE"));
                turmas.setAno(rs.getInt("ANO"));
                turmas.setCurso(rs.getInt("CURSO"));
                turmas.setProfessor(rs.getInt("PROFESSOR"));
                turmas.setSala(rs.getInt("SALA"));
                turmas.setListaAlunos(rs.getString("ALUNOS"));
                turmas.setHora(rs.getString("HORA"));
    
                listaTurmas.add(turmas);
            }
    
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return listaTurmas;
    }

    public void atualizar(Turmas turmas) {
        try {
            Connection conn = ConexaoBD.getConexao();
    
            // Remover todas as associações de alunos existentes para esta turma
            String sqlDeleteMatricula = "DELETE FROM MATRICULA WHERE TURMA = ?";
            PreparedStatement psDeleteMatricula = conn.prepareStatement(sqlDeleteMatricula);
            psDeleteMatricula.setInt(1, turmas.getId());
            psDeleteMatricula.execute();
            psDeleteMatricula.close();
    
            // Atualizar os dados da turma
            String sqlUpdateTurmas = "UPDATE TURMAS SET SEMESTRE = ?, ANO = ?, CURSO = ?, PROFESSOR = ?, SALA = ?, HORA = ? WHERE ID = ?";
            PreparedStatement psUpdateTurmas = conn.prepareStatement(sqlUpdateTurmas);
            psUpdateTurmas.setInt(1, turmas.getSemestre());
            psUpdateTurmas.setInt(2, turmas.getAno());
            psUpdateTurmas.setInt(3, turmas.getCurso());
            psUpdateTurmas.setInt(4, turmas.getProfessor());
            psUpdateTurmas.setInt(5, turmas.getSala());
            psUpdateTurmas.setString(6, turmas.getHora());
            psUpdateTurmas.setInt(7, turmas.getId());
            psUpdateTurmas.execute();
            psUpdateTurmas.close();
    
            // Inserir as novas associações de alunos para esta turma
            for (Integer alunoId : turmas.getAlunos()) {
                String sqlInsertMatricula = "INSERT INTO MATRICULA (TURMA, ALUNOS) VALUES (?, ?)";
                PreparedStatement psInsertMatricula = conn.prepareStatement(sqlInsertMatricula);
                psInsertMatricula.setInt(1, turmas.getId());
                psInsertMatricula.setInt(2, alunoId);
                psInsertMatricula.execute();
                psInsertMatricula.close();
            }
    
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void remover(int ID) {
        try {
            Connection conn = ConexaoBD.getConexao();

             // Excluir registros na tabela "matricula" relacionados ao aluno
             String sqlDeleteMatricula = "DELETE FROM MATRICULA WHERE TURMA = ?";
             PreparedStatement psDeleteMatricula = conn.prepareStatement(sqlDeleteMatricula);
             psDeleteMatricula.setInt(1, ID);
 
             psDeleteMatricula.execute();
             psDeleteMatricula.close();

            String sql = "DELETE FROM TURMAS WHERE ID = ?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, ID);

            ps.execute();
            ps.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean verificarSala(int sala, String hora) {
        try {
            Connection conn = ConexaoBD.getConexao();

            String sql = "SELECT * FROM TURMAS WHERE SALA = ? AND HORA = ?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, sala);
            ps.setString(2, hora);

            ResultSet rs = ps.executeQuery();

            return !rs.next(); // Retorna true se não houver resultado, ou seja, a sala está disponível

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean verificarProf(int professor, String hora) {
        try {
            Connection conn = ConexaoBD.getConexao();

            String sql = "SELECT * FROM TURMAS WHERE SALA = ? AND HORA = ?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, professor);
            ps.setString(2, hora);

            ResultSet rs = ps.executeQuery();

            return !rs.next(); // Retorna true se não houver resultado, ou seja, a sala está disponível

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

}