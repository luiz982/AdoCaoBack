package api.adocao.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "adocao")
public class Adocao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "Id_Voluntario", nullable = false)
    private Voluntario voluntario;

    @ManyToOne
    @JoinColumn(name = "Id_Animal", nullable = false)
    private Animal animal;

    @Column(name = "Descricao")
    private String descricao;

    @Column(name = "DataAdocao", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataAdocao;

    @Column(name = "NomeAdotante", nullable = false)
    private String nomeAdotante;

    @Column(name = "CPFAdotante", nullable = false, length = 11)
    private String cpfAdotante;

    @Column(name = "TelefoneAdotante", nullable = false, length = 15)
    private String telefoneAdotante;

    public Adocao() {
    }

    public Adocao(Voluntario voluntario, Animal animal, String descricao, Date dataAdocao,
                  String nomeAdotante, String cpfAdotante, String telefoneAdotante) {
        this.voluntario = voluntario;
        this.animal = animal;
        this.descricao = descricao;
        this.dataAdocao = dataAdocao;
        this.nomeAdotante = nomeAdotante;
        this.cpfAdotante = cpfAdotante;
        this.telefoneAdotante = telefoneAdotante;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Voluntario getVoluntario() {
        return voluntario;
    }

    public void setVoluntario(Voluntario voluntario) {
        this.voluntario = voluntario;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataAdocao() {
        return dataAdocao;
    }

    public void setDataAdocao(Date dataAdocao) {
        this.dataAdocao = dataAdocao;
    }

    public String getNomeAdotante() {
        return nomeAdotante;
    }

    public void setNomeAdotante(String nomeAdotante) {
        this.nomeAdotante = nomeAdotante;
    }

    public String getCpfAdotante() {
        return cpfAdotante;
    }

    public void setCpfAdotante(String cpfAdotante) {
        this.cpfAdotante = cpfAdotante;
    }

    public String getTelefoneAdotante() {
        return telefoneAdotante;
    }

    public void setTelefoneAdotante(String telefoneAdotante) {
        this.telefoneAdotante = telefoneAdotante;
    }

}
