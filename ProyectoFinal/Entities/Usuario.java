/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import enums.Rol;

/**
 *
 * @author Chiara Diaz
 */
public class Usuario extends Base{
    
    
    
    private String nombre;
    private String apellido;
    private String mail;
    private String celular;
    private String contrasenia;
    private Rol rol;
    private List<Pedido> pedidos = new ArrayList<>();

    public Usuario(long id, LocalDateTime createdAt,boolean eliminado) {
        super(id, createdAt,eliminado);
    }

    public Usuario(String nombre, String apellido, String mail, String celular, String contrasenia, Rol rol, long id, LocalDateTime createdAt,boolean eliminado) {
        super(id, createdAt,eliminado);
        this.nombre = nombre;
        this.apellido = apellido;
        this.mail = mail;
        this.celular = celular;
        this.contrasenia = contrasenia;
        this.rol = rol;
    }

    

    @Override
    public String toString() {
        return "Usuario{" + "nombre=" + nombre + ", apellido=" + apellido + ", mail=" + mail + ", celular=" + celular  + ", rol=" + rol + '}';
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
    
    
    public void agregarPedido(Pedido pedido){
        pedidos.add(pedido);
    }
    public void listarPedidos(){
    
        for (Pedido pedido: pedidos) {
            
            System.out.println(pedido);
            pedido.listarDetalle();
            System.out.println("El total  del pedido " + pedido.getTotal());
            
            
        }
    
    }
}
