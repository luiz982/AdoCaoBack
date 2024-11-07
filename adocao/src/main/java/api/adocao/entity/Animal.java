package api.adocao.entity;


import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "animal")
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "Nome", nullable = false)
    private String nome;

    @Column(name = "Raca", nullable = false)
    private String raca;

    @Column(name = "DataNascimento", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataNascimento;

    @Column(name = "Informacoes")
    private String informacoes;

    @Column(name = "Status", nullable = false)
    private Boolean status;

    @Column(name = "Foto")
    private byte[] foto;

    @Column(name = "Tipo" ,nullable = false)
    private String tipo;

    @Column(name = "Sexo", nullable = false)
    private char sexo;

    public Animal() {
    }

    public Animal(String nome, String raca, Date dataNascimento, String informacoes, Boolean status, byte[] foto, String tipo, char sexo) {
        this.nome = nome;
        this.raca = raca;
        this.dataNascimento = dataNascimento;
        this.informacoes = informacoes;
        this.status = status;
        this.foto = foto;
        this.tipo = tipo;
        this.sexo = sexo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getInformacoes() {
        return informacoes;
    }

    public void setInformacoes(String informacoes) {
        this.informacoes = informacoes;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }
}
