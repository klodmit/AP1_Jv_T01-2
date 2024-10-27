package org.example;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        Scanner sc = new Scanner(System.in);
        int flag = 0;
        while (true){
            try {
                int n = sc.nextInt();
                if(n<=0){
                    System.out.println("Input error. Size <= 0");
                } else{
                    int[] nums = new int[n];
                    int sum = 0;
                    int k = 0;
                    for(int i = 0; i < n; i++){
                        nums[i] = sc.nextInt();
                        if(nums[i]<0){
                            sum+=nums[i];
                            k++;
                        }
                    }
                    System.out.println(sum/k);
                }
                break;
            } catch (InputMismatchException e){
                System.out.println("Couldn't parse a number. Please, try again");
                sc.nextLine();
            } catch (ArithmeticException e){
                System.out.println("There are no negative elements");
                break;
            }
        }
    }
}