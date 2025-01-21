package alura.forumhub.domain.resposta;

import alura.forumhub.domain.topico.Topico;
import alura.forumhub.domain.usuario.Usuario;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "respostas")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Resposta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String mensagem;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "topico_id")
    private Topico topico;

    @Column(name = "data_criacao")
    private LocalDateTime dataCriacao;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    public Resposta(@Valid DadosCriarResposta dados, Topico topico, Usuario usuario) {
        this.id = null;
        this.mensagem = dados.mensagem();
        this.topico = topico;
        this.dataCriacao = dados.dataCriacao();
        this.usuario = usuario;
    }
}
