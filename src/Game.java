import java.util.Scanner;

public class Game {
    private Scanner input = new Scanner(System.in);

    public void start(){
        System.out.println("Macera oyununa hoşgeldiniz ..!");
        System.out.print("Lütfen bir isim giriniz : ");
        String playerName  = input.nextLine();

        Player player = new Player(playerName);
        System.out.println("Sayın " + playerName + " hoşgeldiniz !!");

        player.selectChar();
        Location location = null;
        while (true){
            player.printInfo();
            System.out.println();
            System.out.println("----- Bölgeler ------");
            System.out.println();
            System.out.println("1 - Güvenli Ev --> Burası sizin için güvenli bir ev, düşman yoktur !");
            System.out.println("2 - Mağaza -- > Buradan silah veya zırh satın alabilirsiniz !");
            System.out.print("Lütfen gitmek istediğiniz bölgeyi seçiniz : ");
            int selectLoc = input.nextInt();

            switch (selectLoc) {
                case 1:
                    location = new SafeHouse(player);
                    break;
                case 2:
                    location = new ToolStore(player);
                    break;
                default:
                    location = new SafeHouse(player);
            }

            if(!location.onLocation()){
                System.out.println("GAME OVER !");
                break;
            }

        }
    }
}