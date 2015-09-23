package me.machadolucas.questionnaire.helper;

import me.machadolucas.questionnaire.entity.Question;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QuestionsCreator {

    public static List<Question> createQuestions() {
        List<Question> questions = new ArrayList<>();

        Question captivation = new Question();
        captivation.setName("captivation");
        captivation.setTitle("Fascínio");
        captivation.setDescription("Esquecer o envolvimento com o ambiente, ficar compenetrado");
        questions.add(captivation);

        Question challenge = new Question();
        challenge.setName("challenge");
        challenge.setTitle("Desafio");
        challenge.setDescription("Habilidades testadas em um tarefa exigente");
        questions.add(challenge);

        Question competition = new Question();
        competition.setName("competition");
        competition.setTitle("Competição");
        competition.setDescription("Estar em competição com outro oponente");
        questions.add(competition);

        Question completion = new Question();
        completion.setName("completion");
        completion.setTitle("Complitude");
        completion.setDescription("Completar um objetivo, fechar");
        questions.add(completion);

        Question control = new Question();
        control.setName("control");
        control.setTitle("Controle");
        control.setDescription("Dominar, controlar, regular");
        questions.add(control);

        Question cruelty = new Question();
        cruelty.setName("cruelty");
        cruelty.setTitle("Crueldade");
        cruelty.setDescription("Causar dor física ou mental");
        questions.add(cruelty);

        Question discovery = new Question();
        discovery.setName("discovery");
        discovery.setTitle("Descoberta");
        discovery.setDescription("Encontrar algo novo ou desconhecido");
        questions.add(discovery);

        Question eroticism = new Question();
        eroticism.setName("eroticism");
        eroticism.setTitle("Erotismo");
        eroticism.setDescription("Experiência sexualmente estimulante");
        questions.add(eroticism);

        Question exploration = new Question();
        exploration.setName("exploration");
        exploration.setTitle("Exploração");
        exploration.setDescription("Investigar um objeto ou uma situação");
        questions.add(exploration);

        Question expression = new Question();
        expression.setName("expression");
        expression.setTitle("Expressão");
        expression.setDescription("Se manifestar de forma criativa");
        questions.add(expression);

        Question fantasy = new Question();
        fantasy.setName("fantasy");
        fantasy.setTitle("Fantasia");
        fantasy.setDescription("Uma experiência imaginada");
        questions.add(fantasy);

        Question fellowship = new Question();
        fellowship.setName("fellowship");
        fellowship.setTitle("Companheirismo");
        fellowship.setDescription("Amizade, sentir-se parte de uma comunidade, ou intimidade");
        questions.add(fellowship);

        Question humor = new Question();
        humor.setName("humor");
        humor.setTitle("Humor");
        humor.setDescription("Diversão, piadas, gozo, achar engraçado");
        questions.add(humor);

        Question nurture = new Question();
        nurture.setName("nurture");
        nurture.setTitle("Zêlo");
        nurture.setDescription("Cuidar de si ou dos outros");
        questions.add(nurture);

        Question relaxation = new Question();
        relaxation.setName("relaxation");
        relaxation.setTitle("Relaxamento");
        relaxation.setDescription("Alívio de trabalho físico ou mental");
        questions.add(relaxation);

        Question sensation = new Question();
        sensation.setName("sensation");
        sensation.setTitle("Estimulação dos Sentidos");
        sensation.setDescription("Entusiasmo por estimular os sentidos");
        questions.add(sensation);

        Question simulation = new Question();
        simulation.setName("simulation");
        simulation.setTitle("Simulação");
        simulation.setDescription("Imitação da vida e do dia-a-dia");
        questions.add(simulation);

        Question submission = new Question();
        submission.setName("submission");
        submission.setTitle("Submissão");
        submission.setDescription("Fazer parte de uma estrutura maior");
        questions.add(submission);

        Question subversion = new Question();
        subversion.setName("subversion");
        subversion.setTitle("Subversão");
        subversion.setDescription("Quebrar regras e normas sociais");
        questions.add(subversion);

        Question suffering = new Question();
        suffering.setName("suffering");
        suffering.setTitle("Sofrimento");
        suffering.setDescription("Experiência de perda, frustração ou raiva");
        questions.add(suffering);

        Question sympathy = new Question();
        sympathy.setName("sympathy");
        sympathy.setTitle("Simpatia");
        sympathy.setDescription("Compartilhar sentimentos emocionais");
        questions.add(sympathy);

        Question thrill = new Question();
        thrill.setName("thrill");
        thrill.setTitle("Adrenalina");
        thrill.setDescription("Excitação derivada do risco, do perigo");
        questions.add(thrill);

        Collections.shuffle(questions);
        return questions;
    }
}
