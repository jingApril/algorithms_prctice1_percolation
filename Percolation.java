import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation{
    
      private int[][] grid;
      private int n;
      private int[] size;
      private WeightedQuickUnionUF unionInstance;
      private final int BLOCKED = -1;
      private final int OPENED = 0;
      private final int FULL_OPENED = 1;
      
      public Percolation(int n)  { //create n-by-n grind, with all sites clocked
    
             this.n = n;
             grid = new int[n][n];
             for(int row = 0;  row < n; row ++) {
                   for(int col = 0; col <n; col ++) {
                         grid[row][col] = BLCOKED;
                   }
             }       
             unionInstance  = new  WeightedQuickUnionUF(n^2 + 2);
      }
      
      public  void open(int row, int col) { //open site(row, col) if it is not open already
          
             row = StdRandom.uniform(n-1);
             col = StdRandom.uniform(n-1);
            while ( grid[row][col]==BLCOKED) {
                grid[row][col] = OPENED;
            }
      
      }
      public boolean isOpen(int row, int col) //open site(row, col) if it is not open already    
      {      
              if(row < 0 || row > n || col < 0 || col > n)   throw new IllegalException(" Invalid arguments");
              return (grid[row][col] == OPEND ? true : false );      
      }
      
      public boolean isFull(int row, int col) // is site(row, col) open?
      {
            if(row < 0 || row > n || col < 0 || col > n)   throw new IllegalException(" Invalid arguments");
            return (grid[row][col] == FULLY_OPENED ? true : false );
            return weightedQuickUnionUF.connected(xyTo1D(row, col), xyTo1D(row+1, col));
      }
      
      private int xyTo1D(int row, int col) {
           return row*n + col;
      }
      
      public int numberOfOpenSites() {
          int opened = 0;
          for( int row = 0;  row < n;  row++) {
              for(int col = 0;  col < n;  col++) {
                   if(isOpen(row, col)){
                      opened ++;
                  }
               }
         }
          return opened;
      }
      
    public boolean percolates() {
       return unionInstance.connected(0, n* n+1);
    }
    

      
    public static void main(String[] args) {
      
      
      }
     
}