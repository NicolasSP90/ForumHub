package alura.forumhub.domain.topico;

import alura.forumhub.domain.curso.Curso;
import alura.forumhub.domain.resposta.Resposta;
import alura.forumhub.domain.usuario.Usuario;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="topicos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String mensagem;

    @Column(name = "data_criacao")
    private LocalDateTime dataCriacao;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private StatusTopico status;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "curso_id")
    private Curso curso;

    @OneToMany(mappedBy = "topico", fetch = FetchType.EAGER)
    private List<Resposta> respostas;

    public Topico(DadosCriarTopico dados, Usuario usuario, Curso curso) {
        this.id = null;
        this.titulo = dados.titulo();
        this.mensagem = dados.mensagem();
        this.dataCriacao = dados.dataCriacao();
        this.status = dados.status();
        this.usuario = usuario;
        this.curso = curso;
    }

    public void atualizarTitulo(String titulo) { this.titulo = titulo; };

    public void atualizarMensagem(String mensagem) { this.mensagem = mensagem; };

    public void abrirTopico() { this.status = StatusTopico.ABERTO; };

    public void fecharTopico() { this.status = StatusTopico.FECHADO; };

    public void desativarTopico() { this.status = StatusTopico.DESATIVADO; };
}
