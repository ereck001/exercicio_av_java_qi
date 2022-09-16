//import java.time.LocalDate;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Horoscopo horo = new Horoscopo();

        Scanner ler = new Scanner(System.in);

        System.out.println("Digite o dia do seu nascimento: ");        
        horo.setDiaNas(ler.nextByte());

        System.out.println("Digite o mês do seu nascimento: ");        
        horo.setMesNas(ler.nextByte());
        
        System.out.println("Digite o ano do seu nascimento: ");        
        horo.setAnoNas(ler.nextInt());
        
        
        
        System.out.println(horo.toString());
        
        
        ler.close();
    }
}