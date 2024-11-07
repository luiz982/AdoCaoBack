package api.adocao.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "voluntario")
public class Voluntario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "Nome", nullable = false)
    private String nome;

    @Column(name = "DataNascimento", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataNascimento;

    @Column(name = "Tel")
    private String tel;

    @Column(name = "Email")
    private String email;

    public Voluntario() {
    }

    public Voluntario(String nome, Date dataNascimento, String tel, String email) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.tel = tel;
        this.email = email;
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

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
