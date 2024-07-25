package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Conexao.ConexaoBD;
import EduPack.Salas;

public class DAO_Salas {

    public void cadastrarSalas(Salas salas){

        String sql = "INSERT INTO SALAS (LOCAL, CAPACIDADETOTAL) VALUES(?, ?)";

        PreparedStatement ps = null;
        
            try {
                ps = ConexaoBD.getConexao().prepareStatement(sql);
                ps.setString(1, salas.getLocal());
                ps.setLong(2, salas.getCapacidade());

                ps.execute();
                ps.close();
                
            } catch (SQLException e) {

                e.printStackTrace();
        }

    }
    public List<Salas> listar() {
        List<Salas> listaSala = new ArrayList<Salas>();
        try {
            Connection connection = ConexaoBD.getConexao(); // Obtém a conexão corretamente

            String sql = "SELECT * FROM SALAS";

            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Salas salas = new Salas(0, 0, sql);// Certifique-se de atualizar os argumentos com os tipos corretos
                salas.setID(rs.getInt("ID"));
                salas.setCapacidade(rs.getInt("CapacidadeTotal"));
                salas.setLocal(rs.getString("Local"));
                
                listaSala.add(salas);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return listaSala;
    }

    public void atualizar(Salas salas){
        try {
            Connection conn = ConexaoBD.getConexao(); 
    
            String sql = "UPDATE SALAS SET CAPACIDADETOTAL = ?, LOCAL = ? WHERE ID = ?";
    
            PreparedStatement ps = conn.prepareStatement(sql);
    
            ps.setInt(1, salas.getCapacidade());
            ps.setString(2, salas.getLocal());
            ps.setInt(3, salas.getID());

    
            ps.execute();
            ps.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void remover(int ID) {
        try {
            Connection conn = ConexaoBD.getConexao();

            String sql = "DELETE FROM SALAS WHERE ID = ?";

            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setInt(1, ID);

            statement.execute();
            statement.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}