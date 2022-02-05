package javaPratice;

import dataStructuresPractice.arrays.mockInterviews.IntegerToRoman;

import java.util.*;

public class MorganStanleyProblem {
    public static void main(String[] args) {
        List<List<Integer>> result = findPrime(28, 3, 2);
        for(List<Integer> list : result){
            list.stream().forEach(item -> System.out.print(item + " "));
            System.out.println();
        }
    }

// 3 inputs : n, p, s
// p = prime number
// s = any number , greater than prime number
// n = count of numbers I can use to create s
// find
// p = 7, n = 2 -> 2 numbers after 7, s = 28
//{11, 17, 23},  11+18 = 28
// p = 3, s = 28, n = 2 -> {23+5, 11+17}

//find all the prime numbers till s - nums
// map.containsKey(target - nums[i]){
// return nums[i] & map.get(arget - nums[i])

  private static  List<List<Integer>> findPrime(int s, int p, int n) {
      //Map<Integer, Boolean> primeNumbers = new HashMap<>();
      List<Integer> listOfPrimes = new ArrayList<>();
      List<List<Integer>> result = new ArrayList<>();
      for (int i = p; i < s; i++) {
          if (isPrime(p)) {
              listOfPrimes.add(p);
          }
      }

      for(int i=0; i<listOfPrimes.size(); i++) {

          int j=i+n-1;
          int sum = 0;
          while(i < listOfPrimes.size() && j < listOfPrimes.size() && i <= j) {
                sum = sum + listOfPrimes.get(i);
                i++;
          }
          if(sum == s) {
              List<Integer> listOfNumbers = new ArrayList<>();
              for(int k= i; k<j; k++) {
                  listOfNumbers.add(listOfPrimes.get(k));
              }
              result.add(listOfNumbers);
          }
      }
      return result;
  }

  private static boolean isPrime(int n){
    for(int i=2; i*i<=n; i++){
        if(n % i == 0){
            return false;
        }
    }
   return false;
}
}