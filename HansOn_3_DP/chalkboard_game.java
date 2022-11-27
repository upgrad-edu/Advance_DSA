class Chalkboard_game {
  
  Boolean [] dp = new Boolean[1001];
  
  public boolean divisorGame(int n) {
  
    if(n==1)
      return false;
    
    for(int i=1; i<n; i++){
    
      if(n%i==0){
    
        if(dp[i]!=null)
          return dp[i];
    
        if(!divisorGame(n-i)){
            dp[i] = true;
            return true;
    
        } 
    
      } 
    
    }
    
    return false;
  
  }
}