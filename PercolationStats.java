import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
    
      private int n;
      private int t;
      private Percolation pr;
      private double[] results;
      
      public PercolationStats(int n, int t) {     
          
         if (n < 0 || t  <=0) {        
            throw new IllegalArgumentException("wrong arguments");     
            
     }
         
         this.n = n;
         this.t = t;
         results = new double[t];

         for (int k = 0; k < t; k++) {
             
                 pr = new Percolation(n);
                 int openedSites = 0;
                 
                     while (!pr.percolates()) {                
                          int i =StdRandom.uniform(1, n+1);
                          int j =StdRandom.uniform(1, n+1);
                          
                          if (!pr.isOpen(i, j)) {
                              pr.open(i, j);
                              openedSites++;
                          }
              }
                     
                double result = (double) openedSites /(n*n);
                 results[k] = result; 
                
         }
         
     }
     
     public double mean() {  // sample mean od percolation threshold   
         
          return StdStats.mean(results);        
     }  
     
     public double stddev() {  // sample standard deviation of percolatopn threshold
      
          return  StdStats.stddev(results);
     }
     
     public double confidenceLo() { // low endpiont of 95% confidence intercal
      
              return mean() - ((1.96 * stddev()) / Math.sqrt(t));
     }   
     
     public double confidenceHi() { // high endpoint of 95% confidence interval
      
            return mean() + ((1.96 * stddev()) / Math.sqrt(t));
     }
     
    
      public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int t = Integer.parseInt(args[1]);
        PercolationStats ps = new PercolationStats(n, t);

        String confidence = ps.confidenceLo() + ", " + ps.confidenceHi();
        System.out.println("mean                    = " + ps.mean());
        System.out.println("stddev                  = " + ps.stddev());
        System.out.println("95% confidence interval = " + confidence);
     }
     
     
}
