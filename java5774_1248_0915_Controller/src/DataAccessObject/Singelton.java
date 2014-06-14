/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DataAccessObject;

/**
 * @author dell
 */
// this singelton inherit the controller ONLY ONCE (static)
public class Singelton extends Controller{
    private static Singelton mySingelton = null;

    protected Singelton() throws Exception{
       // Exists only to defeat instantiation.
    }

    // cgeck if the singelton already exist
    public static Singelton getMySingelton() throws Exception{
       if(mySingelton == null) {
          mySingelton = new Singelton();
       }
       return mySingelton;
    }
}