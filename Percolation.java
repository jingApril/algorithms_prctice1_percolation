import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;


public class Percolation{
    
      public Percolation(int n) //create n-by-n grind, with all sites clocked
      {
        

      }
          
      public void open(int row, int col) //open site(row, col) if it is not open already
      public boolean isOpen(int row, int col) // is site(row, col) open?
      {
       if(row <=0 || row > N || col < 0 || col > N) 
         throw new IllegalException(" Invalid arguments");
         return grid(row,col);
       
      }
      public boolean isFull(int row, int col) // is site (row,col) full?
      {
          if(row <=0 || row > N || col < 0 || col > N) 
              throw new IllegalException(" Invalid arguments");
          return weightedQuickUnionUF.connected(xyTo1D(row, col),xyTo1D(row-1,col));
              
      }
      public int xyTo1D(int row, int col) {
       return (row-1)*N + (col-1);
      }
      public     int numberOfOpenSites() // number of open sites
      public boolean percolates() // does the system percolste?
      
      public static void main(String[] args) {
      
      
      }
     
}