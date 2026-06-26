/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

/**
 *
 * @author Chiara Diaz
 */

import entities.Pedido;
import entities.Producto;
import entities.Usuario;
import enums.Estado;
import enums.FormaPago;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;
import exceptions.EntidadNoEncontradaException;

public class servicioPedidos {
    
    
    
    private ArrayList<Pedido> pedidos;
    private ArrayList<Usuario>usuarios;
    private ArrayList<Producto>productos;
    Scanner scan = new Scanner(System.in);

    public servicioPedidos(ArrayList<Pedido> pedidos, ArrayList<Usuario> usuarios, ArrayList<Producto> productos) {
        this.pedidos = pedidos;
        this.usuarios = usuarios;
        this.productos = productos;
    }

  
    
    public void listar(){
    
            
                                            if(pedidos.isEmpty()){
                                            
                                            
                                                System.out.println("No hay  pedidos creados");
                                            }else{
                                                for (Pedido pedido: pedidos) {
                                                    
                                                    
                                                if(!pedido.isEliminado()){
                                                    System.out.println("Pedido: " + pedido);
                                                
                                                
                                                }    
                                                
                                            
                                            
                                        
                                              }
                                            
                                            
                                            }
    
    
            
    }
    
    
    public void crear(){
    
        long idUsuario;
                                    
                                    LocalDate fecha = LocalDate.now();
                                    
                                    FormaPago formaDePago=null;
                                    long idPedido = pedidos.size() + 1;
                                    LocalDateTime fecha2= LocalDateTime.now();
                                    boolean eliminado = false;
                                            
                                    
                                    System.out.println("Ingrese el id del usuario ");
                                    idUsuario= Long.parseLong(scan.nextLine());
                                    
                                    for (Usuario usuario: usuarios) {
                                        
                                        
                                        if(usuario.getId() == idUsuario && !usuario.isEliminado()){
                                            
                                            
                                            
                                                       
                                            
                                        

                                        try{
                                            System.out.println("Eliga una forma de pago  : TARJETA,TRANSFERENCIA,EFECTIVO");
                                            formaDePago = FormaPago.valueOf(scan.nextLine().trim().toUpperCase());
                                     
                                        
                                        
                                        
                                        
                                        }catch(IllegalArgumentException e){
                                        
                                            System.out.println("No se encuentra el dato ingresado");
                                        
                                        }        
                                        
                                       
                                        
                                        Estado estado=Estado.CONFIRMADO;
                                        
                                        
                                        
                                               
                                        Pedido pedido = new Pedido(fecha,estado,formaDePago,usuario,idPedido,fecha2,eliminado);
                                        usuario.agregarPedido(pedido); 
                                        pedidos.add(pedido);
                                            
                                        
                                        
                                        long id =0;
                                        int cantidadIngresada=0;
                                        
                                        Producto productoElegido=null;
                                        boolean seguirComprando= false;
                                        String opcion;
                                        String confirmado = "S";
                                       
                                        
                                        
                                        
                                        
                                        try{
                                                do{
                                            
                                                System.out.println("Ingrese el id del producto que desea comprar: ");
                                                id=Long.parseLong(scan.nextLine());
                                                
                                                System.out.println("¿Desea seguir comprando mas productos? S/ N");
                                                opcion = scan.nextLine();
                                                if(opcion.equals(confirmado.trim().toUpperCase())){
                                                    seguirComprando= true;
                                                
                                                }
                                                
                                                }while(seguirComprando);
                                            
                                            }catch(NumberFormatException e){
                                            
                                                System.out.println("Error, ingrese un tipo de dato correcto");
                                            
                                            }
                                            
                                            
                                            catch(IllegalArgumentException e){
                                            
                                            
                                            
                                                System.out.println("Error, ingrese un dato valido no vacio");
                                            }finally{
                                            
                                            
                                                System.out.println("Gracias!");
                                            
                                            }
                                        
                                        
                                        for (Producto producto: productos) {
                                            
                                                
                                                if(producto.getId()== id && !producto.isEliminado() && producto.getStock() > 0 ){
                                                    
                                                    
                                                    
                                                    System.out.println("Producto: " + producto + " id:" + producto.getId());
                                                    productoElegido =  producto;
                                                    System.out.println("Ingrese la cantidad que desee comprar "); 
                                                    cantidadIngresada = Integer.parseInt(scan.nextLine());
                                                        if(productoElegido.getStock() >= cantidadIngresada){
                                                            int stockNuevo;
                                                            
                                                            pedido.addDetallePedido(cantidadIngresada, productoElegido);
                                                            System.out.println("Se agrego el pedido " + pedido + " ID " + pedido.getId());
                                                            stockNuevo = productoElegido.getStock() - cantidadIngresada;
                                                            productoElegido.setStock(stockNuevo);
                                                            
                                                             
                                                
                                                }else{
                                                            System.out.println("No hay suficiente stock, ingrese una cantidad igual o menor a  " + productoElegido.getStock());
                                                        
                                                        }
                                                
                                                    
                                                    
                                                
                                                }else{
                                                
                                                    System.out.println("No se encontro el producto o esta eliminado");
                                                
                                                }
                                                
                                            
                                            
                                        }
                                        
                                       
                                        
                                        
                                        
                                    
                                           

                                        }else{
                                        
                                            System.out.println("Usuario inexistente o eliminado");
                                        }
                                        
                                        
                                        
                                        
                                        
                                    }
    
    
    }
    
    
    
