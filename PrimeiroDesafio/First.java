

package br.com.supera.challange;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/** PRIMEIRO DESAFIO 
 *  Considerando a entrada de valores inteiros não negativos, ordene estes valores segundo o seguinte critério:
 *  • Primeiro os Pares
 *  • Depois os Ímpares
 *  Sendo que deverão ser apresentados os pares em ordem crescente e depois os ímpares em ordem decrescente.
 *  @author leticiasena
 */

public class First {
    private Scanner in;
    
    public First(){
        in = new Scanner(System.in);
        Integer amountOfLines = amountOfLines();
        Integer[] originalNumbers = fillArray(amountOfLines);
        orderArray(originalNumbers);
    }
    
    /**
     * Imprime o array
     * @param array
     * @param mensagem 
     */
    private void printArray(Integer[] array,String mensagem) {
        int position = 0;
        System.out.println(mensagem);
        while(position < array.length){
            System.out.println(array[position]);
            position++;
        }
    }

    /**
     * Ordena o Array
     * @param array 
     */
    private void orderArray(Integer[] array) {
        Integer[] result = new Integer[array.length];
        List<Integer> even = new ArrayList<Integer>();
        List<Integer> odd = new ArrayList<Integer>();
        int counter = 0;
        
        while(counter < array.length){
            if(array[counter]%2 == 0){//is Even
                even.add(array[counter]);
            }else{
                odd.add(array[counter]);
            }
            counter++;
        }
        
        Collections.sort(even);
        Collections.sort(odd);
        
        counter = 0;
        for(int i = 0; i< array.length;i++){
            if(i < even.size()){
                result[i] = even.get(i);
            }else{
                result[i] = odd.get(odd.size()-counter-1);
                counter++;
            }
        }
        
        printArray(result,"A resposta para o problema é:");
    }
   
    /**
     * Recupera do usuário a quantidade de linhas
     * @return 
     */
    private int amountOfLines() {
        System.out.println("Por favor, insira a quantidade de números que deseja ordenar, sendo que esse valor deve ser maior que 1 e menor que 100.000.");
         
        int amountOfLines = in.nextInt();
        if(amountOfLines <= 1 || amountOfLines > 100000){
            System.err.println("A quantidade de números inseridos não é maior que 1 ou menor que 100.000. Tente novamente!");
            amountOfLines = amountOfLines();
        }
       return amountOfLines;
    }

    /**
     * Recupera do usuário os números para o Array
     * @param amountOfLines
     * @return 
     */
    private Integer[] fillArray(int amountOfLines) {
        Integer[] originalNumbers = new Integer[amountOfLines];
        int position = 0;
        while(position < amountOfLines){
            originalNumbers[position] = getNumber(position+1);
            position++;
        }
        printArray(originalNumbers,"A entrada fornecida foi:");
        return originalNumbers;
    }
    
    /**
     * Recupera do usuário cada número individualmente
     * @param position
     * @return 
     */
    private int getNumber(int position){
        System.out.println("Insira o número inteiro e positivo na posição "+position+":");
        int number= in.nextInt();
        if(number <= 0){
            System.err.println("Por favor, insira um número inteiro e não negativo. Tente novamente!");
            number = getNumber(position);
        }
        return number;
    }
    
    public static void main(String[] args) {
       new First();
    }

}
