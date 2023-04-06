package br.safeway.teste.romulo;


import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;


class VendaFactoryTest {


    @Test void deveCriarVenda() {
        VendaFactory vendaFactory = new VendaFactory();
        Venda venda = vendaFactory.criar("123456789");
        assertNotNull(venda);
    }

    @Test void
    QuandoCriarUmaVenda_SeJaExistirVendaProCliente_EntaoRetornarVendaExistente() {
        VendaFactory vendaFactory = new VendaFactory();
        Venda venda = vendaFactory.criar("123456789");
        assertSame(vendaFactory.criar("123456789"), venda);
    }



}