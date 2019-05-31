package Enums;

public enum SexType {

    FEMALE("F"),
    MALE("M");


    private String sex;

    SexType(String sex){
        this.sex = sex;
    }


    public static SexType valueof(String sex){
        SexType salida = null;
        switch (sex) {
            case "F":
                salida = SexType.FEMALE;
                break;
            case "M":
                salida = SexType.MALE;
                break;
        }
        return salida;
    }
}
