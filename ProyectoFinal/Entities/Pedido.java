/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import static java.time.LocalDateTime.now;
import java.util.ArrayList;
import java.util.List;
import enums.Estado;
import enums.FormaPago;
import interfaces.Calculable;

/**
 *
 * @author Chiara Diaz
 */
public class Pedido extends Base implements Calculable{
    
    private LocalDate fecha;
    private Estado estado;
    private double total;
    private FormaPago formaPago;
    private List<DetallePedido>detallePedidos = new ArrayList<>();
    private Usuario usuario;

    public Pedido(long id, LocalDateTime createdAt,boolean eliminado) {
        super(id, createdAt,eliminado);
    }

    public Pedido(LocalDate fecha, Estado estado, FormaPago formaPago, Usuario usuario, long id, LocalDateTime createdAt,boolean eliminado) {
        super(id, createdAt,eliminado);
        this.fecha = fecha;
        this.estado = estado;
        
        this.formaPago = formaPago;
        this.usuario = usuario;
        
    }

    @Override
    public String toString() {
        return "Pedido{" + "fecha=" + fecha + ", estado=" + estado + ", formaPago=" + formaPago  + '}';
    }
    
  
    
    

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

 

    public void setTotal(double total) {
        this.total = total;
    }

    public FormaPago getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(FormaPago formaPago) {
        this.formaPago = formaPago;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    
    
    @Override
    public void calcularTotal() {
            
            this.total = 0;
            for (DetallePedido detalle: detallePedidos) {
                total += detalle.getSubtotal();
                
            
            }
            
                
    }
    
    
   
    public void addDetallePedido(int cantidad, Producto product){
        
        long nuevoId = detallePedidos.size() + 1; 
        LocalDateTime fecha1 = LocalDateTime.now();
        boolean eliminado = false;
        detallePedidos.add(new DetallePedido(cantidad,product,nuevoId,fecha1,eliminado));
        
        calcularTotal();
            
            
            
            
            
        
    
        
        
        
        
        
    
    
    }
     public double getTotal() {
        return total;
    }
    
    
   
    public DetallePedido findDetallePedidoByProducto(Producto p){
    
    
        
        
        for (DetallePedido pedido: detallePedidos) {
            int i = 0;
            i++;
            if(pedido.getProducto().getId() == p.getId()){
            
                return pedido;
                
            
            
            }
             
        }
        
        
        
        return null;
        
    
       
    }
    
    
    public void deleteDetallePedidoByProducto(Producto p){
        
        detallePedidos.removeIf(detalle -> detalle.getProducto().equals(p));
    
        System.out.println("Elemento eliminado correctamente");
        calcularTotal();
    
        
    }
    
    
    public void listarDetalle(){
    
        for (DetallePedido detalle: detallePedidos) {
            
            
            System.out.println(detalle);
            
        }
    
    }
}
