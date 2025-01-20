package alura.forumhub.domain.topico;

public record DetalhesCriarTopico(
        Long id,
        String titulo,
        String mensagem
) {

    public DetalhesCriarTopico(Topico topico){
        this(topico.getId(), topico.getTitulo(), topico.getMensagem());
    }
}
