package br.com.crud.beta.dto;

import br.com.crud.beta.enums.Cidade;
import br.com.crud.beta.model.User;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CadastroDto {

    @NotBlank(message = "O campo é obrigatório.")
    private String nome;
    @NotBlank(message = "O campo é obrigatório.")
    private String dataNascimento;
    @NotBlank(message = "O campo é obrigatório.")
    private String email;
    @NotBlank(message = "O campo é obrigatório.")
    private String telefone;
    @NotBlank(message = "O campo é obrigatório.")
    private String rua;
    @NotNull(message = "O campo é obrigatório.")
    private Integer numero;
    private String complemento;
    @NotBlank(message = "O campo é obrigatório.")
    private String bairro;
    @Enumerated(EnumType.STRING)
    @NotNull(message = "O campo é obrigatório.")
    private Cidade cidade;
    @NotBlank(message = "O campo é obrigatório.")
    private String cep;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public User ToCadastro(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dataNascimento = LocalDate.parse(this.dataNascimento,formatter);
        Integer numero = Integer.valueOf(this.numero);
       return new User(this.nome,dataNascimento,this.email,this.telefone,this.rua,numero,this.complemento,
                this.bairro,this.cidade,this.cep);
    }
}
