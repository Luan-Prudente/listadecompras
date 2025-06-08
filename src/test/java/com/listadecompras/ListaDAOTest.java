package com.listadecompras;

import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ListaDAOTest {

    static ListaDAO dao;
    static int idCriado;

    @BeforeAll
    static void setup() {
        dao = new ListaDAO();
    }

    @Test
    @Order(1)
    void testAdicionarItem() {
        Item item = new Item("Arroz", 2);
        dao.adicionarItem(item);
        List<Item> itens = dao.listarItens();
        assertTrue(itens.stream().anyMatch(i -> i.getNome().equals("Arroz")));
        idCriado = itens.stream().filter(i -> i.getNome().equals("Arroz")).findFirst().get().getId();
    }

    @Test
    @Order(2)
    void testBuscarItemPorId() {
        Item item = dao.buscarPorId(idCriado);
        assertNotNull(item);
        assertEquals("Arroz", item.getNome());
    }

    @Test
    @Order(3)
    void testAtualizarItem() {
        Item atualizado = new Item(idCriado, "Feijão", 3, false);
        dao.atualizarItem(atualizado);
        Item item = dao.buscarPorId(idCriado);
        assertEquals("Feijão", item.getNome());
        assertEquals(3, item.getQuantidade());
    }

    @Test
    @Order(4)
    void testMarcarComoComprado() {
        dao.marcarComoComprado(idCriado);
        Item item = dao.buscarPorId(idCriado);
        assertTrue(item.isComprado());
    }

    @Test
    @Order(5)
    void testRemoverItem() {
        dao.removerItem(idCriado);
        Item item = dao.buscarPorId(idCriado);
        assertNull(item);
    }
}
