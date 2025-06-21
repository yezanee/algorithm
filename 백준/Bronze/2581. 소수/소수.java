import java.util.*;

class Main {
  public static void main(String[] args)  {

      Scanner sc = new Scanner(System.in);

      long M = sc.nextLong();
      long N = sc.nextLong();

      long sum = 0;
      long minPrime = -1;
      boolean isFirst = true;

      for(long i = M; i <= N; i++) {
        if(isPrime(i) && isFirst == true) {
          sum += i;
          minPrime = i;
          isFirst = false;
        } else if (isPrime(i) && isFirst == false) {
          sum += i;
        }
      }
      
      if (minPrime > 0) {
        System.out.println(sum);
        System.out.println(minPrime);
      } else {
        System.out.println(minPrime);
      }
  }

  private static boolean isPrime(long num) {
    if (num < 2) return false;
    
    for(int i = 2; i <= Math.sqrt(num); i++) {
      if (num % i == 0) return false;
    }

    return true;
  }
}