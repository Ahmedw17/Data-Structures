public class Lab01 {
    
    public static void main(String[] args) {
     int [] array1 = {1,2,3,4,5,6};
     int [][] array2 = { {9,8,7,6} , {5,4,3,2} ,{1,10,11,12} };
    
    int maxValue = array1[0];
    for(int x :array1)
         if(x > maxValue )
         maxValue = x;
         System.out.println("the max value is = " + maxValue);
         
    int maxValue2 = array2[0][0];
    for(int [] row :array2)
            for(int x : row)
         if( x > maxValue )
         maxValue = x;
         System.out.println("the max value is = " + maxValue);
        
        
       int minValue = array1[0];
    for(int x :array1)
         if(x < minValue )
         minValue = x;
         System.out.println("tthe min value is = " + minValue);
        
         
       int minValue2 = array2[0][0];
    for(int [] row :array2)
            for(int x : row)
         if( x < minValue )
         minValue = x;
         System.out.println("the min value is = " + minValue);  
         
         for(int y :array1)
             System.out.print((y * y)+" ");
         System.out.print(" "); 
         for(int [] row : array2)
             for(int y : row)
                 System.out.print((y * y)+" ");
                 
         
    }
    
}
