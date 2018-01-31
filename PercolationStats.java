import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats{
    
      private int N;
      private int T;
      private Percolation pr;
      private double[] results;
      
      public PercolationStats(int N, int T) 
       {  
         if( N < 0 || T  <=0 ) 
         {
                 throw new IllegalArgumentException("wrong arguments");
         }
         
         this.N = N;
         this.T = T;
         results = new double[T];

         for (int k = 0; k < T; k++ )
         {
                pr = new Percolation(N);
                 int openedSites = 0;
                     while(!pr.percolates()) {
                         
                          int i =StdRandom.uniform(1, N+1);
                          int j =StdRandom.uniform(1, N+1);
                          if(!pr.isOpen(i, j) )
                          {
                               pr.open(i, j);
                              openedSites = pr.numberOfOpenSites();
                          }
              }
                     
                double result =(double) openedSites  /(N*N);
                 results[k] = result; 
                
         }
         
     }
     
     public double mean(){ //sample mean od percolation threshold
           return StdStats.mean(results);
     }  
     
     public double stddev(){ // sample standard deviation of percolatopn threshold
           return  StdStats.stddev(results);
     }
     
     public double confidenceLo() { //low endpiont of 95% confidence intercal
      
               return mean() - ((1.96 * stddev()) / Math.sqrt(T));
     }   
     
     public double confidenceHi() {//high endpoint of 95% confidence interval
               return mean() + ((1.96 * stddev()) / Math.sqrt(T));
     
     }
     
    
      public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        int T = Integer.parseInt(args[1]);
        PercolationStats ps = new PercolationStats(N, T);

        String confidence = ps.confidenceLo() + ", " + ps.confidenceHi();
        System.out.println("mean                    = " + ps.mean());
        System.out.println("stddev                  = " + ps.stddev());
       System.out.println("95% confidence interval = " + confidence);
    }
     
     
}
