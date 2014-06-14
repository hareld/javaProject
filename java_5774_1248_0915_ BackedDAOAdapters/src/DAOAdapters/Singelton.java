/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAOAdapters;

/**
 *
 * @author dell
 */
//public class Singelton extends IBackend_DAO_List_impl{
   public class Singelton extends Java_5774_1248_0915_BackedDAOAdapters{
        private static Singelton mySingelton = null;

        protected Singelton() throws Exception{
           // Exists only to defeat instantiation.
        }

         /**
          *
          * @return
          * @throws java.lang.Exception

          */
         public static Singelton getMySingelton() throws Exception{
           if(mySingelton == null) {
              mySingelton = new Singelton();
           }
           return mySingelton;
        }
    
}

