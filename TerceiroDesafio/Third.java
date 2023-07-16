package br.com.supera.challange;

import java.util.Scanner;

/**
 * Dado um array de inteiros e um valor alvo, determine o número de pares entre os elementos
 * do array em que a sua diferença seja igual ao valor alvo.
 * @author leticiasena
 */
public class Third {
    private Scanner in;
    
    public Third(){
        in = new Scanner(System.in);
        int lenght = lenghtArray();
        int target = targetNumber();
        Integer[] array = fillArray(lenght);
        numberOfPositions(array,target);
    }
    
    /**
     * Recupera do usuário a quantidade de números/tamanho do array
     * @return 
     */
    private int lenghtArray() {
        System.out.println("Por favor, insira a quantidade de números quer descobrir a diferença entre um alvo.");
         
        int amountOfLines = in.nextInt();
        if(amountOfLines < 1){
            System.err.println("A quantidade de números deve ser maior que 0. Tente novamente!");
            amountOfLines = lenghtArray();
        }
       return amountOfLines;
    }
    
    /**
     * Recupera do usuário a quantidade de números/tamanho do array
     * @return 
     */
    private int targetNumber() {
        System.out.println("Por favor, insira o alvo desejado para verificar a diferença.");
         
        int target = in.nextInt();
        if(target < 1){
            System.err.println("O alvo deve ser maior que 0. Tente novamente!");
            target = lenghtArray();
        }
       return target;
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
   
    /**
     * Calcula as posições que satisfazem o critério desejado do alvo
     * @param array
     * @param target 
     */
    private void numberOfPositions(Integer[] array, int target) {
       String pairs = "{";
       int result = 0,counter = 0;
       for(int i = 0;i < array.length;i++){
            for(int j = 0; j < array.length; j++){
                result = array[i]-array[j];
                if(result == target) {
                    counter++;
                    pairs += "["+array[i]+"-"+array[j]+"],";
                }
            }
        }
       pairs = pairs.substring(0, pairs.length()-1)+"}";
       System.out.println("Existem "+counter+" pares que satisfazem o critério desejado:"+pairs);
        
    }
    
    public static void main(String[] args) {
       new Third();
       
    }

    

}
