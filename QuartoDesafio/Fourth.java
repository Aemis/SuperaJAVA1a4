package br.com.supera.challange;

import java.util.Scanner;

/**
 *
 * @author leticiasena
 */
public class Fourth {
    private Scanner in;
 
    public Fourth(){
        in = new Scanner(System.in);
        int linesToRead = getNumber();
        String[] textToDecipher = readLinesWithText(linesToRead);
        decipherText(textToDecipher);
    }
    
    /**
     * Recupera do usuário a quantidade de testes a ser desembaralhada
     * @param position
     * @return 
     */
    private int getNumber(){
        System.out.println("Insira o número de frases a desembaralhar:");
        int number= in.nextInt();
        if(number <= 0){
            System.err.println("Por favor, insira a quantidade de frases que quer desembaralhar. Tente novamente!");
            number = getNumber();
        }
        return number;
    }
    
    /**
     * Recupera as linhas de texto do usuário 
     * @param linesToRead
     * @return 
     */
    private String[] readLinesWithText(int linesToRead) {
        String[] lines = new String[linesToRead];
        int iterator = 0;
        while(iterator < linesToRead){
            lines[iterator] = readLine().toUpperCase();
            iterator++;
        }
        return lines;
    }
    
    /**
     * Recupera uma única de texto do usuário
     * @return 
     */
    private String readLine(){
        System.out.println("Entre com a frase que deseja decifrar:");
        String text = in.nextLine();
        if(text.length() < 2 || text.length() > 100){
            System.err.println("Por favor, verifique a frase desejada. O tamanho máximo de caracteres é 100 e o mínimo é 2!");
            text = readLine();
        }
        return text;
    }
    
    /**
     * Decifra todo o array com o texto desorganizado
     * @param textToDecipher 
     */
    private void decipherText(String[] textToDecipher) {
        String result = "";
        for(String phrase:textToDecipher){
            result = organizeText(phrase.substring(0, phrase.length()/2));
            result+= organizeText(phrase.substring(phrase.length()/2,phrase.length()));
            
            System.out.println(result);
        }
    }
    
    /**
     * Organiza o texto 
     * @param textToOrder
     * @return 
     */
    private String organizeText(String textToOrder){
        String result = "";
        int iterator = textToOrder.length()-1;
        while(iterator >= 0){
            result += textToOrder.charAt(iterator);
            iterator--;
        }
        return result;
    }
    
    public static void main(String[] args) {
       new Fourth();
    }

   

   
}
