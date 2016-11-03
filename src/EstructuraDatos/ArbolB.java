/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates sfserfersfer
 * and open the template in the editor.
 */
package EstructuraDatos;

/**
 *
 * @author leider
 */
public class ArbolB<T extends Comparable> {
    private T raiz;
    private ArbolB<T> izq, der;
    private boolean visitado;
   public ArbolB(){
       raiz=null;
       izq=der=null;
   }
   public boolean vacia(){
        return raiz==null;
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
        visitado=false;
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
   public void visitar(){
       visitado=true;
   }
   public boolean estaVisitado(){
       return visitado;
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
   public void busquedaProfundidad(ArbolB<T>arbolProblema){
       
   }
    
}
