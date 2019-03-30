package ipv4;

import java.util.Scanner;

public class IPV4 {

    public static void main(String[] args) {
        String IP;
        Scanner sc = new Scanner(System.in); // leitor
        int i, quant; // declaração de variáveis
        do {
            System.out.println("====================");
            System.out.println("|CALCULADORA DE IPV4|"); // introdução
            System.out.println("====================");
            System.out.println("");
            System.out.println("digite o IPV4 com os pontos"); 
            IP = sc.next(); // leitura da variavel IP0
            Calculadora ip1 = new Calculadora(IP); // instanciação do objeto
            boolean veri; // declaração de variável boolean
            ip1.Div_oct(); // método
            veri = ip1.Verificar(); // variavel recebendo retorno o método
             if (veri == true) { // condição
            ip1.ID_Classe(); // método
                 System.out.println("digite:");
                 System.out.println("1- dividir por quantidade de subrede");
                 System.out.println("2- dividir pela quantidade de host");
                 System.out.println("outro numero para dividir por mascara");
                 int op = sc.nextInt();
            if (op==1){ // condição
                System.out.println("digite a quantidade de subredes");
                quant =sc.nextInt();
                ip1.quant_sub(quant); // parâmetro para o método
            }else if(op==2){  // condição
                System.out.println("digite a quantidade de hosts");
                quant = sc.nextInt();
                ip1.quant_subH(quant);
                        } else { // condição
                System.out.println("digite o ultimo octeto da mascara");
                quant = sc.nextInt(); 
                ip1.descobrir(quant);
            }
                ip1.id_masc(); // chamada do método
                ip1.tabela(); // chamada do método
            }else {
                System.out.println("IP Invalido");
            }
            System.out.println(" ");
            System.out.println("para sair digite 1. Para calcular um novo IP, 0");
            i = sc.nextInt();
        } while (i == 0);
    }
}
            
            
           
