

 

package projeto;
  /** This Class test is reference to JavaDoc
 * @author Alexsandro da Silva Saraiva
 * @version Beta
 *
 */
    


public class features {
 
   
   /** This function averaging of the matrix making the sum of 
     * values ​​of all elements and dividing by the total number of elements.
     * @param float[][] pixels
     * @return A float value with the  mean of th matrix
     */    
    public static float mean(float[][] pixels){       
        int bufferPlus = 0;
        float result;
        int rows = pixels.length;
        int columns = pixels[0].length;
        int numberOfElements = rows * columns;
        for(int i = 0; i< rows; i++)
        {
           for(int j = 0; j<columns; j++ )
            {
                bufferPlus +=  pixels[i][j];                
            }           
        }        
        result = bufferPlus / numberOfElements;     
        return result;
    }
    
    /* If this option is enable, the number zero isn't count in the mean*/
    public static float mean(float[][] pixels, boolean noZeroCount){       
        float bufferPlus = 0;
        float result;
        int rows = pixels.length;
        int columns = pixels[0].length;
        int numberOfElements = rows * columns;
        for(int i = 0; i< rows; i++)
        {
           for(int j = 0; j<columns; j++ )
            {
                if(noZeroCount && pixels[i][j]!= 0)
                 {
                    bufferPlus = bufferPlus + pixels[i][j];                 
                 }
                else
                {
                   // System.out.println("O Elemento "+i+ j+" é zero");
                    numberOfElements--;
                }
            }           
        }
        result = bufferPlus / numberOfElements;  
        return result;
    }
    
    
    public static float variance(float[][] pixels){
        int result;
        float meanOfMatrix = features.mean(pixels);
        int plusResult = 0;
        int rows = pixels.length;
        int columns = pixels[0].length;
        int numberOfElements = rows * columns; 
        for (int i = 0; i< rows; i++){
            for (int j = 0; j< columns; j++){
                plusResult = (int) (plusResult + Math.pow((pixels[i][j] - meanOfMatrix),2));                
            }
        }        
        result = plusResult/numberOfElements;        
        return result;
    }
    
    public static float variance(float[][] pixels, boolean noZeroCount){
        float result;
        float meanOfMatrix = features.mean(pixels,true);
        int bufferTempResult = 0;
        int rows = pixels.length;
        int columns = pixels[0].length;
        int numberOfElements = rows * columns; 
        for (int i = 0; i< rows; i++){
            for (int j = 0; j< columns; j++){
                if(noZeroCount){
                    bufferTempResult = (int) (bufferTempResult + Math.pow((pixels[i][j] - meanOfMatrix),2));                
                }
            }
        }        
        result = bufferTempResult/numberOfElements;        
        return result;
    }
    
    public static float standardDeviation(float[][] pixels){
        float result;
        float variance = features.variance(pixels);
        result = (float) Math.sqrt(variance);
        return result; 
    }
    
     public static float standardDeviation(float[][] pixels, boolean noZeroCounter){        
        float variance = features.variance(pixels, true);
        int result = (int)(float)Math.sqrt(variance);
        return result; 
    }
     
     public static float maximum(float[][] pixels){
        float result, buffer = pixels[0][0];
        int rows = pixels.length;
        int columns = pixels[0].length;
        
        for (int i = 0; i< rows; i++)
        {
            for (int j = 0; j< columns; j++)
            {
                if(buffer < pixels[i][j])
                {
                    buffer = pixels[i][j];
                }              
            }            
        }
        result = buffer;         
         return result;
     }
     
     public static float maximum(float[][] pixels,boolean noZeroCounter){
        float result, buffer = pixels[0][0];
        int rows = pixels.length;
        int columns = pixels[0].length;
        
        for (int i = 0; i< rows; i++)
        {
            for (int j = 0; j< columns; j++)
            {
                if(pixels[i][j] != 0 && buffer < pixels[i][j])
                {
                    buffer = pixels[i][j];
                }              
            }            
        }
        result = buffer;         
         return result;
     }
     
     public static float minimum(float[][] pixels){
        float result, buffer = pixels[0][0];
        int rows = pixels.length;
        int columns = pixels[0].length;
        
        for (int i = 0; i< rows; i++)
        {
            for (int j = 0; j< columns; j++)
            {
                if(buffer > pixels[i][j])
                {
                    buffer = pixels[i][j];
                }              
            }            
        }
        result = buffer;         
         return result;
     }
     
