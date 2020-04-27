/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package courrierselectronique;

/**
 *
 * @author aliba
 */
public class User {
    
    private String objet ;
    private String message ;
    
    
     public User (String vObjet,String vMessage){
     
     objet=vObjet ;
     message=vMessage ;
     }
     
    public String getMessage() {return message;}
    public String getObjet() {return objet ;}
    
}
