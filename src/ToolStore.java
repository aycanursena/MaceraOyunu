public class ToolStore extends NormalLoc{
    public ToolStore(Player player) {
        super(player, "Mağaza");
    }

    @Override
    public boolean onLocation(){
        System.out.println("----- Mağazaya Hoşgeldiniz ! -----");

        boolean showMenu = true;
        while (showMenu){
            System.out.println("1 - Silahlar");
            System.out.println("2 - Zırhlar");
            System.out.println("3 - Çıkış Yap");
            System.out.println();
            System.out.print("Seçiminiz : ");
            int selectCase = input.nextInt();

            while (selectCase < 1 || selectCase > 3){
                System.out.print("Geçersiz değer, tekrar giriniz : ");
                selectCase = input.nextInt();
            }

            switch (selectCase){
                case 1:
                    printWeapon();
                    buyWeapon();
                    break;
                case 2:
                    printArmor();
                    buyArmor();
                    break;
                case 3:
                    System.out.println("Bir daha bekleriz !");
                    showMenu = false;
                    break;

            }
        }
        return true;
    }

    public void printArmor(){
        System.out.println("----- Zırhlar -----");
        for (Armor ar : Armor.armors()){
            System.out.println(ar.getId() + "- " + ar.getName() + " < Para : " + ar.getPrice() +
                    ", Zırh : " + ar.getBlock() + " >");
        }
        System.out.println("0 - Çıkış Yap");
    }
    public void printWeapon(){
        System.out.println("----- Silahlar -----");
        for (Weapon w : Weapon.weapons()){
            System.out.println(w.getId() + "- " + w.getName() + " < Para : " + w.getPrice() +
                    ", Hasar : " + w.getDamage() + " >");
        }
        System.out.println("0 - Çıkış Yap");
    }

    public void buyWeapon(){
        System.out.print("Bir silah seçiniz : ");
        int selectWeaponId = input.nextInt();

        while (selectWeaponId < 0 || Weapon.weapons().length > 3){
            System.out.print("Geçersiz değer, tekrar giriniz : ");
            selectWeaponId = input.nextInt();
        }
        if(selectWeaponId != 0){
            Weapon selectedWeapon = Weapon.getWeaponObjByID(selectWeaponId);
            if(selectedWeapon != null){
                if(selectedWeapon.getPrice() > this.getPlayer().getMoney()){
                    System.out.println("Yeterli paranız bulunmamaktadır...");
                }else {
                    System.out.println(selectedWeapon.getName() + " silahını satın aldınız.");
                    int balance = this.getPlayer().getMoney() - selectedWeapon.getPrice();
                    this.getPlayer().setMoney(balance);
                    System.out.println("Kalan paranız : " + this.getPlayer().getMoney());
                    System.out.println("Önceki silahınız : " + this.getPlayer().getInventory().getWeapon().getName());
                    this.getPlayer().getInventory().setWeapon(selectedWeapon);
                    System.out.println("Yeni silahınız : " + this.getPlayer().getInventory().getWeapon().getName());
                }
            }
        }
    }

    public void buyArmor(){
        System.out.print("Bir zırh seçiniz : ");
        int selectArmorId = input.nextInt();

        while (selectArmorId < 0 || Armor.armors().length > 3){
            System.out.print("Geçersiz değer, tekrar giriniz : ");
            selectArmorId = input.nextInt();
        }
        if(selectArmorId != 0) {
            Armor selectedArmor = Armor.getArmorObjByID(selectArmorId);
            if (selectedArmor != null) {
                if (selectedArmor.getPrice() > this.getPlayer().getMoney()) {
                    System.out.println("Yeterli paranız bulunmamaktadır...");
                } else {
                    System.out.println(selectedArmor.getName() + " zırhını satın aldınız.");
                    int balance = this.getPlayer().getMoney() - selectedArmor.getPrice();

                    this.getPlayer().setMoney(balance);
                    System.out.println("Kalan paranız : " + this.getPlayer().getMoney());
                    System.out.println("Önceki silahınız : " + this.getPlayer().getInventory().getWeapon().getName());
                    this.getPlayer().getInventory().setArmor(selectedArmor);
                    System.out.println("Yeni silahınız : " + this.getPlayer().getInventory().getWeapon().getName());
                }
            }
        }

    }
}

