import br.com.alura.tdd.modelo.Funcionario;
import br.com.alura.tdd.service.BonusService;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BonusServiceTest {

    @Test
    public void bonusDeveriaSerZeroParaFuncionarioComSalarioMuitoAltoTest()
    {
        BonusService bonus = new BonusService();
        assertThrows(IllegalArgumentException.class, () -> bonus.calcularBonus(new Funcionario("Diogo Cortez", LocalDate.now(), new BigDecimal("25000"))));
    }

    @Test
    public void bonusDeveriaSer10PorCentoDoSalarioTest()
    {
        BonusService bonus = new BonusService();
        BigDecimal valor = bonus.calcularBonus(new Funcionario("Diogo Cortez", LocalDate.now(), new BigDecimal("2500")));

        assertEquals(new BigDecimal("250.0"), valor);
    }

    @Test
    public void bonusDeveriaSerDezPorcentoParaSalarioDe10000()
    {
        BonusService bonus = new BonusService();
        BigDecimal valor = bonus.calcularBonus(new Funcionario("Diogo Cortez", LocalDate.now(), new BigDecimal("10000")));

        assertEquals(new BigDecimal("1000.0"), valor);
    }
}
