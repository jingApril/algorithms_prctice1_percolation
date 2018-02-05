import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

    private boolean[][] grid;
    private final int size;
    private int top;
    private int bottom;
    private WeightedQuickUnionUF uf;
    private WeightedQuickUnionUF fulluf;
    private int opened;
   
    public Percolation(int n) { // create N-by-N grid, with all sites blocked
       
            size = n;
            top = 0;
            opened = 0;
            bottom = n * n + 1;
            grid = new boolean[n][n];
            uf = new WeightedQuickUnionUF(n*n + 2);
            fulluf = new WeightedQuickUnionUF(n*n + 1);
            
            for (int i = 0;  i < size; i++)  {                
                for (int j = 0; j < size; j++)  {
                grid[i][j] = false;  
                }      
            }       
            
    }
      
    public void open(int i, int j) {   // open site (row i, column j) if it is not already  
         
        if (!grid[i-1][j-1]) {
           grid[i-1][j-1] = true;  
            opened++;
        }
           
        if (i == 1 && isOpen(i, j)) {
           uf.union(xyTo1D(i, j), top);
           fulluf.union(xyTo1D(i, j), top);
        } 

        if (i == size && isOpen(i, j)) {
           uf.union(xyTo1D(i, j), bottom);
        } 
          
        if (i > 1  &&  isOpen(i-1, j)) { // left

            uf.union(xyTo1D(i, j), xyTo1D(i-1, j));
            fulluf.union(xyTo1D(i, j), xyTo1D(i-1, j));
        }
           
        if (i < size   &&  isOpen(i+1,  j)) { // right
           
            uf.union(xyTo1D(i, j),  xyTo1D(i+1,  j));
            fulluf.union(xyTo1D(i, j),  xyTo1D(i+1,  j));
        }
           
        if (j > 1  &&  isOpen(i, j-1)) { // top
           
            uf.union(xyTo1D(i, j),  xyTo1D(i,  j-1));
            fulluf.union(xyTo1D(i, j),  xyTo1D(i,  j-1));
        }
            
        if (j <  size  &&  isOpen(i, j+1)) { // bottom
            
            uf.union(xyTo1D(i, j),  xyTo1D(i, j+1));
            fulluf.union(xyTo1D(i, j),  xyTo1D(i, j+1));
        }  
        
    }
      
    public boolean isOpen(int row, int col) { // open site(row, col) if it is not open already    
          
        if (row <= 0 || row  > size || col  <= 0 || col  > size)  throw  new IndexOutOfBoundsException(" Invalid arguments");

         return grid[row-1][col-1];     
                          
    }
      
       
    public boolean isFull(int row, int col) { // is site(row, col) open?
         
        if (row <= 0 || row  > size || col  <= 0 || col  > size) throw  new IndexOutOfBoundsException(" Invalid arguments");
        if (isOpen(row, col))  return fulluf.connected(xyTo1D(row, col), top);
        return false;
            
    }
                 
    public int numberOfOpenSites() {
         return opened;
    }

    private int xyTo1D(int row, int col) {   
        return (row-1) * size + col;       
    }
      
      
    public boolean percolates() {  
        return uf.connected(top, bottom);    
    }
    
    // public static void main(String[] args) {
        
    // }
     
}