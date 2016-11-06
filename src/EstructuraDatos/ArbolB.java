/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates sfserfersfer
 * and open the template in the editor.  vvvv
 */
package EstructuraDatos;

/**
 *
 * @author leider
 */
public class ArbolB<T extends Comparable> {
    private T raiz;
    private ArbolB<T> izq, der;
    int nivelRes;
    boolean encontrado=false;
    String timeB;
   public ArbolB(){
       raiz=null;
       izq=der=null;
       nivelRes=-1;
   }
   public boolean vacia(){
        return raiz==null;
   }
   public void setEncontrado(){
       encontrado=true;
   }
   public boolean getEncontrado(){
       return encontrado;
   }
   public String getTimeB(){
       return timeB;
   }
   public int getNivelRes(){
       return nivelRes;
    }
   public void setNivelRes(int n){
       nivelRes=n;
    }

   public void insertarAmp(T d){
        Cola<ArbolB<T>>c;
        c=new Cola<ArbolB<T>>();
        c.encolar(this);
        insertarAmp(d, c);
   }
   private void insertarAmp(T d, Cola<ArbolB<T>>c){
        ArbolB<T>arb;
        arb=c.decolar();
        if(arb.vacia()){
            arb.raiz=d;
            arb.izq=new ArbolB<T>();
            arb.der=new ArbolB<T>();
        }else{
            c.encolar(arb.izq);
            c.encolar(arb.der);
            insertarAmp(d, c);
        }
   }
   public int profundidad(){
       return profundidad(0);
   }
   private int profundidad(int index){
       int indexx=index;
       if(raiz!=null){
           indexx+=1;
           indexx=izq.profundidad(indexx);
       }
       return indexx;
   }
   public T eliminar(T d){
        T res=null;
        if(!vacia()){
            if(raiz.equals(d)){
                if(raizHoja()){
                    res=raiz;
                    raiz=null;
                    izq=der=null;
                }
            }else{
                res=izq.eliminar(d);
                if(res==null){
                    res=der.eliminar(d);
                }
            }
        }
        return res;
   }
   private boolean raizHoja(){
        return izq.vacia() && der.vacia();
   }
   public int nroHojas(){
        int res = 0;
        if(!vacia()){
            if(raizHoja()){
                res=1;
            }else{
                res=izq.nroHojas()+der.nroHojas();
            }
        }
        return res;
   }
   
   //public boolean busquedaProfundidad(ArbolB<T>arbolProblema, T dato){
     //  return busquedaProfundidad(arbolProblema, dato, false);
   //}
   //public boolean busquedaProfundidad(ArbolB<T>arbolProblema, T dato, boolean bandera){
     //  boolean res=bandera;
       //if(arbolProblema.raiz!=null){
         //  if(arbolProblema.raiz==dato){
           //     res=true;
           
            //}else{
              //  res=busquedaProfundidad(arbolProblema.izq, dato, bandera);
                //res=busquedaProfundidad(arbolProblema.der, dato, bandera);
           
       //}
       //}
       //return res;
   //}
   public boolean busquedaProfundidad(T dato){
       return busquedaProfundidad( dato, false);
   }
   private boolean busquedaProfundidad( T dato, boolean bandera){
       long startTime = System.currentTimeMillis(); 
       boolean res=bandera;
       if(raiz!=null){
           if(raiz.equals(dato)){
                res=true;
                long endTime = System.currentTimeMillis();
                System.out.println(endTime-startTime);
                timeB=""+(endTime-startTime);
                
                //System.out.println(res);
           
            }else{
                res=izq.busquedaProfundidad(dato, res);
                res=der.busquedaProfundidad(dato, res);
           
       }
       }
       //System.out.println(res);
       return res;
   }
    
   
   public int nivelResult(T dato){
       int res=nivelResult( dato, -1);
       return  res;
   }
   private int nivelResult( T dato, int index){
       int res=index;
       if(raiz!=null){       
           if(!raiz.equals(dato)){
               if (!izq.vacia()) {
                    res=izq.nivelResult(dato, res+1);
                    System.out.println("***/"+izq.raiz+"/***");
                    if(!izq.busquedaProfundidad(dato)){
                        res=der.nivelResult(dato, res);                        
                        if(!der.busquedaProfundidad(dato)){
                            res=res-1;
                        }
                    }                   
               }                                            
            }else{
               res=res+1;
               System.out.println("--->"+res);               
           }
       }
       System.out.println("**"+res+"**");
       return res;
   }
}
