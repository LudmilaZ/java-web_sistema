package controllers;

import java.time.LocalDate;

public class Eric {
    public static void main(String[] args) {
       double cantotadDeAnos = calcularDinero(1000, 1, 3);
        System.out.println(cantotadDeAnos);
        LocalDate localDate = LocalDate.ofYearDay(2010,85);
        int day = localDate.getDayOfMonth();
        if (day<localDate.lengthOfMonth()/2) {
            System.out.println("Menos" + day+" " +localDate);
        } else{
            System.out.println("Mas"+ day +" " +localDate );
        }
    }

    public static double calcularDinero(double startDinero, double stavca, int cantotadDeAnos){

        for (int year=1; year<=cantotadDeAnos; year++){
            startDinero = startDinero+startDinero*stavca/100;

        }


        return startDinero;
    }
}
