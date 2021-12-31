package br.com.kassioschaider.service;

import br.com.kassioschaider.ValidacaoException;
import br.com.kassioschaider.model.Funcionario;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ReajusteService {

    public void reajustarSalarioDoFuncionario(Funcionario funcionario, BigDecimal aumento) {
        BigDecimal salarioAtual = funcionario.getSalario();
        BigDecimal percentualReajuste = aumento.divide(salarioAtual, RoundingMode.HALF_UP);
        if (percentualReajuste.compareTo(new BigDecimal("0.4")) > 0) {
            throw new ValidacaoException("Reajuste nao pode ser superior a 40% do salario!");
        }
        BigDecimal salarioReajustado = salarioAtual.add(aumento);
        funcionario.atualizarSalario(salarioReajustado);
    }
}
