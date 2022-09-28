/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package control.de.imoveis;

import java.sql.*;
/**
 *
 * @author Aluno
 */
public class ControlDeImoveis {

    private static int inicio;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        Connection connection = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String serverName = "127.0.0.1:3306"; //caminho do servidor do BD
            String mydatabase = "Imoveis"; // nome do seu banco de dados
            String url = "jdbc:mysql://" + serverName + "/" + mydatabase + "?useTimezone=true&serverTimezone=UTC";
            String username = "root"; // nome de um usuario de seu BD
            String password = ""; // sua senha de acesso
            //faz conexao com o banco
            connection = DriverManager.getConnection(url, username, password);

            if (connection != null) {
                System.out.println("STATUS--->Conectado com sucesso!");
            } else {
                System.out.println("STATUS--->Nao foi possivel realizar conexao");
            }
            //INSERT
            String sql = "INSERT INTO Imoveis (imoveis novos acrecimo,imoveis usados desconto)VALUES ('10%','-5%')";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.execute();

            // UPDATE
            String sqlUpdate = "UPDATE veiculo SET cor =? WHERE codigo=?";
            ps = connection.prepareStatement(sqlUpdate);
            ps.setString(1, "+10");
            ps.setString(2, "-5");
            // Executa a intrucao
            int retorno = ps.executeUpdate();
            if (retorno > 0) {

                System.out.printf("Novo registro alterado");
            } else {
                System.out.println("Nao foi possivel alterar os registros !");
            }
            // Select
            String sqlSelect = "SELECT codigo, nome , endereco, preco FROM Imoveis";
            ps = connection.prepareStatement(sqlSelect);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                // recupera valor referente ao nome da coluna
                int codigo = rs.getInt("codigo");
                //Recupera o indice do campo referente ao campo nome 
                String nome = rs.getString(2);
                String endereco = rs.getString("endereco");
                System.out.printf("Codigo %d: %s - %s \n", codigo, nome, endereco);
            }
        } catch (ClassNotFoundException e) {// Driver nao encontrado
            System.out.println("O driver expecificado nao foi encontrado.");
        } catch (SQLException e) {
            // Nao conseguiendo conectar ao banco
            System.out.println("Nao foi possivel conectar ao banco de dados." + e.getMessage());
        } finally {
            connection.close();
        }
        boolean num = false;
        
            while(num ! = ); {
        System.out.println("1- imoveis novos, 2- imoveis usados,5 - mostrar dados tabela ou  - Sair.");
        num =  ler.nextInt();
        
        if (inicio == 1){
           Imovnovo imovNovo = new ImovNovos();
           imovNovo.mostrar();
           
           double retornoMetodo = imovNovo.acrecimo();
            System.out.println("Valor de acrecimo :"+ retornoMetodo);
            String sql = "INSERT INTO imoveis novos (codigo, nome, endereco,preco)Values (?,?,?,?,)";
               PreparedStatement ps = connection.prepareStatement (sql);
               ps.setString(1, imovNovo.getCodigo());
               ps.setString(2, imovNovo.getNome());
               ps.setString(3, imovNovo.getEndereco());
               ps.setString(4, imovNovo.getPreco());
               ps.execute();
        }    
                if (inicio == 2){
           Imovusado imovUsado = new ImovUsado();
           imovUsado.mostrardados();
           
           double retornoMetodo = imovUsado.desconto();
            System.out.println("Valor de desconto em imove usado:"+ retornoMetodo);
            String sql = "INSERT INTO imove(codigo,nome , endereco,preco)VALUES (?,?,?,?,)";
               PreparedStatement ps = connection.prepareStatement (sql);
               ps.setString(1, imovUsado.getCodigo());
               ps.setString(2, imovUsado.getNome());
               ps.setString(3, imovUsado.getEnderco());
               ps.setString(4, imovUsado.getPreco());
               ps.execute();
               }    
           if (num == 0 ) {
            String sqlSelect = "SELECT *  FROM Imove";
            PreparedStatement ps = connection.prepareStatement (sqlSelect);
            ResultSet rs = ps.executeQuary();
            while (rs.next()){
               String codigo = rs.getString(1);
               String nome = rs.getString(2);
               String endereco = rs.getString(3);
               Double preco = rs.getString(4);
               System.out.printf("codigo: %s, nome: %S, endereco: %s, preco: %s, \ n", codigo, nome, endereco, preco, );
            }  
        
    } // TODO code application logic here
    
    }

    }
    
}