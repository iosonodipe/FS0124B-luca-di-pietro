package com.epicode.U5D2;

import com.epicode.U5D2.entities.Drink;
import com.epicode.U5D2.entities.Order;
import com.epicode.U5D2.entities.Pizza;
import com.epicode.U5D2.entities.Table;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Slf4j
class Esercizio30102023ApplicationTests {

    Order ordine;

    @Autowired
    @Qualifier("Tavolo3")
    Table tavolo3;

    @Autowired
    @Qualifier("Tavolo2")
    Table tavolo2;

    @Autowired
    @Qualifier("pizzas")
    List<Pizza> pizze;

    @Autowired
    @Qualifier("drinks")
    List<Drink> drinks;

    @BeforeEach
    void creaOrdine(){
        ordine = new Order(1, tavolo3);
        ordine.addItem(pizze.get(0));
        ordine.addItem(drinks.get(0));
        log.info("Creo un ordine");
    }

    @Test
    @DisplayName("Verifica totale ordine")
    void getTotalTest(){
        log.info("Eseguo test sul totale dell'ordine");
        assertEquals(8.280000000000001, ordine.getTotal());
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    @DisplayName("Verifica totale articoli dell'ordine")
    void checkOrderItemsTest(int numeroCoperti){
        log.info("Eseguo test per verifica se il numero degli articoli totali dell'ordine corrisponde");
        assertEquals(numeroCoperti, ordine.getOrderedProducts().size());
    }

    @Test
    @DisplayName("Verifica che l'ordine abbia il tavolo correto")
    void checkOrderTableTest(){
        log.info("Eseguo test sulla corrispondenza del tavolo");
        assertEquals(tavolo3, ordine.getTable());
    }

}
