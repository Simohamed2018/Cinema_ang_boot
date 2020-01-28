package com.simo.cinema.dto;

import lombok.Data;
import java.util.ArrayList;
import java.util.List;
@Data
public class TicketForm {

    private List<Long> tickets=new ArrayList<>();
    private String nomClient;
    private int codePayement;

}
