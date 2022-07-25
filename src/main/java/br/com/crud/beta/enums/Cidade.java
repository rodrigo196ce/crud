package br.com.crud.beta.enums;

public enum Cidade {
    FORTALEZA("Fortaleza"),
    SAO_PAULO("São Paulo"),
    RIO_DE_JANEIRO("Rio de Janeiro"),
    FLORIANOPOLIS("Florianópolis"),
    BRASILIA("Brasília"),
    PORTO_ALEGRE("Porto Alegre"),
    SALVADOR("Salvador");

    private String descricao;

    Cidade(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
