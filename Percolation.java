import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation{
    
      private boolean[][] grid;
      //private int top = 0;
      //private int bottom ;
      private int size;
      private WeightedQuickUnionUF uf;
   
      public Percolation(int n)  {   // create N-by-N grid, with all sites blocked
             
             size = n;
            // bottom = size*size;
             grid = new boolean[n][n];
             uf  = new  WeightedQuickUnionUF((n*n));
             
             for(int row = 1;  row <= n; row ++) 
             {
                  
                 for(int col = 1; col <= n; col ++) 
                   
                 {
                         grid[row][col] = false;  
                 }
                 
             }       
             
      }
      
      public  void open(int i, int j) {   // open site (row i, column j) if it is not already
         
              grid[i][j] = true;
              
              if(  i  >=1  &&  isOpen(i-1,j)  ) //left
               {
                 uf.union( to1D(i, j),  to1D(i -1,j) );
               }
               if(i  <  size -1  &&  isOpen(i+1,j)) //right
               {
                   uf.union( to1D(i,j),   to1D(i+1,j) );
               }
               if(j  >= 1  &&  isOpen(i,j-1)) //up
               {
                  uf.union( to1D(i,j),   to1D(i, j-1) );
               }
               
                if(j  <=size -1  &&  isOpen(i,j+1)) //down
                {
                  uf.union( to1D(i,j),   to1D(i,j+1) );
               }    

      }
      
      public boolean isOpen(int row, int col) //open site(row, col) if it is not open already    
      {      
               if(row < 1 || row  > size || col  < 1 || col  >  size)  throw  new IndexOutOfBoundsException(" Invalid arguments");
               return grid[row][col];    
       }
      
       
      public boolean isFull(int row, int col) // is site(row, col) open?
      {
            if(row < 1 || row > size || col < 1 || col > size)  throw  new IndexOutOfBoundsException(" Invalid arguments");
            
            if(isOpen(row,col))
            {
                 for(int i = 1; i < size+1; i ++) 
                   {
                       return uf.connected(to1D(row, col), i );
                   }    
            }
            return false;
      }
      
      
      
      private int to1D(int row, int col) {
           return (row-1)*size + col-1;
      }
      
      
      
      public int numberOfOpenSites() {
          int opened = 0;
          for( int row = 1;  row <= size;  row++) {
              for(int col = 1;  col <= size;  col++) {
                   if(isOpen(row, col)){
                      return opened ++;
                  }
               }
         }
          return opened;
      }
        
    public boolean percolates() {     
              for(int i = 1; i <=  size; i ++) 
                {          
                         for(int j = 1; j <=  size; j ++) 
                         {
                         return   isFull ( to1D(1, i) ,  to1D(size, j) );
                         }
                  } 
             return false;
    }
    
   // public static void main(String[] args) {
        
     //}
     
}