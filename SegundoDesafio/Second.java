package br.com.supera.challange;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * Leia um valor de ponto flutuante com duas casas decimais. Este valor representa um valor
 * monetário. A seguir, calcule o menor número de notas e moedas possíveis no qual o valor
 * pode ser decomposto. As notas consideradas são de 100, 50, 20, 10, 5, 2. As moedas
 * possíveis são de 1, 0.50, 0.25, 0.10, 0.05 e 0.01. A seguir mostre a relação de notas
 * necessárias.
 * @author leticiasena
 */
public class Second {
    private Scanner in;

    public Second() {
        in = new Scanner(System.in);
        float value = getMoneyValue();
        decomposeToPaperNotesAndCoins(value);
    }
    
    /**
     * Recupera do usuário o valor monetário a decompor
     * @return 
     */
    private float getMoneyValue() {
        System.out.println("Por favor, insira o valor entre 0 e 1000000.00 a ser decomposto em notas financeiras.");
         
        float money = in.nextFloat();
        if(money < 0 || money > 1000000){
            System.err.println("O valor inserido é menor que 0 ou maior que 1000000,00. Tente novamente!");
            money = getMoneyValue();
        }
       return money;
    }
    
    /**
     * Decompõe o valor monetário em notas e moedas
     * @param value 
     */
    private void decomposeToPaperNotesAndCoins(float value) {
        BigDecimal remaining = BigDecimal.valueOf(value);
        BigDecimal monetaryValue;
        int amount;
        
        System.out.println("NOTAS:");
        //100
        monetaryValue = BigDecimal.valueOf(100);
        amount = remaining.divide(monetaryValue).intValue();
        remaining = remaining.remainder(monetaryValue);
        System.out.println(String.format("%6d ",amount)+" notas(s) de R$ 100.00");
        
        //50
        monetaryValue = BigDecimal.valueOf(50);
        amount = remaining.divide(monetaryValue).intValue();
        remaining = remaining.remainder(monetaryValue);
        System.out.println(String.format("%6d ",amount)+" notas(s) de R$  50.00");
        
        //20
        monetaryValue = BigDecimal.valueOf(20);
        amount = remaining.divide(monetaryValue).intValue();
        remaining = remaining.remainder(monetaryValue);
        System.out.println(String.format("%6d ",amount)+" notas(s) de R$  20.00");
        
        //10
        monetaryValue = BigDecimal.valueOf(10);
        amount = remaining.divide(monetaryValue).intValue();
        remaining = remaining.remainder(monetaryValue);
        System.out.println(String.format("%6d ",amount)+" notas(s) de R$  10.00");
        
        //5
        monetaryValue = BigDecimal.valueOf(5);
        amount = remaining.divide(monetaryValue).intValue();
        remaining = remaining.remainder(monetaryValue);
        System.out.println(String.format("%6d ",amount)+" notas(s) de R$   5.00");
        
        //2
        monetaryValue = BigDecimal.valueOf(2);
        amount = remaining.divide(monetaryValue).intValue();
        remaining = remaining.remainder(monetaryValue);
        System.out.println(String.format("%6d ",amount)+" notas(s) de R$   2.00");
        
        
        System.out.println("MOEDAS:");
        
        //1
        monetaryValue = BigDecimal.valueOf(1);
        amount = remaining.divide(monetaryValue).intValue();
        remaining = remaining.remainder(monetaryValue);
        System.out.println(String.format("%6d ",amount)+" moeda(s) de R$   1.00");
        
        //0.5
        monetaryValue = BigDecimal.valueOf(0.5);
        amount = remaining.divide(monetaryValue).intValue();
        remaining = remaining.remainder(monetaryValue);
        System.out.println(String.format("%6d ",amount)+" moeda(s) de R$   0.50");
        
        //0.25
        monetaryValue = BigDecimal.valueOf(0.25);
        amount = remaining.divide(monetaryValue).intValue();
        remaining = remaining.remainder(monetaryValue);
        System.out.println(String.format("%6d ",amount)+" moeda(s) de R$   0.25");
        
        //0.10
        monetaryValue = BigDecimal.valueOf(0.10);
        amount = remaining.divide(monetaryValue).intValue();
        remaining = remaining.remainder(monetaryValue);
        System.out.println(String.format("%6d ",amount)+" moeda(s) de R$   0.10");
        
        //0.05
        monetaryValue = BigDecimal.valueOf(0.05);
        amount = remaining.divide(monetaryValue).intValue();
        remaining = remaining.remainder(monetaryValue);
        System.out.println(String.format("%6d ",amount)+" moeda(s) de R$   0.05");
        
        //0.01
        monetaryValue = BigDecimal.valueOf(0.01);
        amount = remaining.divide(monetaryValue).intValue();
        remaining = remaining.remainder(monetaryValue);
        System.out.println(String.format("%6d ",((int)amount))+" moeda(s) de R$   0.01");
    }
    
    public static void main(String[] args) {
       new Second();
    }

   

    
}
