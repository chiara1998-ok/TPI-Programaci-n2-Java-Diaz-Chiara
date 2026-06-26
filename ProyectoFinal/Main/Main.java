/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package prog2;


import java.util.Scanner;
import entities.Categoria;

import entities.Pedido;
import entities.Producto;
import entities.Usuario;

import java.util.ArrayList;
import services.CategoriaService;
import services.ProductoServices;
import services.UsuarioService;
import services.servicioPedidos;




/**
 *
 * @author Chiara Diaz
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
      
        
        Scanner scan = new Scanner(System.in);
       
        int opcionIngresada,opcionElegida;
        
        ArrayList<Categoria>categorias = new ArrayList<>();
        CategoriaService categoriaService = new CategoriaService(categorias);
        ArrayList<Producto>productos = new ArrayList<>();
        ProductoServices productoService = new ProductoServices(productos,categorias);
        ArrayList<Usuario>usuarios = new ArrayList<>();
        UsuarioService usuarioService = new UsuarioService(usuarios);
        ArrayList<Pedido> pedidos = new ArrayList<>();
        servicioPedidos pedidoService = new servicioPedidos(pedidos,usuarios,productos);
        
        
        do{
            System.out.println("Ingrese la opcion que desee: ");
            System.out.println("1: Categorias");
            System.out.println("2: Productos");
            System.out.println("3: Usuarios");
            System.out.println("4: Pedidos");
            System.out.println("0: Salir");
            opcionIngresada = Integer.parseInt(scan.nextLine());
            validacion(opcionIngresada);
            switch(opcionIngresada){
                case 1 -> { System.out.println("Ingrese la accion que desea realizar: ");
                            System.out.println("1: Listar");
                            System.out.println("2: Crear");
                            System.out.println("3: Editar");
                            System.out.println("4:  Eliminar");
                            System.out.println("0: Salir");
                            opcionElegida = Integer.parseInt(scan.nextLine());
                            validacion(opcionElegida);
                            switch(opcionElegida){
                            
                                case 1 -> {
                                    
                                       
                                       
                                        categoriaService.listar();
                                            
                                }
                                
                                
                                case 2 -> {
                                    
                                         categoriaService.crear();
                                    
                                    




                                }
                                case 3 -> {     
                                           categoriaService.editar();
                                                  
                                                 }
                                  
                                            
                                case 4 -> {
                                    
                                        categoriaService.eliminar();
                              

                                }
                                default -> {System.out.println("Opcion invalida");}
                                
                                
                            
                                    }
            
            
                                }
                
                case 2 -> { System.out.println("Ingrese la accion que desea realizar: ");
                            System.out.println("1: Listar");
                            System.out.println("2: Crear");
                            System.out.println("3: Editar");
                            System.out.println("4:  Eliminar");
                            System.out.println("0: Salir");
                            opcionElegida = Integer.parseInt(scan.nextLine());
                            validacion(opcionElegida);
                            switch(opcionElegida){    
                    
                    
                                        case 1 -> {
                                    
                                       
                                       
                                        productoService.listar();
                                          
                                            
                                        
                                     } 
                                
                                
                                
                                case 2 -> {
                                    

                                    productoService.crear();


                                }
                                case 3 -> {
                                        productoService.editar();
                                                   
                                }     
                                               
                                               
                                case 4 -> {
                                    
                                    productoService.eliminar();
                                    
                               
                                    



                                }
                                default -> {System.out.println("Opcion invalida");}
                    
                        
                   
                    
                }
                            
             }                
                case 3 -> {
                            System.out.println("Ingrese la accion que desea realizar: ");
                            System.out.println("1: Listar");
                            System.out.println("2: Crear");
                            System.out.println("3: Editar");
                            System.out.println("4:  Eliminar");
                            System.out.println("0: Salir");
                            opcionElegida = Integer.parseInt(scan.nextLine());
                            validacion(opcionElegida);
                            switch(opcionElegida){    
                    
                    
                                        case 1 -> {
                                    
                                       
                                                usuarioService.listar();
                                        
                                          
                                            
                                        
                                        } 
                                
                                
                                
                                        case 2 -> {


                                                usuarioService.crear();



                                            }
                                        case 3 -> { 
                                            
                                                    usuarioService.editar();
                                                               
                                              }
                                        
                                        
                                        
                                            case 4 -> {
                                                
                                                
                                                    usuarioService.eliminar();




                                                }
                                            default -> {System.out.println("Opcion invalida");}
                                                          
                                    }
                                                



                            }
                                      




                                       
                case 4 -> {
                
                    System.out.println("Ingrese la accion que desea realizar: ");
                            System.out.println("1: Listar");
                            System.out.println("2: Crear");
                            System.out.println("3: Editar");
                            System.out.println("4:  Eliminar");
                            System.out.println("0: Salir");
                            opcionElegida = Integer.parseInt(scan.nextLine());
                            validacion(opcionElegida);
                            switch(opcionElegida){    
                    
                    
                                        case 1 -> {
                                    
                                       
                                            pedidoService.listar();
                                        
                                            
                                        
                                        } 
                                
                                
                                
                                case 2 -> {
                                    
                                    
                                            pedidoService.crear();
                               



                                }
                                case 3 -> {
                                    
                                            pedidoService.editar();
                           



                                }
                                case 4 -> { 
                                    
                                    
                                             pedidoService.eliminar();
                                    
                                    
                                    
                                    




                                }
                               default -> {System.out.println("Opcion invalida");}
                
                }
                
                        
                   
                    
                }
                default -> {System.out.println("Opcion invalida");}
               
            
            
            }
           
        
        }while(opcionIngresada != 0);
        
        
    

        
        
        
        

        /*System.out.println(usuario1);
        usuario1.listarPedidos();
       
        
     
        
        System.out.println("El total acumulado por usuario " + (pedido1.getTotal() + pedido2.getTotal()));
        
        System.out.println(usuario2);
        
        
        usuario2.listarPedidos();
       
        
        
        
        System.out.println("El total acumulado por usuario " + (pedido3.getTotal() + pedido4.getTotal()));*/
        
        
      
        
        
    }
    
    public static void validacion(int datoIngresado){
        
        
        if(datoIngresado >= 5 || datoIngresado < 0){
        
        
            System.out.println("Dato ingreado valido, ingrese un un numero menor que 5 o mayor o igual a 0");
        }
    
       
    
    } 
    
 
    
}
