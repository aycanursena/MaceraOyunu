public class SafeHouse extends Location{
    public SafeHouse(Player player) {
        super(player,"Güvenli Ev");
    }

    @Override
    boolean onLocation(){
        System.out.println("Güvenli evdesiniz !");
        System.out.println("Canınız yenilendi !");
        return true;
    }
}
