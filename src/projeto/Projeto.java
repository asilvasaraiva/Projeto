/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projeto;

import java.util.Random;

/**
 *
 * @author SAA
 */
public class Projeto {

    
    public static void main(String[] args) {
        Random gerador = new Random();
        //int value = gerador.nextInt(10);
        float[][] A = new float [800][600];
        long tempoInicio = System.currentTimeMillis();  // start of time meter
        
        for (int i = 0;i<A.length; i++){
            for (int j = 0; j<A[0].length; j++){
                A[i][j] = gerador.nextInt(200);    // Teste para a média da Matriz     
                //System.out.println(A[i][j]);
            }
        }       
        
        long tempoFim = System.currentTimeMillis(); //end of time meter  
        long TotalTime = tempoFim - tempoInicio;
        
        //System.out.println(Math.pow(3, 3));
        tempoInicio = System.currentTimeMillis(); //end of time meter  
 
        System.out.println("Total elapsed time in milliseconds : "+TotalTime);
        System.out.println("The arithmetic mean of the main matrix is: "+features.mean(A)+" tempo: "+ (System.currentTimeMillis()-tempoInicio)); //result without zero counter
        System.out.println("The arithmetic mean of the matrix without zero counter is: "+features.mean(A,true)); //result with zero counter
       // System.out.println("the variance is : "+features.standardDeviation(A));
        System.out.println("the variance with zero is: "+ features.variance(A));
        System.out.println("the varianze whitout zero is :"+ features.variance(A, true));
        System.out.println("the standard with zero is : "+ features.standardDeviation(A));
        System.out.println("the standard without zero is: "+ features.standardDeviation(A, true));
        System.out.println("the maximun is: "+ features.maximum(A));
        System.out.println("The maximum without zero is : "+ features.maximum(A, true));
        System.out.println("The minimum is: "+ features.minimum(A));
        System.out.println("The minimum without zero is: "+ features.minimum(A, true));
        
        System.out.println("A mediana é :"+features.median(A));
        
        tempoInicio = System.currentTimeMillis(); //end of time meter  
        features.
        System.out.println(" A moda é: "+ features.mode(A)+" tempo: "+ (System.currentTimeMillis()-tempoInicio));
        
    }
    
}
