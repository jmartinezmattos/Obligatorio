package Enums;

public enum MedalType {
    BRONZE("B"),
    SILVER("S"),
    GOLD("G"),
    NA("NA");

    private String medal;

    MedalType(String medal){
        this.medal = medal;
    }

    public static MedalType valueof(String sex){
        MedalType salida = null;
        switch (sex) {
            case "Bronze":
                salida = MedalType.BRONZE;
                break;
            case "Silver":
                salida = MedalType.SILVER;
                break;
            case "Gold":
                salida = MedalType.GOLD;
                break;
            case "NA":
                salida = null;
                break;
        }
        return salida;
    }
}