     public static float minimum(float[][] pixels,boolean noZeroCounter){
        float result, buffer = pixels[0][0];
        int rows = pixels.length;
        int columns = pixels[0].length;
        
        for (int i = 0; i< rows; i++)
        {
            for (int j = 0; j< columns; j++)
            {
                if(pixels[i][j] != 0 && buffer > pixels[i][j])
                {
                    buffer = pixels[i][j];
                }              
            }            
        }
        result = buffer;         
         return result;
     }
     
     public static float range(float[][] pixels){
         float result = features.maximum(pixels) - features.minimum(pixels);
         return result;
     }   
     
    public static float range(float[][] pixels,boolean noZeroCounter){
        float result = features.maximum(pixels,true) - features.minimum(pixels,true);
         return result;
     }
    
   /*public static float mode(float[][] pixels){
    float result = 0;
    int n = 0;
    int rows = pixels.length;
    int columns = pixels[0].length;
    float[] vector = new float[columns* rows];
	for(int i = 0; i < rows; i++)
	{		
		for(int j = 0; j < columns; j++)
		{			
			vector[n] = pixels[i][j];
			n++;
		}
	}
   return result;
   }*/
   
   public static float median(float[][] pixels){
         float result;                
         int n = 0;
         int rows = pixels.length;
         int columns = pixels[0].length;
         int numberOfElements = columns* rows;
         float[] vector = new float[numberOfElements];
         
         /*Changing the matrix for vector*/
	for(int i = 0; i < rows; i++)
            {		
		for(int j = 0; j < columns; j++)
		{			
                    vector[n] = pixels[i][j];
                    n++;
		}
            }
        
        /*Ordering the vector*/
          quickSort(vector,0,vector.length-1);
        
         result = vector[numberOfElements/2];
         return result;
     } 
      
   /** This function receive one matrix of image like  parameters 
    * 
    * return the Mode of matrix*/
   public static float mode(float[][] pixels){        
        int rows = pixels.length;
        int columns = pixels[0].length;
        int result;
        int indexOfVector = 0;
        float big = 0;
        int pos = 0;
        float min =  features.minimum(pixels);
        float max =  features.maximum(pixels);
        int numOfElements = (int) (max - min);
        float[] vectorPixels = new float[rows* columns];
        float[] vector = new float[numOfElements + 1];        
        /*This loop turn the matrix in vector*/
        for(int i = 0; i < rows; i++) 
            {		
		for(int j = 0; j < columns; j++)
		{			
                    vectorPixels[indexOfVector] = pixels[i][j];
                    indexOfVector++;
		}
            }   
        /*This loop increments the index of vector*/
        /*for(int i = 0; i< vector.length;i++){            
            for(int j = 0; j< vectorPixels.length;j++)
            {              
                if( i == vectorPixels[j]){
                    vector[i]++;                    
                }                 
            }
        } */
        
        //for(int i = 0; i< vector.length;i++){   
        int k;
            for(int j = 0; j< vectorPixels.length;j++)
            {              
                k = (int)(vectorPixels[j] - min);
                vector[k]++;                    
                //}                 
            }
        //}
        
        
        /*Show the number and the times that it appears*/
        //for(int i = 0; i< vector.length; i++){
        //   System.out.println("O numero "+i+" se repetiu :"+vector[i]+" vezes");
        //}      
        /* This loop make the comparison of index and the number of repetitions and returns the number more repeated */
       for(int i = 0; i< vector.length; i++)
       {
           if(vector[i]> big){
               big = vector[i];
               pos = i;             
           }
       }                     
       result = pos;       
       return result + min;        
    }
   
   
   
   //--------Extra Functions for order Vector----------//
    @SuppressWarnings("empty-statement")
 public static int partition(float arr[], int left, int right){
     int i = left, j = right;
     float tmp;
     float pivot = arr[(left + right) / 2];
     
      while (i <= j) {
            while (arr[i] < pivot)
                  i++;
            while (arr[j] > pivot)
                  j--;
            if (i <= j) {
                  tmp = arr[i];
                  arr[i] = arr[j];
                  arr[j] = tmp;
                  i++;
                  j--;
            }
      };     
      return i;
} 
 public static void quickSort(float arr[], int left, int right) {
      int index = partition(arr, left, right);
      if (left < index - 1)
            quickSort(arr, left, (index - 1));
      if (index < right)
            quickSort(arr, index, right);
}
 //-------End extra Functions for order Vector--------//
 
}
