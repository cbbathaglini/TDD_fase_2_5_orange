package br.com.springpum.demo.service;
import br.com.springpum.demo.model.Aluno;
import br.com.springpum.demo.model.Avaliacao;
import br.com.springpum.demo.model.RespostaQuestao;

public class CriadorDeResposta {

    private RespostaQuestao respostaQuestao;

    public CriadorDeResposta daAvaliacaoXdoAlunoY(Avaliacao avaliacao, Aluno aluno, Integer nota){
        this.respostaQuestao = new RespostaQuestao(avaliacao,aluno,nota);
        return this;
    }
}
