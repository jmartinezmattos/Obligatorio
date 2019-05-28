package Enums;

public enum SeasonType {
    SUMMER("Summer"),
    WINTER("Winter");

    private String season;

    SeasonType(String season){
        this.season = season;
    }


    public SeasonType valueof(String season){
        SeasonType salida = null;
        switch (season) {
            case "Summer":
                salida = SeasonType.SUMMER;
                break;
            case "Winter":
                salida = SeasonType.WINTER;
                break;
        }
        return salida;
    }
}