    public void editar(){
            
                                    long idPedido=0;
                                    
                                    long idUsuario;
                                    Estado[] estadoPedido=Estado.values();
                                    int opcionFormaPago,opcionPago;
                                    int opcionEstado;
                                    FormaPago[] formaPago = FormaPago.values();
                                    
                                     System.out.println("Ingrese el id del usuario ");
                                     idUsuario= Long.parseLong(scan.nextLine());
                                     
                                     
                                        for (Usuario usuario: usuarios) {
                                        
                                        
                                        if(usuario.getId() == idUsuario && !usuario.isEliminado()){
                                            
                                            
                                          try{
                                          
                                              System.out.println("Ingrese el id del pedido");
                                              idPedido = Long.parseLong(scan.nextLine());
                                              if(idPedido<=0){
                                                  System.out.println("Ingrese un numero mayor que 0");
                                              
                                                  
                                              
                                              }
                                          
                                          
                                          }catch(NumberFormatException e){
                                          
                                          
                                              System.out.println("Ingrese un dato valido");
                                          
                                          }  
                                                       
                                            
                                        
                                            for (Pedido pedido:pedidos) {
                                                
                                                
                                                
                                                if(pedido.getId() == idPedido){
                                                    
                                                        System.out.println("Elige una opcion del estado actual del pedido: ");
                                                        for (int i = 0; i < estadoPedido.length; i++) {
                                                            
                                                            
                                                            
                                                            System.out.println((i+1) + ". " + estadoPedido[i]);
                                                        
                                                    }
                                                        opcionEstado = Integer.parseInt(scan.nextLine());
                                                        if(opcionEstado>=1 && opcionEstado < estadoPedido.length ){
                                                                    
                                                                        Estado estadoDePedido = estadoPedido[opcionEstado - 1];
                                                                        pedido.setEstado(estadoDePedido);
                                                                        
                                                                        System.out.println("Elegiste " + estadoDePedido);
                                                                        
                                                                    
                                                                    
                                                                    }else{
                                                                    
                                                                        System.out.println("Opcion invalida");
                                                                    
                                                                    }
                                                        
                                                        System.out.println("Desea cambiar la forma de pago? Ingrese un numero 1 (Si) 2 (No)");
                                                        opcionFormaPago = Integer.parseInt(scan.nextLine());
                                                        if(opcionFormaPago == 1){
                                                                    System.out.println("Eliga una forma de pago  : ");
                                                                    for (int i = 0; i < formaPago.length; i++) {
                                                                        
                                                                        
                                                                        
                                                                        
                                                                        System.out.println((i+1) + ". " + formaPago[i]);
                                                                
                                                            }
                                                                   
                                                                    opcionPago = Integer.parseInt(scan.nextLine());
                                                                    if(opcionPago>=1 && opcionPago <= formaPago.length ){
                                                                    
                                                                        FormaPago formadePago = formaPago[opcionPago - 1];
                                                                        pedido.setFormaPago(formadePago);
                                                                        
                                                                        System.out.println("Elegiste " + formadePago);
                                                                        
                                                                    
                                                                    
                                                                    }else{
                                                                    
                                                                        System.out.println("Opcion invalida");
                                                                    
                                                                    }
                                                        
                                                        }
                                                     
                                                 
                                                        
                                                        
                                                        
                                                        
                                                }else{
                                                
                                                
                                                    System.out.println("Ingrese un dato valido");
                                                
                                                }
          
                                                
                                                
                                            }
  
                                             
                                        }
                                        
                                    }
                                     
    
            
    
    }
    
    
    public void eliminar(){
    
                                                    String opcion;
                                                    String confirmado = "S";
                                                    long id;
                                    
                                    
                                                    System.out.println("Ingrese id del pedido a eliminar");
                                                    id = Long.parseLong(scan.nextLine());
                                                    System.out.println("¿Dese eliminar realmente? Ingrese S/N");
                                                    opcion = scan.nextLine();
                                                    if(confirmado.equals(opcion)){

                                                        for (Pedido pedido:pedidos) {
                                                            if(pedido.getId() == id){

                                                                pedido.setEliminado(true);

                                                                }
                                              
                                        
                                                        }
                                    
                                                    }

                                    
    
    }
}
