package io.github.Sothnik0.arxgrandhotel.enums;

public enum Gender {
    MASCULINO("Masculino"),
    FEMININO("Feminino"),
    OUTRO("Outro");

    private final String genero;

    Gender(String genero) {
        this.genero = genero;
    }

    public String getGenero(){
        return this.genero;
    }

    @Override
    public String toString(){
        return this.genero;
    }
}
