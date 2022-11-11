
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author christian
 */
public class Usuario {
    private Conexion conectorBD;
    private Connection conexion;
    private PreparedStatement statement = null;
    private ResultSet result = null;
    
    public Usuario(){
        this.conectorBD=new Conexion();
    }
    
    public String validarUsuario(String user, String pass){
        String sql = "SELECT * FROM usuario WHERE usuario = '" + user + "' AND contrasenia = '"+pass+"'";
        try{
            this.conexion = this.conectorBD.conectar();
            this.statement = conexion.prepareStatement(sql);
            this.result=this.statement.executeQuery();
            if(result != null){
                 String usuarioEncontrado="";
                while (result.next()){
                    usuarioEncontrado= result.getString("usuario");
                }
                return usuarioEncontrado;
            }
            return "Usuario no encontrado";
        }
        catch(SQLException e){
           return e.getMessage();
        }
    }
}