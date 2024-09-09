package dados;

import java.sql.*;

public class AppDao {

    Connection conectado;
    PreparedStatement st;

    private void conectar() throws ClassNotFoundException, SQLException {
        //Conectando com o Banco de Dados
        Class.forName("com.mysql.cj.jdbc.Driver");
        conectado = DriverManager.getConnection("jdbc:mysql://localhost:3307/consultorio", "root", "p@$$w0rd");
    }
    
    //Login Tela Recepcionista
    
    public ResultSet logarRecepcionista(String nome, String senha) throws ClassNotFoundException, SQLException{
        conectar();
        
        st = conectado.prepareStatement("Select * from rep where nome = ? and senha = ?");
        st.setString(1,nome);
        st.setString(2,senha);
        st.executeQuery();
        
        ResultSet resultado = st.executeQuery();
        return resultado;
    }
    
    //Login Tela Médico
    
    public ResultSet logarMedico(String nome, String senha, String crm) throws ClassNotFoundException, SQLException{
        conectar();
        
        st = conectado.prepareStatement("Select * from medico where nome = ? and senha = ? and crm = ?");
        st.setString(1, nome);
        st.setString(2, senha);
        st.setString(3, crm);
        st.executeQuery();
        
        ResultSet resultado = st.executeQuery();
        return resultado;        
    }
    
    //Cadastrando o paciente no banco de dados

    public void cadastrarPaciente(String nome, String cpf, String tel, String endereco, String cep, String bairro, String complemento, String numero) throws SQLException, ClassNotFoundException {
        conectar();

        st = conectado.prepareStatement("Insert into paciente (nome,cpf,telefone,endereco,cep,bairro,complemento,numero) values (?,?,?,?,?,?,?,?)");

        st.setString(1, nome);
        st.setString(2, cpf);
        st.setString(3, tel);
        st.setString(4, endereco);
        st.setString(5, cep);
        st.setString(6, bairro);
        st.setString(7, complemento);
        st.setString(8, numero);
        st.executeUpdate();
    }

    //Exibindo o paciente na tela do usuário
    
    public ResultSet exibirPaciente(String nome) throws ClassNotFoundException, SQLException {
        conectar();

        st = conectado.prepareStatement("Select nome,cpf,telefone,endereco,cep,bairro,complemento,numero from paciente where nome = ?");
        st.setString(1, nome);

        ResultSet dadosPaciente = st.executeQuery();

        return dadosPaciente;
    }
    
    public ResultSet exibirMedico(String nome) throws ClassNotFoundException, SQLException{
        conectar();
        
        st = conectado.prepareStatement("Select nome, senha, crm from medico where nome = ?");
        st.setString(1, nome);
        
        ResultSet dadosMedico = st.executeQuery();
        
        return dadosMedico;
    }
    
    public void alterarMedico(String nome, String senha) throws ClassNotFoundException, SQLException{
        conectar();
        
        st = conectado.prepareStatement("Update medico set nome = ?, senha = ? where nome = ?");
        st.setString(1, nome);
        st.setString(2, senha);
        st.setString(3, nome);
        st.executeUpdate();
    }
    
    public void cadastraMedico(String nome, String senha, String crm) throws ClassNotFoundException, SQLException{
        conectar();
        
        st = conectado.prepareStatement("Insert into medico (nome,senha,crm) values (?,?,?)");
        st.setString(1, nome);
        st.setString(2, senha);
        st.setString(3, crm);
        st.executeUpdate();
    }
    
    public int excluirMedico(String nome) throws ClassNotFoundException, SQLException{
        conectar();
        
        st = conectado.prepareStatement("Delete from medico where nome = ?");
        st.setString(1, nome);
        
        int resultado = st.executeUpdate();
        
        return resultado;
    }
    
    public int excluirPaciente(String nome) throws ClassNotFoundException, SQLException{
        conectar();
        
        st = conectado.prepareStatement("Delete from paciente where nome = ?");
        st.setString(1, nome);
        int resultado = st.executeUpdate();
        
        return resultado;
    }
    
    public void cadastrarRep(String nome, String senha) throws ClassNotFoundException, SQLException{
        conectar();
        
        st = conectado.prepareStatement("Insert into rep (nome,senha) values (?,?)");
        st.setString(1, nome);
        st.setString(2, senha);
        st.executeUpdate();
    }
    
    public ResultSet exibirRep(String nome) throws ClassNotFoundException, SQLException{
        conectar();
        
        st = conectado.prepareStatement("Select nome, senha from rep where nome = ?");
        st.setString(1, nome);
        
        ResultSet dadosRep = st.executeQuery();
        
        return dadosRep;
    }
    
    public void alterarRep(String nome, String senha) throws ClassNotFoundException, SQLException{
        conectar();
        
        st = conectado.prepareStatement("Update rep set senha = ? where nome = ?");
        st.setString(1, senha);
        st.setString(2, nome);
        st.executeUpdate();
    }
    
    public int excluirRep(String nome) throws ClassNotFoundException, SQLException{
        conectar();
        
        st = conectado.prepareStatement("Delete from rep where nome = ?");
        st.setString(1, nome);
        
        int resultado = st.executeUpdate();
        
        return resultado;
    }

    public void alterarPaciente(String nome, String cpf, String tel, String endereco, String cep, String bairro, String complemento, String numero) throws SQLException, ClassNotFoundException {
        conectar();

        st = conectado.prepareStatement("Update paciente set nome = ?, cpf = ?, telefone = ?, endereco = ?, cep = ?, bairro = ?, complemento = ?, numero = ? where nome = ?");
        
        st.setString(1, nome);
        st.setString(2, cpf);
        st.setString(3, tel);
        st.setString(4, endereco);
        st.setString(5, cep);
        st.setString(6, bairro);
        st.setString(7, complemento);
        st.setString(8, numero);
        st.setString(9, nome);
        st.executeUpdate();
    }
    
    //Criando aficha da Triagem do paciente
    
    public void cadastrarFicha(String nome,String temp,String pressao,String localDor,String inteDor,String tipoDor,String duraDor) throws ClassNotFoundException, SQLException{
        conectar();
        
        st = conectado.prepareStatement("Insert into ficha_paciente (nome_paciente,temp,pressao,local_Dor,inte_Dor,tipo_Dor,dura_Dor) values (?,?,?,?,?,?,?)");
        
        st.setString(1,nome);
        st.setString(2,temp);
        st.setString(3,pressao);
        st.setString(4,localDor);
        st.setString(5,inteDor);
        st.setString(6,tipoDor);
        st.setString(7,duraDor);
        st.executeUpdate();
    }
    
    public ResultSet exibirProntuario(String nome) throws ClassNotFoundException, SQLException{
        conectar();
        
        st = conectado.prepareStatement("Select nome_Paciente,temp,pressao,local_Dor,inte_Dor,tipo_Dor,dura_Dor from ficha_paciente where nome_Paciente = ?");
        st.setString(1, nome);
        
        ResultSet dadosFicha = st.executeQuery();

        return dadosFicha;
    }

}
