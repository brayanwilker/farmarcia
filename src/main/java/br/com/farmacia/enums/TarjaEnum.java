package br.com.farmacia.enums;


public enum TarjaEnum {

    PRETA(1),
    VERMELHA(2),
    AMARELA(3);

    final Integer id;


    TarjaEnum(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}
