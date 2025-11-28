package com.azahartech.eventdev.extras.semana9;

public class AlertaNumerosPares {
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            System.out.println((i%2 == 0) ? (i + " *") : i);

            /*
            if(i%2==0){
                System.out.println(i+" *");
            }else {
                System.out.println(i);
            }
             */
        }

    }
}
