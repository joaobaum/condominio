package org.example;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        LocalDate data1 = LocalDate.of(2024, 11, 1);
        LocalDate data2 = LocalDate.of(2024, 11, 3);
        LocalDate data3 = LocalDate.of(2024, 11, 5);
        LocalDate data4 = LocalDate.of(2024, 11, 7);
        LocalDate data5 = LocalDate.of(2024, 11, 9);


        calcularValores(0, data1,data2, data3, data4,data5);

    }

    private static void calcularValores(int quantosFeriados, LocalDate... datasDeTrabalho) {
        double total = 0.0;
        for (LocalDate data : datasDeTrabalho) {
            total += validarValoresReceber(data);
        }
        System.out.printf("Valores total = R$%,.2f%n", total - quantosFeriados * 60);
    }

    private static double validarValoresReceber(LocalDate localDate) {
        double valoresDiasUteis = 260.0;
        double valoresFindFeriado = 200.0;

        return (localDate.getDayOfWeek() == DayOfWeek.SATURDAY || localDate.getDayOfWeek() == DayOfWeek.SUNDAY) ? valoresFindFeriado : valoresDiasUteis;
    }


}
