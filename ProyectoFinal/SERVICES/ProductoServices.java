/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

/**
 *
 * @author Chiara Diaz
 */


import entities.Categoria;
import entities.Producto;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;
import exceptions.StockInvalidoException;
import exceptions.EntidadNoEncontradaException;
public class ProductoServices {
    
    
    private ArrayList<Producto> productos;
    private ArrayList<Categoria>categorias;
    
    Scanner scan = new Scanner(System.in);

    public ProductoServices(ArrayList<Producto> productos, ArrayList<Categoria> categorias) {
        this.productos = productos;
        this.categorias = categorias;
    }

  
    
    
    public void listar(){
              if(productos.isEmpty()){
                                            
                                            
                System.out.println("No hay productos cargadas");
              }else{
                                                
                                                
                    for (Producto producto:productos) {
                                                    
                                                    
                         if(!producto.isEliminado()){    
                            System.out.println("Producto: " + producto);
                                        
                          }else{
                                                           
                           }
                                            
                    }
                                            
           }
            
    }
    
    public void crear(){
        
                                    
                                    long id = productos.size() + 1;
                                    LocalDateTime fecha = LocalDateTime.now();
                                    String nombre="";
                                    String descripcion="";
                                    double precio = 0;
                                    int stock = 0;
                                    String imagen="";
                                    boolean disponible;
                                    long idCategoria = 0;
                                    
                                    
                                    int i =0;
                                    int posicion = 0;
                                    
                                    
                                    
                                    while(nombre.isEmpty() || descripcion.isEmpty() || imagen.isEmpty()){
                                    
                                    
                                        try{
                                        
                                            System.out.println(" Ingrese el nombre del producto");
                                            nombre = scan.nextLine();
                                            System.out.println("Ingree la descrpcion del productos");
                                            descripcion = scan.nextLine();
                                            System.out.println(" Ingrese la imagen del producto");
                                            imagen = scan.nextLine();
                                            
                                        
                                        
                                        }catch(IllegalArgumentException e){
                                        
                                        
                                        
                                            System.out.println("No ingrese valores vacios");
                                        
                                        
                                        }finally{
                                    
                                            System.out.println("Gracias!");
                                    
                                    
                                        }
                                    
                                    
                                    }
                                    
                                    while(precio <= 0 || stock <= 0 || id <= 0){
                                    
                                        try{
                                        
                                            System.out.println(" Ingrese el precio del producto");
                                            precio =Double.parseDouble(scan.nextLine());
                                            System.out.println("Ingree el stock del productos");
                                            stock = Integer.parseInt(scan.nextLine());
                                            System.out.println("Ingrese el id de la categoria ");
                                    
                                            idCategoria = Long.parseLong(scan.nextLine());

                                        
                                        }catch(IllegalArgumentException e){
                                        
                                            System.out.println("Error no ingrese valores negativos");
                                        
                                        
                                        }finally{
                                            
                                            
                                            System.out.println("Gracias!");
                                    
                                    
                                                }
                                    
                                    
                                    }
                                    for (Categoria categoria1 : categorias) {
                                        
                                        i++;
                                        if(categoria1.getId() != idCategoria){
                                            posicion = i;
                                        }
                                        
                                    }
                            
                                  
                                   
                                    for (Producto producto: productos) {
                                        
                                        if(producto.getNombre().equals(nombre)){
                                        
                                            System.out.println("No se puede crear dos productos con el mismo nombre");
                                        
                                        
                                        }
                                        if(producto.getCategoria().isEliminado() || producto.getCategoria() == null){
                                        
                                            break;
                                        
                                        
                                        }
                                        
                                        
                                    }
                                    
                                    disponible = true;
                                    productos.add(new Producto(nombre,precio,descripcion,stock,imagen,disponible,categorias.get(posicion),id,fecha,false));
                                    System.out.println("Se ingreso el producto " + nombre + " id " + id);
                                    
    
    
    
    
    }
    
    
    
    
    public void editar(){
    
    
    
        
                                                long id=0;
                                                String nombre="";
                                                String descripcion="";
                                                String precioTexto="";
                                                String stockTexto="";
                                                String imagen="";
                                                boolean disponible=false;
                                                String idCategoria="";
                                                int posicion = 0;
                                                
                                                int stock = 0;
                                                double precio=0;
                                                
                                                try{
                                                    System.out.println("Ingrese el id del producto");
                                                     id= Long.parseLong(scan.nextLine());
                                                     System.out.println("Ingrese descripcion a modificar");
                                                     descripcion = scan.nextLine();
                                                     
                                                     System.out.println("Ingrese nombre a modificar");
                                                     nombre = scan.nextLine();
                                                     System.out.println("Ingrese la imagen a modificar: ");
                                                     imagen = scan.nextLine();
                                                     System.out.println("Ingrese el id de la categoria a modificar");
                                                     idCategoria = scan.nextLine();
                                                    System.out.println("Ingrese el precio a modificar: ");
                                                    precioTexto = scan.nextLine().trim();

                                                    System.out.println("Ingrese el stock a modificar: ");
                                                    stockTexto = scan.nextLine().trim();
                                                   
                                                     
                                                
                                                
                                                }catch(NumberFormatException e){
                                                
                                                
                                                    System.out.println("No se puede ingresar otro tipo de dato");
                                                
                                                }finally{
                                                
                                                
                                                
                                                    System.out.println("Gracias!");
                                                
                                                }
                                                
                                               
                                              
                                                
                                                for (Producto producto :productos) {
                                                    
                                                    if(producto.getId() == id){
                                                        
                                                        
                                                                    long idCompatibleCategoria=0;
                                                                    disponible = true;
                                                                    if(nombre.isEmpty() && descripcion.isEmpty() && imagen.isEmpty() && precioTexto.isEmpty() && stockTexto.isEmpty() && !idCategoria.isEmpty()){
                                                                    } else {
                                                                          if(!idCategoria.isEmpty()){
                                                                          
                                                                               idCompatibleCategoria= Long.parseLong(idCategoria);
                                                                                for (int i=0;i<categorias.size();i++){

                                                                                Categoria categoria = categorias.get(i);
                                                                                if(categoria.getId() == idCompatibleCategoria){
                                                                                    
                                                                                    
                                                                                    producto.setCategoria(categorias.get(posicion));
                                                                                    System.out.println("Operacion confirmada");


                                                                                }


                                                                            }
                                                                          
                                                                               
                                                                          }  
                                                                          
                                                                           
                                        
                                                                        if (!stockTexto.isEmpty()) {
                                                                               stock = Integer.parseInt(stockTexto);
                                                                               if(stock > 0){
                                                                               
                                                                                   producto.setStock(stock);
                                                                                   System.out.println("Operacion confirmada");
                                                                               }else{
                                                                               
                                                                                   System.out.println("No se puede ingresar numeros negativos");
                                                                               }
                                                                               
                                                                                                        
                                                                         }
                                                                       
                                                                        
                                                                        if(!precioTexto.isEmpty()){
                                                                                precio = Double.parseDouble(precioTexto);
                                                                                if(precio > 0){
                                                                                
                                                                                    producto.setPrecio(precio);
                                                                                    System.out.println("Operacion confirmada");
                                                                                
                                                                                }else{
                                                                                
                                                                                    System.out.println("No se puede ingresar numero negativo");
                                                                                }
                                                                                
                                                                                            
                                                                           }
                                                                        
                                                                        if(!nombre.isEmpty()){
                                                                        
                                                                            
                                                                            producto.setNombre(nombre);
                                                                            System.out.println("Operacion confirmada");
                                                                        
                                                                        }
                                                                        if(!descripcion.isEmpty()){
                                                                        
                                                                            producto.setDescripcion(descripcion);
                                                                            System.out.println("Operacion confirmada");
                                                                        
                                                                        
                                                                        }
                                                                        
                                                                        if(!imagen.isEmpty()){
                                                                        
                                                                            producto.setImagen(imagen);
                                                                            System.out.println("Operacion confirmada");
                                                                        
                                                                        
                                                                        }
                                                                       
                                                            
                                                                }
                                                                    
                                                               
                                                        }
                                                          
                                            }
    
    
    }
    
    
    public void eliminar(){
    
    
    
                                    String opcion;
                                    String confirmado = "S";
                                    long id;
                                    
                                    
                                    System.out.println("Ingrese id del producto a eliminar");
                                    id = Long.parseLong(scan.nextLine());
                                    System.out.println("¿Dese eliminar realmente? Ingrese S/N");
                                    opcion = scan.nextLine().trim().toUpperCase();
                                    if(confirmado.equals(opcion)){
                                    
                                        for (Producto producto: productos) {
                                            if(producto.getId() == id){

                                                producto.setEliminado(true);

                                            }
                                              
                                        
                                    }
                                    
            }
    
    }
    
    
    public Producto buscarProductoPorId(long id) throws EntidadNoEncontradaException {

    for (Producto producto : productos) {
        if (producto.getId() == id && !producto.isEliminado()) {
            return producto;
        }
    }

    throw new EntidadNoEncontradaException("Producto no encontrado");
}
    
}
