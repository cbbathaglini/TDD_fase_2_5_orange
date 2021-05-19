package br.com.springpum.demo.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.event.annotation.AfterTestExecution;
import org.springframework.test.context.event.annotation.BeforeTestExecution;


import static org.junit.jupiter.api.Assertions.*;

class RespostaQuestaoTest {

    //@Test(expected = RuntimeException.class) versão 4 ou < do JUnit
    @Test
    void naoDeveResponderQuestaoSeAvaliacaoNaoExiste() throws RuntimeException{
        //A avaliação não pode ser nula
        RespostaQuestao respostaQuestao = new RespostaQuestao(null, new Aluno("Carine", "cbbathaglini@gmail.com", 23), 2);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Assertions.assertFalse(respostaQuestao.getAvaliacao() ==  null);
        });
    }

    @Test
    void naoDeveResponderQuestaoSeAlunoNaoExiste(){
        //O aluno não pode ser nulo

        RespostaQuestao respostaQuestao = new RespostaQuestao(new Avaliacao("Avaliação 1"), null, 2);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Assertions.assertFalse(respostaQuestao.getAluno() ==  null);
        });

    }

    @Test
    void notaNaoPodeSerMenorQueZero(){
        //A nota não pode ser menor que zero

        Avaliacao avaliacao = new Avaliacao("Avaliação 2");
        Aluno aluno = new Aluno("Carine", "cbbathaglini@gmail.com", 23);
        RespostaQuestao respostaQuestao = new RespostaQuestao(avaliacao, aluno, -1);

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Assertions.assertFalse(respostaQuestao.getNota() < 0);
        });



    }

    @Test
    void notaNoIntervaloPermitidoDe0ate10(){

        Avaliacao avaliacao2 = new Avaliacao("Avaliação 2");
        Aluno aluno2 = new Aluno("Carine", "cbbathaglini@gmail.com", 23);
        RespostaQuestao respostaQuestao2 = new RespostaQuestao(avaliacao2, aluno2, 10);
        //System.out.println(respostaQuestao2.toString());
        Assertions.assertTrue(respostaQuestao2.getNota() > 0 && respostaQuestao2.getNota() <= 10);
    }

    @Test
    void notaNaoPodeSerMaiorQue10(){
        //A nota não pode ser maior que 10

        Avaliacao avaliacao = new Avaliacao("Avaliação 2");
        Aluno aluno = new Aluno("Carine", "cbbathaglini@gmail.com", 23);
        RespostaQuestao respostaQuestao = new RespostaQuestao(avaliacao, aluno, 12);

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Assertions.assertFalse(respostaQuestao.getNota() > 10);
        });

    }

}