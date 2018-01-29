import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class PercolationStats{
    
     public PercolationStats(int n, int trials) 
     {
         if( n< 0 || trials  <=0) 
         {
             throw new IllegalArgumentException("wrong arguments");
         }
         
         this.trials = trials;
         trialResults = new double[trials];
         int cellCount = n * n;
         
         final double[] results = new double[trials];
         
         
         for (int i = 0; i < cellCount; i++ )
         {
             cellIndices[i] =i
         }
         
         for (int i = 0; i < trials; i++ )
         {
             final Percolation percolation = new Percolation(n);
         }
         
         while(!percolation.percolates()) {
             final int row =StdRandom.uniform(1, n);
             final int col =StdRamdom.uniform(1, n);
             percolation.open(row, col);
         }
         
         results[i] = (double) percolation.numberOfOpenSites()/n *n;
         
     }
     
     public double mean(){ //sample mean od percolation threshold
       mean =StdStds.mean(results);
     }  
     
     public double stddev(){ // sample standard deviation of percolatopn threshold
       stdDevistion = StdStats.stddev(results);
     }
     
     public double confidenceLo() { //low endpiont of 95% confidence intercal
      
     return 0;
     }   
     
     public double confidenceHi() {//high endpoint of 95% confidence interval
     return 0;
     
     }
     
     public static void main(String[] args) //test client (described below)
     {
     int n = Integer.parseInt(args[0]);
     }
}
