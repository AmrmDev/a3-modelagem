package dao;

import database.DataBaseConnection;
import model.Produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ProdutoDAO {

    private final Connection conexao;

    public ProdutoDAO(Connection conexao) {
        this.conexao = conexao;
    }

        public void inserirProdutos(Produto produto) {
            String sql = "INSERT INTO produto (nome, valor, marca, categoria, vencimento) VALUES (?, ?, ?, ?, ?)";

            try (PreparedStatement ps = conexao.prepareStatement(sql)) {
                ps.setString(1, produto.getNome());
                ps.setBigDecimal(2, produto.getValor);
                ps.setString(3, produto.getMarca());
                ps.setInt(4, produto.getCategoria());
                ps.setDate(5, getVencimento());
            } catch (SQLException e) {
                System.err.println("Erro ao inserir produto: " + e.getMessage());
            }
        }

        public void atualizarProdutos(Produto produto){
            String sql = "UPDATE produto SET nome = ?, valor = ?, marca = ?, categoria = ?, vencimento = ?, WHERE = ?";

            try (PreparedStatement ps = conexao.prepareStatement(sql)) {
                ps.setString(1, produto.getNome());
                ps.setBigDecimal(2, produto.getValor());
                ps.setString(3, produto.getMarca());
                ps.setInt(4, produto.getCategoria());
                ps.setDate(5, produto.getVencimento());
                ps.setInt(6, produto.getCategoria());
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        public void deletarProduto(Produto produto){
            String sql = "DELETE FROM produto WHERE Categoria = ?";
            try (PreparedStatement ps = conexao.prepareStatement(sql)){
                ps.setInt(1, getCategoria());
                ps.execute();
                ps.close();
            } catch (SQLException e){
                throw new RuntimeException();
            }
        }

        public List<Produto> listaProduto(){
            List<Produto> listaProduto = new ArrayList();
            String sql = "SELECT * FROM Produto";
                try (PreparedStatement ps = conexao.prepareStatement(sql)){
                    ResultSet rs = ps.executeQuery();
                    while(rs.next()){
                        Produto produto = new Produto();

                        produto.setCategoria(rs.getCategoria("Categoria"));
                        produto.setNome(rs.getNome("Nome"));
                        produto.setValor(rs.getValor("Valor"));
                        produto.setMarca(rs.getMarca("Marca"));
                        produto.setCategoria(rs.getCategoria("Vencimento"));
                    }
                    return listaProduto();
                } catch(SQLException e) {
                    throw new RuntimeException(e);
                }
        }



}
