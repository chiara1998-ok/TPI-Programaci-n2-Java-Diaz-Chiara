/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

/**
 *
 * @author Chiara Diaz
 */



import entities.Usuario;
import enums.Rol;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;
import exceptions.EntidadNoEncontradaException;
public class UsuarioService {
    
    
   private ArrayList<Usuario>usuarios;
   
   
   
   Scanner scan = new Scanner(System.in);

    public UsuarioService(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
   
   
   
    public void listar(){
               if(usuarios.isEmpty()){
                                            
                                            
                   System.out.println("No hay usarios cargados");
                }else{


                        for (Usuario usuario: usuarios) {


                            if(usuario.isEliminado()){    





                            }else{

                             System.out.println("Usuario: " + usuario);
                            }
                                            
                        }
                                            
                                        
                 }
    
    
    
    }
    
    public void crear(){
    
        
                                            long id = usuarios.size() + 1;
                                            LocalDateTime fecha = LocalDateTime.now();
                                            String nombre = "";
                                            String apellido = "";
                                            String mail = "";
                                            String cel = "";
                                            String contrasenia = "";
                                            Rol rol = null;
                                            boolean eliminado = false;

                                            while(nombre.isEmpty() || apellido.isEmpty() || mail.isEmpty() || contrasenia.isEmpty() || cel.isEmpty()){

                                                try{

                                                    System.out.println(" Ingrese el nombre");
                                                    nombre = scan.nextLine();
                                                    System.out.println("Ingrese el apellido");
                                                    apellido = scan.nextLine();
                                                    System.out.println("Ingrese el mail");
                                                    mail = scan.nextLine();
                                                    System.out.println("Ingrese la contrasenia ");
                                                    contrasenia = scan.nextLine();
                                                    System.out.println("Ingrese el numero de celular");
                                                    cel = scan.nextLine();




                                                }catch(IllegalArgumentException ie){


                                                    System.out.println("No ingrese datos vacios");

                                                }





                                            }

                                            while(rol == null){
                                                try{


                                                    System.out.println("Eliga el rol : ADMIN o USUARIO");
                                                    rol = Rol.valueOf(scan.nextLine().trim().toUpperCase());


                                                }catch(IllegalArgumentException e){

                                                    System.out.println("Rol invalido intente nuevamente");


                                                }




                                            }

                                            for (Usuario usuario: usuarios) {

                                                if(usuario.getMail().equals(mail)){

                                                    System.out.println("No se puede crear dos mails iguales");


                                                }



                                            }


                                            usuarios.add(new Usuario(nombre,apellido,mail,cel,contrasenia,rol,id,fecha,eliminado));
                                            System.out.println("Se ingreso el siguiente usuario " + nombre + " id " + id);

    
    
    }
    
    
    public void editar(){
        
        
        
                                            
                                            long id = usuarios.size() + 1;
                                            
                                            
                                            String nombre = "";
                                            String apellido = "";
                                            String mail = "";
                                            String cel = "";
                                            String contrasenia = "";
                                            Rol rol = null;
                                            
                                                
                                            
                                            
                                            try{    
                                                
                                                    System.out.println(" Ingrese el ID  a modificar");
                                                    id = Long.parseLong(scan.nextLine());
                                                    System.out.println(" Ingrese el nombre  a modificar");
                                                    nombre = scan.nextLine();
                                                    System.out.println("Ingrese el apellido a modificar");
                                                    apellido = scan.nextLine();
                                                    System.out.println("Ingrese el mail a modificar");
                                                    mail = scan.nextLine();
                                                    System.out.println("Ingrese la contrasenia a modificar ");
                                                    contrasenia = scan.nextLine();
                                                    System.out.println("Ingrese el numero de celular a modificar");
                                                    cel = scan.nextLine();
                                                   
                                                     
                                                
                                                
                                                }catch(NumberFormatException e){
                                                
                                                
                                                    System.out.println("No se puede ingresar otro tipo de dato");
                                                
                                                }finally{
                                                
                                                
                                                
                                                    System.out.println("Gracias!");
                                                
                                                }
                                            
                                                
                                            while(rol == null){
                                                try{


                                                    System.out.println("Eliga el rol : ADMIN o USUARIO a modificar");
                                                    rol = Rol.valueOf(scan.nextLine().trim().toUpperCase());


                                                }catch(IllegalArgumentException e){

                                                    System.out.println("Rol invalido intente nuevamente");


                                                }




                                            }
                                            
                                            for (Usuario usuario: usuarios) {
                                                    
                                                    if(usuario.getId() == id && !usuario.isEliminado()){
                                                        
                                                        
                                                                    
                                                                    
                                                                        
                                                                        usuario.setRol(rol);
                                                                            
                                                                        if(!nombre.isEmpty()){
                                                                               
                                                                                
                                                                                
                                                                                    usuario.setNombre(nombre);
                                                                                    System.out.println("Operacion confirmada");
         
                                                                                            
                                                                           }
                                                                        if(!apellido.isEmpty()){
                                                                               
                                                                                
                                                                                
                                                                                    usuario.setApellido(apellido);
                                                                                    System.out.println("Operacion confirmada");
         
                                                                                            
                                                                           }
                                                                        if(!mail.isEmpty()){
                                                                            
                                                                            if(!mail.equals(usuario.getMail())){
                                                                            
                                                                                usuario.setMail(mail);
                                                                                System.out.println("Operacion confirmada");
                                                                            
                                                                            
                                                                            }else{
                                                                            
                                                                                System.out.println("No se puede ingresar dos veces el mismo mail");
                                                                            
                                                                            }
                                                                               
                                                                                
                                                                                
                                                                                    
                                                                                            
                                                                           }
                                                                        if(!contrasenia.isEmpty()){
                                                                               
                                                                                
                                                                                
                                                                                    usuario.setContrasenia(contrasenia);
                                                                                    System.out.println("Operacion confirmada");
         
                                                                                            
                                                                           }
                                                                        
                                                                        if(!cel.isEmpty()){
                                                                               
                                                                                
                                                                                
                                                                                    usuario.setCelular(cel);
                                                                                    System.out.println("Operacion confirmada");
         
                                                                                            
                                                                                }
                                                                        
                                                                
                                                                          
                                                                               
                                                                            }else if(usuario.isEliminado()){
                                                                            
                                                                            
                                                                                System.out.println("Usuario eliminado");
                                                                            
                                                                            
                                                                            }else{
                                                                            
                                                                            
                                                                                System.out.println("No existe el usuario");
                                                                            
                                                                            }     
                                                                          
                                                               
                                                                       
                                                            
                                                                        }
    
        
    
    }
    
    
    
    
    public void eliminar(){
        
        
          String opcion;
                                                    String confirmado = "S";
                                                    long id;
                                    
                                    
                                                    System.out.println("Ingrese id del usuario a eliminar");
                                                    id = Long.parseLong(scan.nextLine());
                                                    System.out.println("¿Dese eliminar realmente? Ingrese S/N");
                                                    opcion = scan.nextLine().trim().toUpperCase();
                                                    if(confirmado.equals(opcion)){

                                                        for (Usuario usuario: usuarios) {
                                                            if(usuario.getId() == id){

                                                                usuario.setEliminado(true);

                                                                }
                                              
                                        
                                                        }
                                    
                                                    }
    
    
        
    
    }
    
    
}
