package ipv4;

public class Calculadora {

    String IP;
    String ips[];
    int ip2[] = new int[4];
    int bits_host;
    String end[] = new String[4];
    int vetor[] = {1, 2, 4, 8, 16, 32, 64, 128};
    int n_sub, host;

    public Calculadora(String IP) { //Construtor
        this.IP = IP;
    }

    public void Div_oct() { // Método para dividir o IP usando a função split
        ips = IP.split("[.]"); // A função divide os octetos do IP usando o '.' que são armazenados no vetor ips
        if(ips.length!= 4){ //se ip == 4 octetos
            System.out.println("Algo deu errado");// exibir mensagem
        } else{// senão
        for (int i = 0; i <= 3; i++) { //cria-se o i já inicializado de 0 a 3 para percorrer os 4 octetos do IP
            ip2[i] = Integer.parseInt(ips[i]); //utilizamos o método estático parseInt da classe Integer para transformar a String em int
        }
        }
    }

    public boolean Verificar() {
        if (ip2.length == 4) { //se ip == 4 octetos
        if ((ip2[0] >= 1 && ip2[0] <= 255) && (ip2[1] <= 255 && ip2[1] >= 0) && (ip2[2] <= 255 && ip2[2] >= 0) && (ip2[3] <= 255 && ip2[3] >= 0)) { //Se ip for maior ou = 1 
                return true;// retorno do metodo é verdadeiro
            } else { //Se não
                return false;// retorno do metodo é falso
            }
        } else { // se o ip não conter quatro octetos
            return false;// returno falso
        }
    }

    public void ID_Classe() { //Informações da classe
        if (ip2[0] >= 192 && ip2[0] <= 255) { //Verificando se o primeiro octeto do IP pertence a classe C
        } else {//se não
            System.out.println("IP não pertence a classe C"); // mensagem de erro
            System.out.println("Impossivel a realização de operações");// mensagem de erro
            System.exit(0); // sair do sistema
        }

    }

    public void quant_sub(int num) {// criação do metodo
        for (int i = 0; i <= 8; i++) {// laço de repetição para percorrer a tabela
            if (vetor[i] >= num) {//se o numeroa da tabela for maior ou igual ai numero digitado
                n_sub = vetor[i]; // quantidade de subredes é igual ao numero da tabela
                bits_host = 8 - i; // a quantidade de bits por host é igual a 8 - quantidade de bits para subrede(i)
                host = (int) (Math.pow(2, bits_host)) - 2; // calculo de hosts por rede
                System.out.println(n_sub + " subredes"); // impressão de resultados
                System.out.println(host + " hosts por subrede");// impressão de resultados
                System.out.println("");
                break;
            }
        }
    }
    
    public void quant_subH (int nH){
        for (int i = 0; i <= 8; i++) {// laço de repetição para percorrer a tabela
        host = (int) (Math.pow(2,i)) - 2;// calcula quantidade de host
        if (host>= nH){ // se quantidade de host for maior ou igual a digitada 
            int sub_rede = 8-i; // quantidade de bits por subrede
                bits_host = i; // quantidade de bits para host
                 n_sub = vetor[sub_rede]; // calculo de subredes 
             System.out.println(n_sub + " subredes"); // impressão 
             System.out.println(host + " hosts por subrede");// impressão
             break;
        }
        }
    }
    
    public void descobrir(int oc){
        int result = 0; //variavel
         for (int i = 7; i>0; i--) {// laço para percorrer a tabela
             result = vetor[i] + result; // calculo do ultimo octeto da mascara
             if(result==oc){ // quando o ultimo octeto calculado for igual ao digitado
                host = (int) (Math.pow(2,i)) - 2; // calculo de host
                bits_host =i; // bits por host
                int sub = 8-i; // bits por subrede
                n_sub = vetor[sub]; // numero de subrede
                System.out.println(n_sub + " subredes"); // impressão
             System.out.println(host + " hosts por subrede");// impressão 
             }
         }
    }

    public void id_masc() { // criar o metodo
        int result = 0; // inicialização da variavel result
        for (int i = bits_host; i <8; i++) { // laço para percorrer a tabela nos bits ocupados para host
            result = vetor[i] + result;// soma para calculo de mascara
        }
        System.out.println("255.255.255." + result);// impressão de resultados
    }

    public void tabela() { // criação do metodo tabela
        int rede, priHost, ulHost, broad;// criação de variaveis
        int quant = (int) (Math.pow(2, bits_host));//qualcular a quantidade de host contando end. de rede e 
        System.out.println("");
        System.out.println("1° subrede"); // impressão de dados
        rede = 0;// calculo do primeiro endereço de rede
        priHost = 1;// primeiro host
        broad = quant - 1;// broadcast
        ulHost = broad - 1;//ultimohost
        System.out.println("Endereço de Rede: " + rede);//impressão
        System.out.println("Primeiro Host: " + priHost);//impressão
        System.out.println("Ultimo Host: " + ulHost);//impressão
        System.out.println("Broadcast: " + broad);//impressão
        for (int i = 2; i < n_sub + 1; i++) {// laço para repetir as redes e calcular os dados
            System.out.println("");
            System.out.println(i + "° subrede");//impressão
            rede = rede + quant; // calculo de en.rede
            priHost = priHost + quant;// calculo de priHost
            broad = broad + quant;// calculo de broadcast
            ulHost = ulHost + quant;// calculo de ultimo host
            System.out.println("Endereço de Rede: " + rede);//impressão
            System.out.println("Primeiro Host: " + priHost);//impressão
            System.out.println("Ultimo Host: " + ulHost);//impressão
            System.out.println("Broadcast: " + broad);//impressão
        }
    }

}
