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
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;
import exceptions.EntidadNoEncontradaException;
public class CategoriaService {
    
    
    private ArrayList<Categoria> categorias;
    Scanner scan = new Scanner(System.in);

    public CategoriaService(ArrayList<Categoria> categorias) {
        this.categorias = categorias;
    }
    
    public void listar(){
    
            if(categorias.isEmpty()){
                                            
                                            
                                System.out.println("No hay categorias cargadas");
                                 }else{
                                                
                                                
                                        for (Categoria categoria: categorias) {
                                                    
                                                    
                                                if(categoria.isEliminado()){    
                                                    
                                                
                                                    System.out.println("Categoria eliminada");
                                            
                                        
                                                }else{
                                                           
                                                     System.out.println("Categoria: " + categoria);
                                                           
                                                    }
                                            
                                            
                                            }
                                            
                                        
                                        } 
    
    }
    
    public void crear(){
    
             long id = categorias.size() + 1;
                                    LocalDateTime fecha = LocalDateTime.now();
                                    String nombre;
                                    String descripcion;
                                    System.out.println(" Ingrese el nombre de la categoria");
                                    nombre = scan.nextLine();
                                    System.out.println("Ingrese la descripcion de de la categoria");
                                    descripcion = scan.nextLine();
                                    
                                    if(nombre.isEmpty() || descripcion.isEmpty()){
                                    
                                        System.out.println("Debe ingresar datos no vacios");
                                    
                                    
                                    }
                                    for (Categoria categoria: categorias) {
                                        
                                        if(categoria.getNombre().equals(nombre)){
                                        
                                            System.out.println("No se puede crear dos categorias con el mismo nombre");
                                        
                                        
                                        }
                                        
                                        
                                        
                                    }
                                    
                                    
                                    categorias.add(new Categoria(nombre,descripcion,id,fecha,false));
                                    System.out.println("Se ingreso categoria " + nombre + " id " + id);
                                    
    
    
    
    }
    
    
    public void editar(){
    
    
                                long id = 0;
                                String nombre = "";
                                String descripcion = "";
                                                
                                                
                                    while(nombre.isEmpty() || descripcion.isEmpty()){
                                                
                                                
                                            try{
                                                    
                                                System.out.println("Ingrese el id de la categoria");
                                                id= Long.parseLong(scan.nextLine());
                                                System.out.println("Ingrese nombre a modificar");
                                                nombre = scan.nextLine();
                                                System.out.println("Ingrese descripcion a modificar");
                                                descripcion = scan.nextLine();


                                            }catch(IllegalArgumentException e){

                                                System.out.println("No ingrese valores vacios o id invalido");


                                               }
                                                
                                                
                                          }
                                               
                                                
                                           for (Categoria categoria: categorias) {
                                                    
                                                if(categoria.getId() == id){
                                                        
                                                        
                                                    categoria.setNombre(nombre);
                                                    categoria.setDescripcion(descripcion);
                                                    System.out.println("Operacion confirmada");
                                                    System.out.println("Categoria: " + categoria);
                                                            
                                                        
                                                }else{
                                                    
                                                    System.out.println("No se encontro concidencias con ese id");
                                                      }
                                                        
                                                    
                                          }
    
    
    }
    
    
    
    public void eliminar(){
    
        
                                    String opcion = "";
                                    String confirmado = "S";
                                    long id = 0;
                                    
                                    while(id < 0 || id == 0 || !opcion.equals(confirmado)){
                                    
                                    
                                        try{
                                            System.out.println("Ingrese id de la categoria a eliminar");
                                            id = Long.parseLong(scan.nextLine());
                                            System.out.println("¿Dese eliminar realmente? Ingrese S/N");
                                            opcion = scan.nextLine().trim().toUpperCase();
                                        
                                        
                                        
                                        
                                        
                                        }catch(IllegalArgumentException e){
                                        
                                            System.out.println("Id invalido ");
                                        
                                       
                                        
                                        }
                                    
                                   
                                    }
                                        
                                        

                                    for (Categoria categoria: categorias) {
                                                if(categoria.getId() == id){

                                                    categoria.setEliminado(true);

                                                }
                                         
                                    }
    
    
    }
    
}
