package com.epicode.U5D1.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Ordine {
    private int numero;
    private StatoOrdine stato;
    private List<Item> items = new ArrayList<>();
    private int coperti;
    private LocalDate oraAcquisizione;
    private int totale;

}
